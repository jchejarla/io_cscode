package io.cscode.algorithms.strings;

public class IndexOfFirstOccurrenceInAString {

    /**
     * Using two pointers, check starting character match in both strings,
     * if anywhere a break is found, repeat the process
     * Complexity O(n * m) - where n is length of haystack, and n is length of needle
     *
     * @param haystack
     * @param needle
     * @return
     */
    static int usingTwoPointers(String haystack, String needle) {

        int i =0;
        while(i < haystack.length() && i+needle.length() <= haystack.length()) {
            int j=0;
            for(; j<needle.length(); j++) {
                if(needle.charAt(j) != haystack.charAt(i+j)) {
                    // not same characters
                    break;
                }
            }

            if(j == needle.length()) {
                return i;
            }
            i++;

        }
        return -1;
    }


    /**
     * Pattern matching using KMP algorithm
     *  1. build a LPS array (longest prefix suffix array)
     *  2. match characters between haystack and needle
     *      if any mismatch found, then reset needle index to a prefix index from LPS array
     *
     * @param haystack
     * @param needle
     * @return
     */
    static int patternMatchingUsingKMP(String haystack, String needle) {
        int[] lps = createLPSArray(needle);
        int i=0; // track haystack
        int j=0; // track needle
        while(i<haystack.length() && j<needle.length()) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if(j != 0) {
                    j = lps[j-1];
                } else {
                    i++;
                }
            }

            if(j == needle.length()) {
                return i-j;
            }
        }
        return -1;
    }

    static int[] createLPSArray(String pattern) {
        int[] lps = new int[pattern.length()];
        int i=0;
        int j=1; // start from index 1, because at index 0, there is no character (previous) to compare with
        while(j < pattern.length()) {
            if(pattern.charAt(i) == pattern.charAt(j)) {
                lps[j] = i +1;
                i++;
                j++;
            } else {
                if (i != 0) {
                    i = lps[i-1];
                } else {
                    lps[j] = 0;
                    j++;
                }
            }
        }
        return  lps;
    }


    public static void main(String[] args) {

        System.out.println("############### Using Two pointers ######################");
        System.out.println(patternMatchingUsingKMP("aaaaaaaaaaaabaacaazbbz", "aazbbz"));
        System.out.println(usingTwoPointers("sadbutsad", "sad"));
        System.out.println(usingTwoPointers("cscodeio", "cscd"));
        System.out.println(usingTwoPointers("mississippi", "issipi"));
        System.out.println(usingTwoPointers("abcabcyabcxabcyabczadbca", "abcyabcz"));

        System.out.println("############### Using KMP pattern matching ######################");
        System.out.println(patternMatchingUsingKMP("aaaaaaaaaaaabaacaazbbz", "aazbbz"));
        System.out.println(patternMatchingUsingKMP("sadbutsad", "sad"));
        System.out.println(patternMatchingUsingKMP("cscodeio", "cscd"));
        System.out.println(patternMatchingUsingKMP("mississippi", "issipi"));
        System.out.println(patternMatchingUsingKMP("abcabcyabcxabcyabczadbca", "abcyabcz"));

    }
}
