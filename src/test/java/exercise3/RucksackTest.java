package exercise3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RucksackTest {
    private List<String> example;
    private List<String> input;

    @BeforeEach
    void setUp() throws IOException {
        Utils utils = new Utils();
        File fileExample = utils.getFile("exercise3_example.txt");
        File fileRealInput = utils.getFile("exercise3_input.txt");

        //Read files
        example = Files.readAllLines(fileExample.toPath());
        input = Files.readAllLines(fileRealInput.toPath());
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