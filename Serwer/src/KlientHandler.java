import java.io.*;
import java.net.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class KlientHandler implements Runnable{
    final Socket socket;
    PrintWriter out;
    DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");

    KlientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(socket.getOutputStream(), true);

            LocalTime obecnyCzas;
            Scanner scanner = new Scanner(System.in);

            System.out.println("Podaj tekst");
            while(scanner.hasNextLine()) {
                String wyjscie = scanner.nextLine();
                if(wyjscie.isEmpty()) {
                    break;
                }
                out.println(wyjscie);

                obecnyCzas = LocalTime.now();
                String czas = obecnyCzas.format(format);
                out.println(czas);
                System.out.println("Wysłano o godzinie: " + czas);
                System.out.println("\nPodaj tekst:");
            }
            System.out.println("Połączenie z klientem zakończone");
            out.close();
            socket.close();

        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas obsługi klienta");
        }
    }
}
