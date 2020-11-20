/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

November 20, 2020
 */

class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        else if (nums.length == 1) {
            return nums[0] == target;
        }

        // since we're iterating over the array starting from index 0, we only want to begin evaluating whether or not
        // target is in nums (and short circuiting if we know it can't be) if we've encountered a value less than target
        boolean foundValLessThanTarget = false;
        boolean result = false;

        for (int num : nums) {
            if (num == target) {
                result = true;
                break;
            }
            else if (foundValLessThanTarget) {
                if (num > target) {
                    break;
                }
            }
            else {
                if (num < target) {
                    foundValLessThanTarget = true;
                }
            }
        }

        return result;
    }
}