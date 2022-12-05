package day05;

import org.junit.jupiter.api.Test;
import util.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SupplyStacksCraneTest extends BaseTest {

    public SupplyStacksCraneTest() {
        super("day05/day05_example.txt", "day05/day05_input.txt");
    }

    @Test
    void cleanStacksWithExampleExercise1() {

        SupplyStacksCrane stacks = new Crater9000(example);
        assertEquals("CMZ", stacks.applyMoves());

    }

    @Test
    void cleanStacksWithExampleExercise2() {

        SupplyStacksCrane stacks = new Crater9001(example);
        assertEquals("MCD", stacks.applyMoves());

    }

    @Test
    void cleanStacksWithRealInputExercise1() {

        SupplyStacksCrane stacks = new Crater9000(input);
        assertEquals("QNNTGTPFN", stacks.applyMoves());

    }

    @Test
    void cleanStacksWithRealInputExercise2() {

        SupplyStacksCrane stacks = new Crater9001(input);
        assertEquals("GGNPJBTTR", stacks.applyMoves());

    }

}