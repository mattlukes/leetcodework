/*
Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and
nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1

December 18, 2020
 */

class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length <= 2) {
            return false;
        }

        boolean result = false;
        int index = 1;
        int minVal = nums[0];

        while (index < nums.length) {
            if (nums[index] > minVal) {
                // We've satisfied our first requirement of increasing values in nums - now search for another such
                // increase in the rest of nums
                result = findSecondIncrease(Arrays.copyOfRange(nums, index, nums.length), nums[index]);

                // If we've found a second increase, we're done. Otherwise, continue looking for smaller values in nums
                // that may satisfy the requirements
                if (result) {
                    break;
                }
            }
            else {
                minVal = Math.min(minVal, nums[index]);
            }

            index++;
        }

        return result;
    }

    private boolean findSecondIncrease(int[] nums, int minVal) {
        boolean result = false;
        for (int num : nums) {
            if (num > minVal) {
                result = true;
                break;
            }
        }

        return result;
    }
}