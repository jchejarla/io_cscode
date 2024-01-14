package io.cscode.algorithms.slidingwindow;

import java.util.HashSet;

public class ContainsDuplicatesII {

    static boolean containsNearbyDuplicate(int[] nums, int k) {

        int left = 0;
        int right = 0;
        HashSet<Integer> dups = new HashSet<>();
        while(right < nums.length) {
            if(right-left > k) {
                dups.remove(nums[left]);
                left++;
            }
            if(dups.contains(nums[right])) {
                return true;
            }
            dups.add(nums[right]);
            right++;
        }
        return false; // if nothing found
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));

    }
}
