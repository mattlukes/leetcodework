/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of
the non-overlapping intervals that cover all the intervals in the input.

November 18, 2020
 */

class Solution {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // First, sort the input list from lowest to highest interval start value
        List<int[]> intervalList = new ArrayList<>(Arrays.asList(intervals));
        intervalList.sort((o1, o2) -> {
            if (o1[0] < o2[0]) {
                return -1;
            } else if (o1[0] == o2[0]) {
                if (o1[1] < o2[1]) {
                    return -1;
                }
                else if (o1[1] == o2[1]) {
                    return 0;
                }
            }
            return 1;
        });

        List<int[]> condensedIntervalList = new ArrayList<>();
        condensedIntervalList = condenseIntervals(intervalList);

        List<int[]> condenseAgain = condenseIntervals(condensedIntervalList);

        // Repeatedly condense the intervals until we can't condense anymore
        while (condenseAgain.size() < condensedIntervalList.size()) {
            condensedIntervalList = condenseAgain;
            condenseAgain = condenseIntervals(condensedIntervalList);
        }

        int[][] result = new int[condensedIntervalList.size()][2];

        for (int index = 0; index < condensedIntervalList.size(); index++) {
            result[index] = condensedIntervalList.get(index);
        }

        return result;
    }

    private static List<int[]> condenseIntervals(List<int[]> intervalList) {
        List<int[]> condensedIntervalList = new ArrayList<>();
        int index = 1;
        int[] currInterval = intervalList.get(0);

        while (index < intervalList.size()) {
            if (currInterval[1] >= intervalList.get(index)[0]) {
                if (currInterval[1] < intervalList.get(index)[1]) {
                    currInterval[1] = intervalList.get(index)[1];
                    condensedIntervalList.add(currInterval);
                }
            }
            else {
                condensedIntervalList.add(currInterval);
                currInterval = intervalList.get(index);
            }

            index++;
        }

        if (condensedIntervalList.isEmpty()) {
            condensedIntervalList.add(currInterval);
        }
        else if (condensedIntervalList.get(condensedIntervalList.size() - 1)[1] < intervalList.get(intervalList.size() - 1)[1]) {
            currInterval[1] = Math.max(currInterval[1], intervalList.get(intervalList.size() - 1)[1]);
            condensedIntervalList.add(currInterval);
        }

        return condensedIntervalList;
    }
}