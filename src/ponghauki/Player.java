package ponghauki;

import java.util.ArrayList;

public class Player {
	private int pos[];
	public Player(int pos1, int pos2) {
		// TODO Auto-generated constructor stub
		pos = new int[2];
		this.pos[0] = pos1;
		this.pos[1] = pos2;
	}
	
	public int getPos(int coinNum){
		return pos[coinNum];
	}
	public void setPos(int coinNum, int pos) {
		this.pos[coinNum] = pos;
	}
	
	
}

