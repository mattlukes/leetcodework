/*
We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning
right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both
are the same size, both will explode. Two asteroids moving in the same direction will never meet.

October 21, 2020
 */

class Solution {
    public static int[] asteroidCollision(int[] asteroids) {
        if (asteroids.length <= 1) {
            return asteroids;
        }

        List<Integer> asteroidList = new ArrayList<>();
        int i = 0;

        for (i = 0; i < asteroids.length; i++) {
            asteroidList.add(asteroids[i]);
        }

        boolean asteroidDestroyed = true;

        while (asteroidDestroyed) {
            asteroidDestroyed = resolveCollisions(asteroidList);
        }

        if (asteroidList.isEmpty()) {
            return new int[0];
        }

        int[] result = new int[asteroidList.size()];

        for (i = 0; i < asteroidList.size(); i++) {
            result[i] = asteroidList.get(i);
        }

        return result;
    }

    private static boolean resolveCollisions(List<Integer> asteroids) {
        boolean asteroidDestroyed = false;
        int index = 0;

        while (index < asteroids.size() - 1) {
            if (asteroids.get(index) > 0) {
                if (asteroids.get(index + 1) < 0) {
                    int destroyedAsteroidIndex;
                    if (Math.abs(asteroids.get(index)) == Math.abs(asteroids.get(index + 1))) {
                        destroyedAsteroidIndex = index;
                        asteroids.remove(destroyedAsteroidIndex);
                        asteroids.remove(destroyedAsteroidIndex);
                    }
                    else {
                        if (Math.abs(asteroids.get(index)) > Math.abs(asteroids.get(index + 1))) {
                            destroyedAsteroidIndex = index + 1;
                        }
                        else {
                            destroyedAsteroidIndex = index;
                        }

                        asteroids.remove(destroyedAsteroidIndex);
                    }

                    asteroidDestroyed = true;
                    break;
                }
            }

            index++;
        }

        return asteroidDestroyed;
    }
}