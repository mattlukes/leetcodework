/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly
k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat
numbers, k. For example, there won't be input like 3a or 2[4].

Constraints:

1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].

November 19, 2020
 */

class Solution {
    public static String decodeString(String s) {
        if (s.length() <= 1) {
            return s;
        }

        return decodeSubstring(s);
    }

    private static String decodeSubstring(String s) {
        StringBuilder result = new StringBuilder();
        int index = 0;

        while (index < s.length()) {
            // done processing this substring
            if (s.charAt(index) == ']') {
                break;
            }
            // all alphabetical characters have higher ascii values than numerical characters, so we just need this comp
            // we also don't need to worry about hitting a [ here because we are guaranteed to hit a number first
            else if (s.charAt(index) > '9') {
                result.append(s.charAt(index));
                index++;
            }
            else {
                StringBuilder multiplierBuffer = new StringBuilder();
                while (s.charAt(index) != '[') {
                    multiplierBuffer.append(s.charAt(index));
                    index++;
                }

                // pass over the [
                index++;
                int multiplier = Integer.parseInt(multiplierBuffer.toString());

                int lengthOfSubstring = findLengthOfSubstring(s, index);
                String decodedSubstring = decodeSubstring(s.substring(index));

                while (multiplier > 0) {
                    result.append(decodedSubstring);
                    multiplier--;
                }

                // skip over the length of the recently decoded substring
                index += lengthOfSubstring;
            }
        }

        return result.toString();
    }

    private static int findLengthOfSubstring(String s, int index) {
        int lengthOfSubstring = 0;
        int braceMatch = 1;

        while (index < s.length()
                && braceMatch > 0) {
            if (s.charAt(index) == ']') {
                braceMatch--;
            }
            else if (s.charAt(index) == '[') {
                braceMatch++;
            }

            index++;
            lengthOfSubstring++;
        }

        return lengthOfSubstring;
    }
}