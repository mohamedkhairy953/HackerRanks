package space_station;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Solution {

    // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) {

        int distance = 0;
        int maxDistance = -1;
        int lastStationPosition = -1;
        Map<Integer, Integer> mapOfCities = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            mapOfCities.put(i, 0);
        }
        for (int j : c) {
            mapOfCities.put(j, 1);
        }
        for (int i = 0; i < n; i++) {
            if (mapOfCities.get(i) == 1) {
                if (lastStationPosition == -1)
                    distance = i;
                else
                    distance = (i-lastStationPosition) / 2 ;

                lastStationPosition = i;
                if (distance > maxDistance) {
                    maxDistance = distance;
                }
                distance = 0;
            } else {
                distance++;
            }
        }
        if (distance > maxDistance) {
            maxDistance = distance;
        }
        return maxDistance;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] c = new int[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = flatlandSpaceStations(n, c);
        System.out.println(result);
      /*  bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();*/

        scanner.close();
    }
}
