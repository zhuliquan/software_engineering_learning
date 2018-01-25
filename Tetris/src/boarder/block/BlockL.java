package boarder.block;

import java.util.ArrayList;

import boarder.cell.MoveCell;

public class BlockL extends Block {

	@Override
	public String toString() {
		return super.toString()+"L";
	}

	public BlockL(int positionR, int positionC) {
		super(positionR, positionC);
		int R = positionR;
		int C = positionC;
		cells[0] = new MoveCell(R,C);
		cells[1] = new MoveCell(R+1,C);
		cells[2] = new MoveCell(R+2,C);
		cells[3] = new MoveCell(R+2,C+1);
		
		edgeLefts = new ArrayList<MoveCell>();
		edgeLefts.add(cells[0]);
		edgeLefts.add(cells[1]);
		edgeLefts.add(cells[2]);
		
		edgeRights = new ArrayList<MoveCell>();
		edgeRights.add(cells[0]);
		edgeRights.add(cells[1]);
		edgeRights.add(cells[3]);
		
		edgeTops = new ArrayList<MoveCell>();
		edgeTops.add(cells[0]);
		
		edgeButtoms = new ArrayList<MoveCell>();
		edgeButtoms.add(cells[2]);
		edgeButtoms.add(cells[3]);
	}

}
