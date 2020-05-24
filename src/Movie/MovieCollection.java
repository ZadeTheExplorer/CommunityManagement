package Movie;

import User.MemberCollection;

import java.util.Arrays;

public class MovieCollection {
    private static MovieCollection movieCollection;
    private static BinarySearchTree MovieBTS;

    private MovieCollection() {}

    public static MovieCollection getInstance(){
        if(movieCollection == null) {
            movieCollection = new MovieCollection();
            MovieBTS = new BinarySearchTree();
            System.out.println("Movie Collection Initialised!");
        }

        return movieCollection;
    }

    public void add(Movie movie) {
        MovieBTS.addNode(movie.getTitle(), movie);
        System.out.println("Movie Added!");
    }

    public void remove(String movieTitle) {
        if (MovieBTS.deleteNode(movieTitle)) {
            System.out.format("Remove %s from the movie collection%n", movieTitle);
        } else {
            System.out.format("Cannot find %s in the movie collection%n", movieTitle);
        }
    }

    public MovieNode search(String movieTitle) {
        MovieNode movie = MovieBTS.search(movieTitle);
        if (movie == null) {
            System.out.println("Cannot found movie: " + movieTitle);
        }
        return movie;
    }

    public String[] getAllMovieTitle() {
        return MovieBTS.getAllNode();
    }

    public void displayAll() {
        StringBuilder all = new StringBuilder();
        String [] AllMovieArr = MovieBTS.getAllNode();
        for (int i=0; i < AllMovieArr.length; i++){
            if(AllMovieArr[i] != null){
                all.append(String.format("%02d",i + 1)).append(". ").append(AllMovieArr[i]).append("\n");
            }
        }
        System.out.println(all);
    }

    public void modifyBorrowedNum(String title, int amountOfDVDs) {
        MovieBTS.search(title).modifyBorrowedNum(amountOfDVDs);
    }
}
