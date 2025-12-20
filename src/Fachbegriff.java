public class Fachbegriff {
    private String begriff;
    private String erklaerung;
    private String kategorie;


    public Fachbegriff(String begriff, String erklaerung, String kategorie) {
        this.begriff = begriff;
        this.erklaerung = erklaerung;
        this.kategorie = kategorie;
    }


    public String getBegriff() {
        return begriff;
    }


    public String getErklaerung() {
        return erklaerung;
    }


    public String getKategorie() {
        return kategorie;
    }


    @Override
    public String toString() {
        return begriff;
    }
}