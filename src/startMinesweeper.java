import java.awt.Point;
import java.util.Arrays;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class startMinesweeper {
	


	// Main program file. Contains main and controllor
	
		
		public static void main(String[] args) {
			
			preconfiguration();
			introduction();
			mainMenu();
		}
		public static void preconfiguration() {
			
		}
		public static void introduction() {
			
		}
		public static void mainMenu() {
			MinesweeperGame game = new MinesweeperGame(10, 10, 98);
			//point size= game.getSize();
			int spilTilstand = 0;
			for(;;) {
				Scanner input= new Scanner(System.in);
				Point nextTile= getNextInput(game, input);
				game.getPos(nextTile);
				//test new pos
				spilTilstand=game.testConditions(nextTile);
				if (spilTilstand == 9 || spilTilstand == 8) {
					break;
				}
				showGameState(game);
				System.out.println();
				gameState(game);
			}
			if (spilTilstand == 8) {
				victory();
			}
			if (spilTilstand == 9) {
				defeat();
			}
			
		}
		public static void victory() {
			System.out.println("Victory Royale!");
		}
		public static void defeat() {
			System.out.println("Defeat screen :(");
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
			GridPane.
			//}
		}
}