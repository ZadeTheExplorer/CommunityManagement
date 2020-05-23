package Movie;

public class MovieNode {
    private String title;
    private Movie movie;
    private int borrowedNum;
    private MovieNode leftNode;
    private MovieNode rightNode;

    public MovieNode(String movieTitle,Movie movie){
        this.title = movieTitle;
        this.movie = movie;
        this.leftNode = null;
        this.rightNode = null;
        this.borrowedNum = 0;
    }

    public Movie getMovie(){
        return movie;
    }

    public void setMovie(Movie movie){
        this.movie = movie;
        this.title = movie.getTitle();
    }

    public int getBorrowedNum() {
        return borrowedNum;
    }
    public void setBorrowedNum(int borrowedNum) {
        this.borrowedNum = borrowedNum;
    }
    public void modifyBorrowedNum(int amount) {
        borrowedNum += amount;
    }
    public MovieNode getLeftNode(){
        return leftNode;
    }
    public void setLeftNode(MovieNode node){
        this.leftNode = node;
    }
    public MovieNode getRightNode(){
        return rightNode;
    }
    public void setRightNode(MovieNode node){
        this.rightNode = node;
    }

}
