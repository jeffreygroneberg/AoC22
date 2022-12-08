package day08;

import org.junit.jupiter.api.Test;
import util.BaseTest;
import util.Utils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TreetopTreeHouseTest extends BaseTest {

    private int[][] example =
            {
                    {3, 0, 3, 7, 3},
                    {2, 5, 5, 1, 2},
                    {6, 5, 3, 3, 2},
                    {3, 3, 5, 4, 9},
                    {3, 5, 3, 9, 0}
            };

    public TreetopTreeHouseTest() {
        super("day08/day08_example.txt", "day08/day08_input.txt");
    }

    @Test
    public void testExercise1Example() {

        TreetopTreeHouse treetopTreeHouse = new TreetopTreeHouse();
        int[][] allVisibleTrees = treetopTreeHouse.createVisibleTreesFromEdgesMask(example, TreetopTreeHouse.EDGE.values());
        int sum = Arrays.stream(allVisibleTrees).flatMapToInt(ints1 -> Arrays.stream(ints1)).sum();

        assertEquals(21, sum);

    }

    @Test
    public void testExercise1Input() {

        TreetopTreeHouse treetopTreeHouse = new TreetopTreeHouse();

        int[][] allVisibleTrees = treetopTreeHouse.createVisibleTreesFromEdgesMask(Utils.multipleLinesToNumberArrays(input), TreetopTreeHouse.EDGE.values());
        int sum = Arrays.stream(allVisibleTrees).flatMapToInt(ints1 -> Arrays.stream(ints1)).sum();

        assertEquals(1719, sum);

    }

    @Test
    public void testExercise2Example() {

        TreetopTreeHouse treetopTreeHouse = new TreetopTreeHouse();
        int[][] scenicTreeMask = treetopTreeHouse.createScenicTreeWithEdgesMask(example, TreetopTreeHouse.EDGE.values());
        int asInt = Arrays.stream(scenicTreeMask).flatMapToInt(ints1 -> Arrays.stream(ints1)).max().getAsInt();

        assertEquals(8, asInt);

    }

    @Test
    public void testExercise2Input() {

        TreetopTreeHouse treetopTreeHouse = new TreetopTreeHouse();
        int[][] scenicTreeMask = treetopTreeHouse.createScenicTreeWithEdgesMask(Utils.multipleLinesToNumberArrays(input), TreetopTreeHouse.EDGE.values());
        int asInt = Arrays.stream(scenicTreeMask).flatMapToInt(ints1 -> Arrays.stream(ints1)).max().getAsInt();

        assertEquals(590824, asInt);

    }
}