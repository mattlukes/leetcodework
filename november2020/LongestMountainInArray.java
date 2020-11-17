/*
Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:

B.length >= 3
There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
(Note that B could be any subarray of A, including the entire array A.)

Given an array A of integers, return the length of the longest mountain.

Return 0 if there is no mountain.

November 16, 2020
 */

class Solution {
    public static int longestMountain(int[] A) {
        if (A.length <= 2) {
            return 0;
        }

        int mountainStartIndex = 0;
        boolean potentialMountainFound = false;
        int mountainEndIndex = -1;
        int longestMountainLength = 0;
        int index = 1;

        while (index < A.length) {
            // If we haven't set a peak yet we know we're still climbing
            if (!potentialMountainFound) {
                if (A[index] <= A[index - 1]) {
                    mountainStartIndex = index;
                }
                else {
                    potentialMountainFound = true;
                }
            }
            else {
                // We have set a peak so now we're looking for a valid descent
                if (A[index] < A[index - 1]) {
                    mountainEndIndex = index;
                }
                else if (A[index] == A[index - 1]) {
                    // If two consecutive peaks are equal, we must reset the mountain
                    if (mountainEndIndex != -1) {
                        // The descent is over, so calculate if the mountain we just finished was the longest one
                        longestMountainLength = Math.max(longestMountainLength, mountainEndIndex - mountainStartIndex + 1);
                    }

                    // Reset the end index to a sentinel and put the start of the next mountain here
                    mountainStartIndex = index;
                    potentialMountainFound = false;
                    mountainEndIndex = -1;
                }
                else {
                    // When the n + 1 height is higher than the n height we could still be climbing the mountain, so
                    // only do our end calculations if we've established an end to that mountain already
                    if (mountainEndIndex != -1) {
                        // The descent is over, so calculate if the mountain we just finished was the longest one
                        longestMountainLength = Math.max(longestMountainLength, mountainEndIndex - mountainStartIndex + 1);

                        // Reset the end index to sentinel and put the start of the next mountain at the previous index
                        mountainStartIndex = index - 1;
                        potentialMountainFound = true;
                        mountainEndIndex = -1;
                    }
                }
            }

            index++;
        }

        // The input array may have finished on a valid mountain, so run one more check to see if we have a valid mountain
        if (mountainEndIndex != -1) {
            longestMountainLength = Math.max(longestMountainLength, mountainEndIndex - mountainStartIndex + 1);
        }
        else if (A[index - 1] < A[index - 2] && potentialMountainFound) {
            mountainEndIndex = index - 1;
            longestMountainLength = Math.max(longestMountainLength, mountainEndIndex - mountainStartIndex + 1);
        }

        return longestMountainLength;
    }
}