package day03;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Rucksack {

    // Not sure if there is already a util method for this.
    // Take the char and substract a or A to get to the common base
    // and then add the alphabet "value"
    public int getPrioForLetter(Character c) {

        if (Character.isUpperCase(c)) {
            return c - 'A' + 27;

        }

        return c - 'a' + 1;

    }

    public int calculuatePriosExercise1(List<String> rucksacks) {

        return rucksacks.stream().map(s -> {

            String firstHalf = s.substring(0, s.length() / 2);
            String secondHalf = s.substring(firstHalf.length());

            for (int i = 0; i < firstHalf.length(); i++)
                if (secondHalf.contains(String.valueOf(firstHalf.charAt(i))))
                    return getPrioForLetter(firstHalf.charAt(i));

            return 0;
        }).collect(Collectors.summingInt(Integer::intValue));

    }

    public int calculuatePriosExercise2(List<String> rucksacks) {

        List<Character> foundBadges = new ArrayList<>();

        for (int i = 0; i <= rucksacks.size() - 3; i = i + 3) {

            // Split the bucket
            String first = rucksacks.get(i);
            String two = rucksacks.get(i + 1);
            String three = rucksacks.get(i + 2);

            // look for the char that is in all of them
            // if we found the first char we can break (j = length)
            // as there is only one to look for
            for (int j = 0; j < first.length(); j++) {

                String toLookFor = String.valueOf(first.charAt(j));

                if (two.contains(toLookFor)
                        && three.contains(toLookFor)) {
                    foundBadges.add(first.charAt(j));
                    j = first.length();
                }
            }
        }

        return foundBadges.stream().map(this::getPrioForLetter).collect(Collectors.summingInt(Integer::intValue));

    }


}
