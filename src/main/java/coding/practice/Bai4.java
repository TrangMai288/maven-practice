package coding.practice;

public class Bai4 {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,4};
        int min = minOfArray(arr);
        int max = maxOfArray(arr);
        System.out.println("Min = " + min);
        System.out.println("Max = " + max);
    }

    public static int minOfArray (int[] arr) {
         int lengthOfArray = arr.length;
         int min = arr[0];
         for (int i = 1; i < lengthOfArray; i++) {
             if (arr[i] < min) {
                 min = arr[i];
             }
         }
         return min;
    }

    public static int maxOfArray (int[] arr) {
        int lengthOfArray = arr.length;
        int max = arr[0];
        for (int i = 1; i < lengthOfArray; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
