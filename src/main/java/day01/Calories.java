package day01;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Calories {

    /**
     * See https://adventofcode.com/2022/day/1
     * <p>
     * Method to find the highest amount of calories within a list of numbers.
     * For example, suppose the Elves finish writing their items' Calories and end up with the following list:
     * <p>
     * 1000
     * 2000
     * 3000
     * <p>
     * 4000
     * <p>
     * 5000
     * 6000
     * <p>
     * 7000
     * 8000
     * 9000
     * <p>
     * 10000
     * This list represents the Calories of the food carried by five Elves:
     * <p>
     * The first Elf is carrying food with 1000, 2000, and 3000 Calories, a total of 6000 Calories.
     * The second Elf is carrying one food item with 4000 Calories.
     * The third Elf is carrying food with 5000 and 6000 Calories, a total of 11000 Calories.
     * The fourth Elf is carrying food with 7000, 8000, and 9000 Calories, a total of 24000 Calories.
     * The fifth Elf is carrying one food item with 10000 Calories.
     * In case the Elves get hungry and need extra snacks, they need to know which Elf to ask: they'd like to know how many Calories are being carried by the Elf carrying the most Calories. In the example above, this is 24000 (carried by the fourth Elf).
     * <p>
     * Find the Elf carrying the most Calories. How many total Calories is that Elf carrying?
     *
     * @param entries
     * @return
     */
    public static int findElfWithHighestCalories(List<String> entries) {

        List<List<Integer>> collect = entries.stream().collect(splitBySeparator(s -> s.equals("")));
        Optional<Integer> max = collect.stream().map(integers -> integers.stream()
                .mapToInt(Integer::intValue)
                .sum()).max(Comparator.naturalOrder());


        return max.get();
    }

    /**
     * By the time you calculate the answer to the Elves' question, they've already realized that the Elf carrying the most Calories of food might eventually run out of snacks.
     *
     * To avoid this unacceptable situation, the Elves would instead like to know the total Calories carried by the top three Elves carrying the most Calories.
     * That way, even if one of those Elves runs out of snacks, they still have two backups.
     *
     * In the example above, the top three Elves are the fourth Elf (with 24000 Calories), then the third Elf (with 11000 Calories),
     * then the fifth Elf (with 10000 Calories). The sum of the Calories carried by these three elves is 45000.
     *
     * Find the top three Elves carrying the most Calories. How many Calories are those Elves carrying in total?
     *
     * @param entries
     * @param n
     * @return
     */
    public static int findNumberOfElvesWithTheHighestCalories(List<String> entries, int n) {

        List<List<Integer>> collect = entries.stream().collect(splitBySeparator(s -> s.equals("")));
        return collect.stream().map(integers -> integers.stream()
                        .mapToInt(Integer::intValue)
                        .sum()).sorted(Comparator.reverseOrder()).collect(Collectors.toList()).subList(0, n).stream().mapToInt(Integer::intValue)
                .sum();

    }

    // parallel collector to build subsets of a list based on a seperator
    private static Collector<String, List<List<Integer>>, List<List<Integer>>> splitBySeparator(Predicate<String> sep) {
        return Collector.of(() -> new ArrayList<>(Arrays.asList(new ArrayList<>())),
                (l, elem) -> {
                    if (sep.test(elem)) {
                        l.add(new ArrayList<>());
                    } else l.get(l.size() - 1).add(Integer.parseInt(elem));
                },
                (l1, l2) -> {
                    l1.get(l1.size() - 1).addAll(l2.remove(0));
                    l1.addAll(l2);
                    return l1;
                });
    }

}
