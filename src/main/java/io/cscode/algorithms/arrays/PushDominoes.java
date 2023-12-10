package io.cscode.algorithms.arrays;

public class PushDominoes {

    static String pushDominoes(String dominoes) {
        char[] dominoesArray = dominoes.toCharArray();
        int n = dominoesArray.length;
        int[] forces = new int[n];
        int force = 0;
        for(int i=0; i<n; i++) { // going from left to right, towards right, meaning R falls on neighbour dominoes
            if(dominoesArray[i] == 'R') {
                force = n;
            } else if(dominoesArray[i] == 'L') {
                force = 0;
            } else {
                force = Math.max(force-1, 0);
            }
            forces[i] += force;
        }
        force = 0;
        for(int i=n-1; i>=0; i--) {
            if(dominoesArray[i] == 'L') {
                force = n;
            } else if (dominoesArray[i] == 'R') {
                force = 0;
            } else {
                force = Math.max(force-1, 0);
            }
            forces[i] -= force;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n; i++) {
            if(forces[i] <0) {
                sb.append('L');
            } else if (forces[i]>0) {
                sb.append('R');
            } else {
                sb.append('.');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(pushDominoes(".L.R...LR..L.."));
    }
}
