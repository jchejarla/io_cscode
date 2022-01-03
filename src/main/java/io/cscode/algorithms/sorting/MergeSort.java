package io.cscode.algorithms.sorting;

public class MergeSort {

    public void sort(int[] nums) {
        if(nums == null || nums.length==0 ||nums.length==1) {
            return;
        }
        mergeSort(nums, 0, nums.length-1);
    }

    private void mergeSort(int[] nums, int left, int right) {
        if(left < right) {
            int mid = left + (right-left)/2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid+1, right);
            merge(nums, left, mid, right);
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int n1= mid -left +1; // mid inclusive and indexes starts with 0, so +1
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i=0; i<n1; i++) {
            leftArray[i] = nums[left+i];
        }

        for (int j=0; j<n2; j++) {
            rightArray[j] = nums[mid+1+j];
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

