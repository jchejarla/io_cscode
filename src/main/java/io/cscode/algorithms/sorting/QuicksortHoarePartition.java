package io.cscode.algorithms.sorting;

public class QuicksortHoarePartition {

    public void sortArray(int[] nums) {
        if(nums == null || nums.length==0 ||nums.length==1) {
            return;
        }
        quickSort(nums, 0, nums.length-1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if(left < right) {
            int pivotIndex = partition(nums, left, right);
            quickSort(nums, left, pivotIndex);
            quickSort(nums, pivotIndex +1, right);
        }
    }
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

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
