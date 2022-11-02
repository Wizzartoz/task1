package solve;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import solve.models.Circle;
import solve.models.Cube;
import solve.models.Cylinder;
import solve.models.Shape;

import java.util.Arrays;
import java.util.List;
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
        return Stream.of(
                Arguments.arguments(
                        Arrays.asList("#like", "#cool"),
                        Arrays.asList(
                                "I #like my mom, because she's #cool cook",
                                "I #like my dad, because he's #cool drive")
                ),
                Arguments.arguments(
                        Arrays.asList("#friend", "#girl", "#mom", "#love", "#best"),
                        Arrays.asList("#best", "#friend", "#best", "#girl", "#mom", "#mom", "#friend", "#love", "#girl", "#love", "#cool")
                ),
                Arguments.arguments(
                        Arrays.asList("#friend", "#myself"),
                        Arrays.asList("hello my #friend", "I love #myself")
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
    void getTopTagByRowList(List<String> expect, List<String> result) {
        Assertions.assertArrayEquals(expect.toArray(), Utils.getTopTagByRowList(result).toArray());

    }

    @ParameterizedTest
    @MethodSource("setListForSortShapeByValue")
    void sortShapeByValue(List<Shape> expect, List<Shape> result) {
        Assertions.assertArrayEquals(expect.toArray(), Utils.sortShapeByValue(result).toArray());
    }
}
