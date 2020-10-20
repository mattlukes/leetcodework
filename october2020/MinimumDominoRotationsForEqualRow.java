/*
In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the ith domino.  (A domino is a tile with
two numbers from 1 to 6 - one on each half of the tile.)

We may rotate the ith domino, so that A[i] and B[i] swap values.

Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.

If it cannot be done, return -1.

October 19, 2020
 */

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int[] valCountA = new int[7];
        int[] valCountB = new int[7];

        for (int i = 0; i < A.length; i++) {
            valCountA[A[i]]++;
            valCountB[B[i]]++;
        }

        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= 6; i++) {
            boolean validSolution = true;
            int rotations = 0;
            if (valCountA[i] + valCountB[i] >= A.length) {
                for (int j = 0; j < A.length; j++) {
                    if (valCountA[i] > valCountB[i]) {
                        if (A[j] == i) {
                            continue;
                        }
                        else if (B[j] == i) {
                            rotations++;
                        }
                        else {
                            validSolution = false;
                            break;
                        }
                    }
                    else {
                        if (B[j] == i) {
                            continue;
                        }
                        else if (A[j] == i) {
                            rotations++;
                        }
                        else {
                            validSolution = false;
                            break;
                        }
                    }
                }

                if (validSolution) {
                    result = Math.min(result, rotations);
                }
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}