package io.cscode.algorithms.arrays;

import java.util.HashMap;

public class ContiguousSubArraySum {

    static boolean checkSubArraySum(int[] nums, int k) {
        HashMap<Integer, Integer> remainderToIndexMap = new HashMap<>(nums.length);
        remainderToIndexMap.put(0, -1);

        for(int i=0; i<nums.length; i++) {
            nums[i] = nums[i] + (i==0 ? 0 : nums[i-1]);
            int remainder  = nums[i] % k;
            Integer index = remainderToIndexMap.get(remainder);
            if(index == null) {// remainder not exists, then we add it
                remainderToIndexMap.put(remainder, i);
            } else if (i - index >=2) { // subarray min length of 2 or more, we have found answer
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkSubArraySum(new int[] {23,2,4,6,7}, 6));
        System.out.println(checkSubArraySum(new int[] {24,2,4,6,7}, 6));
        System.out.println(checkSubArraySum(new int[] {24,0}, 6));
        System.out.println(checkSubArraySum(new int[] {0,0}, 6));
        System.out.println(checkSubArraySum(new int[] {5,0,0}, 3));

        System.out.println(checkSubArraySum(new int[] {24}, 6)); // will produce false, since length is 1.
        System.out.println(checkSubArraySum(new int[] {24,1}, 6)); // will produce false, since length is 1.

    }
}
