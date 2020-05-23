package Main;

import Movie.*;
import java.util.Scanner;

/**
 * The type Main.
 */
public class Main {

    /**
     * The Collection.
     */
    static MovieCollection collection = MovieCollection.initCollection();

    /**
     * All genres to string string.
     *
     * @return the string
     */
    public static String allGenresToString() {
        Genres[] genres = Genres.values();
        StringBuilder genresString = new StringBuilder();
        for (int i=0; i<genres.length; i++){
            genresString.append(String.valueOf(i + 1)).append(". ").append(genres[i].getString()).append("\n");
        }
        return genresString.toString();
    }

    /**
     * Get genres input genres [ ].
     *
     * @param listOfGenres the list of genres
     * @return the genres [ ]
     */
    public static Genres[] getGenresInput(String listOfGenres) {
        String [] listVector = listOfGenres.split(" ");
        Genres[] genres = new Genres[listVector.length];
        for (int i=0; i < listVector.length; i++){
            if (listVector[i].compareTo("1") == 0){
                genres[i] = Genres.DRAMA;
            }
            if (listVector[i].compareTo("2") == 0){
                genres[i] = Genres.ADVENTURE;
            }
            if (listVector[i].compareTo("3") == 0){
                genres[i] = Genres.FAMILY;
            }
            if (listVector[i].compareTo("4") == 0){
                genres[i] = Genres.ACTION;
            }
            if (listVector[i].compareTo("5") == 0){
                genres[i] = Genres.SCI_FI;
            }
            if (listVector[i].compareTo("6") == 0){
                genres[i] = Genres.COMEDY;
            }
            if (listVector[i].compareTo("7") == 0){
                genres[i] = Genres.ANIMATED;
            }
            if (listVector[i].compareTo("8") == 0){
                genres[i] = Genres.THRILLER;
            }
            if (listVector[i].compareTo("9") == 0){
                genres[i] = Genres.OTHER;
            }
        }
        return genres;
    }

    /**
     * All classification string.
     *
     * @return the string
     */
    public static String allClassification() {
        Classification[] classifications = Classification.values();
        StringBuilder classificationsString = new StringBuilder();
        for (int i=0; i<classifications.length; i++){
            classificationsString.append(String.valueOf(i + 1)).append(". ").append(classifications[i].getString()).append("\n");
        }
        return classificationsString.toString();
    }

    /**
     * Gets classification input.
     *
     * @param input the input
     * @return the classification input
     */
    public static Classification getClassificationInput(int input) {

        Classification classification = null;

        switch (input){
            case 1:
                classification = Classification.G;
                break;
            case 2:
                classification = Classification.PG;
                break;
            case 3:
                classification = Classification.M;
                break;
            case 4:
                classification = Classification.MA;
                break;
            default:
                break;
        }

        return classification;
    }

    /**
     * Clear screen.
     */
    public static void clearScreen() {
        System.out.println(System.lineSeparator().repeat(50));
    }


    /**
     * Main menu.
     */
    public static void mainMenu() {
        Scanner input = new Scanner(System.in);

        String welcomeMenu = "Welcome to the Community Library\n" +
                "============Main Menu===========\n" +
                " 1. Staff Login\n" +
                " 2. Member Login\n" +
                " 0. Exit\n" +
                "================================\n\n" +
                "Please make a selection (1-2 or 0 to exit): ";

        clearScreen();

        System.out.print(welcomeMenu);

        switch(input.nextInt()) {
            case 1:
                staffMenu();
                break;
            case 2:
                memberMenu();
                break;
            case 0:
                input.close();
                System.exit(0);
                break;
            default:
                System.out.print("Wrong input, please try again");
                input.nextInt();
        }
        input.close();
    }

    /**
     * Staff menu.
     */
    public static void staffMenu() {
        String staffMenu = "================Staff Menu================\n" +
                "1. Add a new movie DVD\n" +
                "2. Remove a movie DVD\n" +
                "3. Register a new Member\n" +
                "4. Find a registered member's phone number\n" +
                "0. Return to main menu\n" +
                "==========================================\n\n" +
                "Please make a selection (1-5 or 0 to exit): ";

        Scanner scanner = new Scanner(System.in);

        clearScreen();
        System.out.print(staffMenu);

        while(scanner.hasNext()){
            if(scanner.nextInt() == 1){

                scanner.nextLine();
                System.out.print("Enter the movie title of the DVD added: ");
                String title = scanner.nextLine();

                System.out.print("Enter the list of starring, separated by comma: ");
                String starring = scanner.nextLine();

                System.out.print("Enter the name of director: ");
                String director = scanner.nextLine();

                System.out.print("Enter the durations (minutes): ");
                String duration = scanner.nextLine();

                System.out.println(allGenresToString());
                System.out.print("Enter the genres from the list above with number, separate with space: ");
                Genres[] genres = getGenresInput(scanner.nextLine());

                System.out.println(allClassification());
                System.out.print("Enter the classification of the movie DVD as the number in the list above: ");
                Classification classification = getClassificationInput(scanner.nextInt());
                scanner.nextLine();
                System.out.print("Enter the released date: ");
                String releasedDate = scanner.nextLine();

                System.out.print("Enter the number of DVDs added: ");
                int totalDVDs = scanner.nextInt();
                collection.add(new Movie(title, starring, director, duration, genres, classification, releasedDate, totalDVDs));

                System.out.println("Added Movie: " + title + ", with: " + totalDVDs + " DVDs.");
                collection.displayAll();
                System.out.println("Press any key to return back to menu. . .");
                scanner.next();
                scanner.close();
                staffMenu();
                break;
            }
            if(scanner.nextInt() == 2) {
                scanner.nextLine();
                System.out.print("Enter the movie title of the DVDs to remove: ");
                String movieTitleRemove = scanner.nextLine();
                System.out.print("Enter the number of DVDs removing: ");
                int DvdsNumRemove = scanner.nextInt();
                System.out.println("Removed " + movieTitleRemove + " with num: " + DvdsNumRemove);
                break;
            }
            if(scanner.nextInt() == 3){
                scanner.nextLine();
                System.out.print("Enter member name: ");
                String username = scanner.nextLine().replaceAll("\\s", "");
                System.out.print("Enter password: ");
                int password = scanner.nextInt();
                System.out.println("Created user: " + username + " with password: " + password);
                break;
            }
            if(scanner.nextInt() == 4){
                scanner.nextLine();
                System.out.print("Enter member name: ");
                String name = scanner.nextLine();
                System.out.println("User: " + name + "number.........02139213");
                break;
            }
            if(scanner.nextInt() == 0){
                mainMenu();
            break;
            }
        }

        scanner.close();
    }

    /**
     * Member menu.
     */
    public static void memberMenu() {
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

        switch (scanner.nextInt()) {
            case 1:
                collection.displayAll();
            case 2:
            case 3:
            case 4:
            case 5:
            case 0:
                mainMenu();
                break;
            default:
                break;
        }
    }


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
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
        collection.add(movie1);
        collection.add(movie2);
        collection.add(movie3);
        mainMenu();

    }
}
