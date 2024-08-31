package io.cscode.algorithms.binarysearch;

public class CapacityToShipPackagesWithinDays {

    static int shipWithinDays(int[] weights, int days) {
            int max = 0;
            int sum =0;
            for(int i=0; i<weights.length; i++) {
                sum += weights[i];
                max = Math.max(max, weights[i]);
            }

            if(weights.length == days) {
                return max; // if we were given days = weights length, that means we can use all available days to ship
            }

            int left = max;
            int right = sum;
            int ans = 0;
            while(left <= right) {
                int mid = left + (right -left) /2;
                if(canShipPackagesWithCapacity(weights, mid, days)) {
                    ans = mid;
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            }
        return ans;
    }

    static boolean canShipPackagesWithCapacity(int[] weights, int capacity, int days) {
        int d = 1;
        int sum = 0;
        for(int i=0; i<weights.length; i++) {
            sum+=weights[i];
            if(sum>capacity) {
                d++;
                sum = weights[i];
            }
        }

        return d<=days;
    }

    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));
    }
}
