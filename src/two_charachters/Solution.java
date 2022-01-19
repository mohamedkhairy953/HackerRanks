package two_charachters;

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
     * Complete the 'alternate' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int alternate(String s) {
        // Write your code here
        char[] ss = s.toCharArray();
        List<Integer> lengths = new ArrayList<>();
        List<Character> sArr = new ArrayList<>();
        for (char c : ss) {
            sArr.add(c);
        }
        TreeSet set = new TreeSet(sArr);
        ArrayList<Character> list = new ArrayList<>(set);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 1; j < list.size(); j++) {
                int finalI = i;
                int finalJ = j;
                if (list.get(finalI) == list.get(finalJ)) continue;
                List<Character> temp = sArr.stream().filter((it -> it == list.get(finalI)
                        || it == list.get(finalJ)))
                        .collect(Collectors.toList());

                if (isValid(temp)) {
                    lengths.add(temp.size());
                }
            }
        }
        if (lengths.isEmpty()) return 0;
        return lengths.stream().sorted().skip(lengths.size() - 1).findFirst().get();
    }

    private static boolean isValid(List<Character> temp) {

        for (int i = 0; i < temp.size() - 1; i++) {
            if (temp.get(i) == temp.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = Result.alternate(s);
        System.out.println(result);
        // bufferedWriter.write(String.valueOf(result));
        //   bufferedWriter.newLine();

        bufferedReader.close();
    }
}
