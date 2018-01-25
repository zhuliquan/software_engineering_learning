package utils.operator.generate;

import boarder.block.Block;
import boarder.block.BlockZ;

public class GenerateBlockZ implements GenerateOperator {

	public GenerateBlockZ() {
	}
	public Block generate(int row,int col) {
		int R = row,C = col;
		BlockZ blockZ= new BlockZ(R, C);
		return blockZ;
	}

}
