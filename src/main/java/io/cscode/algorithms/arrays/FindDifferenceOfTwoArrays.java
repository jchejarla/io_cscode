package io.cscode.algorithms.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDifferenceOfTwoArrays {

    static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>(nums1.length);
        for(int num: nums1) {
            nums1Set.add(num);
        }
        Set<Integer> nums2Set = new HashSet<>(nums2.length);
        for(int num: nums2) {
            nums2Set.add(num);
        }

        List<Integer> result1 = new ArrayList<>();
        List<Integer> result2 = new ArrayList<>();

        for(Integer num1 : nums1Set) {
            if(!nums2Set.contains(num1)) {
                result1.add(num1);
            }
        }

        for(Integer num2 : nums2Set) {
            if(!nums1Set.contains(num2)) {
                result2.add(num2);
            }
        }

        return List.of(result1, result2);
    }

    public static void main(String[] args) {
        System.out.println(findDifference(new int[]{1, 2, 3}, new int[] {2, 4, 6}));
    }
}
