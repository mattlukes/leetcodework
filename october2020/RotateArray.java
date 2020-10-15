/*
Given an array, rotate the array to the right by k steps, where k is non-negative.

October 15, 2020
 */

class Solution {
    public static void rotate(int[] nums, int k) {
        if (nums.length <= 1
                || k == 0) {
            return;
        }

        int[] numsCopy = new int[nums.length];
        for (int i = 0; i < numsCopy.length; i++) {
            numsCopy[i] = nums[i];
        }

        int index;

        for (int i = 0; i < numsCopy.length; i++) {
            index = (i + k) % nums.length;
            nums[index] = numsCopy[i];
        }
    }
}