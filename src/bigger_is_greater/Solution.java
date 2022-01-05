package bigger_is_greater;

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
     * Complete the 'biggerIsGreater' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING w as parameter.
     */

    public static String biggerIsGreater(String w) {
        // Write your code here
        char replicable;
        int counter = 1;
        char[] wArr = w.toCharArray();
        boolean swapped = false;
        String result = "no answer";
        while (counter < wArr.length) {
            replicable = wArr[wArr.length - counter];
            for (int i = wArr.length - counter - 1; i >= 0; i--) {
                if (wArr[i] < replicable) {
                    char temp = wArr[i];
                    wArr[i] = replicable;
                    wArr[wArr.length - counter] = temp;
                    char[] suffix = Arrays.copyOfRange(wArr, i + 1, wArr.length);
                    Arrays.sort(suffix);
                    char[] prefix = Arrays.copyOfRange(wArr, 0, i+1);
                    result = new String(prefix) + new String(suffix);
                    swapped = true;
                    break;
                }

            }
            if (swapped)
                break;
            else
                counter++;


        }
        return result;
    }

}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String w = bufferedReader.readLine();

                String result = Result.biggerIsGreater(w);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

