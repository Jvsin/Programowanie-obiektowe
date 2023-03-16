import java.io.*;
import java.net.*;
import static java.lang.System.exit;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            System.err.println("Nie udało się utworzyć hosta");
            exit(1);
        }
        System.out.println("Utworzono hosta");

        Socket socket = null;
        try {
            socket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Nie udało się połączyć");
            exit(1);
        }
        System.out.println("Połączono");

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        LocalTime obecnyCzas;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine()) {
            System.out.print("Podaj tekst: ");
            String wejscie = scanner.nextLine();
            if(wejscie.isEmpty()) break;
            out.println(wejscie);

            obecnyCzas = LocalTime.now();
            String czas = obecnyCzas.format(format);
            out.println(czas);
            System.out.println("Wysłano o godzinie: " + czas);
        }

        out.close();
        socket.close();
        serverSocket.close();
    }
}