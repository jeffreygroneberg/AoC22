package day05;

import java.util.List;
import java.util.Stack;

public class Crater9001 extends SupplyStacksCrane {

    public Crater9001(List<String> stacks) {
        super(stacks);
    }

    @Override
    public void move(int number, int from, int to) {

        Stack<Character> tempStack = new Stack<>();

        for (int i = 0; i < number; i++) {
            tempStack.add(this.stacks.get(from - 1).pop());
        }

        int initialSize = tempStack.size();
        for (int i = 0; i < initialSize; i++)
            this.stacks.get(to - 1).add(tempStack.pop());

    }
}
