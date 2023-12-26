package io.cscode.algorithms.strings;

public class MergeStringsAlternately {

    static String mergeAlternately(String word1, String word2) {
        int i=0;
        int j=0;
        StringBuilder result = new StringBuilder();
        while(i<word1.length() && j<word2.length()) {
            result.append(word1.charAt(i++));
            result.append(word2.charAt(j++));
        }
        if(i<word1.length()) { // if there are any remaining characters in word1, take remaining string
            result.append(word1.substring(i));
        }
        if(j<word2.length()) {
            result.append(word2.substring(j));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pqr"));
        System.out.println(mergeAlternately("abcd", "pq"));
        System.out.println(mergeAlternately("ab", "pqrs"));
    }

}
