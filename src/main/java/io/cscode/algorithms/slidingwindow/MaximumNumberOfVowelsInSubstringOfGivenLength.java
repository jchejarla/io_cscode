package io.cscode.algorithms.slidingwindow;

public class MaximumNumberOfVowelsInSubstringOfGivenLength {

    static int maxVowels(String s, int k) {

        int left = 0;
        int right =0;
        int vowels = 0;
        int maxVowels = 0;
        while(right < s.length()) {
            char current = s.charAt(right);
            if(isVowel(current)) {
                vowels++;
            }
            while(right-left+1>k){
                char leftChar = s.charAt(left);
                if(isVowel(leftChar)) {
                    vowels--;
                }
                left++;
            }

            maxVowels = Math.max(maxVowels, vowels);
            right++;
        }

        return maxVowels;
    }

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3));
        System.out.println(maxVowels("aeiou", 2));
        System.out.println(maxVowels("cscode", 3));
    }

}
