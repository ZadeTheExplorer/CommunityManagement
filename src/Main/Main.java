package Main;

import Movie.*;
import User.Member;
import User.MemberCollection;

import java.io.IOException;
import java.util.Arrays;

import static java.lang.Thread.sleep;

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



        Member member1 = new Member("Taylor Swift", "1234", "0123456789", "America");
        Member member2 = new Member("Ariana Grade", "1234", "0987654321", "America");
        Member member3 = new Member("Cristiano Ronaldo", "1234", "0124395678", "Spain");
        Member member4 = new Member("Bill Gates", "1234", "0123789456", "America");
        Member member5 = new Member("Barack Obama", "1234", "0456712389", "America");
        Member member6 = new Member("Elon Musk", "1234", "0412356789", "America");
        Member member7 = new Member("Sy Tri Ha", "1234", "0123456789", "Vietnam");

        MemberCollection memberCollection = MemberCollection.getInstance();


        char[] animationChars = new char[]{'|', '/', '-', '\\'};

        for (int i = 0; i <= 100; i++) {
            System.out.print("Initializing: " + i + "% " + animationChars[i % 4] + "\r");

            try {
                if (i == 1){
                    System.out.println("Staffs are adding new movie to movie collection...");
                    movieCollection.add(movie1);
                    movieCollection.add(movie2);
                    movieCollection.add(movie3);
                    for (int j=0; j<10; j++){
                        String title = "Movie " + String.format("%02d", j+1);
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
                    sleep(100);
                    System.out.println("Adding new movie finished.");
                }
                if (i == 33) {
                    System.out.println("Staffs are adding sample members to member collection...");
                    memberCollection.addMember(member1);
                    memberCollection.addMember(member2);
                    memberCollection.addMember(member3);
                    memberCollection.addMember(member4);
                    memberCollection.addMember(member5);
                    memberCollection.addMember(member6);
                    memberCollection.addMember(member7);
                    sleep(100);
                    System.out.println("Sample member generated.");
                }
                if (i == 60) {
                    System.out.println("Sample members are borrowing movie DVDs...");
                    // Member 1 borrowed full slots
                    member1.borrowDVD("Movie 01");member1.borrowDVD("Us");
                    member2.borrowDVD("Movie 03");member2.borrowDVD("Us");member2.borrowDVD("Titanic");member2.borrowDVD("The Wizard of Oz");
                    member3.borrowDVD("Movie 04");member3.borrowDVD("Us");
                    member7.borrowDVD("Us");
                    sleep(100);
                    System.out.println("Sample Borrowing DVDs finished.");
                }
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Initializing: Done!  - 100%");
        System.out.println("Redirect user to main menu.");
        Menu menu = new Menu(movieCollection);
        menu.main();

    }
}
