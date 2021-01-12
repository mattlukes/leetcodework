/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume that nums1 has enough
space (size that is equal to m + n) to hold additional elements from nums2.

Constraints:

0 <= n, m <= 200
1 <= n + m <= 200
nums1.length == m + n
nums2.length == n
-109 <= nums1[i], nums2[i] <= 109

January 11, 2021
 */

class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }

        int[] newNums = new int[m + n];
        int newNumsIndex = 0;
        int nums1Index = 0;
        int nums2Index = 0;

        while (newNumsIndex < newNums.length) {
            if (nums2Index < n) {
                if (nums1Index < m
                 && nums1[nums1Index] <= nums2[nums2Index]) {
                    newNums[newNumsIndex] = nums1[nums1Index];
                    nums1Index++;
                }
                else {
                    newNums[newNumsIndex] = nums2[nums2Index];
                    nums2Index++;
                }
            }
            else {
                newNums[newNumsIndex] = nums1[nums1Index];
                nums1Index++;
            }

            newNumsIndex++;
        }

        for (int i = 0; i < newNums.length; i++) {
            nums1[i] = newNums[i];
        }
    }
}