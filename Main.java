import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
        String wybor, nazwa, klucz = null, przedmiot;
        boolean pierwsze = true, wyjdz = false;
        Scanner scanner = new Scanner(System.in);

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

        while(!wyjdz) {
            System.out.println("wyjdź");
            System.out.println("wyświetl wszystko");
            System.out.println("wyświetl kategorie");
            System.out.println("dodaj kategorie");
            System.out.println("dodaj produkty");
            System.out.println("usuń wszystko");
            System.out.println("usuń kategorie");
            System.out.println("usuń produkt");
            System.out.println();
            System.out.println("Co chcesz zrobić:");

            wybor = scanner.nextLine();
            System.out.println();

            switch(wybor) {
                case "wyjdź":
                    wyjdz = true;
                    break;

                case "wyświetl wszystko":
                    for (Map.Entry<String, List<String>> dane : mapa.entrySet()) {
                        System.out.println(dane.getKey());

                        if(dane.getValue() == null) {
                            System.out.println("\tPusto");
                            continue;
                        }

                        for (String wartosc : dane.getValue()) {
                            System.out.println("\t" + wartosc);
                        }
                    }
                    System.out.println();
                    break;

                case "wyświetl kategorie":
                    for (Map.Entry<String, List<String>> dane : mapa.entrySet()) {
                        klucz = dane.getKey();
                        System.out.println(klucz.substring(0, klucz.length() - 1));
                    }
                    System.out.println();
                    System.out.println("Podaj kategorię, którą chcesz wyświetlić:");
                    nazwa = scanner.nextLine() + ":";
                    if(!mapa.containsKey(nazwa)) {
                        System.out.println("Nie istnieje taka kategoria");
                        break;
                    }

                    wartosci = mapa.get(nazwa);
                    for(String produkt : wartosci) {
                        System.out.println("\t" + produkt);
                    }
                    System.out.println();
                    break;

                case "dodaj kategorie":
                    System.out.print("Podaj nazwę kategorii: ");
                    nazwa = scanner.nextLine() + ":";
                    mapa.put(nazwa, null);
                    System.out.println();
                    break;

                case "dodaj produkty":
                    System.out.println("Podaj nazwę kategorii, do której chcesz dodać produkty: ");
                    for (Map.Entry<String, List<String>> dane : mapa.entrySet()) {
                        klucz = dane.getKey();
                        System.out.println(klucz.substring(0, klucz.length() - 1));
                    }
                    System.out.println();

                    nazwa = scanner.nextLine() + ":";
                    if(!mapa.containsKey(nazwa)) {
                        System.out.println("Nie istnieje taka kategoria");
                        break;
                    }

                    System.out.println("Podaj produkty do dodania:");
                    wartosci = mapa.get(nazwa);
                    if(wartosci == null) {
                        wartosci = new ArrayList<>();
                    }
                    while(scanner.hasNextLine()) {
                        przedmiot = scanner.nextLine();
                        if(przedmiot.isEmpty()) {
                            break;
                        }

                        if(!wartosci.contains(przedmiot)) {
                            wartosci.add(przedmiot);
                        }
                    }

                    mapa.put(nazwa, wartosci);
                    System.out.println();
                    break;

                case "usuń wszystko":
                    mapa = new LinkedHashMap<>();
                    System.out.println();
                    break;

                case "usuń kategorie":
                    System.out.println("Podaj kategorię, którą chcesz usunąć:");
                    nazwa = scanner.nextLine() + ":";
                    if(!mapa.containsKey(nazwa)) {
                        System.out.println("Nie istnieje taka kategoria");
                        break;
                    }
                    mapa.remove(nazwa);
                    break;

                case "usuń produkt":
                    System.out.println("Podaj nazwę kategorii, do której chcesz usunąć produkty: ");
                    for (Map.Entry<String, List<String>> dane : mapa.entrySet()) {
                        klucz = dane.getKey();
                        System.out.println(klucz.substring(0, klucz.length() - 1));
                    }
                    System.out.println();

                    nazwa = scanner.nextLine() + ":";
                    if(!mapa.containsKey(nazwa)) {
                        System.out.println("Nie istnieje taka kategoria");
                        break;
                    }

                    wartosci = mapa.get(nazwa);
                    for(String produkt : wartosci) {
                        System.out.println("\t" + produkt);
                    }

                    System.out.println("Podaj produkty do usunięcia:");
                    wartosci = mapa.get(nazwa);
                    while(scanner.hasNextLine()) {
                        przedmiot = scanner.nextLine();
                        if(przedmiot.isEmpty()) {
                            break;
                        }

                        if(wartosci.contains(przedmiot)) {
                            wartosci.remove(przedmiot);
                        }
                    }
                    System.out.println();
                    break;

                default:
                    System.out.println("Niepoprawny wybór");
                    break;
            }
        }

        System.out.println("Czy chcesz zapisać te liste? (tak/nie)");
        wybor = scanner.nextLine();
        if(wybor.equals("tak")) {
            System.out.print("Podaj nazwę pliku: ");
            nazwa = scanner.nextLine();

            try {
                FileWriter writer = new FileWriter(nazwa);

                for (Map.Entry<String, List<String>> dane : mapa.entrySet()) {
                    writer.write(dane.getKey() + "\n");
                    for (String wartosc : dane.getValue()) {
                        writer.write(wartosc + "\n");
                    }
                }
                writer.close();
                System.out.println("Zapisano");
            } catch (IOException e) {
                System.out.println("Nie udało się otworzyć pliku");
                e.printStackTrace();
            }
        }
    }
}
