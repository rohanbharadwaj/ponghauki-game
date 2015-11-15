package ponghauki;

import java.util.Scanner;

public class DriverTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game g = Game.getInstance();
		Player p1 = new Player(0, 3);
		Player p2 = new Player(1, 2);
		Scanner sc = new Scanner(System.in);
		while(!isGameFinished(g, p1, p2))
		{
			System.out.println("Player1: Which goti you want to move");
			int coinNum = sc.nextInt();
			System.out.println("Player1: which pos you want to move");
			int pos = sc.nextInt();
			System.out.println();
			if(g.move(p1.getPos(coinNum-1), pos)){
				System.out.println("Player1: moved " + coinNum + " to pos " + pos);
				p1.setPos(coinNum-1, pos);
			}
			else {
				System.out.println("Wrong move");
			}
			/* player 2 */
			System.out.println("Player2: Which goti you want to move");
			coinNum = sc.nextInt();
			System.out.println("Player2: which pos you want to move coin " + coinNum);
			pos = sc.nextInt();
			if(g.move(p2.getPos(coinNum-1), pos)){
				System.out.println("Player2: moved " + coinNum + " to pos " + pos);
				p2.setPos(coinNum-1, pos);
			}
			else {
				System.out.println("Wrong move");
			}
			System.out.println("Current board state is ");
			System.out.println("Player1: ");
			System.out.println(p1.getPos(0) + ", " + p1.getPos(1));
			System.out.println("Player2: ");
			System.out.println(p2.getPos(0) + ", " + p2.getPos(1));
		}
		if(g.isGameFinished(p1.getPos(0), p1.getPos(1)))
			System.out.println("Player 2 won");
		else
			System.out.println("Player 1 won");
		sc.close();
	}
	
	public static boolean isGameFinished(Game g, Player p1, Player p2){
		return g.isGameFinished(p1.getPos(0), p1.getPos(1)) || 
				g.isGameFinished(p2.getPos(0), p2.getPos(1));
		
	}

}
