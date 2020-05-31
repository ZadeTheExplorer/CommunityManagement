package Main;

import Movie.*;
import User.Member;
import User.MemberCollection;

import java.util.Arrays;

/**
 * The type Main.
 */
public class Main {
    //TODO: COMMENT
    public static void main(String[] args){
        Movie movie1 = new Movie(
                "Titanic",
                "Leonardo DiCaprio, Kate Winslet",
                "Jame Cameron",
                "195minutes",
                Genres.DRAMA,
                Classification.G,
                "1997",
                10
        );

        Movie movie2 = new Movie(
                "The Wizard of Oz",
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
                4
        );

        MovieCollection movieCollection = MovieCollection.getInstance();
        movieCollection.add(movie1);
        movieCollection.add(movie2);
        movieCollection.add(movie3);
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
            movieCollection.add(movie);
        }


        Member member1 = new Member("Taylor Swift", "1234", "0123456789", "America");
        Member member2 = new Member("Ariana Grade", "1234", "0987654321", "America");
        Member member3 = new Member("Cristiano Ronaldo", "1234", "0124395678", "Spain");
        Member member4 = new Member("Bill Gates", "1234", "0123789456", "America");
        Member member5 = new Member("Barack Obama", "1234", "0456712389", "America");
        Member member6 = new Member("Elon Musk", "1234", "0412356789", "America");
        Member member7 = new Member("Sy Tri Ha", "1234", "0123456789", "Vietnam");

        MemberCollection memberCollection = MemberCollection.getInstance();
        memberCollection.addMember(member1);
        memberCollection.addMember(member2);
        memberCollection.addMember(member3);
        memberCollection.addMember(member4);
        memberCollection.addMember(member5);
        memberCollection.addMember(member6);
        memberCollection.addMember(member7);
        // Member 1 borrowed full slots
        member1.borrowDVD("Movie 01");member1.borrowDVD("Us");

        member2.borrowDVD("Movie 03");member2.borrowDVD("Us");member2.borrowDVD("Titanic");member2.borrowDVD("The Wizard of Oz");
        member3.borrowDVD("Movie 04");member3.borrowDVD("Us");
        member7.borrowDVD("Us");
        Menu menu = new Menu(movieCollection);
        menu.main();

    }
}
