package exercise3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.BaseTest;
import util.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Day 3")
class RucksackTest extends BaseTest {
    public RucksackTest() {
        super("exercise3_example.txt", "exercise3_input.txt");
    }

    @Test
    void calculuatePriosExercise1Example() {

        Rucksack rucksack = new Rucksack();
        assertEquals(157, rucksack.calculuatePriosExercise1(example));

    }

    @Test
    void calculuatePriosExercise1Real() {

        Rucksack rucksack = new Rucksack();
        assertEquals(8243, rucksack.calculuatePriosExercise1(input));

    }

    @Test
    void calculuatePriosExercise2Example() {

        Rucksack rucksack = new Rucksack();
        assertEquals(70, rucksack.calculuatePriosExercise2(example));

    }

    @Test
    void calculuatePriosExercise2Real() {

        Rucksack rucksack = new Rucksack();
        assertEquals(2631, rucksack.calculuatePriosExercise2(input));

    }
}