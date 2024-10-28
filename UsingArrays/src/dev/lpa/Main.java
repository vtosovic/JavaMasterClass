package dev.lpa;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int[] firstArray = getRandomArray(10);
        System.out.println(Arrays.toString(firstArray));
        //sorted
        Arrays.sort(firstArray);
        System.out.println(Arrays.toString(firstArray));

        // uses 0 as default
        int[] secondArray = new int[10];
        System.out.println(Arrays.toString(secondArray));
        // fills array with 5
        Arrays.fill(secondArray, 5);
        System.out.println(Arrays.toString(secondArray));

        int [] thirdArray = getRandomArray(10);
        System.out.println(Arrays.toString(thirdArray));
        // creates copy of the same size, a new instance
        int [] fourthArray = Arrays.copyOf(thirdArray, thirdArray.length);
        System.out.println(Arrays.toString(fourthArray));

        Arrays.sort(fourthArray);
        System.out.println(Arrays.toString(thirdArray));
        System.out.println(Arrays.toString(fourthArray));

        // creating smaller and larger copy
        int[] smallerArray = Arrays.copyOf(thirdArray, 5);
        System.out.println(Arrays.toString(smallerArray));
        int[] largerArray = Arrays.copyOf(thirdArray, 15);
        System.out.println(Arrays.toString(largerArray));

        String[] sArray = {"Able", "Jane", "Mark", "Ralph", "David"};
        Arrays.sort(sArray);
        System.out.println(Arrays.toString(sArray));
        if (Arrays.binarySearch(sArray, "Mark") >=0 ){
            System.out.println("Found Mark in the list");

        }

        // Equals method, same length and values, and same order
        int[] s1 = {1, 2, 3, 4, 5};
        int[] s2 = {1, 2, 3, 4, 5};
        if (Arrays.equals(s1, s2)) {
            System.out.println("Arrays are equal");
        } else {
            System.out.println("Arrays are not equal");
        }
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
