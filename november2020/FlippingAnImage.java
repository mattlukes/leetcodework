/*
Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0]
horizontally results in [0, 1, 1].

To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1]
results in [1, 0, 0].

November 10, 2020
 */

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int[][] result = new int[A.length][A.length];
        if (A.length == 0) {
            return result;
        }
        else if (A.length == 1) {
            result[0][0] = A[0][0] ^ 1;
            return result;
        }

        for (int row = 0; row < A.length; row++) {
            int leftColumn = 0;
            int rightColumn = A.length - 1;
            while (rightColumn >= leftColumn) {
                if (rightColumn == leftColumn) {
                    result[row][rightColumn] = A[row][rightColumn] ^ 1;
                }
                else {
                    result[row][leftColumn] = A[row][rightColumn] ^ 1;
                    result[row][rightColumn] = A[row][leftColumn] ^ 1;
                }

                rightColumn--;
                leftColumn++;
            }
        }

        return result;
    }
}