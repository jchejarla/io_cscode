package io.cscode.algorithms.arrays;

import java.util.HashSet;
import java.util.stream.IntStream;

public class LongestConsecutiveSequence {

    /**
     *
     * First store elements into a HashSet, then loop through each element in the array and find if
     * previous number (num-1) exists in set, if it exists that means that is not the first number of a starting sequence,
     * and if previous number does not exist, then this is the first number of a starting sequence.
     *
     * When you find a starting number of sequence, keep checking if next number exists (num+1) and find the longest
     */
    static int longestConsecutiveUsingHashSet(int[] nums) {
        HashSet<Integer> set = new HashSet<>(nums.length);
        IntStream.of(nums).forEach(set::add);
        int longest =0;

        for(int num: nums) {
            if(!set.contains(num-1)) {
                // if the previous number is not in the set, that means this is the starting of sequence.
                int currentLong = 1;
                while(set.contains(num+1)) {
                    currentLong++;
                    num++;
                }
                if(currentLong >longest) {
                    longest = currentLong;
                }
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutiveUsingHashSet(new int[]{100,4,200,1,3,2}));
        System.out.println(longestConsecutiveUsingHashSet(new int[]{0,3,7,2,5,8,4,6,0,1}));

    }
}
