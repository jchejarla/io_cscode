package io.cscode.algorithms.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement1 {

    /* iteration over both arrays and for each number in nums1, find next immediate greater element if exists from nums2 */
    static int[] usingIterateOverArrays(int[] nums1, int[] nums2) {
        for(int i=0;i <nums1.length; i++) {
            int num = nums1[i];
            int nextGreater=0;
            for(int j=0; j<nums2.length; j++) {
                if(nums2[j] == num) {
                    nextGreater = -1;

                }
                if(nextGreater == -1 && nums2[j] > num) {
                    nextGreater = nums2[j];
                    break;
                }
            }
            nums1[i] = nextGreater;
        }
        return nums1;
    }

    /* For every number in nums2, store next greater element possible in a Map, then loop through nums1 and get greater element from already computed Map */
    static int[] usingStackAndMap(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums2.length; i++) {
            int currentNum = nums2[i];
            while(!stack.isEmpty() && currentNum > stack.peek()) {
                map.put(stack.pop(), currentNum);
            }
            stack.push(currentNum);
        }

        // If stack still have elements left
        while(!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        // now, iterate through nums1 array an find the next greatest element from map which we stored above
        for(int i=0; i<nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }

    public static void main(String[] args) {
        System.out.println("############### Iterate over both arrays ######################");
        System.out.println(Arrays.toString(usingIterateOverArrays(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
        System.out.println(Arrays.toString(usingIterateOverArrays(new int[]{2, 4}, new int[]{1, 2, 3, 4})));

        System.out.println("############### Compute greater elements into a map using a stack ######################");
        System.out.println(Arrays.toString(usingStackAndMap(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
        System.out.println(Arrays.toString(usingStackAndMap(new int[]{2, 4}, new int[]{1, 2, 3, 4})));
    }
}
