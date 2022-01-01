package queen_attack;


import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Pair{
    private int r;
    private int c;

    Pair(int r, int c){

        this.r = r;
        this.c = c;
    }
}
class Result {

    /*
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     */

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        // Write your code here
        Map<String, Pair> obstaclesMap = toMap(obstacles);
        if (n == 1) return 0;
        return leftAttacks(r_q, c_q, obstacles) +
                rightAttacks(n, r_q, c_q, obstacles) +
                topAttacks(r_q, c_q, obstacles) +
                bottomAttacks(n, r_q, c_q, obstacles) +
                topLeftAttacks(n, r_q, c_q, obstaclesMap) +
                topRightAttacks(n, r_q, c_q, obstaclesMap) +
                bottomLeftAttacks(n, r_q, c_q, obstaclesMap) +
                bottomRightAttacks(n, r_q, c_q, obstaclesMap);
    }

    private static Map<String, Pair> toMap(List<List<Integer>> obstacles) {
        Map<String, Pair> result = new HashMap<>();
        for (List<Integer> obstacle : obstacles) {
            String key = obstacle.get(0) + "" + obstacle.get(1);
            result.put(key, new Pair(obstacle.get(0), obstacle.get(1)));
        }
        return result;
    }

    private static int bottomRightAttacks(int n, int r_q, int c_q, Map<String, Pair> obstacles) {
        int result = 0;
        if (r_q < n && c_q < n)
            while (r_q <= n && c_q <= n) {
                int nr_q = r_q + 1;
                int nc_q = c_q + 1;
                if (nc_q > n || nr_q > n) break;
                if (!obstacles.containsKey(nr_q + "" + nc_q)) {
                    result++;
                } else {
                    break;
                }
                r_q = nr_q;
                c_q = nc_q;
            }
        return result;
    }

    private static int bottomLeftAttacks(int n, int r_q, int c_q, Map<String, Pair> obstacles) {
        int result = 0;
        if (r_q < n)
            while (r_q <= n && c_q >= 1) {
                int nr_q = r_q + 1;
                int nc_q = c_q - 1;
                if (nr_q > n) break;
                if (nc_q < 1) break;
                if (!obstacles.containsKey(nr_q + "" + nc_q)) {
                    result++;

                } else {
                    break;
                }
                r_q = nr_q;
                c_q = nc_q;
            }

        return result;
    }

    private static int topRightAttacks(int n, int r_q, int c_q, Map<String, Pair> obstacles) {
        int result = 0;
        if (c_q < n)
            while (r_q >= 1 && c_q <= n) {
                int nr_q = r_q - 1;
                int nc_q = c_q + 1;
                if (nc_q > n) break;
                if (nr_q < 1) break;

                if (!obstacles.containsKey(nr_q + "" + nc_q)) {
                    result++;

                } else {
                    break;
                }
                r_q = nr_q;
                c_q = nc_q;
            }

        return result;
    }

    private static int topLeftAttacks(int n, int r_q, int c_q, Map<String, Pair> obstacles) {
        int result = 0;
        if (r_q > 1 && c_q > 1)
            while (r_q > 1 && c_q > 1) {
                int nr_q = r_q - 1;
                int nc_q = c_q - 1;
                if (!obstacles.containsKey(nr_q + "" + nc_q)) {
                    result++;
                } else {
                    break;
                }
                r_q = nr_q;
                c_q = nc_q;
            }

        return result;
    }


    private static int bottomAttacks(int n, int r_q, int c_q, List<List<Integer>> obstacles) {
        int firstObstacle = Integer.MAX_VALUE;
        for (List<Integer> obstacle : obstacles) {
            if (obstacle.get(1) == c_q && obstacle.get(0) > r_q) {
                if (obstacle.get(0) < firstObstacle)
                    firstObstacle = obstacle.get(0);
            }

        }
        int result;
        if (firstObstacle == Integer.MAX_VALUE) {
            result = n - r_q;
        } else {
            result = firstObstacle - r_q - 1;
        }

        return result;
    }

    private static int topAttacks(int r_q, int c_q, List<List<Integer>> obstacles) {
        int firstObstacle = Integer.MIN_VALUE;
        for (List<Integer> obstacle : obstacles) {
            if (obstacle.get(1) == c_q && obstacle.get(0) < r_q) {
                if (obstacle.get(0) > firstObstacle)
                    firstObstacle = obstacle.get(0);
            }
        }

        int result;
        if (firstObstacle == Integer.MIN_VALUE) {
            result = r_q - 1;
        } else {
            result = r_q - firstObstacle - 1;
        }

        return result;
    }

    private static int rightAttacks(int n, int r_q, int c_q, List<List<Integer>> obstacles) {
        int firstObstacle = Integer.MAX_VALUE;
        for (List<Integer> obstacle : obstacles) {
            if (obstacle.get(0) == r_q && obstacle.get(1) > c_q) {
                if (obstacle.get(1) < firstObstacle)
                    firstObstacle = obstacle.get(1);
            }

        }

        int result;
        if (firstObstacle == Integer.MAX_VALUE) {
            result = n - c_q;
        } else {
            result = firstObstacle - c_q - 1;
        }

        return result;
    }

    private static int leftAttacks(int r_q, int c_q, List<List<Integer>> obstacles) {
        int firstObstacle = Integer.MIN_VALUE;
        for (List<Integer> obstacle : obstacles) {
            if (obstacle.get(0) == r_q && obstacle.get(1) < c_q) {
                if (obstacle.get(1) > firstObstacle)
                    firstObstacle = obstacle.get(1);
            }
        }

        int result;
        if (firstObstacle == Integer.MIN_VALUE) {
            result = c_q - 1;
        } else {
            result = c_q - firstObstacle - 1;
        }

        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r_q = Integer.parseInt(secondMultipleInput[0]);

        int c_q = Integer.parseInt(secondMultipleInput[1]);

        List<List<Integer>> obstacles = new ArrayList<>();

        IntStream.range(0, k).forEach(i -> {
            try {
                obstacles.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.queensAttack(n, k, r_q, c_q, obstacles);
        System.out.println(
                result
        );
        bufferedReader.close();
    }
}