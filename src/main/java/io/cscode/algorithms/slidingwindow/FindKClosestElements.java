package io.cscode.algorithms.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindKClosestElements {

    static List<Integer> findClosestElements(int[] arr, int k, int x) {

        int n = arr.length;
        int left  = 0;
        // we are going to run sliding window with size as K.
        // so if left pointer reaches to right side of the array
        // we need atleast k elements to be there
        int right = n- k;

        // since the array is sorted, to find the window, we can use binary search
        while(left < right) {
            int mid = left + (right - left)/2;
            // we are trying to find element X/ element nearest to X in a sorted array
            // and the subarray of length k which has elements near to X
            // say if the input array is [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13], and k=4 x=3
            // since right side values are greater than left side values
            // check whether left side is closer to x or right side value is closer to x
            // if they are same distance, then we have to take smaller value (i.e. left side value), so move towards left
            if(x-arr[mid] > arr[mid+k]-x) {
                left = mid+1;
            } else {
                right = mid; // suppose mid is the X, we need to consider mid
            }
        }
        return IntStream.of(Arrays.copyOfRange(arr, left, left+k)).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}, 4, 3));
        System.out.println(findClosestElements(new int[]{1,2,3,4,5}, 4, 3));
        System.out.println(findClosestElements(new int[]{1,2,3,4,5}, 4, -1));
    }
}
