package dev.lpa;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] returnedArray = readIntegers();
        System.out.println(Arrays.toString(returnedArray));
        int returnedMin = findMin(returnedArray);
        System.out.println("min = " + returnedMin);
        reverse(returnedArray);
        System.out.println("Final: " + Arrays.toString(returnedArray));

    }

    private static int[] readIntegers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a list of integers, separated by commas:");
        String input = scanner.nextLine();

        // we have input with numbers separated by commas
        // in input variable
        // we split input variable and create a new array that is the size of split parts
        String[] splits = input.split(",");
        int[] values = new int[splits.length];

        // we go through split parts and convert them to Int
        // then we put them into the array
        for(int i = 0; i < splits.length; i++ ) {
            values[i] = Integer.parseInt(splits[i].trim());
        }

        return values;
    }

    private static int findMin(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int el : array) {
            if (el < min) {
                min = el;
            }
        }
        return min;
    }

    private static void reverse(int[] array){
        int maxIndex = array.length -1;
        int halfLength = array.length /2;
        for (int i = 0; i < halfLength; i++){
            int temp = array [i];
            array[i] = array[maxIndex -i];
            array[maxIndex -i] = temp;
        }

    }
}
