package io.cscode.algorithms.strings;

import java.util.HashMap;
import java.util.Map.Entry;

public class ValidAnagram {

    /* Using a temporary array */
    static boolean usingArray(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        int[] arr = new int[26];
        for(int i=0; i<s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        for(int j=0; j<t.length(); j++) {
            int charIndex = t.charAt(j) - 'a';
            arr[charIndex] = arr[charIndex] - 1;
            if(arr[charIndex] == -1) {
                return false;
            }
        }
        return true;
    }

    /* Using two hashmaps two keep character count of each string s and t */
    static boolean usingTwoHashMap(String s, String t) {
        if(s.length() != t.length()) { // if the lengths are not same, they can't be anagrams
            return false;
        }

        HashMap<Character, Integer> s_count = new HashMap<>();
        HashMap<Character, Integer> t_count = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            s_count.merge(s.charAt(i), 1, Integer::sum);
            t_count.merge(t.charAt(i), 1, Integer::sum);
        }

        //now, for every character count in s_count, check if the count in t_count matches or not

        for(Entry<Character, Integer> charToCountEntry : s_count.entrySet()) {
            if(!charToCountEntry.getValue().equals(t_count.get(charToCountEntry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    /* Using a single HashMap - equivalent to using arrays approach*/
    static boolean usingSingleHashMap(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> s_count = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            s_count.merge(s.charAt(i), 1, Integer::sum);
        }

        for(int j=0; j<t.length(); j++) {
            int newValAfter = s_count.merge(t.charAt(j), -1, Integer::sum); // this returns the new value after decrementing the count
            if(newValAfter == -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("############### Using Two HashMaps approach######################");
        System.out.println(usingTwoHashMap("anagram", "nagaram"));
        System.out.println(usingTwoHashMap("car", "rat"));

        System.out.println("############### Using One HashMap approach######################");
        System.out.println(usingSingleHashMap("anagram", "nagaram"));
        System.out.println(usingSingleHashMap("car", "rat"));

        System.out.println("############### Using array approach######################");
        System.out.println(usingArray("anagram", "nagaram"));
        System.out.println(usingArray("car", "rat"));

    }
}
