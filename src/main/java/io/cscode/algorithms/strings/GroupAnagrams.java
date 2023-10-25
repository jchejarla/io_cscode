package io.cscode.algorithms.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    /* Using char -> count as key and value as List of strings, then group all strings who has same char -> count*/
    static List<List<String>> usingHashMapToStoreCharacterCount(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> result = new HashMap<>();
        for(String str: strs) {
            HashMap<Character, Integer> key = new HashMap<>();
            for(char c: str.toCharArray()) {
                key.merge(c, 1, Integer::sum);
            }
            result.merge(key, new ArrayList<>(List.of(str)), (oldVal, newVal) -> {
                oldVal.addAll(newVal);
                return oldVal;
            });
        }
        return new ArrayList<>(result.values());
    }

    /* This is same as above, instead of using HashMap as key, we will construct an array with char -> count
        and convert that to a string for e.g. abc will be [1, 1, 1, 0, 0, 0, 0, .........], it will become a
        string with 26 characters length 11100000000000....*/
    static List<List<String>> usingCharArrayAsKey(String[] strs) {
        HashMap<String, List<String>> result = new HashMap<>();
        for (String str : strs) {
            char[] count = new char[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            result.merge(String.valueOf(count), new ArrayList<>(List.of(str)), (oldVal, newVal) -> {
                oldVal.addAll(newVal);
                return oldVal;
            });
        }
        return  new ArrayList<>(result.values());

    }


    public static void main(String[] args) {
        System.out.println("############### Using char->count in a Map as key ######################");
        System.out.println(usingHashMapToStoreCharacterCount(new String[]{"eat","tea","tan","ate","nat","bat"}));
        System.out.println(usingHashMapToStoreCharacterCount(new String[]{""}));
        System.out.println(usingHashMapToStoreCharacterCount(new String[]{"a"}));

        System.out.println("############### Using char->count in an array as key ######################");
        System.out.println(usingCharArrayAsKey(new String[]{"eat","tea","tan","ate","nat","bat"}));
        System.out.println(usingCharArrayAsKey(new String[]{""}));
        System.out.println(usingCharArrayAsKey(new String[]{"a"}));

    }
}
