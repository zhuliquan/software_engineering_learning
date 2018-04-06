package viewer;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import boarder.BackGround;
import boarder.Boarder;

public class Viewer extends JPanel{
	private static final long serialVersionUID = 1L;

	private Boarder boarder;
	private int gridSize;
	private int winHeight;
	private int winWidth;
	/**
	 * @param boarder �� ���
	 */
	public Viewer(Boarder boarder) {
		this.boarder = boarder;
		gridSize = 30;
		winHeight = gridSize * boarder.getTotalRow();
		winWidth = gridSize * boarder.getTotalCol();
		setSize(winWidth, winHeight);		
	}
	public int getGridSize() {
		return gridSize;
	}
	public void setGridSize(int gridSize) {
		this.gridSize = gridSize;
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		int totalRow = boarder.getTotalRow();
		int totalCol = boarder.getTotalCol();
		BackGround background = boarder.getBackground();
		//��������
		g.setColor(Color.BLACK);
		for (int row=0; row<=totalRow; row++) {
			g.drawLine(0, row*gridSize, winWidth, row*gridSize);
		}
		for (int col=0; col<=totalCol; col++) {
			g.drawLine(col*gridSize,0, col*gridSize,winHeight);
		}		
		//���Ʒ���
		for (int row=0; row < totalRow; row++) {
			for (int col=0; col < totalCol; col++) {
				if (!background.getCellEmpty(row, col) ||
					background.getCellUsed(row, col)) {
					g.setColor(background.getCellColor(row,col));
					g.fillRect(col*gridSize, row*gridSize, gridSize, gridSize);
				}
			}
		}
	}
	public void display() {
		repaint();
		printMsg("--------------Game--------------");
		printMsg("a-����,s-����,d-����,0-�˳�");
	}
	public void printMsg(String msg) {
		System.out.println(msg);
	}

}

