package io.cscode.algorithms.arrays;

public class RangeSumQueryImmutable {

    private final int[] arr;

    public RangeSumQueryImmutable(int[] nums) {
        arr = new int[nums.length];
        arr[0] = nums[0];
        for(int i=1; i<nums.length; i++) {
            arr[i] = nums[i] + arr[i-1];
        }
    }

    public int sumRange(int left, int right) {
        return arr[right] - (left ==0 ? 0 : arr[left-1]);
    }

    public static void main(String[] args) {
        RangeSumQueryImmutable rangeSumQueryImmutable = new RangeSumQueryImmutable(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(rangeSumQueryImmutable.sumRange(0, 2));
        System.out.println(rangeSumQueryImmutable.sumRange(2, 5));
        System.out.println(rangeSumQueryImmutable.sumRange(0, 5));

    }
}
