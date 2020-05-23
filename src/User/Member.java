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

    public Movie[] getBorrowedList() {
        return borrowedList;
    }



    public Member(String fullname, String password, String contact, String address) {
        super(fullname.replaceAll("\\s", ""), password);
        this.fullname = fullname;
        this.contact = contact;
        this.address = address;
        this.borrowedList = new Movie[10];
    }

    public boolean borrowDVD(String title) {
        for (int i=0; i<borrowedList.length; i++) {
            if (borrowedList[i] == null) {
                MovieCollection.getInstance().modifyBorrowedNum(title,1);
                borrowedList[i] = MovieCollection.getInstance().search(title);
                return true;
            }
            else {
                if (borrowedList[i].getTitle().compareTo(title) == 0) {
                    System.out.println("Already borrowed.");
                    return false;
                }
            }

        }
        System.out.println("Your borrow list is full. Please return any books before try to borrow new ones.");
        return false;
    }

    public boolean returnDVD(String title) {
        for (int i=0; i<borrowedList.length; i++) {
            if (borrowedList[i] != null && borrowedList[i].getTitle().compareTo(title) == 0) {
                MovieCollection.getInstance().modifyBorrowedNum(title,1);
                borrowedList[i] = null;
                System.out.println("Return successful!");
                return true;

            }


        }
        System.out.println("Your borrow list is full. Please return any books before try to borrow new ones.");
        return false;
    }

    public String displayBorrowList() {
        StringBuilder string = new StringBuilder();
        for( Movie movie : borrowedList){
            if(movie != null){
                string.append(movie.getTitle()).append(", ");
            }
        }
        return string.toString();
    }
}
