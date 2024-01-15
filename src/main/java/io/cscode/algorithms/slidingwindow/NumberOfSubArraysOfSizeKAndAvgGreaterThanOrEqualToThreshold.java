package io.cscode.algorithms.slidingwindow;

public class NumberOfSubArraysOfSizeKAndAvgGreaterThanOrEqualToThreshold {

    static int numOfSubarrays(int[] arr, int k, int threshold) {

        int result = 0;
        int left = 0;
        int right = 0;
        int movingSum = 0;
        while (right < arr.length) {
            if (right - left > k - 1) {
                if (movingSum / k >= threshold) {
                    result++;
                }
                movingSum -= arr[left]; // subtract left pointer value from moving su, for next window
                left++;
            }

            movingSum += arr[right++];
        }

        if (movingSum / k >= threshold) {
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numOfSubarrays(new int[]{2, 2, 2, 2, 5, 5, 5, 8}, 3, 4));
        System.out.println(numOfSubarrays(new int[]{11, 13, 17, 23, 29, 31, 7, 5, 2, 3}, 3, 5));
    }
}
