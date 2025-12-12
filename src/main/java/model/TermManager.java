package model;

import java.util.ArrayList;

public class TermManager {

    private static final TermManager instance = new TermManager();

    public static TermManager getInstance() {
        return instance;
    }

    private final ArrayList<Fachbegriff> terms = new ArrayList<>();

    public ArrayList<Fachbegriff> getTerms() {
        return terms;
    }

    public void addTerm(String begriff, String def) {
        terms.add(new Fachbegriff(begriff, def));
    }

    public void removeTerm(Fachbegriff term) {
        terms.remove(term);
    }
}
