import javafx.event.ActionEvent;

public class MinesweeperController {
	MinesweeperGame game;
	MinesweeperView view;
	
	public void main (String args[]) {
		game = new MinesweeperGame(10, 10, 10);
		view = new MinesweeperView(10, 10);
	}
}
