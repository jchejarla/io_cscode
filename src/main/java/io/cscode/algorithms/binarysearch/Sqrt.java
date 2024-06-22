package io.cscode.algorithms.binarysearch;

public class Sqrt {

    static int mySqrt(int x) {
        int left = 1;
        int right = x;
        while(left <= right) {
            int mid = left + (right - left) /2;
            long square = (long)mid * mid;
            if(square == x) {
                return mid;
            } else if(square > x) {
                right = mid -1;
            } else {
                left = mid+1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        //System.out.println(mySqrt(4));
        //System.out.println(mySqrt(8));
        System.out.println(mySqrt(2147395599));
    }
}
