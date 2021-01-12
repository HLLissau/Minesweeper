import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MinesweeperView implements EventHandler<ActionEvent> {
	MinesweeperController controller;
	GridPane grid;
	int x,y;
	
	public MinesweeperView(int x, int y,MinesweeperController controller) {
		this.x = x;
		this.y = y;
		controller = this.controller;
	}
	
	
	public void loadstage(Stage topLevelStage) {
		int spilTilstand = 0;
		topLevelStage.setTitle("Minesweeper");
		StackPane layout = new StackPane();
		grid = new GridPane();
		for (int i =0; i<this.y; i++) {
			for (int j =0; j<this.x; j++) {
				MinesweeperButton button = new MinesweeperButton(j,i);
				button.setText("");
				button.setOnAction(this);
				grid.add(button, j, i);
			}
		}
				
		layout.getChildren().add(grid);
		
		
		System.out.println("End of start method");
		
		Scene scene = new Scene(layout, 350,300);
		topLevelStage.setScene(scene);
		topLevelStage.show();
		
	
	}
	
	public void handle(ActionEvent event) {
			
		MinesweeperButton button =(MinesweeperButton)event.getSource();
		System.out.println(button.getPos());
		grid.getChildren().remove(event.getSource());
		int cell = controller.getNext(button.getPos());
		Button text = new Button(""+ cell);
		grid.add(new ImageView(pictures()[9]), button.getPos().x, button.getPos().y);
		
		
	}
	
}
