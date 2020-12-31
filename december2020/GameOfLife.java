/*
According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the
British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead
(represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births
and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 25
board[i][j] is 0 or 1.

December 30, 2020
 */

class Solution {
    public static void gameOfLife(int[][] board) {
        int rowSize = board.length;
        int columnSize = board[0].length;

        int[][] newBoard = new int[rowSize][columnSize];
        int newCellVal;

        if (rowSize == 1
         && columnSize == 1) {
            newBoard[0][0] = 0;
        }
        else {
            for (int row = 0; row < rowSize; row++) {
                for (int column = 0; column < columnSize; column++) {
                    newCellVal = analyzeCell(board, row, column, rowSize, columnSize);
                    newBoard[row][column] = newCellVal;
                }
            }
        }

        for (int row = 0; row < rowSize; row++) {
            for (int column = 0; column < columnSize; column++) {
                board[row][column] = newBoard[row][column];
            }
        }
    }

    private static int analyzeCell(int[][] board, int row, int column, int rowSize, int columnSize) {
        boolean liveCell = board[row][column] == 1;
        int liveNeighbors = 0;
        int newCellValue = 0;

        boolean rowIsBigEnough = row > 0;
        boolean rowIsSmallEnough = row < rowSize - 1;
        boolean columnIsBigEnough = column > 0;
        boolean columnIsSmallEnough = column < columnSize - 1;

        // Inspect all 8 of the current cell's possible neighbors
        if (rowIsBigEnough) {
            if (columnIsBigEnough) {
                liveNeighbors += board[row - 1][column - 1];
            }

            liveNeighbors += board[row - 1][column];

            if (columnIsSmallEnough) {
                liveNeighbors += board[row - 1][column + 1];
            }
        }

        if (columnIsBigEnough) {
            liveNeighbors += board[row][column - 1];
        }

        if (columnIsSmallEnough) {
            liveNeighbors += board[row][column + 1];
        }

        if (rowIsSmallEnough) {
            if (columnIsBigEnough) {
                liveNeighbors += board[row + 1][column - 1];
            }

            liveNeighbors += board[row + 1][column];

            if (columnIsSmallEnough) {
                liveNeighbors += board[row + 1][column + 1];
            }
        }

        if (liveCell) {
            if (liveNeighbors == 2
             || liveNeighbors == 3) {
                newCellValue = 1;
            }
        }
        else if (liveNeighbors == 3) {
            newCellValue = 1;
        }

        return newCellValue;
    }
}