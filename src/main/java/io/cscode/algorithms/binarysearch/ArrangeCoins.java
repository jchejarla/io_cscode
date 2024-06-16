package io.cscode.algorithms.binarysearch;

public class ArrangeCoins {

    static int arrangeCoins(int n) {
        // 1, 2, 3, 4, --- sum formula sum = n(n+1) /2

        int left = 1;
        int right= n;
        while(left<=right) {
            int mid = left + (right - left) /2;
            long sum = (long)mid * (mid+1) /2;
            if(sum==n) {
                return mid;
            } else if (sum>n) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return right;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(5));
        System.out.println(arrangeCoins(8));
        System.out.println(arrangeCoins(1804289383));
    }
}

