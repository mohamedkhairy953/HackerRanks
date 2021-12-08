package non_divisible_subset;

import java.util.*;

public class NonDivisibleSubset {


    public static void main(String[] args) {

        List<Integer> ss = new ArrayList<>();
        ss.add(1);
        ss.add(7);
        ss.add(2);
        ss.add(4);

        System.out.println(nonDivisibleSubset(3, ss));
    }

    public static int nonDivisibleSubset(int k, List<Integer> s) {

        Map<Integer, Integer> mapOfModulus = new HashMap<>();
        for (int i = 0; i < k; i++) {
            mapOfModulus.put(i, 0);
        }

        int result = 0;
        for (Integer integer : s) {
            mapOfModulus.put( integer%k, mapOfModulus.get(integer%k) + 1);

        }
        if (mapOfModulus.get(0) > 0)
            result++;

        for (int i = 1; i < k; i++) {
            if (mapOfModulus.get(i) > 0) {
                if (i +i ==k )
                    result++;
                else {
                    result += Math.max(mapOfModulus.get(i), mapOfModulus.get(k - i));
                    mapOfModulus.put(i, 0);
                    mapOfModulus.put(k - i, 0);
                }
            }
        }

        return result;
    }

    private static Map<Integer, List<Integer>> getLargestListOfKeys(Map<Integer, List<Integer>> map, Set<Integer> keys, List<Integer> subset) {
        List<Integer> largestList = new ArrayList<>();
        Integer selectedKey = 0;
        for (Integer key : keys) {
            if (map.get(key) == null)
                continue;
            if (largestList.size() < map.get(key).size() && keyInSubset(key, subset, map)) {
                selectedKey = key;
                largestList = map.get(key);
            }
        }
        HashMap<Integer, List<Integer>> result = new HashMap<>();
        result.put(selectedKey, largestList);
        return result;
    }

    private static boolean keyInSubset(Integer key, List<Integer> subset, Map<Integer, List<Integer>> map) {
        if (subset.isEmpty())
            return true;

        for (int i = 0; i < subset.size(); i++) {
            if (!map.get(subset.get(i)).contains(key))
                return false;
        }
        return true;
    }
}
