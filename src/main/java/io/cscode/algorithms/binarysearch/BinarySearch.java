package io.cscode.algorithms.binarysearch;

public class BinarySearch {

    static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        while(left <= right) {
            int mid = left + (right - left)/2; // to avoid integer overflow
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid]>target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 9));
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 2));
    }
}
