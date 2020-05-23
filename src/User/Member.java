package User;

import Movie.Movie;

public class Member extends User{
    private String fullname;
    private String contact;
    private String address;
    private Movie[] borrowedList;

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


    //TODO: impliment method for borrow a DVD
    public void borrowNewMovie(Movie movie){

    }

    public Member(String fullname, String password, String contact, String address) {
        super(fullname.replaceAll("\\s", ""), password);
        this.fullname = fullname;
        this.contact = contact;
        this.address = address;
        this.borrowedList = new Movie[10];
    }

}
