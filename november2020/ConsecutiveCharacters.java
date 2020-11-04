/*
Given a string s, the power of the string is the maximum length of a non-empty substring that contains only one unique
character.

Return the power of the string.

November 3, 2020
 */

class Solution {
    public int maxPower(String s) {
        if (s.length() == 1) {
            return 1;
        }

        int result = 1;
        int currCount = 1;
        char lastChar = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == lastChar) {
                currCount++;
                result = Math.max(result, currCount);
            }
            else {
                lastChar = s.charAt(i);
                currCount = 1;
            }
        }

        return result;
    }
}