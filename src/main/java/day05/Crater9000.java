package day05;

import java.util.List;

public class Crater9000 extends SupplyStacksCrane {

    public Crater9000(List<String> stacks) {
        super(stacks);
    }

    @Override
    public void move(int number, int from, int to) {

        for (int i = 0; i < number; i++) {
            this.stacks.get(to - 1).add(this.stacks.get(from - 1).pop());
        }

    }
}
