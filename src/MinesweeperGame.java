public class MinesweeperGame{
	
	public int[][] knownGameState;
	private int[][] gameState;
	private int sizex;
	private int sizey;
	
	public MinesweeperGame() {
		this.knownGameState = new int[10][10] ;
		this.sizex=10;
		this.sizey=10;
	}

	// transfer given [x,y] set from gamestate to knowngamestate.
	public int[][] getPos( int[] position) {
		this.knownGameState[position[0]][position[1]]=this.gameState[position[0]][position[1]];
		
		
		
		return knownGameState;
	}
	public void randomBombGenerator(int antalBomber) {
		
	}
	public int getSizex() {
		return this.sizex;
	}
	public int getSizey() {
		return this.sizey;
	}
}
