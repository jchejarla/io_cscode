package io.cscode.algorithms.strings;

public class ValidPalindrome {

    static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() -1;
        while(start < end) {
            char left = s.charAt(start);
            char right = s.charAt(end);
            if(!Character.isLetterOrDigit(left)) {
                start++;
            } else if (!Character.isLetterOrDigit(right)){
                end--;
            } else if (Character.toLowerCase(left) != Character.toLowerCase(right)) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(" "));

    }
}
