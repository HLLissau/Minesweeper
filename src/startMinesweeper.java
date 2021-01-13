import java.awt.Point;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class startMinesweeper extends Application {
	
	MinesweeperModel model;
	
	int spilTilstand;
	int x,y,bombs;
	GridPane grid;
	MinesweeperController controller;
	MinesweeperView view;
	ObservableList<Node> childrens;
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
		
		
		
	public void start(Stage topLevelStage) throws Exception {
		int spilTilstand = 0;
		x = 10;
		y = 10;
		bombs = 10;
		model = new MinesweeperModel(x,y,bombs);
		view = new MinesweeperView();
		controller = new MinesweeperController(model, view);
		
		topLevelStage = view.basicGame(topLevelStage, controller,x,y);
		
	}
	
	public static Point getNextInput(MinesweeperModel game, Scanner input) {
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
}
		
		
		