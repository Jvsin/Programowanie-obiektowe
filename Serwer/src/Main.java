import java.io.*;
import java.net.*;
import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            System.err.println("Nie udało się utworzyć hosta");
            exit(1);
        }
        System.out.println("Utworzono hosta");

        while (true) {
            Socket socket;
            try {
                socket = serverSocket.accept();
                System.out.println("Połączono z klientem: " + socket.getInetAddress().getHostAddress());
            } catch (IOException e) {
                System.err.println("Nie udało się połączyć");
                continue;
            }

            new Thread(new KlientHandler(socket)).start();
        }
    }
}
