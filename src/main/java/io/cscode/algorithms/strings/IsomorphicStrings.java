package io.cscode.algorithms.strings;

import java.util.HashMap;

public class IsomorphicStrings {

    static boolean usingHashMapStoreMapping(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> s_map = new HashMap<>();
        HashMap<Character, Character> t_map = new HashMap<>();

        for(int i=0; i<s.length(); i++ ){
            char s_char = s.charAt(i);
            char t_char = t.charAt(i);

            Character s_exists = s_map.get(s_char); // if mapping already exists and not equal to t_char, then we can return false
            if(s_exists != null && s_exists != t_char) {
                return false;
            }
            s_map.put(s_char, t_char);

            Character t_exists = t_map.get(t_char);
            if(t_exists != null && t_exists != s_char) { // if already exists and not equal to s_char, then we can return false
                return false;
            }
            t_map.put(t_char, s_char);
        }

        return true;
    }

    static boolean usingArrayToStoreMapping(String s, String t) {
        int[] s_map = new int[128];
        int[] t_map = new int[128];

        for(int i=0; i<s.length(); i++) {
            char s_char = s.charAt(i);
            char t_char = t.charAt(i);

            int s_exists = s_map[s_char];
            if(s_exists != 0 && s_exists != t_char) {
                return false;
            }
            s_map[s_char] = t_char;

            int t_exists = t_map[t_char];
            if(t_exists != 0 && t_exists != s_char) {
                return false;
            }
            t_map[t_char] = s_char;

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("############### Using s->t mapping in a Map ######################");
        System.out.println(usingHashMapStoreMapping("egg", "add"));
        System.out.println(usingHashMapStoreMapping("foo", "bar"));
        System.out.println(usingHashMapStoreMapping("badc", "baba"));

        System.out.println("############### Using s->t mapping in an array ######################");
        System.out.println(usingArrayToStoreMapping("egg", "add"));
        System.out.println(usingArrayToStoreMapping("foo", "bar"));
        System.out.println(usingArrayToStoreMapping("badc", "baba"));

    }
}
