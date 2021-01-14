import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.TextArea;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

public class MinesweeperView {
	MinesweeperController controller;
	Stage stage;
	String title;
	Image[] images;
	int x,y;
	
	//MinesweeperView initiates constructor to make view
	public MinesweeperView() {
		setPictures();
	}
	
	//Set game parameters
	public void SetOptions(Stage topLevelStage, MinesweeperController controller, int x, int y, String title) {
		this.x = x;
		this.y = y;
		this.stage = topLevelStage;
		this.controller = controller;
		this.title = title;
	}
	
	//Load pictures to images array
	public void setPictures() {
		this.images = new Image[10];
		
		for(int i = 0; i<10; i++) {
			String name ="images\\" + i + ".png";
			images[i] = new Image(name);
			
		}
	}
	
	/*
	 * Load pictures from view to game. If out of bounds, last index is returned.
	 * Input: x (array index)
	 * Output: Image from array index (x)
	 */
	public Image getPicture(int x) {
		if (!(x<this.images.length)||(x<0)) {
			x = this.images.length-1;
		}
		
		return images[x];
	}
	
	
	//Sets the stage
	public Stage basicGame() {
		this.stage.setTitle(title);
		StackPane layout = new StackPane();
		layout.getChildren().add(controller.getGrid());
		Scene scene = new Scene(layout, 23*this.x, 25*this.y);
		stage.setScene(scene);
		return stage;
	}
	
	/*
	 * Open game over window.
	 * Output: new Stage with game over window. This window contains a button, if pressed begins a new game.
	 */
	
	public void alertBox(String title, String text) {
		//controller.clearButtonAction();
		Stage window = new Stage();
		window.setTitle(title);
		//Force user to interact with window
		window.initModality(Modality.APPLICATION_MODAL);
		
		//
		Label label = new Label();
		label.setText(text);
		
		//button (Begin new game)
		Button button = new Button();
		button.setText("New game");
		button.setOnAction(e -> window.close());
		
		//Layout
		StackPane layout = new StackPane();
		layout.getChildren().addAll(label, button);
		Scene scene= new Scene(layout,200,150);
		window.setScene(scene);
		window.show();
		window.setOnCloseRequest(e -> controller.gotoNewGame());
		
	
		
	}
}
	