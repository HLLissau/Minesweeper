import java.awt.Point;
import java.util.ArrayList;
public class MinesweeperGame{
	
	public int[][] knownGameState;
	private int[][] gameState;
	private int sizex;
	private int sizey;
	private int vendteFelter;
	private int antalBomber;
	private ArrayList<Point> ledigefelter;
	
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
	//sikre første felt markeret ikke indeholder en bombe.
	public MinesweeperGame(int sizex, int sizey, int bombAmount, Point firstClicked) {
		this.knownGameState = new int[sizex][sizey] ;
		this.gameState = new int[sizex][sizey];
		this.sizex=sizex;
		this.sizey=sizey;
		ledigefelter.add(firstClicked);
		randomBombGenerator(bombAmount);
		nearBombs();
	}
 
	// transfer given [x,y] set from gamestate to knowngamestate.
	public int[][] getPos( int[] position) {
		this.knownGameState[position[0]][position[1]]=this.gameState[position[0]][position[1]];
		vendteFelter += 1;
		
		
		return knownGameState;
	}
	// genererer alle felter til 0, herefter indsættes bomber
	public void randomBombGenerator(int antalBomber) {
		this.antalBomber=antalBomber;
		//laver liste af ledige felter til pladsering af bomber
		int antalFelter=(this.sizex*this.sizey);
		ledigefelter = new ArrayList<Point>();
				
		
		
		//Sætter array felter til 0
		for (int i=0; i<this.sizey; i++) {
			for ( int j=0; j<this.sizex;j++) {
				this.gameState[j][i]=0;
				ledigefelter.add(new Point(j,i));
			}
		}
		
		//placeret bomberne og fjerne feltet fra Arraylist. Sikre at ingen bomber bliver placeret på samme felt
		for (int i=0; i<antalBomber;i++) {
			int nextBomb= (int) (Math.random()*(antalFelter-i));
			Point nextBombPlacement = ledigefelter.remove(nextBomb);
			this.gameState[nextBombPlacement.x][nextBombPlacement.y]= 9;

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
		for (int i = 0; i < this.sizey; i++) {
			for (int j = 0; j < this.sizex; j++) {
				if (gameState[j][i] == 9) {
					for (int k = -1; k <= 1; k++) {
						for (int l =-1; l <= 1; l++) {
							if (k!=0 || l!=0) {
								if (i+k >= 0 && i+k < this.sizey && j+l >=0 && j+l < this.sizex) {
									gameState[j+l][i+k] += 1;
									if (gameState[j+l][i+k] > 9) gameState[j+l][i+k] = 9;
									
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


