package exercise2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RockPaperScissorTest {

    private List<String> example;
    private List<String> input;

    @BeforeEach
    void setUp() throws IOException {
        Utils utils = new Utils();
        File fileExample = utils.getFile("exercise2_example.txt");
        File fileRealInput = utils.getFile("exercise2_input.txt");

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