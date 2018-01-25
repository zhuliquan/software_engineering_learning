package utils.operator.generate;

import boarder.block.Block;
import boarder.block.BlockL;

public class GenerateBlockL implements GenerateOperator {

	public GenerateBlockL() {
	}
	public Block generate(int row,int col) {
		int R = row,C = col;
		BlockL blockL= new BlockL(R, C);
		return blockL;
	}

}
