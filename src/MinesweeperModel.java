import java.awt.Point;
import java.util.ArrayList;

//Model class containing game
public class MinesweeperModel{
	public int[][] knownGameState;
	private int[][] gameState;
	private int sizex;
	private int sizey;
	private int bombAmount;
	private int isGameStarted;
	private int clickedFields;
	private ArrayList<Point> availableFields;
	private int endCondition;
	
	/*
	 * Creates a standard (n x m) game with x bombs
	 * Input: Game size given as x and y, along with amount of bombs.
	 */
	public MinesweeperModel(int sizex, int sizey, int bombAmount) {
		this.knownGameState = new int[sizex][sizey] ;
		this.gameState = new int[sizex][sizey];
		this.sizex=sizex;
		this.sizey=sizey;
		this.clickedFields=0;
		this.bombAmount= bombAmount;
		isGameStarted=1;
	}
	
	/*
	 * transfer given [x,y] set from gamestate to knowngamestate.
	 * Input: Point position to update
	 * Output: number of neighbors (9 = bombs).
	 */
	public int getPos( Point nextPos) {
		if (isGameStarted ==1) {
			isGameStarted =0;
			randomBombGenerator(bombAmount, nextPos );
			nearBombs();
			
		}
		
		this.knownGameState[nextPos.x][nextPos.y]=this.gameState[nextPos.x][nextPos.y];
		clickedFields += 1;
		int cell = this.knownGameState[nextPos.x][nextPos.y];
		
		testConditions(nextPos);
		return cell;
	}
	
	/*
	 * Sets all elements in gameState[][] to 0, bombs are inserted hereafter randomly.
	 * Creates list of unoccupied fields for placement of bombs.
	 * For each iteration of the loop, puts a bomb on an unoccupied field, and removes field from list.
	 * Bombs are represented by the number 9.
	 * Generates gameState after user makes first click to ensure game is not lost in first click.
	 * Input: Number of bombs, first clicked element by user.
	 */
	public void randomBombGenerator(int bombAmount, Point firstClicked) {
		this.bombAmount=bombAmount;
		int fieldAmount=(this.sizex*this.sizey);
		this.availableFields = new ArrayList<Point>();
		for (int i=0; i<this.sizey; i++) {
			for ( int j=0; j<this.sizex;j++) {
				this.gameState[j][i]=0;
				availableFields.add(new Point(j,i));
			}
		}
		availableFields.remove(firstClicked.x+this.sizex*firstClicked.y);
		for (int i=0; i<bombAmount;i++) {
			int nextBomb= (int) (Math.random()*(fieldAmount-i-1));
			Point nextBombPlacement = availableFields.remove(nextBomb);
			this.gameState[nextBombPlacement.x][nextBombPlacement.y]= 9;

		}
	}
	
	/*
	 * Iterates through gameState[][] looking for bombs.
	 * For each bomb the neighbors value is increased by one, except if it is already a bomb.
	 */
	public void nearBombs() {
		for (int i = 0; i < this.sizey; i++) {
			for (int j = 0; j < this.sizex; j++) {
				if (gameState[j][i] == 9) {
					for (int k = -1; k <= 1; k++) {
						for (int l =-1; l <= 1; l++) { 
							//The following if statement ensures that the program stays within the array
							if (i+k >= 0 && i+k < this.sizey && j+l >=0 && j+l < this.sizex) {
								gameState[j+l][i+k] += 1;
								if (gameState[j+l][i+k] > 9) {
									gameState[j+l][i+k] = 9;
								}
							}
						}
					}
				}
			}
		}
	}
	public void testConditions(Point nextTile) {
		if (defeatCondition(nextTile.x, nextTile.y)) {
			this.endCondition =9;
		} else if (victoryCondition()) {
			this.endCondition =8;
		} 
	}

	//The remaining functions are used to get game parameters
	public int getSizex() {
		return this.sizex;
	}
	
	public int getSizey() {
		return this.sizey;
	}
	
	public int[][] getGameState() {
		return gameState;
	}

	
	public int getBombAmount() {
		return this.bombAmount;
	}
	
	public int getAmountClickedFields() {
		return this.clickedFields;
	}
	
	private boolean victoryCondition() {
		return ((this.sizex*this.sizey)-this.bombAmount == this.clickedFields);
	}
	
	private boolean defeatCondition(int x, int y) {
		return gameState[x][y] == 9;
	}
	public int getEndCondition() {
		return this.endCondition;
	}
	
}
