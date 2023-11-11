package io.cscode.algorithms.arrays;

import java.util.HashSet;

public class ValidSudoku {

    static boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>(9 * 9);
        for(int i=0; i< board.length; i++) {
            for(int j=0; j<board[i].length; j++) {

                if(board[i][j] == '.') {
                    continue;
                }

                // check if the number seen in the same row
                if(!set.add("ROW : "+i+ " NUM :"+board[i][j])) {
                    return false;
                }

                // check if the number seen in the same row
                if(!set.add("COLUMN : "+j+ " NUM :"+board[i][j])) {
                   return false;
                }

                // check if the number seen in the 3 X 3 matrix that the current cell is in
                // use i/3 and j/3 to get the current that matrix
                if(!set.add("ROW :"+ i/3 +"COLUMN : "+ j/3 + " NUM :"+board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board1  = {{'5','3','.','.','7','.','.','.','.'}
                                ,{'6','.','.','1','9','5','.','.','.'}
                                ,{'.','9','8','.','.','.','.','6','.'}
                                ,{'8','.','.','.','6','.','.','.','3'}
                                ,{'4','.','.','8','.','3','.','.','1'}
                                ,{'7','.','.','.','2','.','.','.','6'}
                                ,{'.','6','.','.','.','.','2','8','.'}
                                ,{'.','.','.','4','1','9','.','.','5'}
                                ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board1));

        char[][] board2  = {{'8','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board2));

    }
}
