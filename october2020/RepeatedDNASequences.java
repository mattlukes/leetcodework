/*
All DNA is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T', for example: "ACGAATTCCG". When
studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

October 17, 2020
 */

class Solution {
    public static List<String> findRepeatedDnaSequences(String s) {
        if (s == null
         || s.length() < 10) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();
        HashSet<String> encounteredDnaSequences = new HashSet<>();
        String dnaSequence;

        for (int i = 10; i <= s.length(); i++) {
            dnaSequence = s.substring(i - 10, i);
            if (!encounteredDnaSequences.add(dnaSequence)) {
                if (!result.contains(dnaSequence)) {
                    result.add(dnaSequence);
                }
            }
        }

        return result;
    }
}