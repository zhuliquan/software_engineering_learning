package game;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Game game = new Game();
		Scanner scanner = new Scanner(System.in);
//		int epoches = scanner.nextInt();
		int  epoches = 1;
		for (int epoche=0; epoche < epoches; epoche++) {
			System.out.println(game.solve());
		}
		scanner.close();
	}

}
