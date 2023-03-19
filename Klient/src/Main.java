import java.net.*;
import java.io.*;
import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) throws IOException {
        Socket socket = null;

        try {
            socket = new Socket("localhost", 4444);
        } catch (UnknownHostException e) {
            System.out.println("Nie znaleziono hosta");
            exit(1);
        } catch (IOException e) {
            System.out.println("Nie udało się połączyć z hostem");
            exit(1);
        }
        System.out.println("Połączono z hostem");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        while (true) {
            try {
                String wiadomosc = in.readLine();
                String czas = in.readLine();

                if (wiadomosc == null) {
                    throw new EmptyMessageException();
                }

                System.out.println("Wiadomość: " + wiadomosc);
                System.out.println("Czas: " + czas);
            } catch (EmptyMessageException e) {
                System.out.println(e.getMessage());
                break;
            }
        }

        System.out.println("Koniec programu");
        in.close();
        socket.close();
    }
}
