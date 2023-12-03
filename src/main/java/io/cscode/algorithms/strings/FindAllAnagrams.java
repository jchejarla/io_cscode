package io.cscode.algorithms.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagrams {

    static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if(p.length() > s.length()) {
            return result;
        }

        // s = cbaebabacd  p=abc
        HashMap<Character, Integer> p_count = new HashMap<>();
        HashMap<Character, Integer> s_count = new HashMap<>();

        for(int i=0; i<p.length() -1 ; i++) {
            p_count.merge(p.charAt(i), 1, Integer::sum);
            s_count.merge(s.charAt(i), 1, Integer::sum);
        }
        p_count.merge(p.charAt(p.length()-1), 1, Integer::sum);

        for(int i=p.length() -1; i<s.length(); i++) {
            //add next character to current slide window to make s_count and p_count have same number of characters
            s_count.merge(s.charAt(i), 1, Integer::sum);
            int windowStart = i - p.length() +1;
            if(p_count.equals(s_count)) {
                result.add(windowStart);
            }
            //Now, remove beginning indexed character to move the sliding window
            Integer valAfter = s_count.merge(s.charAt(windowStart), -1, Integer::sum);
            if(valAfter.equals(0)) {
                s_count.remove(s.charAt(windowStart));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
        System.out.println(findAnagrams("baa", "aa"));
        System.out.println(findAnagrams("aaaaaaaaaa", "aaaaaaaaaaaaa"));

    }
}
