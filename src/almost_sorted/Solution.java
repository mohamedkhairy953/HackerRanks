package almost_sorted;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'almostSorted' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void almostSorted(List<Integer> arr) {
        List<Integer> sorted = arr.stream().sorted().collect(toList());
        int l = 0;
        int r = arr.size();
        for (int i = 0; i < arr.size(); i++) {
            if (!sorted.get(i).equals(arr.get(i))) {
                if (l == 0) {
                    l = i + 1;
                    continue;
                }
            }
            if (!sorted.get(i).equals(arr.get(i)) && l > 0 && l <= i) {
                r = i + 1;
            }
        }
        if (l == 0) {
            System.out.println("yes");
            return;
        }
        List<Integer> list = arr.subList(l - 1, r);
        List<Integer> slist = sorted.subList(l - 1, r);

        int temp = list.get(list.size() - 1);
        list.set(list.size() - 1, list.get(0));
        list.set(0, temp);

        boolean swap = true;
        for (int i = 0; i < list.size(); i++) {
            if (!slist.get(i).equals(list.get(i))) {
                swap = false;
                break;
            }
        }
        if (swap) {
            System.out.println("yes");
            System.out.println("swap " + l + " " + r);
            return;
        }
        boolean reverse = true;
        for (int i = 1; i < list.size()-1; i++) {
            if (!slist.get(slist.size() - 1 - i).equals(list.get(i))) {
                reverse = false;
                break;
            }
        }
        if(reverse){
            System.out.println("yes");
            System.out.println("reverse " + l + " " + (r));
            return;
        }
        System.out.println("no");

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.almostSorted(arr);

        bufferedReader.close();
    }
}
