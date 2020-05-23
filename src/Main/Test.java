package Main;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[4] = 5;

        for(int i : arr){
            System.out.println(i);
        }
    }
}