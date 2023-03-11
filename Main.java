import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        NrTelefoniczny nr1 = new NrTelefoniczny(48, 123456789);
        NrTelefoniczny nr2 = new NrTelefoniczny(48, 987654321);
        NrTelefoniczny nr3 = new NrTelefoniczny(48, 111222333);
        NrTelefoniczny nr4 = new NrTelefoniczny(48, 444555666);

        Osoba osoba1 = new Osoba("Jan", "Kowalski", "Radwańska 32", nr1);
        Osoba osoba2 = new Osoba("Anna", "Nowak", "Stefanowskiego 18/22", nr2);
        Firma firma1 = new Firma("Zahir kebab", "Radwańska 32", nr3);
        Firma firma2 = new Firma("Indeks", "Stefanowskiego 17", nr4);

        TreeMap<NrTelefoniczny, Wpis> ksiazkaTelefoniczna = new TreeMap<>();
        ksiazkaTelefoniczna.put(nr1, osoba1);
        ksiazkaTelefoniczna.put(nr2, osoba2);
        ksiazkaTelefoniczna.put(nr3, firma1);
        ksiazkaTelefoniczna.put(nr4, firma2);

        System.out.println("Oryginalna książka telefoniczna");
        wypisz(ksiazkaTelefoniczna);
        usun(ksiazkaTelefoniczna);
        System.out.println("Książka telefoniczna po usunięciu takich samych adresów");
        wypisz(ksiazkaTelefoniczna);
    }

    public static void wypisz(TreeMap<NrTelefoniczny, Wpis> ksiazkaTelefoniczna) {
        for (Map.Entry<NrTelefoniczny, Wpis> para : ksiazkaTelefoniczna.entrySet()) {
            para.getValue().opis();
        }
        System.out.println();
    }

    public static void usun(TreeMap<NrTelefoniczny, Wpis> ksiazkaTelefoniczna) {
        ArrayList<String> ksiazkaAdresow = new ArrayList<>();
        Iterator<Map.Entry<NrTelefoniczny, Wpis>> iterator = ksiazkaTelefoniczna.entrySet().iterator();

        while(iterator.hasNext()) {
            Map.Entry<NrTelefoniczny, Wpis> entry = iterator.next();
            String adres = entry.getValue().getAdres();
            if(ksiazkaAdresow.contains(adres)) {
                iterator.remove();
            }
            else {
                ksiazkaAdresow.add(adres);
            }
        }
    }
}
