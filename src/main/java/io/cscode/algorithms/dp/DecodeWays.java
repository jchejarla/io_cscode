package io.cscode.algorithms.dp;

import java.util.HashMap;

public class DecodeWays {

    /* brute force approach solution */
    static int bruteForceApproach(String s) {
        if(s == null || s.startsWith("0")){
            return 0;
        }

        if(s.length() == 0 || s.length() ==1) {
            return 1;
        }

        String first_char_remainder = s.substring(1);
        int result = bruteForceApproach(first_char_remainder); // recursively call for remaining substring after 1st character
        char char_1 = s.charAt(0);
        char char_2 = s.charAt(1);
        if(char_1 == '1'
                || (char_1=='2' && (char_2=='0' || char_2 == '1' || char_2 =='2' || char_2 =='3'
                                    || char_2 == '4' || char_2 == '5' || char_2 == '6'))) {
            String second_char_remainder = s.substring(2);
            result+= bruteForceApproach(second_char_remainder);
        }
        return result;
    }

    /* DP memoize solution */
    static int dpMemoizeApproach(String s) {
        HashMap<String, Integer> cache = new HashMap<>();
        return dpMemoizeApproachRec(s, cache);
    }
    static int dpMemoizeApproachRec(String s, HashMap<String, Integer> cache) {
        if(s == null || s.startsWith("0")){
            return 0;
        }

        if(s.length() == 0 || s.length() ==1) {
            return 1;
        }

        if(cache.containsKey(s)) { // re-use cached result if it exists
            return cache.get(s);
        }

        String first_char_remainder = s.substring(1);
        int result = bruteForceApproach(first_char_remainder); // recursively call for remaining substring after 1st character
        char char_1 = s.charAt(0);
        char char_2 = s.charAt(1);
        if(char_1 == '1'
                || (char_1=='2' && (char_2=='0' ||char_2 == '1' || char_2 =='2' || char_2 =='3'
                                    || char_2 == '4' || char_2 == '5' || char_2 == '6'))) {
            String second_char_remainder = s.substring(2);
            result+= bruteForceApproach(second_char_remainder);
        }
        cache.put(s, result); // cache result
        return result;
    }

    /* DP tabulation approach */
    static int dpTabulationApproach(String s) {
        if(s.charAt(0) == '0') {
            return 0;
        }
        int[] count = new int[s.length()+1];
        count[0] = 1; // dummy value
        count[1] = 1; //decode possibilities for 0th index element from input string
        for(int i=2; i<=s.length(); i++) {

            int current = s.charAt(i-1); // though we are at i=2, we have to continue from 1st index of input string
            int prev = s.charAt(i-2);

            if(current > '0'){ // It does ascii comparison, but this is fine as ASCII values for 1 -9 will be greater than ASCII of 0
                count[i] += count[i-1];
            }
            if(prev =='1' ||
                    (prev == '2' && (current =='0' || current == '1' || current == '2' || current == '3'
                                    || current == '4' || current =='5' || current =='6'))) {
                count[i] += count[i-2];
            }
        }
        // finally take the last element of DP tabulation array
        return count[s.length()];
    }

    /* DP memory optimized */
    static int doMemoryOptimized(String s) {
        if(s.charAt(0) == '0') {
            return 0;
        }
        int prev = 1;
        int current = 1;
        for(int i=2; i<=s.length(); i++) {

            int one_char = s.charAt(i-1);
            int two_char = s.charAt(i-2);

            int temp = 0;
            if(one_char > '0'){
                temp += current;
            }
            if(two_char =='1' ||
                    (two_char == '2' && (one_char =='0' || one_char == '1' || one_char == '2' || one_char == '3'
                            || one_char == '4' || one_char =='5' || one_char =='6'))) {
                temp += prev;
            }
            prev = current;
            current = temp;
        }
        // finally return current value
        return current;
    }

    public static void main(String[] args) {
        System.out.println("############### Brute force approach######################");
        System.out.println(bruteForceApproach("1212"));
        System.out.println(bruteForceApproach("12"));
        System.out.println(bruteForceApproach("226"));
        System.out.println(bruteForceApproach("06"));

        System.out.println("############### DP memoization approach######################");
        System.out.println(dpMemoizeApproach("1212"));
        System.out.println(dpMemoizeApproach("12"));
        System.out.println(dpMemoizeApproach("226"));
        System.out.println(dpMemoizeApproach("06"));

        System.out.println("############### DP tabulation approach######################");
        System.out.println(dpTabulationApproach("1212"));
        System.out.println(dpTabulationApproach("12"));
        System.out.println(dpTabulationApproach("226"));
        System.out.println(dpTabulationApproach("06"));

        System.out.println("############### DP memory optimized######################");
        System.out.println(doMemoryOptimized("1212"));
        System.out.println(doMemoryOptimized("12"));
        System.out.println(doMemoryOptimized("226"));
        System.out.println(doMemoryOptimized("06"));
    }
}
