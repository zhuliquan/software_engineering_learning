package boarder;

import java.awt.Color;

import boarder.block.Block;
import boarder.cell.*;

public class BackGround {
	protected StaticCell [][]background;
	public BackGround(int totalRow,int totalCol) {
		int R = totalRow,C = totalCol;
		background = new StaticCell[R][C];
		for (int row=0; row < R; row++) {
			for (int col=0; col < C; col++) {
				background[row][col] = new StaticCell(row, col);
			}
		}
	}
	public void setCellEmpty(int row,int col,boolean isEmpty) {
		background[row][col].setEmpty(isEmpty);
	}
	public boolean getCellEmpty(int row,int col) {
		return background[row][col].isEmpty();
	}
	public void setCellUsed(int row,int col,boolean isUsed) {
		background[row][col].setUsed(isUsed);
	}
	public void setCellUsed(Block block) {
		Cell []cells = block.getMoveCells();
		for (Cell cell :cells) {
			setCellUsed(cell.getRow(), cell.getCol(),true);
			setCellColor(cell.getRow(),cell.getCol(),block.getColor());
		}
	}
	public boolean getCellUsed(int row,int col) {
		return background[row][col].isUsed();
	}
	public void setCellColor(int row, int col, Color color) {
		background[row][col].setColor(color);
	}
	public Color getCellColor(int row, int col) {
		return background[row][col].getColor();
	}
}
