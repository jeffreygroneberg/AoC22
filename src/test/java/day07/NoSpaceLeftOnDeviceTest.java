package day07;

import org.junit.jupiter.api.Test;
import util.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NoSpaceLeftOnDeviceTest extends BaseTest {

    public NoSpaceLeftOnDeviceTest() {
        super("day07/day07_example.txt", "day07/day07_input.txt");
    }

    @Test
    void testBuildDirectoriesAndFilesExample1() {
        NoSpaceLeftOnDevice fileSystem = new NoSpaceLeftOnDevice(example);
        assertEquals(95437, fileSystem.getSumOfSizeForDirectoriesWith(10, size -> size < 100000));
    }


    @Test
    void testBuildDirectoriesAndFilesInput1() {
        NoSpaceLeftOnDevice device = new NoSpaceLeftOnDevice(input);
        assertEquals(1642503, device.getSumOfSizeForDirectoriesWith(Integer.MAX_VALUE, size -> size < 100000));
    }


    @Test
    void testBuildDirectoriesAndFilesExample2() {
        NoSpaceLeftOnDevice device = new NoSpaceLeftOnDevice(example);
        assertEquals(24933642, device.getDirectoryToFreeSpaceOf(30000000, 70000000).get().getCalculatedSize());
    }

    @Test
    void testBuildDirectoriesAndFilesInput2() {
        NoSpaceLeftOnDevice device = new NoSpaceLeftOnDevice(input);
        assertEquals(6999588, device.getDirectoryToFreeSpaceOf(30000000, 70000000).get().getCalculatedSize());
    }
}