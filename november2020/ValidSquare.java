/*
Given the coordinates of four points in 2D space, return whether the four points could construct a square.

The coordinate (x,y) of a point is represented by an integer array with two integers.

November 11, 2020
 */

class Solution {
    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        boolean result = false;
        double p1p2dist = distBetweenTwoPoints(p1[0], p1[1], p2[0], p2[1]);
        double p1p3dist = distBetweenTwoPoints(p1[0], p1[1], p3[0], p3[1]);
        double p1p4dist = distBetweenTwoPoints(p1[0], p1[1], p4[0], p4[1]);
        double p2p4dist = distBetweenTwoPoints(p2[0], p2[1], p4[0], p4[1]);
        double p3p4dist = distBetweenTwoPoints(p3[0], p3[1], p4[0], p4[1]);
        double p2p3dist = distBetweenTwoPoints(p2[0], p2[1], p3[0], p3[1]);

        if (p1p2dist == p1p3dist) {
            if (validateSquare(p1p2dist, p1p3dist, p2p4dist, p3p4dist, p1p4dist, p2p3dist)) {
                result = true;
            }
        }
        else if (p1p2dist == p1p4dist) {
            if (validateSquare(p1p2dist, p1p4dist, p2p3dist, p3p4dist, p1p3dist, p2p4dist)) {
                result = true;
            }
        }
        else if (p1p3dist == p1p4dist) {
            if (validateSquare(p1p3dist, p1p4dist, p2p3dist, p2p4dist, p1p2dist, p3p4dist)) {
                result = true;
            }
        }

        return result;
    }

    private static double distBetweenTwoPoints(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private static boolean validateSquare(double side1, double side2, double side3, double side4, double diag1, double diag2) {
        return side1 == side2
            && side1 == side3
            && side1 == side4
            && side2 == side3
            && side2 == side4
            && side3 == side4
            && diag1 == diag2
            && diag1 != 0.0;
    }
}