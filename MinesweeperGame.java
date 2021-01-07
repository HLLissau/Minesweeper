public class MinesweeperGame{
	
	public int[][] knownGameState;
	private int[][] gameState;
	private Point size;
	
	public MinesweeperGame() {
		this.knownGameState = new int[10][10] ;
		this.size= new Point(10,10);
	}

	
	public int[][] getPos() {
		
		
		
		return knownGameState;
	}
	public void randomBombGenerator(int antalBomber) {
		
	}
	public point getSize() {
		return this.size;
	}
	
}
