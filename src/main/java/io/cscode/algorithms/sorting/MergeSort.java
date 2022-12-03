package io.cscode.algorithms.sorting;

/**
 * MergeSort implementation
 */
public class MergeSort {

    /**
     * Entry method this sorting algorithm
     *
     * @param nums input array
     */
    public void sort(int[] nums) {
        if(nums == null || nums.length==0 ||nums.length==1) {
            return;
        }
        mergeSort(nums, 0, nums.length-1);
    }

    /**
     * Main function that divides array into two halves and recursively calls itself on sub arrays
     * when the array cannot be split further, it calls merge() method to start merging on sub arrays.
     *
     * @param nums input array
     * @param left start index
     * @param right end index
     */
    private void mergeSort(int[] nums, int left, int right) {
        if(left < right) {
            int mid = left + (right-left)/2;
            mergeSort(nums, left, mid); //sort from 1...n/2
            mergeSort(nums, mid+1, right); //sort from (n/2)+1 ...n
            merge(nums, left, mid, right); //call merge function when input array can't be split be further
        }
    }

    /**
     * merge function to merge two sub arrays in sorting order.
     *
     * @param nums input array
     * @param left left index
     * @param mid mid index
     * @param right right index
     */
    private void merge(int[] nums, int left, int mid, int right) {
        int n1= mid -left +1; // mid inclusive and indexes starts with 0, so +1
        int n2 = right - mid;

        int[] leftArray = new int[n1]; // left sub array
        int[] rightArray = new int[n2]; // right sub array

        for (int i=0; i<n1; i++) {
            leftArray[i] = nums[left+i]; // copy from left to mid onto left sub array
        }

        for (int j=0; j<n2; j++) {
            rightArray[j] = nums[mid+1+j]; // copy from mid+1 to right onto right sub array
        }

        int i=0; // counter to keep track of index for leftArray
        int j=0; // counter to keep track of index for rightArray

        for (int k=left; k <= right; k++) {
            if(i<leftArray.length && j<rightArray.length) {
                if(leftArray[i] <=rightArray[j]) {
                    nums[k] = leftArray[i];
                    i++;
                } else {
                    nums[k] = rightArray[j];
                    j++;
                }
            } else {
                //copy any remaining elements in leftArray or rightArray into input array
                if(i < leftArray.length) {
                    nums[k] = leftArray[i];
                    i++;
                }
                if(j < rightArray.length) {
                    nums[k] = rightArray[j];
                    j++;
                }
            }
        }

    }

}