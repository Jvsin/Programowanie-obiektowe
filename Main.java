import java.util.Random;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("Zła ilośc argumentów");
            exit(1);
        }

        int zakresLiczb = 0;
        try{
            zakresLiczb = Integer.parseInt(args[0]);
        }
        catch (NumberFormatException ex){
            System.out.println("Nie podałeś liczby");
            exit(0);
        }

        if(zakresLiczb <= 0) {
            System.out.println("Liczba powinna być większa od 0");
            exit(0);
        }

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int iloscProb = 0, liczba;
        String wybor;

        while(true) {
            int losowaLiczba = random.nextInt(zakresLiczb);

            boolean trafione = false;
            while(!trafione) {
                System.out.print("Zdagnij liczbę: ");
                liczba = scanner.nextInt();
                scanner.nextLine();
                iloscProb++;

                if(liczba == losowaLiczba) {
                    System.out.println("Zgadłeś w " + iloscProb + " prób");
                    System.out.println("Czy chcesz grać dalej? (tak/nie):");
                    wybor = scanner.nextLine();
                    if(wybor.equals("tak")) {
                        iloscProb = 0;
                        trafione = true;
                    }
                    else if(wybor.equals("nie")) {
                        System.out.println("Dzięki za granie!");
                        exit(0);
                    }
                    else {
                        exit(1);
                    }
                }
                else if(liczba < losowaLiczba) {
                    System.out.println("Za mało. Spróbuj wiekszą liczbę");
                }
                else {
                    System.out.println("Za dużo. Spróbuj mniejszą liczbę");
                }
            }
        }
    }
}