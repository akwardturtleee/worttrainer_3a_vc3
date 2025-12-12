package model;

public class Fachbegriff {

    private String begriff;
    private String definition;

    public Fachbegriff(String begriff, String definition) {
        this.begriff = begriff;
        this.definition = definition;
    }

    public String getBegriff() { return begriff; }
    public void setBegriff(String begriff) { this.begriff = begriff; }

    public String getDefinition() { return definition; }
    public void setDefinition(String definition) { this.definition = definition; }
}
