/*
Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.

A string is represented by an array if the array elements concatenated in order forms the string.

Constraints:

1 <= word1.length, word2.length <= 103
1 <= word1[i].length, word2[i].length <= 103
1 <= sum(word1[i].length), sum(word2[i].length) <= 103
word1[i] and word2[i] consist of lowercase letters.

January 8, 2021
 */

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder word1Builder = new StringBuilder();
        StringBuilder word2Builder = new StringBuilder();

        for (String s : word1) {
            word1Builder.append(s);
        }

        for (String s : word2) {
            word2Builder.append(s);
        }

        return word1Builder.toString().equals(word2Builder.toString());
    }
}