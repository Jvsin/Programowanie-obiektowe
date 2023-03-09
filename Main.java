import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        File plik;
        Scanner plikScanner = null;

        try {
            plik = new File("test.txt");
            plikScanner = new Scanner(plik);
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku.");
            e.printStackTrace();
            exit(1);
        }

        List<String> wartosci = new ArrayList<>();
        Map<String, List<String>> mapa = new LinkedHashMap<>();
        String klucz = null;
        boolean pierwsze = true;

        while (plikScanner.hasNextLine()) {
            String data = plikScanner.nextLine();
            if (data.endsWith(":")) {
                if (!pierwsze) {
                    mapa.put(klucz, wartosci);
                    wartosci = new ArrayList<>();
                }
                klucz = data;
                pierwsze = false;
            } else {
                wartosci.add(data);
            }
        }
        plikScanner.close();
        mapa.put(klucz, wartosci);

        for (Map.Entry<String, List<String>> dane : mapa.entrySet()) {
            System.out.println(dane.getKey());
            for (String wartosc : dane.getValue()) {
                System.out.println("\t" + wartosc);
            }
        }
    }
}
