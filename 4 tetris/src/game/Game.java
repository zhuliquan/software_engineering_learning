
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
	//每次释放一个方块的启动地点；
	static int startRow = -2,startCol = 2;
	//输入器
	private Scanner scanner = new Scanner(System.in);
	//操作集合
	private TreeMap<String,MoveOperator> operators = new TreeMap<>();
	private TreeMap<String, Boolean> switchs = new TreeMap<>();
	/**
	 * @param totalRow ： 总的行数
	 * @param totalCol ： 总的列数
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
			boarder.upData();     //更新数据
			viewer.display();     //绘制数据
			
			String operCmd = scanner.next();
			if ("asd".indexOf(operCmd)!=-1) {
				MoveOperator operator = operators.get(operCmd);
				Block block = boarder.getMoveBlock();
				if (!Utils.isOutofBound(block, boarder, operator)) {
					//可以移动则移动
					operator.move(block);
				} else {
					//不可以移动如果是下落
					if (operator instanceof Drop) {
						boarder.fillCells();//先将对应位置进行填充
						Block newBlock = Utils.getRandomBlock(startRow, startCol);
						boarder.setMoveBlock(newBlock);
					}
				}
			} else if (operCmd.equals("0")) {
				viewer.printMsg("退出");
				break;
			} else {
				viewer.printMsg("输入有问题,请重新输入");
			}
		}
	}
}
