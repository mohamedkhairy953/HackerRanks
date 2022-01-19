package weghted_uniform;

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
     * Complete the 'weightedUniformStrings' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER_ARRAY queries
     */

    public static List<String> weightedUniformStrings(String s, List<Integer> queries) {
        // Write your code here

        List<Integer> ll = new ArrayList<>();
        ll.add((s.charAt(0) - 'a') + 1);
        StringBuilder lastSelected = new StringBuilder(s.charAt(0) + "");
        for (int i = 1; i < s.length(); i++) {
            int currentWeight = (s.charAt(i) - 'a') + 1;
            if (ll.get(i - 1) % currentWeight == 0 && lastSelected.toString().contains(s.charAt(i) + "")) {
                ll.add(ll.get(i - 1) + currentWeight);
            } else {
                ll.add(currentWeight);
                lastSelected.delete(0, lastSelected.length());
            }
            lastSelected.append(s.charAt(i));
        }

       List<Integer> ll1 = ll.stream().sorted().collect(toList());
        return queries.stream().map(q -> (binarySearch(ll1, 0, ll1.size() - 1, q)) ? "Yes" : "No").collect(toList());
    }

    static boolean binarySearch(List<Integer> arr, int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr.get(mid) == x)
                return true;
            if (arr.get(mid) > x)
                return binarySearch(arr, l, mid - 1, x);

            return binarySearch(arr, mid + 1, r, x);
        }
        return false;
    }

    static int getWeight(char[] cs) {
        int result = 0;
        for (char c : cs) {
            result += (c - 'a') + 1;
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<String> result = Result.weightedUniformStrings(s, queries);
        System.out.println(result.stream()
                .collect(joining("\n"))
                + "\n");
/*
        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );*/

        bufferedReader.close();
        // bufferedWriter.close();
    }
}
