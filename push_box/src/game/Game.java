package game;

import java.util.ArrayList;
import data.Boarder;
import data.Coordinate;
import data.State;

public class Game {
	private Boarder map = new Boarder();
	public Game(){}
	public int solve() {
		map.getInit();
//		map.input();
		ArrayList<State> Q = new ArrayList<>();
		State start = map.getStart();
		Q.add(start);
		map.setRemark(start);
		int ret = -1;
		Coordinate DPostions[] = Coordinate.DPosition;
		while (!Q.isEmpty()) {
			State now = Q.get(0);
			Q.remove(0);
			if (map.getType(now.getBoxPosition())== 3) {
				ret = now.getStep();//������ӵ��յ��˳�����
				break;
			}
	        for (Coordinate DPostion: DPostions){
	        	//�ĸ�����ѭ��
	        	Coordinate nextWorkerCoordinate = Coordinate.add(now.getWorkerPosition(), DPostion); 
	            if (map.judgeOutOfBound(nextWorkerCoordinate)|| 
	            	map.judgeWall(nextWorkerCoordinate)) {
	            	//Խ�������ǽ
	                continue;
	            }
	            State nextState = new State(nextWorkerCoordinate,
	            				  now.getBoxPosition(),now.getStep());
	            //�¸�λ���������ж������Ƿ�����ƶ�
	            if (nextWorkerCoordinate.equals(now.getBoxPosition())) {
	            	Coordinate nextBoxCoordinate = Coordinate.add(now.getBoxPosition(), DPostion);
	                if (!map.judgeOutOfBound(nextBoxCoordinate) && 
	                	!map.judgeWall(nextBoxCoordinate)) {
	                	nextState.setBoxPosition(nextBoxCoordinate);
		                nextState.setStep(now.getStep()+1);;
	                }
	            }
	            //�ж��Ƿ��Ѿ��������
	            if (!map.getRemark(nextState)) {
	            	map.setRemark(nextState);
		            Q.add(nextState);
	            }
	        }
		}
		return ret;
	}
}
