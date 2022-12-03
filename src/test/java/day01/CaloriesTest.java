package day01;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import util.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Day 1")
class CaloriesTest {

    List<String> example;
    List<String> input;


    @BeforeAll
    void prepareInput() throws IOException {

        Utils utils = new Utils();
        File fileExample = utils.getFile("day01/day01_example.txt");
        File fileRealInput = utils.getFile("day01/day01_input.txt");

        //Read file
        example = Files.readAllLines(fileExample.toPath());
        input = Files.readAllLines(fileRealInput.toPath());
    }

    @Test
    void findElfWithHighestCaloriesByExample() throws IOException {

        assertEquals(24000, Calories.findElfWithHighestCalories(example));
    }

    @Test
    void findElfWithHighestCaloriesByRealInput() throws IOException {

        assertEquals(69836, Calories.findElfWithHighestCalories(input));

    }

    @Test
    void findNumberOfElvesWithTheHighestCaloriesByExample() throws IOException {

        assertEquals(45000, Calories.findNumberOfElvesWithTheHighestCalories(example, 3));

    }

    @Test
    void findNumberOfElvesWithTheHighestCaloriesRealInput() throws IOException {

        assertEquals(207968, Calories.findNumberOfElvesWithTheHighestCalories(input, 3));

    }
}