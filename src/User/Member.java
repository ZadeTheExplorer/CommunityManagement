package User;

import Movie.Movie;
import Movie.MovieCollection;
public class Member extends User{
    private String fullname;
    private String contact;
    private String address;
    private final Movie[] borrowedList;

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getFullName() {
        return fullname;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getContact() {
        return contact;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }


    public Member(String fullname, String password, String contact, String address) {
        super(fullname.replaceAll("\\s", ""), password);
        this.fullname = fullname;
        this.contact = contact;
        this.address = address;
        this.borrowedList = new Movie[10] ;
    }

    public void borrowDVD(String title) {
        if (MovieCollection.getInstance().search(title) != null){
            if (MovieCollection.getInstance().getAvailableDVDsNum(title) > 0){
                for (int i=0; i<borrowedList.length; i++) {
                    if (borrowedList[i] == null ) {
                        MovieCollection.getInstance().modifyBorrowedNum(title,1);
                        borrowedList[i] = MovieCollection.getInstance().search(title).getMovie();
                        System.out.println("Borrow successful!");
                        return;
                    }
                    else {
                        if (borrowedList[i].getTitle().compareTo(title) == 0) {
                            System.out.println("Already borrowed.");
                            return;
                        }
                    }
                }
                System.out.println("Your borrow list is full. Please return any DVDs before try to borrow new ones.");
                return;
            } else {
                System.out.println("This Movie is out of stock, please try again later!");
                return;
            }
        }
        System.out.println("The movie DVD is not exits!");
    }

    public void returnDVD(String title) {
        if (MovieCollection.getInstance().search(title) != null){
            for (int i=0; i<borrowedList.length; i++) {
                if (borrowedList[i] != null && borrowedList[i].getTitle().compareTo(title) == 0) {
                    MovieCollection.getInstance().modifyBorrowedNum(title,-1);
                    borrowedList[i] = null;
                    System.out.println("Return successful!");
                    return;
                }
            }
            System.out.println("Cannot found that movie DVD in borrowed list.");
        } else {
            System.out.println("Can not found: " + title +" in movie collection.");
        }
    }

    public String displayBorrowList() {
        StringBuilder string = new StringBuilder();
        for( Movie movie : borrowedList){
            if(movie != null){
                string.append(movie.getTitle()).append("\n");
            }
        }
        return string.toString();
    }
}
