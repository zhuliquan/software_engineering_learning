package boarder;

import java.awt.Color;

import boarder.block.Block;

public class Boarder {
	protected int totalRow;
	protected int totalCol;
	protected BackGround background;
	protected Block moveBlock;
	/**
	 * @param totalRow
	 * @param totalCol
	 */
	public Boarder(int totalRow, int totalCol) {
		super();
		int R = totalRow,C = totalCol;
		this.totalRow = R;
		this.totalCol = C;
		this.background = new BackGround(R, C);
	}
	public int getTotalRow() {
		return totalRow;
	}
	public BackGround getBackground() {
		return background;
	}
	public void setBackground(BackGround background) {
		this.background = background;
	}
	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}
	public int getTotalCol() {
		return totalCol;
	}
	public void setTotalCol(int totalCol) {
		this.totalCol = totalCol;
	}
	public Block getMoveBlock() {
		return moveBlock;
	}
	public void setMoveBlock(Block moveBlock) {
		this.moveBlock = moveBlock;
	}
	public void fillCells() {
		background.setCellUsed(moveBlock);
	}
	//��������
	public void upData() {
		for (int row = 0; row < totalRow; row++) {
			for (int col = 0; col < totalCol; col++) {
				if (!background.getCellUsed(row, col)) {//�����Ǳ�ʹ�õ�
					if (moveBlock.isInBlock(row, col)) {
						background.setCellEmpty(row, col, false);
						
						background.setCellColor(row, col, moveBlock.getColor());//��ȥ������ɫ
					} else {
						background.setCellEmpty(row, col, true);
						background.setCellColor(row,col, Color.WHITE);
					}
				}
			}
		}
	}
}
