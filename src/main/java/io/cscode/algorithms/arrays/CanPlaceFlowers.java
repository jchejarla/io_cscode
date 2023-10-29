package io.cscode.algorithms.arrays;

public class CanPlaceFlowers {

    static boolean canPlace(int[] flowerbed, int n) {
        int i = 0;
        while(i<flowerbed.length && n>0) {
            if(flowerbed[i] == 0
                    && (i == 0 || flowerbed[i-1] ==0)
                    && (i==flowerbed.length-1 || flowerbed[i+1]==0)) {
                n--;
                flowerbed[i] = 1;
            }
            i++;
        }

        return n==0;
    }

    public static void main(String[] args) {
        System.out.println(canPlace(new int[] {1, 0, 0, 0, 1}, 1));
        System.out.println(canPlace(new int[] {1, 0, 0, 0, 1}, 2));
        System.out.println(canPlace(new int[] {0, 0, 1, 0, 1}, 1));
        System.out.println(canPlace(new int[] {0, 1, 0, 1, 0}, 1));
        System.out.println(canPlace(new int[] {1,0,0,0,1,0,0}, 2));
        System.out.println(canPlace(new int[] {1,0,0,0,1,0,0}, 2));
        System.out.println(canPlace(new int[] {0}, 1));

    }
}
