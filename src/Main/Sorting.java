package Main;


import java.util.Arrays;

public class Sorting {

    public Sorting() {};

    private static void merge(String [] arr, int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        String [] L = new String [n1];
        String [] R = new String [n2];

        /*Copy data to temp arrays*/
        if (n1 >= 0) System.arraycopy(arr, l, L, 0, n1);
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (R[j].compareTo(L[j]) >= 0 )
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    // Main function that sorts arr[l..r] using
    // merge()
    public static void mergeSort(String[] arr, int minIndex, int maxIndex)
    {
        if (minIndex < maxIndex)
        {
            // Find the middle point
            int m = (minIndex+maxIndex)/2;

            // Sort first and second halves
            mergeSort(arr, minIndex, m);
            mergeSort(arr , m+1, maxIndex);

            // Merge the sorted halves
            merge(arr, minIndex, m, maxIndex);
        }
    }
    // Implement MERGER SORT for string array
    public static void Sort(String[] array){
        mergeSort(array, 0, array.length -1);
    }
    // Implement COUNTING SORT for integer array
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
