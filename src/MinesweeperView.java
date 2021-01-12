import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MinesweeperView extends Application implements EventHandler<ActionEvent> {
	int spilTilstand;
	GridPane grid;
	int x, y;
	
	public MinesweeperView(int x, int y) {
		this.x = x;
		this.y = y;
		launch();
	}
	
	@Override
	public void start(Stage topLevelStage) throws Exception {
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
		gameState(game);
		System.out.println();
		showGameState(game);
		spilTilstand=game.testConditions(button.getPos());
		game.getPos(button.getPos());
		if (spilTilstand == 8) {
			victory();
		}
		if (spilTilstand == 9) {
			defeat();
		}
	}
	
}
