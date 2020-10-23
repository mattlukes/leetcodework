/*
Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such
that i < j < k and nums[i] < nums[k] < nums[j].

Return true if there is a 132 pattern in nums, otherwise, return false.

October 23, 2020
 */

class Solution {
    public static boolean find132pattern(int[] nums) {
        if (nums.length <= 2) {
            return false;
        }

        int[] numsCopy = Arrays.copyOf(nums, nums.length);
        int earliestValIncreaseIndex = 0;

        while (numsCopy.length > 2) {
            int minVal = numsCopy[0];
            for (int i = 1; i < numsCopy.length; i++) {
                minVal = Math.min(numsCopy[i], minVal);
                if (numsCopy[i] > minVal + 1) {
                    earliestValIncreaseIndex = i;
                    break;
                }
            }

            if (earliestValIncreaseIndex == 0) {
                break;
            }

            int maxVal = numsCopy[earliestValIncreaseIndex];
            for (int i = earliestValIncreaseIndex; i < numsCopy.length - 1; i++) {
                maxVal = Math.max(numsCopy[i], maxVal);
                if (maxVal > numsCopy[i + 1]
                 && numsCopy[i + 1] > minVal) {
                    return true;
                }
            }

            numsCopy = Arrays.copyOfRange(numsCopy, earliestValIncreaseIndex, numsCopy.length);
            earliestValIncreaseIndex = 0;
        }

        return false;
    }
}