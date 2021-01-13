import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;


public class MinesweeperView {
	MinesweeperController controller;
	GridPane grid;
	ObservableList<Node> childrens;
	int x,y;
	
	public MinesweeperView() {

	}
	
	public Image[] pictures() {
		Image[] pictures = new Image[10];
		
		for(int i = 1; i<10; i++) {
			String name = i + ".png";
			pictures [i] = new Image(name);
			
		}
		return pictures;	
	}
	
	public Stage basicGame(Stage topLevelStage, MinesweeperController controller, int x, int y) {
		this.x = x;
		this.y = y;
		topLevelStage.setTitle("Minesweeper(Basic).");
		StackPane layout = new StackPane();
		
		this.controller = controller;
		grid = controller.getGrid();
		
				
		layout.getChildren().add(grid);
		
		childrens = grid.getChildren();
		System.out.println("End of start method" + childrens);
		
		Scene scene = new Scene(layout, 23*this.x, 25*this.y);
		topLevelStage.setScene(scene);
		topLevelStage.show();
		return topLevelStage;
	}
	
	public Stage gameOver() {
		Stage gameOverScreen = new Stage();
		gameOverScreen.setTitle("Game Over");
		
		//button
		Button button = new Button();
		button.setText("New game");
		//button.setOnAction(e -> controller.gotoNewGame());
		
		//Layout
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		
		Scene scene= new Scene(layout,200,150);
		gameOverScreen.setScene(scene);
		gameOverScreen.show();
		return gameOverScreen;
	}

	
}
