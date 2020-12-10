/*
Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < A[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

Constraints:

1 <= arr.length <= 104
0 <= arr[i] <= 104

December 10, 2020
 */

class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length <= 1) {
            return false;
        }
        else if (arr[1] < arr[0]) {
            // Quick short circuit to see if the mountain starts with a descent, making it invalid
            return false;
        }

        boolean validMountain = true;
        boolean peakFound = false;

        for (int index = 1; index < arr.length; index++) {
            if (arr[index] == arr[index - 1]) {
                // A valid mountain has no plateaus
                validMountain = false;
                break;
            }
            else if (arr[index] < arr[index - 1]) {
                // If the current height is less than the previous height then we've crossed the peak
                peakFound = true;
            }
            else if (peakFound) {
                // In this scenario we've already found the peak but the current height is greater than the previous
                // height so it isn't a valid mountain
                validMountain = false;
                break;
            }
        }

        return validMountain && peakFound;
    }
}