/*
You are given a list of songs where the ith song has a duration of time[i] seconds.

Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, we want the
number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.

Constraints:

1 <= time.length <= 6 * 104
1 <= time[i] <= 500

December 8, 2020
 */

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        if (time.length <= 1) {
            return 0;
        }

        int validPairs = 0;
        int[] lengthComplements = new int[61];

        for (int i = 0; i < time.length; i++) {
            if (time[i] % 60 == 0) {
                validPairs += lengthComplements[60];
                lengthComplements[60]++;
            }
            else {
                int complement = time[i] % 60;
                validPairs += lengthComplements[60 - complement];
                lengthComplements[complement]++;
            }
        }

        return validPairs;
    }
}