package solve;

import solve.models.Shape;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Utils {

    private Utils() {

    }

    public static int[] getPositiveArrSortByDesc(int[] numberArr) {
        return Arrays.stream(numberArr).boxed()
                .filter(number -> number >= 0)
                .sorted(Comparator.reverseOrder())
                .mapToInt(number -> number)
                .toArray();
    }

    public static Map<String, Long> getTopTagByRowList(List<String> rows) {
        return rows.stream()
                .flatMap(row -> Arrays.stream(row.split(" ")).distinct().filter(word -> word.startsWith("#")))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static List<Shape> sortShapeByValue(List<Shape> shapes) {
        return shapes.stream()
                .sorted()
                .collect(Collectors.toList());
    }

}
