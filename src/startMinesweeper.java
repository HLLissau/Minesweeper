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
		
		view = new MinesweeperView();
		model = new MinesweeperModel(x,y,bombs);
		controller = new MinesweeperController(model, view);
		
		view.SetOptions(topLevelStage, controller, x, y, "basicgame");
		topLevelStage = view.basicGame();
		topLevelStage.show();
	}
}
		
		
		