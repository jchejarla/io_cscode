package io.cscode.algorithms.sorting;

public class QuicksortLomutoPartition {

    public int[] sortArray(int[] nums) {
        if(nums == null || nums.length==0 ||nums.length==1) {
            return nums;
        }
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    private void quickSort(int nums[], int left, int right) {
        if (left < right) {
            int partition = partition(nums, left, right);
            quickSort(nums, left, partition-1);
            quickSort(nums, partition+1, right);
        }
    }

    private int partition(int nums[], int left, int right) {
        int pivot = nums[right];
        int storeIndex = left;
        for (int leftIndex = left; leftIndex < right; leftIndex++) {
            if (nums[leftIndex] <= pivot) {
                swap(nums, leftIndex, storeIndex);
                storeIndex++;
            }
        }
        swap(nums, storeIndex, right); //at the end move pivot element (right indexed element) to its position to complete the partitioning.
        return storeIndex;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
