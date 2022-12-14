package day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Day 2")
class RockPaperScissorTest {

    private List<String> example;
    private List<String> input;

    @BeforeEach
    void setUp() throws IOException {
        Utils utils = new Utils();
        File fileExample = utils.getFile("day02/day02_example.txt");
        File fileRealInput = utils.getFile("day02/day02_input.txt");

        //Read files
        example = Files.readAllLines(fileExample.toPath());
        input = Files.readAllLines(fileRealInput.toPath());
    }

    @Test
    void testWithExample1() {

        RockPaperScissor game = new RockPaperScissor();
        assertEquals(22, game.calculateScoreFirstExercise(example));

    }

    @Test
    void testWithRealInput1() {

        RockPaperScissor game = new RockPaperScissor();
        assertEquals(9651, game.calculateScoreFirstExercise(input));

    }

    @Test
    void testWithRealInput2() {

        RockPaperScissor game = new RockPaperScissor();
        assertEquals(10560, game.calculateScoreSecondExercise(input));

    }

}