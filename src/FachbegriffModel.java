import java.util.ArrayList;
import java.util.List;


public class FachbegriffModel {


    private List<Fachbegriff> begriffe;


    public FachbegriffModel() {
        begriffe = new ArrayList<>();
        begriffe.add(new Fachbegriff(
                "Algorithmus",
                "Eine feste Abfolge von Schritten",
                "Informatik"));
        begriffe.add(new Fachbegriff(
                "Integral",
                "Flächenberechnung unter einer Kurve",
                "Mathematik"));
    }


    public List<Fachbegriff> getAlleBegriffe() {
        return begriffe;
    }
}