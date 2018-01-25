package utils;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import boarder.BackGround;
import boarder.Boarder;
import boarder.block.*;
import boarder.cell.MoveCell;
import utils.operator.generate.GenerateBlockJ;
import utils.operator.generate.GenerateBlockL;
import utils.operator.generate.GenerateBlockO;
import utils.operator.generate.GenerateBlockS;
import utils.operator.generate.GenerateBlockT;
import utils.operator.generate.GenerateBlockZ;
import utils.operator.generate.GenerateOperator;
import utils.operator.move.Drop;
import utils.operator.move.MoveLeft;
import utils.operator.move.MoveOperator;
import utils.operator.move.MoveRight;

public class Utils {
	private static GenerateOperator []generators = {
			new GenerateBlockJ(),
			new GenerateBlockL(),
			new GenerateBlockO(),
			new GenerateBlockS(),
			new GenerateBlockT(),
			new GenerateBlockZ(),
	};
	private final static Color []colors = {
			Color.BLUE,
			Color.GREEN,
			Color.RED,
			Color.ORANGE,
			Color.YELLOW,
	};
	private static Random rnd = new Random();
	public static Block getRandomBlock(int startRow,int startCol) {
		int R = startRow,C = startCol;
		int bound = generators.length;
		Block b = generators[rnd.nextInt(bound)].generate(R, C);
		return b;
	}
	public static boolean isOutofBound(Block block,Boarder boarder,MoveOperator operator) {
		boolean ret = false;
		BackGround background = boarder.getBackground();
		int R  = boarder.getTotalRow(),C = boarder.getTotalCol();
		ArrayList<MoveCell> edgeLefts = block.getEdgeLefts();
		ArrayList<MoveCell> edgeRights = block.getEdgeRights();
		ArrayList<MoveCell> edgeButtoms = block.getEdgeButtoms();
		
		if (operator instanceof MoveLeft) {
			for (MoveCell edgeLeft : edgeLefts) {
				int r = edgeLeft.getRow(),c = edgeLeft.getCol();
				if (c -1 < 0 || background.getCellUsed(r, c-1)) {
					ret = true;
					break;
				}
			}
			
		} else if (operator instanceof MoveRight) {
			for (MoveCell edgeRight: edgeRights) {
				int r = edgeRight.getRow(),c = edgeRight.getCol();
				if (c+1 >= C || background.getCellUsed(r, c+1)) {
					ret = true;
					break;
				}
			}
		} else if (operator instanceof Drop) {
			for (MoveCell edgeButtom: edgeButtoms) {
				int r = edgeButtom.getRow(),c = edgeButtom.getCol();
				if (r+1 < 0) continue;
				if (r + 1 >= R || background.getCellUsed(r+1, c)) {
					ret = true;
					break;
				}
			}
		}
		return ret;
	}
	public static Color getRandomColor() {
		int bound = colors.length;
		Color color = colors[rnd.nextInt(bound)];
		return color;
	}

}
