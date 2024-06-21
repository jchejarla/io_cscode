package io.cscode.algorithms.binarysearch;

public class ValidPerfectSquare {

    static boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while(left <= right) {
            int mid = left + (right - left) /2;
            int sqrt = mid * mid;
            if (sqrt == num) {
                return true;
            } else if (sqrt > num) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(14));
    }
}
