/*
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations
of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the
given input.

October 2, 2020
 */

class Solution {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();

        for (int candidate : candidates) {
            List<Integer> combination = new ArrayList<>();
            combination.add(candidate);
            if (candidate == target) {
                combinations.add(combination);
            }
            else {
                findCombination(candidates, target, combination, candidate, combinations);
            }
        }

        return combinations;
    }

    private static void findCombination(int[] candidates, int target, List<Integer> combination, int currComboSum, List<List<Integer>> combinations) {
        for (int candidate : candidates) {
            if ((currComboSum + candidate) < target) {
                combination.add(candidate);
                findCombination(candidates, target, new ArrayList<>(combination), currComboSum + candidate, combinations);
                combination.remove(Integer.valueOf(candidate));
            }
            else if ((currComboSum + candidate) == target) {
                combination.add(candidate);
                boolean combinationAlreadyExists = false;
                for (List<Integer> confirmedCombination : combinations) {
                    if (combinationsAreEqual(confirmedCombination, combination)) {
                        combinationAlreadyExists = true;
                        break;
                    }
                }


                if (!combinationAlreadyExists) {
                    combinations.add(new ArrayList<>(combination));
                }

                combination.remove(Integer.valueOf(candidate));
            }
        }
    }

    private static boolean combinationsAreEqual(List<Integer> l1, List<Integer> l2) {
        List<Integer> temp = new ArrayList<>(l1);

        for (Integer integer : l2) {
            temp.remove(integer);
        }

        if (!temp.isEmpty()) {
            return false;
        }

        temp = new ArrayList<>(l2);

        for (Integer integer : l1) {
            temp.remove(integer);
        }

        if (!temp.isEmpty()) {
            return false;
        }

        return true;
    }
}