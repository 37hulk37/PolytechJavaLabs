package com.hulk.labsapp.labs.streamapi;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAPI {
    public static double average(List<Integer> l) {
        return l.stream()
                .mapToInt(x -> x)
                .summaryStatistics()
                .getAverage();
    }

    public static List<String> addStr(List<String> l) {
        return l.stream()
                .map(String::toUpperCase)
                .map(str -> "_new_" + str)
                .toList();
    }


    public static <T extends Number> List<Double> listSquare(List<T> l) {
        return l.stream()
                .filter(x -> Collections.frequency(l, x) == 1)
                .mapToDouble(Number::doubleValue)
                .map(x -> x*x)
                .boxed()
                .toList();
    }

    public static List<String> getSortedStringsFromChar(Collection<String> c, String ch) {
        return c.stream()
                .filter(str -> str.startsWith(ch))
                .sorted()
                .toList();
    }

    public static <T> T getLastOrThrow(Collection<T> c) throws RuntimeException {
        return c.stream()
                .reduce((first, last) -> last)
                .orElseThrow(() -> {
                    throw new RuntimeException("Empty collection");
                });
    }


    public static Integer sumEven(Collection<Integer> collection) {
        return collection.stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(x -> x)
                .sum();
    }

    public static Map<Character, String> listToMap(List<String> l) {
        return l.stream()
                .collect(Collectors.toMap(
                        str -> str.charAt(0),
                        str -> str.substring(1),
                        (ch1, ch2) -> ch1
                ));
    }


}
