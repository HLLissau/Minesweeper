public class MinesweeperGame{
	
	public int[][] knownGameState;
	private int[][] gameState;
	private int sizex;
	private int sizey;
	private int vendteFelter;
	private int antalBomber;
	
	public MinesweeperGame() {
		this.knownGameState = new int[10][10] ;
		this.gameState = new int[10][10] ;
		this.sizex=10;
		this.sizey=10;
		this.vendteFelter=0;
		randomBombGenerator(10);
	}

	// transfer given [x,y] set from gamestate to knowngamestate.
	public int[][] getPos( int[] position) {
		this.knownGameState[position[0]][position[1]]=this.gameState[position[0]][position[1]];
		vendteFelter += 1;
		
		
		return knownGameState;
	}
	// genererer alle felter til 0, herefter inds�ttes bomber
	public void randomBombGenerator(int antalBomber) {
		this.antalBomber=antalBomber;
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
	public boolean victoryCondition() {
		return ((this.sizex*this.sizey)-this.antalBomber == this.vendteFelter);
	}
	public boolean defeatCondition(int x, int y) {
		return gameState[x][y] == 9;
	}
	public int testConditions(int[] nextTile) {
		if (defeatCondition(nextTile[0], nextTile[1])) {
			return 9;
		}
		if (victoryCondition()) {
			return 8;
		}
		return 0;
	}
	
}


