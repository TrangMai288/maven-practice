package coding.practice;

public class Bai5 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,6,2};
        int maximumDifference = printMaximumDifference(arr);
        System.out.println(maximumDifference);
    }

    public static int printMaximumDifference (int[] arr) {
        int lengthOfArray = arr.length;
        int min = arr[0];
        int max = arr[0];

        for (int i = 0; i < lengthOfArray; i++) {
            if (min > arr[i]) {
                min = arr[i];
            } if (max < arr[i]) {
                max = arr[i];
            }
        }
        int maximumDifference = max - min;
        return maximumDifference;
    }
}
