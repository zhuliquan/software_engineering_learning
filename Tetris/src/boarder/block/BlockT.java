package boarder.block;

import java.util.ArrayList;

import boarder.cell.MoveCell;

public class BlockT extends Block{
	@Override
	public String toString() {
		return super.toString()+"T";
	}

	/**
	 * @param positionR
	 * @param positionC
	 */
	public BlockT(int positionR, int positionC) {
		super(positionR,positionC);
		int R = positionR;
		int C = positionC;
		cells[0] = new MoveCell(R,C);
		cells[1] = new MoveCell(R,C+1);
		cells[2] = new MoveCell(R,C+2);
		cells[3] = new MoveCell(R+1,C+1);
		
		edgeLefts = new ArrayList<MoveCell>();
		edgeLefts.add(cells[0]);
		edgeLefts.add(cells[3]);
		
		edgeRights = new ArrayList<MoveCell>();
		edgeRights.add(cells[2]);
		edgeRights.add(cells[3]);
		
		edgeTops = new ArrayList<MoveCell>();
		edgeTops.add(cells[0]);
		edgeTops.add(cells[1]);
		edgeTops.add(cells[2]);
		
		edgeButtoms = new ArrayList<MoveCell>();
		edgeButtoms.add(cells[0]);
		edgeButtoms.add(cells[2]);
		edgeButtoms.add(cells[3]);
	}
}
