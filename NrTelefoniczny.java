public class NrTelefoniczny implements Comparable<NrTelefoniczny> {
    private final int nrKierunkowy;
    private final int nrTelefonu;

    public NrTelefoniczny(int nrKierunkowy, int nrTelefonu) {
        this.nrKierunkowy = nrKierunkowy;
        this.nrTelefonu = nrTelefonu;
    }

    @Override
    public String toString() {
        return nrKierunkowy + " " + nrTelefonu;
    }

    @Override
    public int compareTo(NrTelefoniczny drugi) {
        if (this.nrKierunkowy == drugi.nrKierunkowy) {
            // zwraca 1 jeżeli this.nrTelefonu > drugi.nrTelefonu
            // zwraca 0 jeżeli this.nrTelefonu = drugi.nrTelefonu
            // zwraca -1 jeżeli this.nrTelefonu < drugi.nrTelefonu
            return Integer.compare(this.nrTelefonu, drugi.nrTelefonu);
        }
        else {
            return Integer.compare(this.nrKierunkowy, drugi.nrKierunkowy);
        }
    }
}
