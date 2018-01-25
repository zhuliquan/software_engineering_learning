package utils.operator.move;

import boarder.block.Block;

public class Drop implements MoveOperator {
	public void move(Block block) {
		block.drop();
	}
}
