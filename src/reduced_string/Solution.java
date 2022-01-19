package reduced_string;

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
     * Complete the 'superReducedString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String superReducedString(String s) {
        // Write your code here
        char[] ss = s.toCharArray();
        List<Character> chars = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (char c : ss) {
            chars.add(c);
        }
        int i=0;
        while (i<chars.size()-1) {
            if(chars.get(i)==chars.get(i+1)){
                chars.remove(i);
                chars.remove(i);
                i=0;
            }else {
                i++;
            }

        }
        for (char c : chars) {
            sb.append(c);
        }
        return (sb.toString().equals("")) ? "Empty String" : sb.toString();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.superReducedString(s);

        System.out.println(result);

        bufferedReader.close();
        // bufferedWriter.close();
    }
}
