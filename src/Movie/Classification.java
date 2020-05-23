package Movie;

public enum Classification {
    G ("General"),
    PG("Parental Guidance (PG)"),
    M("Mature (M15+)"),
    MA("Mature Accompanied (MA15+)");

    private String string;

    public String getString() {
        return string;
    }

    private Classification(String string) {
        this.string = string;
    }
}
