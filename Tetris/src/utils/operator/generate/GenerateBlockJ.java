package utils.operator.generate;

import boarder.block.Block;
import boarder.block.BlockJ;


public class GenerateBlockJ implements GenerateOperator {

	public GenerateBlockJ() {
	}
	public Block generate(int row,int col) {
		int R = row,C = col;
		return new BlockJ(R, C);
	}

}
