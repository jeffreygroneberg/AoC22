package util;

import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class BaseTest {

    protected String examplePath;
    protected String inputPath;

    public BaseTest(String examplePath, String inputPath) {
        this.examplePath = examplePath;
        this.inputPath = inputPath;
    }

    protected List<String> example;
    protected List<String> input;

    @BeforeEach
    void setUp() throws IOException {
        Utils utils = new Utils();
        File fileExample = utils.getFile(examplePath);
        File fileRealInput = utils.getFile(inputPath);

        //Read files
        example = Files.readAllLines(fileExample.toPath());
        input = Files.readAllLines(fileRealInput.toPath());
    }

}
