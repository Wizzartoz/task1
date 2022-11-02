package solve;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import solve.models.Circle;
import solve.models.Cube;
import solve.models.Cylinder;
import solve.models.Shape;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;


class UtilsTest {

    static Stream<Arguments> setArrForGetPositiveTest() {
        return Stream.of(
                Arguments.arguments(new int[]{3, 2, 2, 1, 1, 1, 0}, new int[]{1, 1, 2, 3, -4, 0, 2, 1}),
                Arguments.arguments(new int[]{100, 9, 2, 1}, new int[]{1, 2, 9, -5, 100}),
                Arguments.arguments(new int[]{9, 3, 0}, new int[]{3, 9, 0}),
                Arguments.arguments(new int[]{3, 3, 2, 2, 1, 1}, new int[]{1, 1, 2, 3, -100, 2, 3}),
                Arguments.arguments(new int[]{35, 6, 4, 3, 2, 1}, new int[]{6, 1, 35, 3, -5, 4, 2}),
                Arguments.arguments(new int[]{2000, 100, 2, 0, 0}, new int[]{-1, 0, 2, 0, 100, 2000, -3})
        );
    }

    static Stream<Arguments> setListForTopTagTest() {
        Map<String, Long> test1 = new HashMap<>();
        test1.put("#like", 2L);
        test1.put("#cool", 2L);
        Map<String, Long> test2 = new HashMap<>();
        test2.put("#friend", 2L);
        test2.put("#girl", 2L);
        test2.put("#mom", 2L);
        test2.put("#love", 2L);
        test2.put("#best", 2L);
        Map<String, Long> test3 = new HashMap<>();
        test3.put("#friend", 1L);
        test3.put("#myself", 1L);
        return Stream.of(
                Arguments.arguments(
                        test1,
                        List.of(
                                "I #like my mom, because she's #cool cook",
                                "I #like my dad, because he's #cool drive")
                ),
                Arguments.arguments(
                        test2,
                        List.of("#best", "#friend", "#best", "#girl", "#mom", "#mom", "#friend", "#love", "#girl", "#love", "#cool")
                ),
                Arguments.arguments(
                        test3,
                        List.of("hello my #friend", "I love #myself")
                )
        );
    }

    static Stream<Arguments> setListForSortShapeByValue() {
        return Stream.of(
                Arguments.arguments(
                        List.of(new Circle(2), new Cylinder(2, 3), new Cube(5)),
                        List.of(new Circle(2), new Cube(5), new Cylinder(2, 3))),
                Arguments.arguments(
                        List.of(new Cube(2), new Cylinder(23.3, 1), new Circle(3)),
                        List.of(new Circle(3), new Cube(2), new Cylinder(23.3, 1))),
                Arguments.arguments(
                        List.of(new Cube(2), new Circle(2.4), new Cylinder(10, 5)),
                        List.of(new Circle(2.4), new Cube(2), new Cylinder(10, 5)))
        );
    }


    @ParameterizedTest
    @MethodSource("setArrForGetPositiveTest")
    void getPositiveArrSortByDesc(int[] expect, int[] result) {
        Assertions.assertArrayEquals(expect, Utils.getPositiveArrSortByDesc(result));
    }

    @ParameterizedTest
    @MethodSource("setListForTopTagTest")
    void getTopTagByRowList(Map<String, Long> expect, List<String> result) {
        Assertions.assertEquals(expect, Utils.getTopTagByRowList(result));

    }

    @ParameterizedTest
    @MethodSource("setListForSortShapeByValue")
    void sortShapeByValue(List<Shape> expect, List<Shape> result) {
        Assertions.assertArrayEquals(expect.toArray(), Utils.sortShapeByValue(result).toArray());
    }
}
