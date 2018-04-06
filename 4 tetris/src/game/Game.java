
package game;
import java.awt.BorderLayout;
import java.util.Scanner;
import java.util.TreeMap;
import javax.swing.JFrame;
import boarder.Boarder;
import boarder.block.*;
import utils.Utils;
import utils.operator.move.Drop;
import utils.operator.move.MoveLeft;
import utils.operator.move.MoveOperator;
import utils.operator.move.MoveRight;
import viewer.Viewer;

public class Game extends JFrame{
	private static final long serialVersionUID = 1L;
	private Boarder boarder;
	private Viewer viewer;
	//ÿ���ͷ�һ������������ص㣻
	static int startRow = -2,startCol = 2;
	//������
	private Scanner scanner = new Scanner(System.in);
	//��������
	private TreeMap<String,MoveOperator> operators = new TreeMap<>();
	private TreeMap<String, Boolean> switchs = new TreeMap<>();
	/**
	 * @param totalRow �� �ܵ�����
	 * @param totalCol �� �ܵ�����
	 */
	public Game(int totalRow, int totalCol) {
		super();
		boarder = new Boarder(totalRow,totalCol);
		viewer = new Viewer(boarder);
		setSize(viewer.getWidth()+18, viewer.getHeight()+50);
		add(viewer, BorderLayout.CENTER); 
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	private void registerAction(String cmd,MoveOperator operator) {
		operators.put(cmd, operator);
		switchs.put(cmd, false);
	}
	public void init() {
		Block moveBlock = Utils.getRandomBlock(startRow, startCol);
		boarder.setMoveBlock(moveBlock);;
		registerAction("s", new Drop());
		registerAction("a", new MoveLeft());
		registerAction("d", new MoveRight());
	}
	
	public void Run() {
		while (true) {
			boarder.upData();     //��������
			viewer.display();     //��������
			
			String operCmd = scanner.next();
			if ("asd".indexOf(operCmd)!=-1) {
				MoveOperator operator = operators.get(operCmd);
				Block block = boarder.getMoveBlock();
				if (!Utils.isOutofBound(block, boarder, operator)) {
					//�����ƶ����ƶ�
					operator.move(block);
				} else {
					//�������ƶ����������
					if (operator instanceof Drop) {
						boarder.fillCells();//�Ƚ���Ӧλ�ý������
						Block newBlock = Utils.getRandomBlock(startRow, startCol);
						boarder.setMoveBlock(newBlock);
					}
				}
			} else if (operCmd.equals("0")) {
				viewer.printMsg("�˳�");
				break;
			} else {
				viewer.printMsg("����������,����������");
			}
		}
	}
}
