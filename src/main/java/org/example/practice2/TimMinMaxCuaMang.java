package org.example.practice2;

import java.util.Arrays;
import java.util.List;

public class TimMinMaxCuaMang {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 4, 9, 0, 2, 8};
        int max = Arrays.stream(arr).max().getAsInt();
        List<Integer> list = Arrays.stream(arr).boxed().toList();
        int maxIndex = list.indexOf(max);
        System.out.println("max = " + max + ", index of max : " + maxIndex);


        int min = Arrays.stream(arr).min().getAsInt();
        int minIndex = list.indexOf(min);
        System.out.println("min = " + min + ", index of min : " + minIndex);

    }
}
