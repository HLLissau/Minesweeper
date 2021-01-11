

import java.awt.Point;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Snakefx extends Application implements EventHandler<ActionEvent>{
	
	
	
	public static void main(String[] args) {
		launch(args);
		System.out.println("after launch");
	}

	

	@Override
	public void start(Stage topLevelStage) throws Exception {
		topLevelStage.setTitle("This is a title.");
		StackPane layout = new StackPane();
		GridPane grid = new GridPane();
		for (int i =0; i<20; i++) {
			for (int j =0; j<20; j++) {
				Button button = new Button();
				button.setText("" +j +", "+ i);
				button.setOnAction(this);
				
				grid.add(button, j, i);
			}
		}
				
		layout.getChildren().add(grid);
		
		
		System.out.println("End of start method");
		
		Scene scene = new Scene(layout, 300,250);
		topLevelStage.setScene(scene);
		topLevelStage.show();
	
	}



	@Override
	public void handle(ActionEvent event) {
		//if (event.getSource()==button) {
			System.out.println("Test" + );
		//}
	}

		
	
	

	
	
}


