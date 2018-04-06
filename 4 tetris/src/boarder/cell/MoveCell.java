package boarder.cell;

public class MoveCell extends Cell {
	public MoveCell(int row, int col) {
		super(row, col);
	}

	public void drop() {
		row += 1;
	}
	public void moveLeft() {
		col -= 1;
	}
	public void moveRight() {
		col += 1;
	}
}
