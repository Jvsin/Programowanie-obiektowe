import java.util.ArrayList;

public class WektoryRoznejDlugosciException extends Exception{
    public WektoryRoznejDlugosciException(ArrayList<Integer> wektor1, ArrayList<Integer> wektor2) {
        super("Wektory mają różną długość\n" + "Wektor 1: " + wektor1.size() + "\nWektor 2: " + wektor2.size());
    }
}
