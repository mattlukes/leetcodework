/*
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

Constraints:

1 <= n <= 20

December 7, 2020
 */

class Solution {
    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        if (n == 1) {
            result[0][0] = 1;
            return result;
        }

        int num = 1;
        int nums = n * n;

        // Create matrix bounds that periodically shrink to limit what index we are assigning the next number to
        int minColumn = 0;
        int maxColumn = n - 1;
        int columnIndex = 0;

        int minRow = 0;
        int maxRow = n - 1;
        int rowIndex = 0;

        while (num <= nums) {
            if (columnIndex == minColumn) {
                // There are two cases we must consider when columnIndex is minColumn
                if (rowIndex == maxRow) {
                    // If rowIndex is maxRow, that means we are moving up in the spiral
                    for (int i = maxRow; i >= minRow; i--) {
                        result[i][columnIndex] = num;
                        num++;
                    }

                    rowIndex = minRow;
                    minColumn++;
                    columnIndex++;
                }
                else {
                    // Otherwise, we're moving to the right
                    for (int i = minColumn; i <= maxColumn; i++) {
                        result[rowIndex][i] = num;
                        num++;
                    }

                    columnIndex = maxColumn;
                    minRow++;
                    rowIndex++;
                }
            }
            else if (rowIndex == minRow) {
                // If the rowIndex is minRow, then we're moving down the spiral
                for (int i = minRow; i <= maxRow; i++) {
                    result[i][columnIndex] = num;
                    num++;
                }

                rowIndex = maxRow;
                maxColumn--;
                columnIndex--;
            }
            else if (columnIndex == maxColumn) {
                // If the columnIndex is maxColumn, that means we're moving left
                for (int i = maxColumn; i >= minColumn; i--) {
                    result[rowIndex][i] = num;
                    num++;
                }

                columnIndex = minColumn;
                maxRow--;
                rowIndex--;
            }

        }

        return result;
    }
}