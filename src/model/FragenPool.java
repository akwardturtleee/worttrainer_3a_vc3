package model;

import java.util.*;

public class FragenPool {
    private List<Fachbegriff> begriffe = new ArrayList<>();
    private List<Frage> fragen = new ArrayList<>();

    public List<Fachbegriff> getBegriffe() { return begriffe; }
    public List<Frage> getFragen() { return fragen; }

    public void clear() {
        begriffe.clear();
        fragen.clear();
    }
}
