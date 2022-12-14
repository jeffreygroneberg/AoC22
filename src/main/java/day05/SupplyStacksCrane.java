package day05;

import util.Utils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class SupplyStacksCrane {
    public record Move(int number, int from, int to) {
    }

    List<Stack<Character>> stacks = new ArrayList<>();
    List<Move> plannedMoves = new ArrayList<>();

    public SupplyStacksCrane(List<String> stacks) {
        // create state of current stacks and all the moves to be applied
        this.initializeStacksAndMoves(stacks);
    }

    public abstract void move(Move move);

    public void initializeStacksAndMoves(List<String> stacksAndMoves) {

        // find maxheight of stack and the number of columns
        int maxHeight = 0;
        int maxColumns = 0;

        for (int i = 0; i < stacksAndMoves.size(); i++) {

            // go till we find the line of the column numbering
            if (stacksAndMoves.get(i).startsWith(" 1 ")) {
                maxHeight = i;
                break;
            }

            List<String> buckets = Utils.getStacksInLine(stacksAndMoves.get(i));

            // initialize stacksAndMoves and max columns
            if (i == 0) {
                maxColumns = buckets.size();
                IntStream.range(0, maxColumns).forEach(value -> this.stacks.add(new Stack<>()));
            }

            IntStream.range(0, maxColumns).forEach(value -> {
                String s = buckets.get(value);
                char c = s.charAt(1);
                if (!Character.isWhitespace(c))
                    this.stacks.get(value).add(0, c);
            });
        }

        // parse moves
        for (int i = maxHeight + 2; i < stacksAndMoves.size(); i++) {
            List<Integer> integers = Utils.findIntegers(stacksAndMoves.get(i));
            plannedMoves.add(new Move(integers.get(0), integers.get(1), integers.get(2)));
        }
    }


    public String applyMoves() {

        // do all moves
        plannedMoves.stream().forEach(this::move);
        return stacks.stream().map(stack -> String.valueOf(stack.lastElement())).collect(Collectors.joining(""));

    }


}


