package Movie;

public enum Genres {
    DRAMA ("Drama"),
    ADVENTURE("Adventure"),
    FAMILY("Family"),
    ACTION("Action"),
    SCI_FI("Sci-Fi"),
    COMEDY("Comedy"),
    ANIMATED("Animated"),
    THRILLER("Thriller"),
    OTHER("Other");

    private String string;

    public String getString() {
        return string;
    }

    private Genres(String string) {
        this.string = string;
    }

}
