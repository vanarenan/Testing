package com.company;
import java.io.*;
import java.lang.reflect.Array;
//import java.util.Arrays;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static LinkedHashMap<String, Integer> sortHashMapByValues(HashMap<String, Integer> passedMap) {
        List<String> mapKeys = new ArrayList<>(passedMap.keySet());
        List<Integer> mapValues = new ArrayList<>(passedMap.values());
        Collections.sort(mapValues, Collections.reverseOrder());
        Collections.sort(mapKeys, Collections.reverseOrder());
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        Iterator<Integer> valueIt = mapValues.iterator();
        while (valueIt.hasNext()) {
            Integer val = valueIt.next();
            Iterator<String> keyIt = mapKeys.iterator();
            while (keyIt.hasNext()) {
                String key = keyIt.next();
                Integer comp1 = passedMap.get(key);
                Integer comp2 = val;
                if (comp1.equals(comp2)) {
                    keyIt.remove();
                    sortedMap.put(key, val);
                    break;
                }
            }
        }
        return sortedMap;
    }

    public static void harry() throws Exception {
        File file = new File("harry.txt");
        BufferedReader br  = new BufferedReader(new FileReader(file));
        String st;
        String harryText = "";
        while ((st = br.readLine()) != null) harryText += st;

        List<String> allMatches = new ArrayList<String>();
        Matcher m = Pattern.compile("\\s[a-zA-Z]{3,}\\s").matcher(harryText);
        while (m.find()) allMatches.add(m.group());

        HashMap<String, Integer> words = new HashMap<>();
        String currentWord;
        Integer currentWordCount;
        for (int i = 0; i < allMatches.size(); i++) {
            currentWord = allMatches.get(i);
            if (words.get(currentWord) == null) {
                words.put(currentWord, 1);
            } else {
                currentWordCount = words.get(currentWord);
                words.put(currentWord, ++currentWordCount);
            }
        }
        List<Map.Entry<String, Integer>> wordsSortedTop20
                = sortHashMapByValues(words).entrySet().stream().limit(20).collect(Collectors.toList());
        System.out.println(wordsSortedTop20);
        BufferedWriter writer = new BufferedWriter(new FileWriter("test.txt"));
        writer.append("A fine header for the file\n\r");
        writer.append(wordsSortedTop20.toString());
        writer.close();

    }
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

    public static String prefix(String[] array) {
        int size = array.length;
        int PSize = 1;
        String prefix = array[0].substring(0, PSize);
        int count = 0;
        do {
            for (int i = 0; i < size; i++) {
                if (array[i].startsWith(prefix)) count++;
            }
            if (count < size) return prefix.substring(0, prefix.length()-1);
            if (prefix.length() == array[0].length()) return prefix;
            PSize++;
            prefix = array[0].substring(0, PSize);
            count = 0;
        } while (count < size);
        return prefix;
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
        String[] arrayTask4_1 = {"abc", "abcd", "abfce", "abcac"} ;
        System.out.println(prefix(arrayTask4_1));  // ab
        String[] arrayTask4_2 = {"abc", "abcd", "abce", "abcac"} ;
        System.out.println(prefix(arrayTask4_2)); // abc
        System.out.println("-----------------------------------------------");

        System.out.println("Task 1.");
        try {
            harry();
        } catch(Exception e) {

        }
    }
}