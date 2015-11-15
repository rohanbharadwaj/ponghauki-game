package ponghauki;

public class Game {
	static boolean[] boardState;
	static int[][] neighbours;
	public static Game mInstance = null;

	public static Game getInstance() {
		if (mInstance == null) {
			mInstance = new Game();
		}
		return mInstance;
	}

	private Game() {
		boardState = new boolean[5];
		neighbours = new int[5][5];
		for (int i = 0; i < boardState.length; i++) {
			boardState[i] = true;
			for (int j = 0; j < boardState.length; j++) {
				neighbours[i][j] = 0;
			}
		}
		boardState[4] = false;
		neighbours[0][1] = 1;
		neighbours[0][4] = 1;
		neighbours[1][0] = 1;
		neighbours[1][2] = 1;
		neighbours[1][4] = 1;
		neighbours[2][1] = 1;
		neighbours[2][3] = 1;
		neighbours[2][4] = 1;
		neighbours[3][2] = 1;
		neighbours[3][4] = 1;
		neighbours[4][0] = 1;
		neighbours[4][1] = 1;
		neighbours[4][2] = 1;
		neighbours[4][3] = 1;
	}

	// check if player can move from pos1 to pos2(check if pos2 is neighbour of
	// pos1
	private static boolean checkValidMove(int pos1, int pos2) {
		if (neighbours[pos1][pos2] == 1)
			return true;
		return false;
	}

	private static boolean isFreePosition(int pos) {
		if (boardState[pos] == false)
			return true;
		return false;
	}

	public boolean move(int pos1, int pos2) {
		if (isFreePosition(pos2) && checkValidMove(pos1, pos2)) {
			boardState[pos1] = false;
			boardState[pos2] = true;
			return true;
		}
		return false;
	}
	//returns true if player lost the game and he can not make any move further
	public boolean isGameFinished(int pos1, int pos2){
		for(int i=0;i<boardState.length; i++){
			if(neighbours[pos1][i] == 1 && isFreePosition(i)) {
					return false;
			}
			if(neighbours[pos2][i] == 1 && isFreePosition(i))
			{
				return false;
			}
				
		}
		return true;
	}
}
