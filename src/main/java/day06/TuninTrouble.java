package day06;

import java.util.*;
import java.util.stream.Collectors;

public class TuninTrouble {
    public record Marker(int position, String sequence) {
    }

    public Marker findMarker(String sequence, int sizeOfMarker) {

        for (int i = 0; i < sequence.length() - sizeOfMarker; i++) {

            // use a set - sets only store unique items
            Set<Character> bag = new LinkedHashSet<>();

            for (int j = 0; j < sizeOfMarker; j++) {
                bag.add(sequence.charAt(i + j));
            }

            // just check if the current set we have has the size we want and that's it.
            if (bag.size() == sizeOfMarker) {
                return new Marker(i + sizeOfMarker, bag.stream().map(String::valueOf).collect(Collectors.joining("")));
            }
        }

        return null;

    }

}
