import java.io.*;
import java.net.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class KlientHandler implements Runnable {
    final Socket socket;
    PrintWriter out;
    DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
    String text;

    KlientHandler(Socket socket, String text) {
        this.socket = socket;
        this.text = text;
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(socket.getOutputStream(), true);

            out.println(text);
            LocalTime obecnyCzas = LocalTime.now();
            String czas = obecnyCzas.format(format);
            out.println(czas);
            System.out.println("Wysłano o godzinie: " + czas);

        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas obsługi klienta");
        }
    }
}
