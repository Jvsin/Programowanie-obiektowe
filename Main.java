import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj pierwszy wektor: ");
        ArrayList<Integer> wektor1 = readVector(scanner);

        System.out.print("Podaj drugi wektor: ");
        ArrayList<Integer> wektor2 = readVector(scanner);

        while (wektor1.size() != wektor2.size()) {
            try {
                throw new WektoryRoznejDlugosciException(wektor1, wektor2);
            }
            catch(WektoryRoznejDlugosciException e) {
                System.out.println(e.getMessage());
                System.out.println("Podaj ponownie wektory\n");

                System.out.print("Podaj pierwszy wektor: ");
                wektor1 = readVector(scanner);

                System.out.print("Podaj drugi wektor: ");
                wektor2 = readVector(scanner);
            }
        }

        ArrayList<Integer> wektorWynik = new ArrayList<>();
        for(int i = 0; i < wektor1.size(); i++) {
            wektorWynik.add(wektor1.get(i) + wektor2.get(i));
        }

        for(Integer liczba : wektorWynik) {
            System.out.println(liczba);
        }
    }

    private static ArrayList<Integer> readVector(Scanner scanner) {
        ArrayList<Integer> wektor = new ArrayList<>();
        while(scanner.hasNextLine()) {
            String linia = scanner.nextLine();
            if(linia.isEmpty()) {
                break;
            }

            String[] slowo = linia.split("\\s+");
            for(String liczba : slowo) {
                try {
                    wektor.add(Integer.parseInt(liczba));
                }
                catch (NumberFormatException e) {
                    System.out.println("Podaj tylko liczby");
                }
            }
        }

        return wektor;
    }
}