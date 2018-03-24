package ua.training;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElementCounter {
    public static Map<Integer, Integer> count(final List<Integer> list) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (Integer element : list) {
            Integer currentCount = counter.get(element);
            counter.put(element, currentCount == null ? 1 : ++currentCount);
        }
        return counter;
    }
}
