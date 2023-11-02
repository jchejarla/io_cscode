package io.cscode.algorithms.strings;

import java.util.HashMap;

public class WordPattern {

    static boolean usingHashMapToStoreMapping(String pattern, String s) {
        String[] words = s.split(" ");
        if(pattern.length() != words.length) {
            return false;
        }
        HashMap<Character, String> map_c_word = new HashMap<>();
        HashMap<String, Character> map_word_c = new HashMap<>();
        for(int i=0; i<pattern.length(); i++) {
            char c = pattern.charAt(i);
            String wordValAfter = map_c_word.putIfAbsent(c, words[i]);
            if(wordValAfter != null && !wordValAfter.equals(words[i])) {
                return false;
            }
            Character cValAfter = map_word_c.putIfAbsent(words[i], c);
            if(cValAfter != null && !cValAfter.equals(c)){
                return false;
            }

        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println("############### Store Mapping into a HashMap ######################");
        System.out.println(usingHashMapToStoreMapping("abba", "dog cat cat dog"));
        System.out.println(usingHashMapToStoreMapping("abbaa", "dog cat cat dog"));
        System.out.println(usingHashMapToStoreMapping("abba", "cat cat cat cat"));

    }
}

