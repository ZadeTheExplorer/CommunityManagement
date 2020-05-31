package Main;

import Movie.MovieCollection;
import Movie.MovieNode;

// Display Top 10 Movie by Borrowed DVDs
public class TopTen {
    public TopTen() {};
    private static int[] getMaxAndMin(MovieNode[] arr) {
        int min = arr[0].getBorrowedNum();
        int max = arr[0].getBorrowedNum();
        for (MovieNode movieNode : arr) {
            if (movieNode.getBorrowedNum() > max) {
                max = movieNode.getBorrowedNum();
            }
            if (movieNode.getBorrowedNum() < min) {
                min = movieNode.getBorrowedNum();
            }
        }
        return new int[] {max, min};
    }
    public static MovieNode[] countingSort(){
        MovieNode[] allMovieArray = MovieCollection.getInstance().getAllNode();
        int [] maxAndMin = getMaxAndMin(allMovieArray);

        int range = maxAndMin[0] - maxAndMin[1] + 1;

        int [] count = new int[range];
        MovieNode [] output = new MovieNode[allMovieArray.length];

        for (MovieNode movieNode : allMovieArray) {
            count[movieNode.getBorrowedNum() - maxAndMin[1]]++;
        }
        for (int i = 1; i < count.length; i++) { count[i] += count[i - 1]; }

        for (int i = allMovieArray.length - 1; i >= 0; i--) {
            output[count[allMovieArray[i].getBorrowedNum() - maxAndMin[1]] - 1] = allMovieArray[i];
            count[allMovieArray[i].getBorrowedNum() - maxAndMin[1]]--;
        }

        for(int i = 0; i < output.length / 2; i++)
        {
            MovieNode temp = output[i];
            output[i] = output[output.length - i - 1];
            output[output.length - i - 1] = temp;
        }
        return output;
    }

    public static void display() {
        MovieNode[] allMovieArray = countingSort();

        StringBuilder all = new StringBuilder();
        for (int i=0; i < 10; i++){
            if(allMovieArray[i] == null){
                break;
            }
            all.append(String.format("%02d",i + 1)).append(". ")
               .append(allMovieArray[i].getMovie().getTitle()).append("\n");
        }
        System.out.println(all);
    }

}
