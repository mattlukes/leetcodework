/*
Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search
target in nums. If target exists, then return its index, otherwise return -1.

October 8, 2020
 */

class Solution {
    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        else if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        return binarySearch(nums, target, 0);
    }

    private static int binarySearch(int[] nums, int target, int offset) {
        int result = -1;
        if (nums.length == 1) {
            if (nums[0] == target) {
                return offset;
            }
            else {
                return -1;
            }
        }
        else {
            int midIndex = nums.length / 2;
            if (nums[midIndex] == target) {
                return midIndex + offset;
            }
            else if (nums[midIndex] < target) {
                offset += midIndex;
                result = binarySearch(Arrays.copyOfRange(nums, midIndex, nums.length), target, offset);
            }
            else {
                result = binarySearch(Arrays.copyOfRange(nums, 0, midIndex), target, offset);
            }
        }

        return result;
    }
}