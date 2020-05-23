package Movie;

import User.MemberCollection;

public class MovieCollection {
    private static MovieCollection movieCollection;
    private static BinarySearchTree MovieBTS;

    private MovieCollection() {}

    public static MovieCollection initCollection(){
        if(movieCollection == null) {
            movieCollection = new MovieCollection();
            MovieBTS = new BinarySearchTree();
            System.out.println("Movie Collection Initialised!");
        }

        return movieCollection;
    }

    public void add(Movie movie) {
        MovieBTS.addNode(movie.getTitle(), movie);
        System.out.println("Movie Added!1");
    }

    public void remove(String movieTitle) {
        if (MovieBTS.deleteNode(movieTitle)) {
            System.out.format("Remove %s from the movie collection%n", movieTitle);
        } else {
            System.out.format("Cannot find %s in the movie collection%n", movieTitle);
        }
    }

    public Movie search(String movieTitle) {
        Movie movie = MovieBTS.search(movieTitle);
        if (movie == null) {
            System.out.println("Cannot found movie: " + movieTitle);
        }
        return movie;
    }

    public void displayAll() {
        String all = "";
        String [] AllMovieArr = MovieBTS.getAllNode();

        for (int i=0; i < AllMovieArr.length; i++){
            if(AllMovieArr[i] != null){
                all += String.valueOf(i+1) + ". " + AllMovieArr[i] + "\n";
            }
        }
        System.out.println(all);

    }

}
