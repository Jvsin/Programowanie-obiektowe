public class Osoba extends Wpis {
    private final String imie;
    private final String nazwisko;
    private final String adres;
    private final NrTelefoniczny nrTelefonu;

    public Osoba(String imie, String nazwisko, String adres, NrTelefoniczny nrTelefonu) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.nrTelefonu = nrTelefonu;
    }

    public String getAdres() {
        return this.adres;
    }

    public void opis() {
        System.out.println("Osoba: " + imie + " " + nazwisko + ", adres: " + adres + ", numer telefonu: " + nrTelefonu);
    }
}
