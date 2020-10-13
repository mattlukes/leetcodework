/*
Given two strings A and B of lowercase letters, return true if you can swap two letters in A so the result is equal to
B, otherwise, return false.

Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at
A[i] and A[j]. For example, swapping at indices 0 and 2 in "abcd" results in "cbad".

October 12, 2020
 */

class Solution {
    public static boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        else if (A.length() <= 1) {
            return false;
        }

        int firstMismatchedIndex = -1;
        int secondMismatchedIndex = -1;

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                if (firstMismatchedIndex < 0) {
                    firstMismatchedIndex = i;
                }
                else if (secondMismatchedIndex < 0) {
                    secondMismatchedIndex = i;
                    if (A.charAt(firstMismatchedIndex) != B.charAt(secondMismatchedIndex)
                            || A.charAt(secondMismatchedIndex) != B.charAt(firstMismatchedIndex)) {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
        }

        if (firstMismatchedIndex >= 0) {
            return secondMismatchedIndex >= 0;
        }

        HashSet<Character> charsInString = new HashSet<>();

        for (int i = 0; i < A.length(); i++) {
            if (!charsInString.add(A.charAt(i))) {
                return true;
            }
        }

        return false;
    }
}