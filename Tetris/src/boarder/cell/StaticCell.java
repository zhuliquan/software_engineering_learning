package boarder.cell;
public class StaticCell extends Cell {
	protected boolean isEmpty;
	protected boolean isUsed;
	public StaticCell(int row, int col) {
		super(row, col);
		isEmpty = true;
		isUsed = false;
	}
	public boolean isEmpty() {
		return isEmpty;
	}
	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
	public boolean isUsed() {
		return isUsed;
	}
	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}
}
