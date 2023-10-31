package io.cscode.algorithms.strings;

import java.util.HashMap;

public class MaximumNumberOfBalloons {

    /* Using a HashMap to store mapping of letters to number of times it appeared, then find how many instances
        of 'balloon' word can be formed */
    static int usingHashMapToStoreMapping(String text) {
        HashMap<Character, Integer> mapping = new HashMap<>();
        for(char c : text.toCharArray()){
            if(c == 'b' || c == 'a' || c =='l' || c =='o' || c == 'n') {
                mapping.merge(c, 1, Integer::sum);
            }
        }

        char[] balloon = {'b', 'a', 'l', 'o', 'n'};
        int max =Integer.MAX_VALUE;
        for(char c: balloon) {
            Integer count = mapping.get(c);
            if(count == null) {
                return 0;
            }
            if(c == 'l' || c == 'o') {
                // since two l and o letters are needed, we will check for 2's count
                count = count /2;
            }

            if(count < max) {
                max = count;
            }
        }
        return max;
    }

    /* Store mapping of letter to its count into an array */
    static int usingArrayToStoreMapping(String text) {
        int[] mapping = new int[26];
        for(char c : text.toCharArray()){
            mapping[c-'a'] +=1;
        }

        char[] balloon = {'b', 'a', 'l', 'o', 'n'};
        int max =Integer.MAX_VALUE;
        for(char c: balloon) {
            int count = mapping[c-'a'];
            if(count == 0) {
                return 0;
            }
            if(c == 'l' || c == 'o') {
                // since two l and o letters are needed, we will check for 2's count
                count = count /2;
            }

            if(count < max) {
                max = count;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("############### Store Mapping into a HashMap ######################");
        System.out.println(usingHashMapToStoreMapping("nlaebolko"));
        System.out.println(usingHashMapToStoreMapping("loonbalxballpoon"));
        System.out.println(usingHashMapToStoreMapping("cscode"));

        System.out.println("############### Store Mapping into an array ######################");
        System.out.println(usingArrayToStoreMapping("nlaebolko"));
        System.out.println(usingArrayToStoreMapping("loonbalxballpoon"));
        System.out.println(usingArrayToStoreMapping("cscode"));
    }
}
