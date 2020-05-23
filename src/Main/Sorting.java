package Main;


import java.util.Arrays;

public class Sorting {

    public Sorting() {};
    //TODO: Implement Merge Sort
    public static void Sort(String[] array){

    }

    public static void Sort(int[] array){
        int max = Arrays.stream(array).max().getAsInt();
        int min = Arrays.stream(array).min().getAsInt();
        int range = max - min + 1;
        int [] count = new int[range];
        int [] output = new int[array.length];

        for (int value : array) {
            count[value - min]++;
        }

        for (int i = 1; i < count.length; i++)
        {
            count[i] += count[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--)
        {
            output[count[array[i] - min] - 1] = array[i];
            count[array[i] - min]--;
        }

        System.arraycopy(output, 0, array, 0, array.length);
    }
}
