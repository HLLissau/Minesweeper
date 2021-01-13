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
	Stage stage;
	String title;
	Image[] images;
	int x,y;
	
	
	public MinesweeperView() {
		setPictures();
	}
	public MinesweeperView(int x, int y) {
		this.x = x;
		this.y = y;
		setPictures();
				
	}
	public void SetOptions(Stage topLevelStage, MinesweeperController controller, int x, int y, String title) {
		this.x = x;
		this.y = y;
		this.stage = topLevelStage;
		this.controller = controller;
		this.title = title;
	}
	public void setPictures() {
		this.images = new Image[10];
		
		for(int i = 0; i<10; i++) {
			String name = i + ".png";
			images[i] = new Image(name);
			
		}
	}

	public Image getPicture(int x) {
		return images[x];
	}
	
	
	
	public Stage basicGame() {
		
		this.stage.setTitle(title);
		StackPane layout = new StackPane();
		
		this.controller = controller;
		grid = controller.getGrid();
		
				
		layout.getChildren().add(grid);
		
		//childrens = grid.getChildren();
		//System.out.println("End of start method" + childrens);
		
		Scene scene = new Scene(layout, 23*this.x, 25*this.y);
		stage.setScene(scene);
		//topLevelStage.show();
		return stage;
	}
	
	
	public Stage gameOver() {
		System.out.println("Test");
		
		Stage gameOverScreen = new Stage();
		gameOverScreen.setTitle("Game Over");
		
		//button
		Button button = new Button();
		button.setText("New game");
		button.setOnAction(e -> controller.gotoNewGame(gameOverScreen));
		
		//Layout
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		
		Scene scene= new Scene(layout,200,150);
		gameOverScreen.setScene(scene);
		gameOverScreen.show();
		stopGame();
		return gameOverScreen;
	}
	public Stage victory() {
		
		Stage gameOverScreen = new Stage();
		gameOverScreen.setTitle("Victory");
		
		//button
		Button button = new Button();
		button.setText("New game");
		button.setOnAction(e -> controller.gotoNewGame(gameOverScreen));
		
		//Layout
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		
		Scene scene= new Scene(layout,200,150);
		gameOverScreen.setScene(scene);
		gameOverScreen.show();
		stopGame();
		return gameOverScreen;
	}
	public void stopGame() {
		for (int i =0; i< childrens.size();i++) {
			MinesweeperButton temp =(MinesweeperButton) childrens.get(i);
			temp.setOnAction(null);
		}
	}
	
}
