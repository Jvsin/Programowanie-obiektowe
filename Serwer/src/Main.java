import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Scanner scanner = new Scanner(System.in);
        ExecutorService executor = Executors.newFixedThreadPool(10);
        ArrayList<Socket> klienci = new ArrayList<>();

        try {
            serverSocket = new ServerSocket(2137);
        } catch (IOException e) {
            System.err.println("Nie udało się utworzyć hosta");
            System.exit(1);
        }
        System.out.println("Utworzono hosta");

        final ServerSocket finalServerSocket = serverSocket;
        new Thread(() -> {
            while (true) {
                Socket clientSocket;
                try {
                    clientSocket = finalServerSocket.accept();
                    System.out.println("Połączono z klientem: " + clientSocket.getInetAddress().getHostAddress());
                    klienci.add(clientSocket);
                } catch (IOException e) {
                    System.err.println("Nie udało się połączyć");
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                System.out.println("Podaj tekst");
                String text = scanner.nextLine();
                for (Socket klient : klienci) {
                    executor.submit(new KlientHandler(klient, text));
                }
                if(text.isEmpty()) {
                    break;
                }
            }
            executor.shutdown();
        }).start();
    }
}
