import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

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
		topLevelStage.setTitle("This is a title.");
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
	
	@Override
	public void handle(ActionEvent event) {
			
		MinesweeperButton button =(MinesweeperButton)event.getSource();
		System.out.println(button.getPos());
		grid.getChildren().remove(event.getSource());
		int cell = controller.getNext(button.getPos());
		Button text = new Button(""+ cell);
		grid.add(text, button.getPos().x, button.getPos().y);
		
		
	}
	
}
