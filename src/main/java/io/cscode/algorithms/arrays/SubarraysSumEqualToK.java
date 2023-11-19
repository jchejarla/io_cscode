package io.cscode.algorithms.arrays;

import java.util.HashMap;

public class SubarraysSumEqualToK {

    static int subarraySum(int[] nums, int k) {
        int result = 0;
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int i=1; i<nums.length; i++) {
            prefixSum[i] = nums[i] + prefixSum[i-1];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int prefix: prefixSum) {
            if(map.containsKey(prefix-k)) {
                result += map.get(prefix-k);
            }
            map.merge(prefix, 1, Integer::sum);
        }
        System.out.println(map);
        return result;
    }


    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,-1,1}, 1));
        System.out.println(subarraySum(new int[]{1,2,3,4,5}, 9));
    }
}
