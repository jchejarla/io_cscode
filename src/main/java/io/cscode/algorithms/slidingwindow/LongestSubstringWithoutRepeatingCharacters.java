package io.cscode.algorithms.slidingwindow;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    static int lengthOfLongestSubstring(String s) {

        // Note that HashSet can be replaced with array[128] if the characters are ascii (see below method)
        HashSet<Character> dups = new HashSet<>();
        int left = 0;
        int right = 0;
        int longest = 0;
        while(right < s.length()) {
            char current = s.charAt(right);
            while (dups.contains(current)) {
                // move left index to where the duplicate was found
                // and remove all characters until that left index
                dups.remove(s.charAt(left++));
            }
            longest = Math.max(longest, right-left+1);
            dups.add(current);
            right++;
        }

        return longest;
    }

    static int lengthOfLongestSubstring_Using_Array_ASCII(String s) {

        // This is same as above, we are replacing HashSet with int[] array, assuming characters are ascii
        int[] dups = new int[128];
        int left = 0;
        int right = 0;
        int longest = 0;
        while(right < s.length()) {
            char current = s.charAt(right);
            while(dups[current] != 0) {
                dups[s.charAt(left)]  -= 1;
                left++;
            }
            longest = Math.max(longest, right - left +1);
            dups[current] +=  1;
            right++;
        }

        return longest;
    }

    public static void main(String[] args) {
        System.out.println("########### Sliding Window, and find duplicates using a HashMap #############");
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(" "));

        System.out.println("########### Sliding Window, and find duplicates using an array (ascii) #############");
        System.out.println(lengthOfLongestSubstring_Using_Array_ASCII("abcabcbb"));
        System.out.println(lengthOfLongestSubstring_Using_Array_ASCII("bbbbb"));
        System.out.println(lengthOfLongestSubstring_Using_Array_ASCII("pwwkew"));
        System.out.println(lengthOfLongestSubstring_Using_Array_ASCII(" "));

    }
}
