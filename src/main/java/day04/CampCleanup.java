package day04;

import org.apache.commons.lang.math.IntRange;

import java.util.List;
import java.util.stream.Collectors;

public class CampCleanup {
    public int getSumOfAssignmentsThatContainAnother(List<String> assignments) {

        return assignments.stream().map(s ->
        {

            String[] split = s.split(",");

            // using apache commons here --> too lazy :)
            String firstValue = split[0].split("-")[0];
            String secondValue = split[0].split("-")[1];
            IntRange firstRange = new IntRange(Integer.parseInt(firstValue), Integer.parseInt(secondValue));

            firstValue = split[1].split("-")[0];
            secondValue = split[1].split("-")[1];
            IntRange secondRange = new IntRange(Integer.parseInt(firstValue), Integer.parseInt(secondValue));

            if (firstRange.containsRange(secondRange) || secondRange.containsRange(firstRange))
                return 1;

            return 0;

        }).collect(Collectors.summingInt(Integer::intValue));

    }

    public int getSumOfAssignmentsThatOverlap(List<String> assignments) {

        return assignments.stream().map(s ->
        {

            String[] split = s.split(",");

            // using apache commons here --> too lazy :)
            String firstValue = split[0].split("-")[0];
            String secondValue = split[0].split("-")[1];
            IntRange firstRange = new IntRange(Integer.parseInt(firstValue), Integer.parseInt(secondValue));

            firstValue = split[1].split("-")[0];
            secondValue = split[1].split("-")[1];
            IntRange secondRange = new IntRange(Integer.parseInt(firstValue), Integer.parseInt(secondValue));

            if (firstRange.overlapsRange(secondRange) || secondRange.overlapsRange(firstRange))
                return 1;

            return 0;

        }).collect(Collectors.summingInt(Integer::intValue));

    }
}
