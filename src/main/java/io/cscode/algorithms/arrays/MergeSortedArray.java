package io.cscode.algorithms.arrays;

import java.util.Arrays;

public class MergeSortedArray {

    static void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = nums1.length - 1;
        while(m>0 && n>0) {
           if(nums1[m-1] > nums2[n-1]) {
               nums1[last--] = nums1[m-1];
               m--;
           } else {
               nums1[last--] = nums2[n-1];
               n--;
           }
        }
        while(n>0) {
            nums1[last--] = nums2[n-1];
            n--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
        nums1 = new int[]{1};
        nums2 = new int[]{};
        merge(nums1, 1, nums2, 0);
        System.out.println(Arrays.toString(nums1));
        nums1 = new int[]{0};
        nums2 = new int[]{1};
        merge(nums1, 1, nums2, 1);
        System.out.println(Arrays.toString(nums1));
        nums1 = new int[]{4,5,6,0,0,0};
        nums2 = new int[]{1,2,3};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));

    }
}
