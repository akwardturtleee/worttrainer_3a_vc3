package model;

public class Statistik {
    private int richtig = 0;
    private int falsch = 0;

    public void richtig() { richtig++; }
    public void falsch() { falsch++; }

    public int getRichtig() { return richtig; }
    public int getFalsch() { return falsch; }

    public void reset() {
        richtig = 0;
        falsch = 0;
    }
}
