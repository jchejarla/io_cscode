package io.cscode.algorithms.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IsStringHasUniqueCharacters {

    public boolean isStringHasUniqueCharsUsingSorting(String input) {
        if(input == null) {
            return false;
        }
        if(input.length() == 0 || input.length() == 1) { // if input string is empty or has just one character
            return true;
        }
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        for(int i=1; i<chars.length; i++) {
            if(chars[i] == chars[i-1]) {
                return false;
            }
        }
        return true;
    }

    public boolean isStringHasUniqueCharsUsingSet(String input) {
        if(input == null) {
            return false;
        }
        if(input.length() == 0 || input.length() == 1) { // if input string is empty or has just one character
            return true;
        }
        Set<Character> visited = new HashSet<>();
        for(char c : input.toCharArray()) {
            boolean duplicateFound = visited.contains(c);
            if(duplicateFound) {
                return false;
            }
            visited.add(c);
        }
        return true;
    }


    /**
     * Considering that that input String has only ASCII characters.
     * If it is not ASCII characters, temp array length can be adjusted accordingly.
     */
    public boolean isStringHasUniqueCharsUsingTempArray(String input)  {
        if(input == null) {
            return false;
        }
        if(input.length() == 0 || input.length() == 1) { // if input string is empty or has just one character
            return true;
        }
        int[] visited = new int[128];
        for(char c: input.toCharArray()) {
            if(visited[c] != 0) { // this means the same character has already been visited
                return false;
            }
            visited[c] = 1;
        }
        return true;
    }


}
