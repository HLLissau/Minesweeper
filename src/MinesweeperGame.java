import java.util.ArrayList;
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
		nearBombs();
	}
	
	public MinesweeperGame(int sizex, int sizey, int bombAmount) {
		this.knownGameState = new int[sizex][sizey] ;
		this.gameState = new int[sizex][sizey];
		this.sizex=sizex;
		this.sizey=sizey;
		randomBombGenerator(bombAmount);
		nearBombs();
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
				this.gameState[j][i]=0;
			}
		}
		int antalFelter=(this.sizex*this.sizey);
		ArrayList<Integer> brugtefelter = new ArrayList<Integer>();
		for (int i=0; i<antalBomber;i++) {
			int nextBomb= (int) (Math.random()*antalFelter);
			System.out.println("Bombe : " + nextBomb);
			int xKoordinat = nextBomb%sizex;
			int yKoordinat = nextBomb/sizey;
			System.out.println("Placering x:" + xKoordinat + ", y:" +yKoordinat);
			this.gameState[xKoordinat][yKoordinat]= 9;

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
	
	public void nearBombs() {
		for (int i = 0; i < this.sizex; i++) {
			for (int j = 0; j < this.sizey; j++) {
				if (gameState[i][j] == 9) {
					for (int k = -1; k <= 1; k++) {
						for (int l =-1; l <= 1; l++) {
							if (k!=0 || l!=0) {
								if (i+k >= 0 && i+k < this.sizey && j+l >=0 && j+l < this.sizex) {
									gameState[i+k][j+l] += 1;
									if (gameState[i+k][j+l] > 9) gameState[i+k][j+l] = 9;
								}
							}
							
						}
					}
				}
			}
		}
	}
	
	public int[][] getGameState() {
		return gameState;
	}
}


