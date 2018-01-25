package utils.operator.move;

import boarder.block.Block;

public class MoveRight implements MoveOperator {
	public void move(Block block) {
		block.moveRight();
	}
}