package io.cscode.algorithms.strings;

public class ValidPalindromeII {

    static boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() -1;

        int charsDeletedOnLeft = 0;
        int charsDeletedOnRight = 0;

        while(start < end) {
            if(s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                if(charsDeletedOnRight ==0) {
                    end--; // try removing the right side character
                    charsDeletedOnRight++;
                } else if(charsDeletedOnLeft ==0) {
                    end++;// move back since we have already tried removing one character above
                    start++;
                    charsDeletedOnLeft++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(validPalindrome("race a car"));
        System.out.println(validPalindrome(" "));
        System.out.println(validPalindrome("aba"));
        System.out.println(validPalindrome("abca"));
        System.out.println(validPalindrome("abc"));

    }
}
