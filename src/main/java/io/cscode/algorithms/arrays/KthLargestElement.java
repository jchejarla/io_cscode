package io.cscode.algorithms.arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {

    public int findKthLargestUsingSorting(int[] input, int k) {
        Arrays.sort(input);
        return input[input.length-k];
    }


    public int findKthLargestUsingMinHeap(int[] input, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for(int num : input) {
            minHeap.add(num);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public int kthLargestUsingQuickSelect(int[] nums, int k) {
        //we are going to find nums.length - k th bigger element from left in the sorting order
        k = nums.length -k;
        return select(nums, 0, nums.length-1, k);
    }

    public int select(int[] nums, int left, int right, int k) {
        if(left==right) { // in case nums contains only on element - will return that
            return nums[left];
        }

        int storeIndex = partition(nums,left,right);
        if(k== storeIndex) {
            return nums[k];
        } else if (k<storeIndex) {
            return select(nums, left, storeIndex-1, k);
        } else {
            return select(nums, storeIndex+1, right, k);
        }
    }

    public int partition(int[] nums, int left, int right) {
        int pivotValue = nums[right];
        int storeIndex = left;
        for(int i=left; i<right; i++) {
            if(nums[i]<pivotValue) {
                swap(nums, i, storeIndex);
                storeIndex++;
            }
        }
        swap(nums,right,storeIndex); // move pivot to its final place
        return storeIndex;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
