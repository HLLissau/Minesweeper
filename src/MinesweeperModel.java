import java.awt.Point;
import java.util.ArrayList;
public class MinesweeperModel{
	
	public int[][] knownGameState;
	private int[][] gameState;
	private int sizex;
	private int sizey;
	private int bombAmount;
	private int firstClicked;
	private int clickedFields;
	private ArrayList<Point> availableFields;
	
	public MinesweeperModel() {
		this.knownGameState = new int[10][10] ;
		this.gameState = new int[10][10] ;
		this.sizex=10;
		this.sizey=10;
		this.clickedFields=0;
		this.bombAmount= 10;
		firstClicked=1;
	}
	
	public MinesweeperModel(int sizex, int sizey, int bombAmount) {
		this.knownGameState = new int[sizex][sizey] ;
		this.gameState = new int[sizex][sizey];
		this.sizex=sizex;
		this.sizey=sizey;
		this.clickedFields=0;
		this.bombAmount= bombAmount;
		firstClicked=1;
	}
	
 
	// transfer given [x,y] set from gamestate to knowngamestate.
	public int getPos( Point nextPos) {
		if (firstClicked ==1) {
			firstClicked =0;
			randomBombGenerator(bombAmount, nextPos );
			nearBombs();
			
		}
		
		this.knownGameState[nextPos.x][nextPos.y]=this.gameState[nextPos.x][nextPos.y];
		clickedFields += 1;
		int cell = this.knownGameState[nextPos.x][nextPos.y];
		
		return cell;
	}
	// genererer alle felter til 0, herefter inds�ttes bomber
	public void randomBombGenerator(int bombAmount, Point firstClicked) {
		this.bombAmount=bombAmount;
		//laver liste af ledige felter til pladsering af bomber
		int fieldAmount=(this.sizex*this.sizey);
		this.availableFields = new ArrayList<Point>();
		
		//S�tter array felter til 0
		for (int i=0; i<this.sizey; i++) {
			for ( int j=0; j<this.sizex;j++) {
				this.gameState[j][i]=0;
				availableFields.add(new Point(j,i));
			}
		}
		availableFields.remove(firstClicked.x+this.sizex*firstClicked.y);
		
		//placeret bomberne og fjerne feltet fra Arraylist. Sikre at ingen bomber bliver placeret p� samme felt
		for (int i=0; i<bombAmount;i++) {
			int nextBomb= (int) (Math.random()*(fieldAmount-i-1));
			Point nextBombPlacement = availableFields.remove(nextBomb);
			this.gameState[nextBombPlacement.x][nextBombPlacement.y]= 9;

		}
	}
	public int getSizex() {
		return this.sizex;
	}
	public int getSizey() {
		return this.sizey;
	}
	public int getBombAmount() {
		return this.bombAmount;
	}
	public int getAmountClickedFields() {
		return this.clickedFields;
	}
	public boolean victoryCondition() {
		return ((this.sizex*this.sizey)-this.bombAmount == this.clickedFields);
	}
	public boolean defeatCondition(int x, int y) {
		return gameState[x][y] == 9;
	}
	public int testConditions(Point nextTile) {
		if (defeatCondition(nextTile.x, nextTile.y)) {
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


