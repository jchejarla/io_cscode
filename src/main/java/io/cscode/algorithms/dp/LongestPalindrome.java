package io.cscode.algorithms.dp;

public class LongestPalindrome {

    /* brute force approach*/
    static String bruteForceApproach(String s) {
        String longestPalindrome = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j <= s.length(); j++) { // we are doing j<=str.length() because substring method we are using below endIndex is exclusive
                String sub = s.substring(i, j);
                if (isPalindrome(sub) && sub.length() > longestPalindrome.length()) {
                    longestPalindrome = sub;
                }
            }
        }
        return longestPalindrome;
    }

    static boolean isPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        if (str.length() == 1) { // if the string length is 1, it is a palindrome
            return true;
        }

        int i = 0;
        int j = 0;
        int length = str.length();

        if (length % 2 == 0) {    // when string length is even, for example "abba" it's a palindrome with no center
            int mid = length / 2; // for "abba" mid will become 2, so we should set i=1 and j=2 (i.e. b b)
            // then, we can check remaining characters by moving i and j to left side and right side
            // of the string respectively
            j = mid;
            i = mid - 1;
        } else {                // when string length is odd, for example "abcba" it's a palindrome with c as center
            int mid = length / 2; // for "abcba" mid will become 2, that is already center letter c
            // so we should set i=1 and j=3 (i.e. b b)
            // then, we can check remaining characters by moving i and j to left side and right side
            // of the string respectively
            j = mid + 1;
            i = mid - 1;
        }

        while (i >= 0 && j < str.length()) {
            if (str.charAt(i) == str.charAt(j)) {
                i--;
                j++;
            } else {
                return false;
            }
        }
        return true;
    }


    /* expand around center*/
    static String expandAroundCenter(String s) {
        String maxPalindrome = "";
        for (int i = 0; i < s.length(); i++) {

            // this will check only odd length palindromes, because l and r pointing to same index i
            String maxPalindromeOdd = expandAroundCenterHelper(s, i, i);
            // since we have checked odd length palindromes above, we will repeat the same process for even length palindromes
            String maxPalindromeEven = expandAroundCenterHelper(s, i, i + 1);
            if (maxPalindromeOdd.length() > maxPalindrome.length()) {
                maxPalindrome = maxPalindromeOdd;
            }
            if (maxPalindromeEven.length() > maxPalindrome.length()) {
                maxPalindrome = maxPalindromeEven;
            }
        }
        return maxPalindrome;
    }

    static String expandAroundCenterHelper(String s, int l, int r) {
        String maxPalindrome = "";
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            if (r - l + 1 > maxPalindrome.length()) {
                maxPalindrome = s.substring(l, r + 1);
            }
            l--;
            r++;
        }
        return maxPalindrome;
    }


    public static void main(String[] args) {
        System.out.println("########### brute force approach #############");
        System.out.println(bruteForceApproach("babad"));
        System.out.println(bruteForceApproach("cbbd"));
        System.out.println(bruteForceApproach("a"));
        System.out.println(bruteForceApproach("ab"));
        System.out.println(bruteForceApproach("bb"));

        System.out.println("########### expand around center #############");
        System.out.println(expandAroundCenter("babad"));
        System.out.println(expandAroundCenter("cbbd"));
        System.out.println(expandAroundCenter("a"));
        System.out.println(expandAroundCenter("ab"));
        System.out.println(expandAroundCenter("bb"));

    }
}
