package day05;

import org.apache.commons.lang.math.IntRange;
import util.Utils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class SupplyStacksCrane {

    // stacks
    List<Stack<Character>> stacks = new ArrayList<>();
    List<List<Integer>> plannedMoves = new ArrayList<>();

    public SupplyStacksCrane(List<String> stacks) {

        // create state of current stacks and all the moves to be applied
        this.initializeStacksAndMoves(stacks);
    }

    /**
     * Move strategy -> defines how the crane will move the cargos from one stack to another
     *
     * @param number
     * @param from
     * @param to
     */
    public abstract void move(int number, int from, int to);

    public void initializeStacksAndMoves(List<String> stacks) {

        // find maxheight of stack and the number of columns
        int maxHeight = 0;
        int maxColumns = 0;

        String stamp = "";
        for (int i = 0; i < stacks.size(); i++) {

            // go till we find the line of the column numbering
            if (stacks.get(i).startsWith(" 1 ")) {

                List<Integer> integers = Utils.findIntegers(stacks.get(i));
                maxColumns = integers.get(integers.size() - 1);
                maxHeight = i;

                // create a stamp with all these columns
                stamp = IntStream.range(0, maxColumns).mapToObj(value -> "[ ]").collect(Collectors.joining(","));
                break;

            }
        }

        // initialize stacks
        IntStream.range(0, maxColumns).forEach(value -> this.stacks.add(new Stack<>()));

        for (int i = maxHeight - 1; i >= 0; i--) {

            // Stamp over so that we can just use "," as a split to get all items and have no
            // whitespaces to deal with between columns
            String[] allItems = Utils.stampStringOver(stamp, stacks.get(i)).split(",");

            for (int j = 0; j < allItems.length; j++) {
                char c = allItems[j].charAt(1);
                if (c != 32)
                    this.stacks.get(j).add(c);
            }

        }

        // parse moves
        for (int i = maxHeight + 2; i < stacks.size(); i++)
            plannedMoves.add(Utils.findIntegers(stacks.get(i)));

    }

    public String applyMoves() {

        // do all moves
        plannedMoves.stream().forEach(integers -> this.move(integers.get(0), integers.get(1), integers.get(2)));
        return stacks.stream().map(characters -> String.valueOf(characters.lastElement())).collect(Collectors.joining(""));

    }


}


