package io.cscode.algorithms.arrays;

public class FindElementInRotationallySortedArray {

    static boolean find(int[] array, int element) {
        //[10, 11, 12, 13, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        int left = 0;
        int right = array.length-1;
        while (left<right) {
            int mid = (left +right)/2;
            if(array[mid] == element) {
                return true;
            } else if(element > array[mid] && element <array[right]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(find(new int[]{10, 11, 12, 13, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 1));
    }
}
