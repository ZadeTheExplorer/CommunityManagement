package Main;

import java.util.Scanner;

public class memberMenu {
    public void memberMenu() {

        String memberMenu = "==============Member Menu==============\n" +
                "1. Display all movies\n" +
                "2. Borrow a movie DVD\n" +
                "3. Return a movie DVD\n" +
                "4. List current borrowed movie DVDSs\n" +
                "5. Display top 10 most popular movies\n" +
                "0. Return to main Menu\n" +
                "=======================================\n\n" +
                "Please make a selection (1-5 or 0 to exit): ";

        Scanner scanner = new Scanner(System.in);

        System.out.print(memberMenu);

        while(scanner.hasNext()) {

        }
    }
}
