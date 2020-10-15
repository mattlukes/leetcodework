/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two
adjacent houses were broken into on the same night.

Given a list of non-negative integers nums representing the amount of money of each house, return the maximum amount of
money you can rob tonight without alerting the police.

October 14, 2020
 */

class Solution {
    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] highestTotal = new int[nums.length];
        highestTotal[0] = nums[0];
        highestTotal[1] = Math.max(nums[0], nums[1]);
        int result = highestTotal[1];

        // Loop through all houses except the last house
        for (int i = 2; i < nums.length - 1; i++) {
            highestTotal[i] = Math.max(highestTotal[i - 1], highestTotal[i - 2] + nums[i]);
            result = highestTotal[i];
        }

        highestTotal[0] = nums[1];
        highestTotal[1] = Math.max(nums[1], nums[2]);

        // Loop through all houses except the first house
        for (int i = 2; i < nums.length - 1; i++) {
            highestTotal[i] = Math.max(highestTotal[i - 1], highestTotal[i - 2] + nums[i + 1]);
        }

        // Once i == nums.length - 1, we break the above loop, so the highest val after the 2nd loop is at
        // index nums.length - 2
        return Math.max(result, highestTotal[highestTotal.length - 2]);
    }
}