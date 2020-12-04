/*
Given two positive integers n and k.

A factor of an integer n is defined as an integer i where n % i == 0.

Consider a list of all factors of n sorted in ascending order, return the kth factor in this list or return -1 if n has
less than k factors.

Constraints:

1 <= k <= n <= 1000

December 4, 2020
 */

class Solution {
    public int kthFactor(int n, int k) {
        int foundFactors = 0;
        int result = -1;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                foundFactors++;
                if (foundFactors == k) {
                    result = i;
                    break;
                }
            }
        }

        return result;
    }
}