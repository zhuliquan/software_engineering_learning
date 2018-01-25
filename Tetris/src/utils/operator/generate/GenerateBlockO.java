package utils.operator.generate;

import boarder.block.Block;
import boarder.block.BlockO;;

public class GenerateBlockO implements GenerateOperator {

	public GenerateBlockO() {
	}
	public Block generate(int row,int col) {
		int R = row,C = col;
		BlockO blockO= new BlockO(R, C);
		return blockO;
	}

}
