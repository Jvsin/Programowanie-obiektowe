import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        if(args.length == 3) {
            String slowo = args[0];

            int dolnyIndex = 0, gornyIndex = 0;

            try{
                dolnyIndex = Integer.parseInt(args[1]);
            }
            catch (NumberFormatException ex){
                exit(0);
            }

            try{
                gornyIndex = Integer.parseInt(args[2]);
            }
            catch (NumberFormatException ex){
                exit(0);
            }

            if(dolnyIndex < gornyIndex && dolnyIndex >= 0 && gornyIndex <= slowo.length()) {
                for(int i = dolnyIndex; i < gornyIndex + 1; i++) {
                    System.out.print(slowo.charAt(i));
                }
            }
        }
    }
}