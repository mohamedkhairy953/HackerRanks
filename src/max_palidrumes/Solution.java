package max_palidrumes;

import java.io.*;
import java.math.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;

import java.util.HashMap;
import java.util.Map;

class Result {
    static String s;
    /*
     * Complete the 'initialize' function below.
     *
     * The function accepts STRING s as parameter.
     */

    public static void initialize(String st) {
        // This function is called once before all queries.
        s = st;
    }

    /*
     * Complete the 'answerQuery' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER l
     *  2. INTEGER r
     */

    public static int answerQuery(int l, int r) {
        String str = s.substring(l - 1, r);
        int n = str.length();
        // Return the answer for this query modulo 1000000007.
        Map<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++)
            mp.put(str.charAt(i), mp.get(str.charAt(i)) == null ?
                    1 : mp.get(str.charAt(i)) + 1);

        int k = 0; // Count of singles
        BigInteger num = new BigInteger(String.valueOf(0)); // numerator of result
        BigInteger den = new BigInteger(String.valueOf(1)); // denominator of result
        int fi;
        for (Map.Entry<Character, Integer> it : mp.entrySet()) {
            // if frequency is even
            // fi = ci / 2
            if (it.getValue() % 2 == 0)
                fi = it.getValue() / 2;

                // if frequency is odd
                // fi = ci - 1 / 2.
            else {
                fi = (it.getValue() - 1) / 2;
                k++;
            }

            // sum of all frequencies
            num = num.add(new BigInteger(String.valueOf(fi)));

            // product of factorial of
            // every frequency
            den = den.multiply(fact(fi));
        }

        // if all character are unique
        // so there will be no pallindrome,
        // so if num != 0 then only we are
        // finding the factorial
        if (num.intValue() != 0)
            num = fact(num.intValue());

        int ans = (num.divide(den)).intValue();

        if (k != 0) {
            // k are the single
            // elements that can be
            // placed in middle
            ans = ans * k;
        }

        return ans % 1000000007;
    }

    static BigInteger fact(int n) {
        if (n == 0) return new BigInteger("1");
        BigInteger ans = new BigInteger("1");
        for (int i = 1; i <= n; i++)
            ans = ans.multiply(new BigInteger(String.valueOf(i)));
        return (ans);
    }

    BigInteger fact2(int n) {
        if (n == 0 || n == 1) return new BigInteger("1");
        return fact2(n - 1).multiply(new BigInteger(String.valueOf(n)));
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //   BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        Result.initialize(s);

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int l = Integer.parseInt(firstMultipleInput[0]);

                int r = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.answerQuery(l, r);


            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        //  bufferedWriter.close();
    }
}