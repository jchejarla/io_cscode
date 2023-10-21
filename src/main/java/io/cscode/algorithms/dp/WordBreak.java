package io.cscode.algorithms.dp;

import java.util.HashMap;

public class WordBreak {

    /* brute force approach*/
    static boolean bruteForceApproach(String s, String[] wordDict) {

        if(s.length()==0){
            return true;
        }

        for(String word: wordDict) {
            if(s.indexOf(word) == 0) { // if the string starts with the word
                String remainder = s.substring(word.length());
                if(bruteForceApproach(remainder, wordDict)) {
                    return true; // possible to construct the string using words from wordDict
                }
            }
        }

        return false;
    }

    /* DP memoization approach */
    static boolean dpMemoizationApproach(String s, String[] wordDict) {
        HashMap<String, Boolean> cache = new HashMap<>();
        return dpMemoizationApproachRec(s, wordDict, cache);
    }

    static boolean dpMemoizationApproachRec(String s, String[] wordDict, HashMap<String, Boolean> cache) {

        if(s.length() == 0) {
            return true;
        }

        if(cache.containsKey(s)) {
            return cache.get(s);
        }

        for( String word: wordDict) {
            if(s.indexOf(word) == 0) {
                String remainder = s.substring(word.length());
                if (dpMemoizationApproachRec(remainder, wordDict, cache)) {
                    cache.put(remainder, true);
                    return true;
                }
            }
        }
        cache.put(s, false);
        return false;
    }

    /* DP tabulation memory optimized */
    static boolean dpTabulationMemoryOptimized(String s, String[] wordDict) {
        boolean[] cache = new boolean[s.length()+1];
        cache[s.length()] = true; // if we reach the end of input target string, that means string "s"
                                   // can be constructed using words from wordDict.
        for (int i=s.length()-1; i>=0; i--) {
            for(String word : wordDict) {
                if(i+ word.length() <= s.length() && word.equals(s.substring(i, i+word.length()))) { // i+ word.length() <= s.length() =>
                                                    // to check if "s" has enough characters to check
                    cache[i] = cache[i + word.length()];
                }
                if(cache[i] == true) { // we have found a matching word
                    break;
                }
            }
        }

        return cache[0];
    }


    public static void main(String[] args) {
        System.out.println("############### Brute force approach######################");
        System.out.println(bruteForceApproach("cscode", new String[]{"code", "cs"}));
        System.out.println(bruteForceApproach("abcdxyz", new String[]{"abc", "abcd", "d","z","xyz","y","x"}));
        System.out.println(bruteForceApproach("catsandog", new String[]{"cats","dog","sand","and","cat"}));

        System.out.println("############### DP memoization approach######################");
        System.out.println(dpMemoizationApproach("cscode", new String[]{"code", "cs"}));
        System.out.println(dpMemoizationApproach("abcdxyz", new String[]{"abc", "abcd", "d","z","xyz","y","x"}));
        System.out.println(dpMemoizationApproach("catsandog", new String[]{"cats","dog","sand","and","cat"}));

        System.out.println("############### DP tabulation memory optimized approach######################");
        System.out.println(dpTabulationMemoryOptimized("cscode", new String[]{"code", "cs"}));
        System.out.println(dpTabulationMemoryOptimized("abcdxyz", new String[]{"abc", "abcd", "d","z","xyz","y","x"}));
        System.out.println(dpTabulationMemoryOptimized("catsandog", new String[]{"cats","dog","sand","and","cat"}));

    }
}
