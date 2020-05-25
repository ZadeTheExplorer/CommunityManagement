package Movie;

import User.Member;

import javax.swing.*;

public class MovieCollection {
    private static MovieCollection movieCollection;
    private static BinarySearchTree MovieBTS;
    private MovieNode[] allNode = new MovieNode[50];

    private MovieCollection() {}

    public static MovieCollection getInstance(){
        if(movieCollection == null) {
            movieCollection = new MovieCollection();
            MovieBTS = new BinarySearchTree();
            System.out.println("Movie Collection Initialised!");
        }

        return movieCollection;
    }

    public void add(Movie movie) {
        MovieBTS.addNode(movie.getTitle(), movie);
        System.out.println("Movie Added!");
    }

    public void remove(String movieTitle) {
        if (MovieBTS.deleteNode(movieTitle)) {
            System.out.format("Remove %s from the movie collection%n", movieTitle);

        } else {
            System.out.format("Cannot find %s in the movie collection%n", movieTitle);
        }
    }

    public MovieNode search(String movieTitle) {
        MovieNode movie = MovieBTS.search(movieTitle);
        if (movie == null) {
            System.out.println("Cannot found movie: " + movieTitle);
        }
        return movie;
    }

    public void modifyBorrowedNum(String title, int amountOfDVDs) {
        MovieBTS.search(title).modifyBorrowedNum(amountOfDVDs);
    }

    public int getAvailableDVDsNum(String title){
        return MovieBTS.search(title).getMovie().getTotalDVDs() - MovieBTS.search(title).getBorrowedNum();
    }

    private void addToAllNode(MovieNode movieNode) {
        int i=0;

        while (i<allNode.length){
            if (allNode[i] == null){
                allNode[i] = movieNode;
                return;
            }
            else if (allNode[i].getMovie().getTitle().compareTo(movieNode.getMovie().getTitle()) == 0) {
                break;
            }
            i++;
        }
    }

    public void innerTraverse(MovieNode node){
        if(node != null){
            innerTraverse(node.getLeftNode());
            addToAllNode(node);
            innerTraverse(node.getRightNode());
        }
    }

    public MovieNode[] getAllNode() {
        innerTraverse(BinarySearchTree.getRoot());

        int i;
        for (i=0; i< allNode.length; i++){
            if(allNode[i] == null){
                break;
            }
        }

        MovieNode [] output = new MovieNode[i];
        System.arraycopy(allNode, 0, output, 0, i);
        return output;
    }

    public void displayAll() {
        StringBuilder all = new StringBuilder();
        //String [] AllMovieArr = MovieBTS.getAllNode();
        MovieNode[] AllMovieArr = getAllNode();
        for (int i=0; i < AllMovieArr.length; i++){
                all.append(String.format("%02d",i + 1)).append(". ").append(AllMovieArr[i].getMovie().toString()).append("\n");
        }
        System.out.println(all);
    }
}
