public class MinesweeperGame{
	
	public int[][] knownGameState;
	private int[][] gameState;
	private int sizex;
	private int sizey;
	
	public MinesweeperGame() {
		this.knownGameState = new int[10][10] ;
		this.gameState = new int[10][10] ;
		this.sizex=10;
		this.sizey=10;
		randomBombGenerator(10);
	}

	// transfer given [x,y] set from gamestate to knowngamestate.
	public int[][] getPos( int[] position) {
		this.knownGameState[position[0]][position[1]]=this.gameState[position[0]][position[1]];
		
		
		
		return knownGameState;
	}
	// genererer alle felter til 0, herefter inds�ttes bomber
	public void randomBombGenerator(int antalBomber) {
		for (int i=0; i<this.sizey; i++) {
			for ( int j=0; j<this.sizex;j++) {
				this.gameState[j][i]=1;
			}
		}
	}
	public int getSizex() {
		return this.sizex;
	}
	public int getSizey() {
		return this.sizey;
	}
}
