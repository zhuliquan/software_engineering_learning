package utils.operator.generate;

import boarder.block.Block;
import boarder.block.BlockS;

public class GenerateBlockS implements GenerateOperator {

	public GenerateBlockS() {
	}
	public Block generate(int row,int col) {
		int R = row,C = col;
		BlockS blockS= new BlockS(R, C);
		return blockS;
	}

}
