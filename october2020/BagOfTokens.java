/*
You have an initial power of P, an initial score of 0, and a bag of tokens where tokens[i] is the value of the ith
token (0-indexed).

Your goal is to maximize your total score by potentially playing each token in one of two ways:

If your current power is at least tokens[i], you may play the ith token face up, losing tokens[i] power and gaining 1
score.
If your current score is at least 1, you may play the ith token face down, gaining tokens[i] power and losing 1 score.
Each token may be played at most once and in any order. You do not have to play all the tokens.

Return the largest possible score you can achieve after playing any number of tokens.

October 24, 2020
 */

class Solution {
    public static int bagOfTokensScore(int[] tokens, int P) {
        if (tokens.length == 0) {
            return 0;
        }
        else if (tokens.length == 1) {
            return tokens[0] <= P ? 1 : 0;
        }

        int currPower = P;
        List<Integer> tokensList = new ArrayList<>();

        for (int token : tokens) {
            tokensList.add(token);
        }

        Collections.sort(tokensList);
        int currScore = 0;
        int maxScore = 0;

        while (!tokensList.isEmpty()) {
            if (tokensList.get(0) <= currPower) {
                currPower -= tokensList.get(0);
                tokensList.remove(0);
                currScore++;
                maxScore = Math.max(maxScore, currScore);
            }
            else if (currScore > 0) {
                currPower += tokensList.get(tokensList.size() - 1);
                tokensList.remove(tokensList.size() - 1);
                currScore--;
            }
            else {
                break;
            }
        }

        return maxScore;
    }
}