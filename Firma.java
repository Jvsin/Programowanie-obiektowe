public class Firma extends Wpis {
    private final String nazwa;
    private final String adres;
    private final NrTelefoniczny nrTelefonu;

    public Firma(String nazwa, String adres, NrTelefoniczny nrTelefonu) {
        this.nazwa = nazwa;
        this.adres = adres;
        this.nrTelefonu = nrTelefonu;
    }

    public String getAdres() {
        return this.adres;
    }

    public void opis() {
        System.out.println("Firma: " + nazwa + ", adres: " + adres + ", numer telefonu: " + nrTelefonu);
    }
}
