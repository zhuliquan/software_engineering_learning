package boarder.cell;

import java.awt.Color;

public class Cell {
	protected int row;
	protected int col;
	protected Color color;
	/**
	 * @param row
	 * @param col
	 */
	public Cell(int row, int col) {
		super();
		this.row = row;
		this.col = col;
		color = Color.WHITE;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Cell [row=" + row + ", col=" + col + "]";
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
}
