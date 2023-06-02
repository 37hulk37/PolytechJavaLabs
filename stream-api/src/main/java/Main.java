import java.util.*;
import java.util.stream.Collectors;

public class Main {
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

    public static int sumEven(Collection<Integer> collection) {
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

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>(Arrays.asList(2, 4, 6,  45, 8, 90));
        System.out.println(average(l));

        List<String> l2 = new ArrayList<>(Arrays.asList("98", "kookvpf", "kofkv0d", "v0k0dk"));
        System.out.println(addStr(l2));

        List<Double> l3 = new ArrayList<>(Arrays.asList(2.0, 4.2, 6.4,  45.3, 8.9, 90.1, 4.6, 78.7, 6.6));
        System.out.println(listSquare(l3));

        //Collection<Integer> c = new ArrayList<>();
        //System.out.println(getLastOrThrow(c));
        System.out.println(getLastOrThrow(Arrays.asList(2.0, 4.2, 6.4,  45.3, 8.9, 90.1, 4.6, 78.7, 6.6)));

        List<String> l4 = new ArrayList<>(Arrays.asList("qwerty", "queen", "quick", "good", "cargo", "cool", "owl"));
        System.out.println(getSortedStringsFromChar(l4, "q"));
        System.out.println(getSortedStringsFromChar(l4, "c"));

        System.out.println(sumEven(l));

        List<String> l5 = new ArrayList<>(Arrays.asList("qwerty", "kotlin", "lombok", "good", "cargo", "imagine"));

        System.out.println(listToMap(l5));
    }
}
