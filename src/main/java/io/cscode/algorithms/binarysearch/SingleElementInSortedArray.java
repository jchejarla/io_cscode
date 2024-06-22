package io.cscode.algorithms.binarysearch;

public class SingleElementInSortedArray {

    static int singleNonDuplicate(int[] nums) {

        int left = 0;
        int right = nums.length -1;

        while(left <= right) {
            int mid  = left + (right - left) /2;
            if((mid-1<0 || nums[mid] != nums[mid-1])
                    && (mid+1 == nums.length || nums[mid] != nums[mid+1])) {
                return nums[mid];
            }

            // Now, we need to decide which side of array to eliminate
            // if the current element duplicate is on left side or right, we will get remaining array sizes on left anf right sides
            // and check which side has odd length array, because if there is only one element appeared once, that side of array should be odd length

            int leftSideLength = mid;  // mid is already 0 indexed, from length wise it represents correct.
                                        //  assuming right side element to mid is same
            if(mid-1>=0 && nums[mid] == nums[mid-1]) { // if left side element and current are same
                leftSideLength = mid-1;
            }

           if(leftSideLength % 2 == 0) { // if left side array is odd length
               left = mid+1;
           } else {
               right = mid -1;
           }

        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
        System.out.println(singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
        System.out.println(singleNonDuplicate(new int[]{1,2,2}));
        System.out.println(singleNonDuplicate(new int[]{1,1,2}));
    }
}
