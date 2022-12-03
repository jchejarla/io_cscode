package io.cscode.algorithms.sorting;

public class QuicksortHoarePartition {

    /**
     * Entry method this sorting algorithm
     *
     * @param nums input array
     */
    public void sortArray(int[] nums) {
        if(nums == null || nums.length==0 ||nums.length==1) {
            return;
        }
        quickSort(nums, 0, nums.length-1);
    }

    /**
     * utility method, that calls partition method and recursively calls left and right sub arrays aplit at pivotIndex
     *
     * @param nums input array
     * @param left left index
     * @param right right index
     */
    private void quickSort(int[] nums, int left, int right) {
        if(left < right) {
            int pivotIndex = partition(nums, left, right);
            quickSort(nums, left, pivotIndex);
            quickSort(nums, pivotIndex +1, right);
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
    private int partition(int[] nums, int left, int right) {
        int pivotIndex = left + (right-left)/2;
        int pivot = nums[pivotIndex];

        int i = left-1;
        int j = right+1;

        while (true) {

            do {
                i++;
            } while(nums[i] < pivot);

            do {
                j--;
            } while (nums[j] > pivot);

            if(i >= j) {
                return j;
            }

            swap(nums, i, j);
        }
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
