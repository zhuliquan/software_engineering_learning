package boarder.block;
import java.util.ArrayList;
import boarder.cell.MoveCell;
import java.awt.Color;
import utils.Utils;

public class Block {
	protected MoveCell []cells;
	protected ArrayList<MoveCell> edgeLefts;
	protected ArrayList<MoveCell> edgeRights;
	protected ArrayList<MoveCell> edgeTops;
	protected ArrayList<MoveCell> edgeButtoms;
	protected Color color;
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public MoveCell[] getMoveCells() {
		return cells;
	}
	public void setMoveCells(MoveCell[] cells) {
		this.cells = cells;
	}
	public Block(int positionR, int positionC) {
		super();
		cells = new MoveCell[4];
		color = Utils.getRandomColor();
	}
	
	public void drop() {
		for (int i=0; i<cells.length; i++) {
			cells[i].drop();
		}
	}
	public void moveLeft() {
		for (int i=0; i<cells.length; i++) {
			cells[i].moveLeft();
		}
	}
	public void moveRight() {
		for (int i=0; i<cells.length; i++) {
			cells[i].moveRight();
		}
	}
	public boolean isInBlock(int row,int col) {
		boolean ret = false;
		for (MoveCell cell:cells) {
			if (cell.getRow() == row && cell.getCol() == col) {
				ret = true;
				break;
			} 
		}
		return ret;
	}
	public ArrayList<MoveCell> getEdgeLefts() {
		return edgeLefts;
	}
	public ArrayList<MoveCell> getEdgeRights() {
		return edgeRights;
	}
	public ArrayList<MoveCell> getEdgeButtoms() {
		return edgeButtoms;
	}
}
