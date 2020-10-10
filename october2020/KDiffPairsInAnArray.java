/*
Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.

A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:

0 <= i, j < nums.length
i != j
|nums[i] - nums[j]| == k
Notice that |val| denotes the absolute value of val.

October 3, 2020
 */

class Solution {
    public static int findPairs(int[] nums, int k) {
        int result = 0;
        HashSet<Integer> numsFound = new HashSet<>();
        HashSet<Integer> lookingFor = new HashSet<>();

        for (int num : nums) {
            if (k != 0) {
                if (!numsFound.contains(num)) {
                    if (numsFound.contains(num - k)) {
                        result++;
                    }
                    if (lookingFor.contains(num)) {
                        result++;
                    }

                    lookingFor.add(num - k);
                    numsFound.add(num);
                }
            }
            else {
                if (!numsFound.contains(num)) {
                    numsFound.add(num);
                }
                else if (!lookingFor.contains(num)) {
                    lookingFor.add(num);
                    result++;
                }
            }
        }

        return result;
    }
}