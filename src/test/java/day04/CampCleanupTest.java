package day04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.BaseTest;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Day 4")
class CampCleanupTest extends BaseTest {

    public CampCleanupTest() {
        super("day04/day04_example.txt", "day04/day04_input.txt");
    }

    @Test
    void getContainsSumExample() {
        CampCleanup cleanup = new CampCleanup();
        assertEquals(2, cleanup.getSumOfAssignmentsThatContainAnother(example));
    }

    @Test
    void getContainsSumReal() {
        CampCleanup cleanup = new CampCleanup();
        assertEquals(540, cleanup.getSumOfAssignmentsThatContainAnother(input));
    }

    @Test
    void getOverlappingSumExample() {
        CampCleanup cleanup = new CampCleanup();
        assertEquals(4, cleanup.getSumOfAssignmentsThatOverlap(example));
    }

    @Test
    void getOverlappingSumReal() {
        CampCleanup cleanup = new CampCleanup();
        assertEquals(872, cleanup.getSumOfAssignmentsThatOverlap(input));
    }

}