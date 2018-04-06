package data;

import java.util.Scanner;

public class Boarder {
	private int data[][];
	private int M,N;
	private boolean remark[][][][];
	private State start;
	public State getStart() {
		return start;
	}
	public void setStart(State start) {
		this.start = start;
	}
	public Boarder() {
		start = new State();
	}
	public void getInit() {
		M = 5;N = 5;
		data = new int[M][N];
		remark = new boolean[M][N][M][N];
		data[0][0] = 0;data[0][1] = 3;data[0][2] = 0;data[0][3] = 0;data[0][4] = 0;
		data[1][0] = 1;data[1][1] = 0;data[1][2] = 1;data[1][3] = 4;data[1][4] = 0;
		data[2][0] = 0;data[2][1] = 0;data[2][2] = 1;data[2][3] = 0;data[2][4] = 0;
		data[3][0] = 1;data[3][1] = 0;data[3][2] = 2;data[3][3] = 0;data[3][4] = 0;
		data[4][0] = 0;data[4][1] = 0;data[4][2] = 0;data[4][3] = 0;data[4][4] = 0;
		for (int wx=0; wx<M; wx++) {
			for (int wy=0; wy<N; wy++) {				
				if (data[wx][wy] == 4) {
					start.setWorkerPosition(new Coordinate(wx, wy));
				}
				if (data[wx][wy] == 2) {
					start.setBoxPosition(new Coordinate(wx, wy));
				}
				for (int bx=0; bx<M; bx++) {
					for (int by=0; by<N; by++) {
						remark[wx][wy][bx][by] = false;
					}
				}
			}
		}
		start.setStep(0);
	}
	public void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("ÊäÈë³¤");
		M = scanner.nextInt();
		System.out.println("ÊäÈë¿í");
		N = scanner.nextInt();
		data = new int[M][N];
		remark = new boolean[M][N][M][N];
		for (int wx=0; wx<M; wx++) {
			for (int wy=0; wy<N; wy++) {
				data[wx][wy] = scanner.nextInt();
				if (data[wx][wy] == 4) {
					start.setWorkerPosition(new Coordinate(wx, wy));
				}
				if (data[wx][wy] == 2) {
					start.setBoxPosition(new Coordinate(wx, wy));
				}
				for (int bx=0; bx<M; bx++) {
					for (int by=0; by<N; by++) {
						remark[wx][wy][bx][by] = false;
					}
				}
			}
		}
		scanner.close();
		start.setStep(0);
	}
	public void setRemark(Coordinate worker,Coordinate box){
		remark[worker.getX()][worker.getY()][box.getX()][box.getY()] = true;
	}
	public void setRemark(State s){
		setRemark(s.getWorkerPosition(),s.getBoxPosition());
	}
	public boolean getRemark(State s) {
		return getRemark(s.getWorkerPosition(),s.getBoxPosition());
	}
	public boolean getRemark(Coordinate worker,Coordinate box){
		return remark[worker.getX()][worker.getY()][box.getX()][box.getY()];
	}
	public int getType(Coordinate coordinate) {
		return getType(coordinate.getX(),coordinate.getY());
	}
	public int getType(int x,int y) {
		return data[x][y];
	}
	public int getBoundX() {
		return M;
	}
	public int getBoundY() {
		return N;
	}
	public boolean judgeOutOfBound(Coordinate coordinate) {
		boolean ret = false;
		if (coordinate.getX() < 0 || coordinate.getX() >= getBoundX() ||
			coordinate.getY() < 0 || coordinate.getY() >= getBoundY()) {
			ret = true;
		}
		return ret;
	}
	public boolean judgeWall(Coordinate coordinate) {
		return getType(coordinate) == 1;
	}
}
