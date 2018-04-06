package boarder.block;

import java.util.ArrayList;

import boarder.cell.MoveCell;

public class BlockO extends Block {

	@Override
	public String toString() {
		return super.toString()+"O";
	}

	public BlockO(int positionR, int positionC) {
		super(positionR, positionC);
		int R = positionR;
		int C = positionC;
		cells[0] = new MoveCell(R,C);
		cells[1] = new MoveCell(R,C+1);
		cells[2] = new MoveCell(R+1,C+1);
		cells[3] = new MoveCell(R+1,C);
		
		edgeLefts = new ArrayList<MoveCell>();
		edgeLefts.add(cells[0]);
		edgeLefts.add(cells[3]);
		
		edgeRights = new ArrayList<MoveCell>();
		edgeRights.add(cells[1]);
		edgeRights.add(cells[2]);
		
		edgeTops = new ArrayList<MoveCell>();
		edgeTops.add(cells[0]);
		edgeTops.add(cells[1]);
		
		edgeButtoms = new ArrayList<MoveCell>();
		edgeButtoms.add(cells[2]);
		edgeButtoms.add(cells[3]);
	}

}
