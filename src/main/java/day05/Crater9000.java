package day05;

import java.util.List;

public class Crater9000 extends SupplyStacksCrane {

    public Crater9000(List<String> stacks) {
        super(stacks);
    }

    @Override
    public void move(Move move) {

        for (int i = 0; i < move.number(); i++) {
            this.stacks.get(move.to() - 1).add(this.stacks.get(move.from() - 1).pop());
        }

    }
}
