package utils.operator.move;

import boarder.block.Block;

public class MoveLeft implements MoveOperator {
	public void move(Block block) {
		block.moveLeft();
	}
}
