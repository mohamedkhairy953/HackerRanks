package beautifull_set;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'beautifulPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY A
     *  2. INTEGER_ARRAY B
     */

    public static int beautifulPairs(List<Integer> A, List<Integer> B) {
        // Write your code here
        Map<Integer, Integer> am = new HashMap<>();
        Map<Integer, Integer> bm = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            if (am.containsKey(A.get(i))) {
                am.put(A.get(i), am.get(A.get(i)) + 1);
            } else {
                am.put(A.get(i), 1);
            }
            // Bm
            if (bm.containsKey(B.get(i))) {
                bm.put(B.get(i), bm.get(B.get(i)) + 1);
            } else {
                bm.put(B.get(i), 1);
            }
        }

        int result = 0;

        for (Integer integer : A) {
            if (bm.containsKey(integer)) {
                result += Math.min(bm.get(integer), am.get(integer));
                am.put(integer,0);
            }
        }
        if (result < A.size())
            return result + 1;
        else
            return 0;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.beautifulPairs(A, B);

        System.out.println(result);
        bufferedReader.close();
    }
}
