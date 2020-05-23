package Main;

import Movie.*;
import User.Member;
import User.MemberCollection;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    private MovieCollection collection;
    public Menu(MovieCollection collection) {
        this.scanner = new Scanner(System.in);
        this.collection = collection;
    }

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
     * Get genres input genres .
     *
     * @param selection the selection of genres
     * @return the genres
     */
    public static Genres getGenresInput(int selection){
        Genres genres = null;
        switch (selection) {
            case 1:
                genres = Genres.DRAMA;
                break;
            case 2:
                genres = Genres.ADVENTURE;
                break;
            case 3:
                genres = Genres.FAMILY;
                break;
            case 4:
                genres = Genres.ACTION;
                break;
            case 5:
                genres = Genres.SCI_FI;
                break;
            case 6:
                genres = Genres.COMEDY;
                break;
            case 7:
                genres = Genres.ANIMATED;
                break;
            case 8:
                genres = Genres.THRILLER;
                break;
            case 9:
                genres = Genres.OTHER;
                break;
            default:
                break;
        }
        if (genres == null) {
            System.out.println("Wrong input, please input again!");
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
     * @param selection the selection
     * @return the classification input
     */
    public static Classification getClassificationInput(int selection) {

        Classification classification = null;

        switch (selection){
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
        if (classification == null){
            System.out.println("Wrong input, please input again!");
        }
        return classification;
    }

    public void main(){
        String welcomeMenu = "\nWelcome to the Community Library\n" +
                "============Main Menu===========\n" +
                " 1. Staff Login\n" +
                " 2. Member Login\n" +
                " 0. Exit\n" +
                "================================\n" +
                "Please make a selection (1-2 or 0 to exit): ";

        System.out.print(welcomeMenu);
        while(scanner.hasNext()){
            if(scanner.hasNextInt()){
                int input = scanner.nextInt();
                if(input == 1) {
                    staff();
                }
                else if(input == 2) {
                    Member member = new Member("Taylor Swift", "1234", "0123456789", "America");
                    member(member);
                }
                else if(input == 0) {
                    scanner.close();
                    System.exit(0);
                    break;
                }
                else if(input == 3) {
                    System.out.print("Test case. ");
                    break;
//                    System.out.println("Press any key to out");
//                    if(scanner.hasNext()){
//                        scanner.close();
//                        System.exit(0);
//                    }
                }
                else{
                    System.out.println("Wrong input, try again...");
                }
            }
            scanner.nextLine();
            System.out.print("Wrong input, please try to enter a selection above: ");

        }
    }
    public void staff() {
        String staffMenu = "\n================Staff Menu================\n" +
                "1. Add a new movie DVD\n" +
                "2. Remove a movie DVD\n" +
                "3. Register a new Member\n" +
                "4. Find a registered member's phone number\n" +
                "0. Return to main menu\n" +
                "==========================================\n" +
                "Please make a selection (1-5 or 0 to exit): ";

        System.out.print(staffMenu);

        while(scanner.hasNext()){
            if(scanner.hasNextInt()){
                int input = scanner.nextInt();
                //TODO: Implement case when movie is already in collection
                // Add Movie DVD
                if(input == 1){
                    scanner.nextLine();
                    System.out.print("Enter the movie title of the DVD added: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter the list of starring, separated by comma: ");
                    String starring = scanner.nextLine();

                    System.out.print("Enter the name of director: ");
                    String director = scanner.nextLine();

                    System.out.print("Enter the durations (minutes): ");
                    String duration = scanner.nextLine();
                    // get input of genres as an array of selection
                    System.out.println(allGenresToString());
                    Genres genres;
                    do {
                        System.out.print("Enter the genres from the list above with number, separate with space: ");
                        genres = getGenresInput(scanner.nextInt());
                    } while (genres == null);
                    // get input of classification as selection
                    System.out.println(allClassification());
                    Classification classification;
                    do {
                        System.out.print("Enter the classification of the movie DVD as the number in the list above: ");
                        classification = getClassificationInput(scanner.nextInt());
                    } while (classification == null);

                    scanner.nextLine();
                    System.out.print("Enter the released date: ");
                    String releasedDate = scanner.nextLine();

                    System.out.print("Enter the number of DVDs added: ");
                    int totalDVDs = scanner.nextInt();
                    collection.add(new Movie(title, starring, director, duration, genres, classification, releasedDate, totalDVDs));

                    System.out.println("Added Movie: " + title + ", with: " + totalDVDs + " DVDs.");

                    System.out.println("Press enter to return to menu...: ");
                    scanner.nextLine();
                    scanner.reset();
                    System.out.println();
                    System.out.println(staffMenu);

                }
                // Remove a Movie DVD
                else if(input == 2) {
                    scanner.nextLine();
                    System.out.print("Enter the movie title of the DVDs to remove: ");
                    String movieTitleRemove = scanner.nextLine();
                    collection.remove(movieTitleRemove);

                    System.out.print("Enter any key to return to menu...: ");
                    scanner.nextLine();
                    System.out.print(staffMenu);
                }
                // Register a new member
                else if(input == 3) {
                    scanner.nextLine();
                    System.out.print("Enter member name: ");
                    String fullName = scanner.nextLine();
                    String username = fullName.replaceAll("\\s", "");

                    System.out.print("Enter password (must be 4 digits): ");
                    String password = scanner.nextLine();

                    System.out.print("Enter member's contact: ");
                    String contact = scanner.nextLine();

                    System.out.print("Enter member's address: ");
                    String address = scanner.nextLine();

                    Member newMem = new Member(fullName, password, contact, address);
                    MemberCollection.getInstance().addMember(newMem);
                    System.out.println("Created user: " + username);

                    System.out.print("Enter any key to return to menu...: ");
                    scanner.nextLine();
                    System.out.print(staffMenu);
                }
                // Find a member's phone number
                else if(input == 4) {
                    scanner.nextLine();
                    System.out.print("Enter member name: ");
                    String name = scanner.nextLine();

                    String phoneNumber = MemberCollection.getInstance().searchMember(name).getContact();
                    System.out.println("Phone number of member \"" + name + "\" is " + phoneNumber);

                    System.out.print("Enter any key to return to menu...: ");
                    scanner.nextLine();
                    System.out.print(staffMenu);
                }
                // test case
                else if(input == 5) {
                    System.out.println("testing menu redirect");
                    scanner.reset();
                    staff();
                }
                // Return to main menu
                else if(input == 0) {
                    main();
                    break;
                }
                else {
                    System.out.println("Wrong input, try again...");
                }
            }
            else if (scanner.hasNextLine()) {
                System.out.print("Wrong input, please try to enter a selection above: ");
//                scanner.nextLine();
            }
        }

        scanner.close();
    }
    public void member(Member member) {

        String memberMenu = "==============Member Menu==============\n" +
                "1. Display all movies\n" +
                "2. Borrow a movie DVD\n" +
                "3. Return a movie DVD\n" +
                "4. List current borrowed movie DVDSs\n" +
                "5. Display top 10 most popular movies\n" +
                "0. Return to main Menu\n" +
                "=======================================\n\n" +
                "Please make a selection (1-5 or 0 to exit): ";

        System.out.print(memberMenu);

        while(scanner.hasNext()){
            if(scanner.hasNextInt()) {
                int input = scanner.nextInt();
                // Display all movie in the collection
                if (input == 1) {
                    scanner.nextLine();
                    collection.displayAll();

                    System.out.print("Enter any key to return to menu...: ");
                    scanner.nextLine();
                    System.out.print(memberMenu);
                }
                // Borrow a movie
                else if (input == 2) {
                    scanner.nextLine();
                    System.out.print("Enter the title of movie to borrow: ");
                    member.borrowDVD(scanner.nextLine());

                    System.out.print("Enter any key to return to menu...: ");
                    scanner.nextLine();
                    System.out.print(memberMenu);
                }
                // Return a movie
                else if (input == 3) {
                    scanner.nextLine();
                    System.out.print("Enter the title of movie to return: ");
                    member.returnDVD(scanner.nextLine());

                    System.out.print("Enter any key to return to menu...: ");
                    scanner.nextLine();
                    System.out.print(memberMenu);
                }
                // Display all movie borrowed
                else if (input == 4) {
                    scanner.nextLine();
                    System.out.println(member.displayBorrowList());
                    System.out.print("Enter any key to return to menu...: ");
                    scanner.nextLine();
                    System.out.print(memberMenu);
                }
                //TODO
                // Display top 10 popular movie DVDs
                else if (input == 5) {
                    scanner.nextLine();

                    System.out.print("Enter any key to return to menu...: ");
                    scanner.nextLine();
                    System.out.print(memberMenu);
                }
                // Return to main menu
                else if (input == 0) {
                    main();
                    break;
                } else {
                    System.out.println("Wrong input, try again...");
                }

            } else if (scanner.hasNextLine()) {
                System.out.print("Wrong input, please try to enter a selection above: ");
//               scanner.nextLine();
            }
        }
        scanner.close();
    }
}
