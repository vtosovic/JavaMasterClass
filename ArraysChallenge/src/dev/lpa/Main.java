package dev.lpa;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int[] originalArray = getRandomArray(5);
        System.out.println(Arrays.toString(originalArray));
        int[] sortedArray = Arrays.copyOf(originalArray, originalArray.length);
        Arrays.sort(sortedArray);
        System.out.println(Arrays.toString(sortedArray));

        int len = sortedArray.length;
        int[] exitArray = new int[len];
        //System.out.println(Arrays.toString(exitArray));
        int j = len -1;
        for (int i = 0; i < len; i++ ) {
                exitArray[i] = sortedArray[j];
                j--;
        }
        System.out.println(Arrays.toString(exitArray));

    }
    private static int[] getRandomArray(int len){

        Random random = new Random();
        int[] newInt = new int[len];
        for (int i = 0; i < len; i++){
            // between 0 and 99
            newInt[i] = random.nextInt(100);
        }
        return newInt;
    }
}
