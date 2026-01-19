package model;

public class Fachbegriff {

    private String begriff;
    private String beschreibung;
    private String kategorie;
    private int schwierigkeit;

    public Fachbegriff(String begriff, String beschreibung,
                       String kategorie, int schwierigkeit) {
        this.begriff = begriff;
        this.beschreibung = beschreibung;
        this.kategorie = kategorie;
        this.schwierigkeit = schwierigkeit;
    }

    public String getBegriff() {
        return begriff;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public String getKategorie() {
        return kategorie;
    }

    public int getSchwierigkeit() {
        return schwierigkeit;
    }

    @Override
    public String toString() {
        return begriff + " (" + kategorie + ")";
    }
}
