import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        Map<String, String[]> mapa = new LinkedHashMap<>();
        try {
            File plik = new File("test.txt");
            Scanner plikScanner = new Scanner(plik);
            List wartosci = new ArrayList<String>();
            while (plikScanner.hasNextLine()) {
                String data = plikScanner.nextLine();
                if(data.charAt(data.length() - 1) == ':') {
                    String klucz = data;
                }
                else {
                    wartosci.add(data);
                }

            }
            plikScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku.");
            e.printStackTrace();
            exit(1);
        }
    }
}
