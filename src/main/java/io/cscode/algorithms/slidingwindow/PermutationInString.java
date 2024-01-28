package io.cscode.algorithms.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;

public class PermutationInString {

    static boolean checkInclusion(String s1, String s2) {

        if(s2.length() < s1.length()) {
            return false;
        }

        // Two maps, one stores the character count of S1
        // Other map stores the characters in current window
        HashMap<Character, Integer> s1_count = new HashMap<>();
        for(char c: s1.toCharArray()) {
            s1_count.merge(c, 1, Integer::sum);
        }

        int left =0;
        int right=0;
        HashMap<Character, Integer> s2_count = new HashMap<>();
        while(right < s2.length()) {
            s2_count.merge(s2.charAt(right), 1, Integer::sum);
            /*
               When s2_count reaches exceeds sliding window size, then remove left most
               (>= because indexes starts with 0)
             */
            if(right >= s1.length()) {
                int new_count = s2_count.merge(s2.charAt(left), -1, Integer::sum);
                if(new_count == 0){
                    s2_count.remove(s2.charAt(left));
                }
                left++;
            }

            if(s1_count.equals(s2_count)) {
                return true;
            }

            right++;
        }

        return false;
    }

    /**
     *  Same solution as above, instead of HashMaps, we are using temp arrays with length 26,
     *  since the input can contain only lowercase english letters
     * @param s1
     * @param s2
     * @return
     */
    static boolean checkInclusionUsingArrays(String s1, String s2) {

        if(s2.length() < s1.length()) {
            return false;
        }

        int[] s1_count = new int[26];
        int[] s2_count = new int[26];

        for(char c: s1.toCharArray()) {
            s1_count[c-'a']++;
        }

        int left =0;
        int right=0;
        while(right < s2.length()) {
            s2_count[s2.charAt(right)-'a']++;
            /*
               When s2_count reaches exceeds sliding window size, then remove left most
               (>= because indexes starts with 0)
             */
            if(right >= s1.length()) {
                s2_count[s2.charAt(left)-'a']--;
                left++;
            }

            if(Arrays.equals(s1_count, s2_count)) {
                return true;
            }

            right++;
        }

        return false;
    }


    /**
     * Similar to previous approaches, time complexity is O ( 26 *n). We can reduce it to just O(n)
     * @param s1
     * @param s2
     * @return
     */
    static boolean checkInclusionUsingArraysAndMatchCount(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }
        int[] s1_count = new int[26];
        int[] s2_count = new int[26];

        for(int i=0; i<s1.length(); i++) {
            s1_count[s1.charAt(i) -'a']++;
            s2_count[s2.charAt(i) -'a']++;
        }

        int matches = 0;
        for(int i=0; i<s1_count.length; i++) {
            matches += (s1_count[i] == s2_count[i]) ? 1 : 0;
        }

        int left = 0;
        // read from where we left off above
        for(int i=s1.length(); i<s2.length(); i++) {
            if(matches == 26) {
                return true; // means all characters count matched
            }

            int rightCharIndex = s2.charAt(i) -'a';
            s2_count[rightCharIndex]++;
            // after adding the next character, check if count at the index between s1_count and s2_count changed ?
            if(s1_count[rightCharIndex] == s2_count[rightCharIndex]) {
                matches++;
            } else if(s1_count[rightCharIndex] +1 == s2_count[rightCharIndex]) {
                matches--;
            }

            // since we have added right element, remove the left element from count and re-check
            int leftCharIndex = s2.charAt(left) - 'a';
            s2_count[leftCharIndex]--;
            if(s1_count[leftCharIndex] == s2_count[leftCharIndex]) {
                matches++;
            } else if(s1_count[leftCharIndex] - 1 == s2_count[leftCharIndex]) {
                matches--;
            }
            left++;
        }

        return matches == 26; // in case, the match happened at the last character.
    }

    public static void main(String[] args) {
        System.out.println("################  Using HashMaps #######################");
        System.out.println(checkInclusion("ab","eidbaooo"));
        System.out.println(checkInclusion("ab","eidboaoo"));

        System.out.println("################  Using temp arrays with length 26 #######################");
        System.out.println(checkInclusionUsingArrays("ab","eidbaooo"));
        System.out.println(checkInclusionUsingArrays("ab","eidboaoo"));

        System.out.println("################  Using temp arrays with length 26 and matchCount as we loop through characters #######################");
        System.out.println(checkInclusionUsingArraysAndMatchCount("ab","eidbaooo"));
        System.out.println(checkInclusionUsingArraysAndMatchCount("ab","eidboaoo"));

    }
}
