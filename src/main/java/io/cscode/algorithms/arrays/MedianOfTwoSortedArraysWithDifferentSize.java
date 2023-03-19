package io.cscode.algorithms.arrays;

public class MedianOfTwoSortedArraysWithDifferentSize {

    /**
     * Utility method to compute median of a given array
     * @param array input array
     * @return median of input array, and throws IllegalArgumentException if the input array is Null or empty
     */
    private static double getMedian(int[] array) {
        if(array == null || array.length ==0) {
            throw new IllegalArgumentException("input array cannot be null or empty");
        }
        if(array.length % 2 == 0) { // resultant array is an even length array
            int midIndex = array.length/2;
            return (double)(array[midIndex] + array[midIndex-1]) /2;
        }
        // if the resultant array is an odd length array
        return array[array.length/2];
    }

    /**
     *
     * Merges input arrays first and then take the median
     *
     * @param nums1 sorted array1
     * @param nums2 sorted array2
     * @return median of resultant array after merging
     */
    public static double median_After_Merging(int[] nums1, int[] nums2) {

        //base cases
        if(nums1 == null || nums1.length == 0) { // if nums1 array is null or empty, result array will be nums2
            return getMedian(nums2);
        } else if (nums2 == null || nums2.length ==0) { // if nums2 array is null or empty, result array will be nums1
            return getMedian(nums1);
        }

        int[] result = new int[nums1.length + nums2.length];

        int i = 0; // index to track nums1 array
        int j = 0; // index to track nums2 array

        for(int k=0; k<result.length; k++) {
            if(i<nums1.length && j<nums2.length) {
                if(nums1[i]<=nums2[j]) { // if nums1 has smaller number take that into result array
                    result[k] = nums1[i];
                    i++;
                } else {
                    result[k] = nums2[j]; // if nums2 has smaller number take that into result array
                    j++;
                }
            } else {
                // copy any remaining elements from nums1 (or) nums2
                if(i<nums1.length) {
                    result[k] = nums1[i];
                    i++;
                }
                if(j<nums2.length) {
                    result[k] = nums2[j];
                    j++;
                }
            }
        }

        return getMedian(result);
    }

    /**
     * whether the resultant array
     * @param nums1
     * @param nums2
     * @return
     */
    public static double median_While_Merging(int[] nums1, int[] nums2) {

        int i=0; // index to keep track of nums1
        int j=0; //index to keep track of nums2

        int m1=-1; // temporary variable to hold 1st mid element
        int m2=-1;// temporary variable to hold 2n mid element

        int mergedArrayLength = nums1.length + nums2.length;

        int n = mergedArrayLength/2;

        if(mergedArrayLength %2 ==0) { // if the result array is even length

            for (int k = 0; k <= n; k++) {
                m1 = m2;
                if(i != nums1.length && j != nums2.length) {
                    m2 = nums1[i]<nums2[j] ? nums1[i++] : nums2[j++];
                } else if (i<nums1.length) {
                    m2 = nums1[i++];
                } else {
                    m2 = nums2[j++];
                }
            }
            return (double) (m1+m2)/2;
        } else { // if the result array is odd array length
            for (int k = 0; k <= n; k++) {
                if (i != nums1.length && j != nums2.length) {
                    m1 = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
                } else if (i < nums1.length) {
                    m1 = nums1[i++];
                } else {
                    m1 = nums2[j++];
                }
            }
            return m1;
        }

    }

    public static double median_Using_Binary_Search(int[] nums1, int[] nums2) {


        if(nums1.length > nums2.length) {
            return median_Using_Binary_Search(nums2, nums1);
        }
        // assume nums1 is smaller array
        int x= nums1.length;
        int y = nums2.length;

        int low = 0;
        int high = x;
        while(low <=high) {

            int partitionX = (low + high) /2;
            int partitionY = (x + y + 1)/2 - partitionX;

            //partitionX == 0 is when there is nothing left on left side of the nums1 array
            //partitionX == x is when there is nothing left on right side of the nums1 array
            int leftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX-1];
            int rightX = partitionX == x ? Integer.MAX_VALUE : nums1[partitionX];

            //partitionY == 0 is when there is nothing left on left side of the nums2 array
            //partitionY == y is when there is nothing left on right side of the nums2 array
            int leftY = partitionY ==0 ? Integer.MIN_VALUE: nums2[partitionY-1];
            int rightY = partitionY ==y ? Integer.MAX_VALUE: nums2[partitionY];

            if(leftX<=rightY && leftY<=rightX) {
                if((x+y) % 2 == 0) {
                    return (double) (Math.max(leftX, leftY) + Math.min(rightX, rightY)) /2;
                } else {
                    return Math.max(leftX, leftY);
                }
            } else if (leftX>rightY) { // we are too far on the right side of array
                high = partitionX -1;
            } else {
                low  = partitionX + 1;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        double median = 0;
        /*median = median_While_Merging(new int[]{1}, new int[]{2} );
        System.out.println(median);
        median = median_While_Merging(new int[]{}, new int[]{2} );
        System.out.println(median);
        median = median_While_Merging(new int[]{1,3}, new int[]{2} );
        System.out.println(median);
        median = median_While_Merging(new int[]{1}, new int[]{2,3} );
        System.out.println(median);
        median = median_While_Merging(new int[]{1,4,7,8,9,12}, new int[]{2,5} );
        System.out.println(median);*/
        median = median_While_Merging(new int[]{1,4}, new int[]{2,3,7,8,9,34,56,99} );
        // 1 2 3 4 7 8 9 34 56 99
        System.out.println(median);
        int[] nums1 = new int[]{1,4};
        int[] nums2 = new int[]{2,3,7,8,9,34,56,99};
        median =  median_Using_Binary_Search(nums1,nums2);
        System.out.println(median);

    }
}
