package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static int[] rightShift(int[] array, int step) {
        for (int s = 0; s < step; s++) {
            int temp = array[array.length-1];
            for (int i = array.length-1; i > 0; i--) {
                array[i] = array[i-1];
            }
            array[0] = temp;
        }
        return array;
    }
    public  static  boolean hasDuplicates(int[] array){
        Arrays.sort(array);
        int[] newArray = new int[array.length];
        for (int a = 0; a < array.length; a++) {
            for (int i = 0; i < a; i++) {
                if (newArray[i] == array[a]) {
                    return true;
                }
            }
            newArray[a] = array[a];
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Task 2.");
        int[] arrayTask2_1 = {10, 20, 30};
        System.out.println(Arrays.toString(rightShift(arrayTask2_1, 1))); // [30, 10, 20]

        int[] arrayTask2_2 = {10, 20, 30, 40, 50};
        System.out.println(Arrays.toString(rightShift(arrayTask2_2, 2))); // [40, 50, 10, 20, 30]

        int[] arrayTask2_3 = {10, 20, 30, 40, 50};

        System.out.println(Arrays.toString(rightShift(arrayTask2_3, 21))); // [50, 10, 20, 30, 40]
        System.out.println("-----------------------------------------------");

        System.out.println("Task 3.");
        int[] arrayTask3 = {1,5,3,6,2,9,33,21};
        System.out.println(hasDuplicates(arrayTask3));  // false
        arrayTask3[5] = 1;
        System.out.println(hasDuplicates(arrayTask3)); // true
        System.out.println("-----------------------------------------------");
        System.out.println("Task 4.");
    }
}