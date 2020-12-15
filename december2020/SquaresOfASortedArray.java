/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.

December 15, 2020
 */

class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = (int)Math.pow(nums[i], 2);
        }

        Arrays.sort(result);
        return result;
    }
}