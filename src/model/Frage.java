package model;

public class Frage {

    // typ = "TEXT" oder "BILD"
    private String typ;
    private String inhalt;
    private String richtigeAntwort;

    public Frage(String typ, String inhalt, String richtigeAntwort) {
        this.typ = typ;
        this.inhalt = inhalt;
        this.richtigeAntwort = richtigeAntwort;
    }

    public String getTyp() {
        return typ;
    }

    public String getInhalt() {
        return inhalt;
    }

    public String getRichtigeAntwort() {
        return richtigeAntwort;
    }

    @Override
    public String toString() {
        if (typ.equals("TEXT")) {
            return "TEXT: " + inhalt;
        }
        if (typ.equals("BILD")) {
            return "BILD: " + inhalt;
        }
        return inhalt;
    }
}
