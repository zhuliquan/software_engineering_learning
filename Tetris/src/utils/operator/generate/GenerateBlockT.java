package utils.operator.generate;

import boarder.block.Block;
import boarder.block.BlockT;

public class GenerateBlockT implements GenerateOperator {

	public GenerateBlockT() {
	}
	public Block generate(int row,int col) {
		int R = row,C = col;
		BlockT blockT= new BlockT(R, C);
		return blockT;
	}

}
