/*
Given a string s, find the length of the longest substring without repeating characters.

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

January 7, 2021
 */

class Solution {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int longestSubstring = 0;
        int currSubstringCount = 0;
        ArrayDeque<Character> charsInSubstringQueue = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char nextChar = s.charAt(i);
            if (charsInSubstringQueue.contains(nextChar)) {
                longestSubstring = Math.max(longestSubstring, currSubstringCount);

                // Continuously remove characters from the substring until the duplicate character has been removed
                char removedChar = charsInSubstringQueue.remove();
                while (removedChar != nextChar
                    && !charsInSubstringQueue.isEmpty()) {
                    removedChar = charsInSubstringQueue.remove();
                }

                currSubstringCount = charsInSubstringQueue.size();
            }

            charsInSubstringQueue.add(nextChar);
            currSubstringCount++;
        }

        // One last check for either an input with entirely unique characters or the ending substring of the input
        // string is the longest one
        return Math.max(longestSubstring, currSubstringCount);
    }
}