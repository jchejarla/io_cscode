package io.cscode.algorithms.arrays;

public class MedianOfTwoSortedArraysOfSameSize {

    public static double median_While_Merging(int[] nums1, int[] nums2, int n) {

        int i=0; // index to keep track of nums1
        int j=0; //index to keep track of nums2

        int m1=-1; // temporary variable to hold 1st mid element
        int m2=-2;// temporary variable to hold 2n mid element

        for (int k =0; k<= n; k++) { // looping to n+1 times to compare elements as our median would be
                                     // from n-1 index element from first array and 0th index from second array
                                     // when the array is fully merged and sorted  [0,1,2....n-1] [0,1,2....n-1]

            if(i == n) { // where nums1 array elements are smaller than nums2,
                        // so i is incremented to the end index of nums1 array
                        // median would be nums1[n-1] = last element from nums1
                        // and nums2[0] = first element from nums2
                m1 = m2;
                m2 = nums2[0];
                break;
            }

            if(j == n) { // where nums2 array elements are smaller than nums1
                m1 = m2;
                m2 = nums1[0];
                break;
            }

            // keep copying the smallest out of nums1 and nums2 into m1 and m2
            if(nums1[i]<=nums2[j]){
                m1 = m2;
                m2 = nums1[i];
                i++;
            } else {
                m1 = m2;
                m2 = nums2[j];
                j++;
            }
        }

        return (double) (m1+m2)/2;
    }

    public static double median_Using_Binary_Search(int[] nums1, int[] nums2) {
        if(nums1.length == 0) { // base case if input arrays have only one element
            return (double) (nums1[0] + nums2[0])/2;
        }
        return median_Using_Binary_Search_Recursive(nums1,nums2, 0, nums1.length-1, 0, nums2.length-1);
    }

    public static double getMedian(int[] input, int start, int end) {
        int length = end -start +1; // since index starts from 0
        int mid = length /2;
        if((length % 2) == 0) { // even array
            return (double)(input[mid-1] + input[mid]) / 2;
        } else {
            return input[mid];
        }
    }

    /**
     *
     * @param nums1
     * @param nums2
     * @param startA - start index of nums1 array
     * @param endA - end index of nums1 array
     * @param startB - start index of nums2 array
     * @param endB - end index of nums2 array
     * @return
     */
    public static double median_Using_Binary_Search_Recursive(int[] nums1, int[] nums2, int startA, int endA, int startB, int endB) {

        if (endA - startA == 1 && endB - startB == 1) { // If the nums1 array has only two elements
                                // nums2 size is also same as nums1, per problem statement
            return (double)(Math.max(nums1[startA], nums2[startB]) + Math.min(nums1[endA], nums2[endB]) ) /2;
        }

        double m1 = getMedian(nums1, startA, endA);
        double m2 = getMedian(nums2, startB, endB);

        // if both medians are same, return either of them
        if(m1 == m2) {
            return m1;
        }

        int length = (endA - startA +1);
        boolean isEven = length % 2==0;
        int mid = isEven ? length/2-1 : length/2;

        // if m1 < m2 then the median will be between m1,endA from nums1[.... m1 ....endA...]
        // and startB and m2 of nums2 [...startB....m2...]

        if(m1<m2) {
            return median_Using_Binary_Search_Recursive(nums1, nums2, startA+(mid), endA, startB, endB - (mid));
        } else {
            return median_Using_Binary_Search_Recursive(nums1, nums2, startA, endA-mid,  startB+mid, endB);
        }

    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 6 }; //2.5
        int[] nums2 = {4, 6, 8, 10}; // 7
        double median = median_Using_Binary_Search(nums2,nums1);
        System.out.println(median);

        nums1 = new int[]{1, 2, 5, 11, 15};
        nums2 = new int[]{3, 4, 13, 17, 18};
        median = median_Using_Binary_Search(nums1,nums2);
        System.out.println(median);

        nums1 = new int[]{1, 2, 11, 15}; //6.5 -- 1 ,2, 3 ,4, 9, 10, 11, 15
        nums2 = new int[]{3, 4, 9, 10}; //6.5
        median = median_Using_Binary_Search(nums1,nums2);
        System.out.println(median);


        nums1 = new int[]{1, 1, 1, 1 ,1};
        nums2 = new int[] {4, 6, 8, 10,12};
        median = median_Using_Binary_Search(nums1,nums2);
        System.out.println(median);
        median = median_Using_Binary_Search(nums2,nums1);
        System.out.println(median);
        median = median_Using_Binary_Search(nums1,nums1);
        System.out.println(median);
        median = median_Using_Binary_Search(nums2,nums2);
        System.out.println(median);

        nums1 = new int[]{1, 3, 5};
        nums2 = new int[]{2, 3, 7};
        median = median_Using_Binary_Search(nums1,nums2);
        System.out.println(median);


    }
}
