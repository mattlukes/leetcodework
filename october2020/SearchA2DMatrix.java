/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

October 16, 2020
 */

class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0
         || matrix[0].length == 0) {
            return false;
        }

        int width = matrix[0].length;

        for (int row = 0; row < matrix.length; row++) {
            if (target < matrix[row][0]) {
                // we have searched all possible rows that the target could reside and didn't find it, so break
                break;
            }

            if (target <= matrix[row][width - 1]) {
                // target has a chance of being in this row
                for (int column = 0; column < width; column++) {
                    if (target == matrix[row][column]) {
                        return true;
                    }
                    else if (target < matrix[row][column]) {
                        return false;
                    }
                }
            }
        }

        return false;
    }
}