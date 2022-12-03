package io.cscode.algorithms.sorting;

public class QuicksortLomutoPartition {

    /**
     * Entry method this sorting algorithm
     *
     * @param nums
     */
    public void sortArray(int[] nums) {
        if(nums == null || nums.length==0 ||nums.length==1) {
            return;
        }
        quickSort(nums,0,nums.length-1);
    }

    /**
     * utility method, that calls partition method and recursively calls left and right sub arrays aplit at pivotIndex
     *
     * @param nums input array
     * @param left left index
     * @param right right index
     */
    private void quickSort(int nums[], int left, int right) {
        if (left < right) {
            int partition = partition(nums, left, right);
            quickSort(nums, left, partition-1);
            quickSort(nums, partition+1, right);
        }
    }

    /**
     * select the 'pivot' element and move elements which are lesser than pivot to left side of pivot
     * and greater than pivot to right side of pivot.
     * By the end of this, pivot is positioned in its position where it should be after array is sorted.
     *
     * @param nums
     * @param left
     * @param right
     * @return pivot index where it is finally positioned
     */
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

    /**
     * Utility method to swap elements
     *
     * @param nums input array
     * @param i index to be swapped with j
     * @param j index to be swapped with i
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
