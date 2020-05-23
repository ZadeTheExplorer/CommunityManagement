package Main;

import Movie.*;

import java.util.Arrays;

/**
 * The type Main.
 */
public class Main {

    public static void main(String[] args){
        Movie movie1 = new Movie(
                "Titanic",
                "Leonardo DiCaprio, Kate Winslet, Billy Zane, Kathy Bates, Frances Fisher, Bernard Hill",
                "Jame Cameron",
                "195minutes",
                Genres.DRAMA,
                Classification.G,
                "1997",
                10
        );

        Movie movie2 = new Movie(
                "The Wizard of Oz ",
                "Judy Garland, Ray Bolger, Jack Haley, Bert Lahr, Margaret Hamilton, Billie Burke",
                "King Vidor",
                "101 minutes",
                Genres.FAMILY,
                Classification.G,
                "Aug 25, 1939 (Wide)",
                10
        );

        Movie movie3 = new Movie(
                "Us",
                "Lupita Nyong'o, Winston Duke, Elisabeth Moss, Tim Heidecker, Shahadi Wright-Joseph, Evan Alex",
                "Jordan Peele",
                "120 minutes",
                Genres.THRILLER,
                Classification.M,
                "Mar 22, 2019 (Wide)",
                10
        );

        MovieCollection collection = MovieCollection.getInstance();
        collection.add(movie1);
        collection.add(movie2);
        collection.add(movie3);
        for (int i=0; i<10; i++){
            String title = "Movie " + String.format("%02d", i+1);
            Movie movie = new Movie(
                    title,
                    "Actor 1, Actress 2",
                    "Director 1",
                    "100 minutes",
                    Genres.THRILLER,
                    Classification.MA,
                    "OLD",
                    10
            );
            collection.add(movie);
        }
        Menu menu = new Menu(collection);
        menu.main();
        System.out.println("The End.");
        String[] array= collection.getAllMovieTitle();
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));

    }
}
