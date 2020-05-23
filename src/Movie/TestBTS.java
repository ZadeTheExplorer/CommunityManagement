package Movie;

import java.sql.SQLOutput;

public class TestBTS {

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();

        Movie movie1 = new Movie(
                "Titanic",
                "Leonardo DiCaprio, Kate Winslet, Billy Zane, Kathy Bates, Frances Fisher, Bernard Hill",
                "Jame Cameron",
                "195minutes",
                new Genres[] {Genres.DRAMA, Genres.OTHER},
                Classification.G,
                "1997",
                10
        );

        Movie movie2 = new Movie(
                "The Wizard of Oz ",
                "Judy Garland, Ray Bolger, Jack Haley, Bert Lahr, Margaret Hamilton, Billie Burke",
                "King Vidor",
                "101 minutes",
                new Genres[] {Genres.FAMILY, Genres.SCI_FI, Genres.OTHER},
                Classification.G,
                "Aug 25, 1939 (Wide)",
                10
        );

        Movie movie3 = new Movie(
                "Us",
                "Lupita Nyong'o, Winston Duke, Elisabeth Moss, Tim Heidecker, Shahadi Wright-Joseph, Evan Alex",
                "Jordan Peele",
                "120 minutes",
                new Genres[] { Genres.THRILLER, Genres.SCI_FI, Genres.OTHER },
                Classification.M,
                "Mar 22, 2019 (Wide)",
                10
        );

        //TODO: ADD 15 movie to the collection
        // 4: Incredibles 2
        // 5: Money Heist
        // 6: IT chapter 2
        // 7: The Dark Knight 2008
        // 8: The lord of Rings 2003
        // 9: Spirited Away (Adventure, Animated, Family)
        // 10: Parasite 2019
        // 11: Idiots 2009
        // 12: Toy Story 3
        // 13: The Godfather
        // 14: God of Gamblers
        // 15: Inception 2010

        //TODO: Impliment testing BTS here
        tree.addNode(movie1.getTitle(), movie1);
        tree.addNode(movie2.getTitle(), movie2);
        tree.addNode(movie3.getTitle(), movie3);
        tree.innerTraverse(tree.root);
        System.out.println(tree.deleteNode("Us"));
        System.out.println(tree.search("Us"));
        System.out.println(tree.deleteNode("Us"));
    }

}
