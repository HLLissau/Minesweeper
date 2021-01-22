import java.awt.Point;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MinesweeperController {
	MinesweeperModel model;
	MinesweeperView view;
	//children is an array which contains a map of buttons and images for JavaFX
	ObservableList<Node> children;
	GridPane grid;
	
	/*
	 * Erik
	 * Import View and highscore into controller.
	 */
	public MinesweeperController(MinesweeperModel model, MinesweeperView view) {
		this.view = view;
		this.model = model;
	}
	
	/*
	 * Erik
	 * Calls model for change in position.
	 * Input: point from view.
	 * Output: number of neighbors (9 = bombs).
	 */
	public int getNext(Point updatepoint) {
		int cell = model.getPos(updatepoint);
		return cell;	
	}
	
	/*
	 * Erik
	 * Program is informed which button the user has pressed. Checks endCondition to see if game is still operational.
	 * When button is pressed, function removes button and inserts image.
	 * Input: MinesweeperButton.
	 */
	public void buttonPressed(MinesweeperButton pressedButton) {
		grid.getChildren().remove(pressedButton);
		int cell = getNext(pressedButton.getPos());
		grid.add(new ImageView(view.getPicture(cell)), pressedButton.getPos().x, pressedButton.getPos().y);
		checkEndCondition(model, pressedButton.getPos());
		
	}
	
	/* 
	 * Harald
	 * Creates GridPane and inserts buttons. Updates ObservableList, with MinesweeperButtons.
	 * Output: New GridPane
	 */
	public GridPane getGrid() {
		grid = new GridPane();
		for (int i =0; i<model.getm(); i++) {
			for (int j =0; j<model.getn(); j++) {
				MinesweeperButton button = new MinesweeperButton(j,i);
				button.setText("  ");
				button.setOnAction(e->buttonPressed(button));
				grid.add(button, j, i);
			}
		}
		
		children = grid.getChildren();
		
		for (int i=0;i<children.size();i++) {
			MinesweeperButton button = (MinesweeperButton) children.get(i);
			button.setNeighbours(model.getm(),model.getn(),children);
		}
		
		return grid;
	}
	
	/*
	 * Erik
	 * Set model to new game with Input parameters.
	 * Input: Width,Height,Bombs,difficulty
	 */
	public void gotoNewGame(Stage thisStage) {
		model = new MinesweeperModel(model.getm(),model.getn(),model.getBombAmount());
	}
		public void gotoNewGame() {
		model = new MinesweeperModel(model.getm(),model.getn(),model.getBombAmount());
		view.basicGame();
		
		
		}

	/*
	 * Anton
	 * Remaining buttons are deactivated 
	 */
	public void clearButtonAction() {
		for (int i =0; i< ((model.getm()*model.getn())-model.getAmountClickedFields()); i++) {
			MinesweeperButton temp =(MinesweeperButton) children.get(i);
			temp.setOnAction(null);
		}
	}

	/*
	 * Anton
	 * Checks for victory and defeat condition.
	 * If endCondition value is 8, the user has won.
	 * If endCondition value is 9, the user has lost.
	 * If endCondition value is 0, the game continues.
	 * Input: Minesweeper controller and point.
	 */
	public void checkEndCondition(MinesweeperModel minesweeperModel, Point point) {
		
		int condition =model.getEndCondition();
		if (condition == 8) {
			view.alertBox("Victory", "Congratulations. You won!");
		}
		if (condition == 9) {
			view.alertBox("Game over", "You lost!");
		}
	
	}
	
}	

	