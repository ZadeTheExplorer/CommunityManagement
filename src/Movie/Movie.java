package Movie;

import java.util.Arrays;

public class Movie {

    private String title;
    private String starring;
    private String director;
    private Genres genre;
    private String duration;
    private Classification classification;
    private String releaseDate;
    private int totalDVDs;

    public void setClassification(Classification classification) {this.classification = classification;}
    public Classification getClassification() {
        return classification;
    }

    public void setDirector(String director) {this.director = director;}
    public String getDirector() {
        return director;
    }

    public void setDuration(String duration) {this.duration = duration;}
    public String getDuration() {
        return duration;
    }

    public void setGenre(Genres genre) {this.genre = genre;}
    public Genres getGenre() {
        return genre;
    }

    public void setReleaseDate(String releaseDate) {this.releaseDate = releaseDate;}
    public String getReleaseDate() {
        return releaseDate;
    }

    public void setStarring(String starring) {this.starring = starring;}
    public String getStarring() {
        return starring;
    }

    public void setTitle(String title) {this.title = title;}
    public String getTitle() {
        return title;
    }

    public void setTotalDVDs(int totalDVDs) {
        this.totalDVDs = totalDVDs;
    }
    public int getTotalDVDs() {
        return totalDVDs;
    }

    // constructor
    public Movie(String title, String starring, String director, String duration, Genres genre, Classification classification, String releaseDate, int totalDVDs){
        this.title = title;
        this.starring = starring;
        this.director = director;
        this.duration = duration;
        this.genre = genre;
        this.classification = classification;
        this.releaseDate = releaseDate;
        this.totalDVDs = totalDVDs;
    }

    @Override
    public String toString() {
        return title + " {" + '\n' +
                "      starring: " + starring + '\n' +
                "      director: " + director + '\n' +
                "      genre: " + genre + '\n' +
                "      duration: " + duration + '\n' +
                "      classification: " + classification + '\n' +
                "      releaseDate: " + releaseDate + '\n' +
                '}';
    }
}
