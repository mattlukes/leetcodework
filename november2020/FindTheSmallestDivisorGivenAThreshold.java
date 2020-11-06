/*
Given an array of integers nums and an integer threshold, we will choose a positive integer divisor and divide all the
array by it and sum the result of the division. Find the smallest divisor such that the result mentioned above is less
than or equal to threshold.

Each result of division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3
and 10/2 = 5).

It is guaranteed that there will be an answer.

November 6, 2020
 */

class Solution {
    public static int smallestDivisor(int[] nums, int threshold) {
        if (nums.length == 1) {
            return (int)Math.ceil((double)nums[0] / (double)threshold);
        }

        int rangeMax = 0;

        for (int num : nums) {
            rangeMax = Math.max(rangeMax, num);
        }

        int rangeMin = 1;
        int divisor = (rangeMax / 2) + 1;
        int smallestDivisor = Integer.MAX_VALUE;

        while (true) {
            if (rangeMin >= rangeMax
             || smallestDivisor == divisor) {
                break;
            }

            int currSum = 0;
            boolean validDivisorFound = true;

            for (int num : nums) {
                currSum += Math.ceil((double)num / (double)divisor);

                if (currSum > threshold) {
                    validDivisorFound = false;
                    break;
                }
            }

            if (validDivisorFound) {
                smallestDivisor = Math.min(smallestDivisor, divisor);
                rangeMax = divisor;
            }
            else {
                if (rangeMin == divisor) {
                    break;
                }
                rangeMin = divisor;
            }

            divisor = ((rangeMax - rangeMin) / 2) + rangeMin;
        }

        return smallestDivisor;
    }
}