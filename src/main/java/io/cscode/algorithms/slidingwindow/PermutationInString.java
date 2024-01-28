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

    public static void main(String[] args) {
        System.out.println("################  Using HashMaps #######################");
        System.out.println(checkInclusion("ab","eidbaooo"));
        System.out.println(checkInclusion("ab","eidboaoo"));

        System.out.println("################  Using temp arrays with length 26 #######################");
        System.out.println(checkInclusionUsingArrays("ab","eidbaooo"));
        System.out.println(checkInclusionUsingArrays("ab","eidboaoo"));
    }
}
