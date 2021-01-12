import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class Testfil extends Application implements EventHandler<ActionEvent> {
	
	MinesweeperGame game;
	int spilTilstand;
	// Main program file. Contains main and controllor
	
		
		public static void main(String[] args) {
			launch(args);
		}
		public static void victory() {
			System.out.println("Victory Royale!");
		}
		public static void defeat() {
			System.out.println("Defeat screen :(");
		}
		
		
		@Override
		public void start(Stage topLevelStage) throws Exception {
			int spilTilstand = 0;
			game = new MinesweeperGame(10, 10, 10);
			topLevelStage.setTitle("This is a title.");
			StackPane layout = new StackPane();
			GridPane grid = new GridPane();
			for (int i =0; i<10; i++) {
				for (int j =0; j<10; j++) {
					MinesweeperButton button = new MinesweeperButton(j,i);
					button.setText("" +j +", "+ i);
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
		
		public static Point getNextInput(MinesweeperGame game, Scanner input) {
			System.out.println("Enter x and y coordinates");
			Point nextInput = new Point(getUserInt(input,0,game.getSizex()-1), getUserInt(input,0,game.getSizey()-1)); 
			System.out.println("You entered: x=" + nextInput.x + ", y=" + nextInput.y);
			return nextInput;
			}
		//check a given int input is in range between min and max
		public static int getUserInt(Scanner f, int min, int max) {
			int i = 0;
		    while (true) {

		    	while (!f.hasNextInt()) {
		                f.next();
		        }
		        i = f.nextInt();
		        if (min <= i && i <= max) {
		        	break;
		        }
		    }
		    return i;
		}

		@Override
		public void handle(ActionEvent event) {
				
			MinesweeperButton button =(MinesweeperButton)event.getSource();
			System.out.println(button.getPos());
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

	
		
		//test of push
		
		public static void showGameState(MinesweeperGame game) {
			for (int i=game.getSizey();i>0; i--) {
				for ( int j=0; j<game.getSizex();j++) {
					System.out.print(game.knownGameState[j][i-1]);
				}
			System.out.println();	
			}
		}
		
		public static void gameState(MinesweeperGame game) {
			for (int i=game.getSizey();i>0; i--) {
				for ( int j=0; j<game.getSizex();j++) {
					System.out.print(game.getGameState()[j][i-1]);
				}
			System.out.println();	
			}
		}
	}
