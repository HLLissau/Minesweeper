import java.awt.Point;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MinesweeperController {
	MinesweeperModel model;
	MinesweeperView view;
	ObservableList<Node> childrens;
	GridPane grid;
	int gameState;
	
	
	
	public MinesweeperController(MinesweeperModel model, MinesweeperView view) {
		this.view = view;
		this.model = model;
	}
	
	public int getNext(Point updatepoint) {
		
		int cell = model.getPos(updatepoint);
		
	return cell;	
	}
	
	public void checkGameState(int gamestate) {
		this.gameState=gamestate;
		if (gameState == 8) {
			view.victory();
		}
		if (gameState == 9) {
			view.gameOver();
		}
	
	}
	public int buttonPressed(MinesweeperButton mbutton) {
		//MinesweeperButton button =mbutton;
		
		//System.out.println(button.getPos());
		grid.getChildren().remove(mbutton);
		int cell = getNext(mbutton.getPos());
		grid.add(new ImageView(view.getPicture(cell)), mbutton.getPos().x, mbutton.getPos().y);
		
		//int gameState = model.testConditions(button.getPos());
		
		//childrens = grid.getChildren();
		if (cell==0) {
			ArrayList<MinesweeperButton> temp = mbutton.getneighbours();
			while (temp.size()>0) {
				
				buttonPressed(temp.remove(0));
			}
		}
		System.out.println(childrens.size());
		checkGameState(childrens.size());
		
		
		return cell;
	}
	
	public GridPane getGrid() {
		grid = new GridPane();
		for (int i =0; i<model.getSizey(); i++) {
			for (int j =0; j<model.getSizex(); j++) {
				MinesweeperButton button = new MinesweeperButton(j,i);
				button.setText("  ");
				button.setOnAction(e->buttonPressed(button));
				
				grid.add(button, j, i);
			}
		}
		
		childrens = grid.getChildren();
		
		for (int i=0;i<childrens.size();i++) {
			MinesweeperButton button = (MinesweeperButton) childrens.get(i);
			button.setNeighbours(model.getSizex(),model.getSizey(),childrens);
		}
		
		return grid;
	}
	
	
	
	public void checkneighbours(GridPane grid,Point position,int number) {
			
		
		
		if (number == 0) {
			for (int k = -1; k <= 1; k++) {
				for (int l =-1; l <= 1; l++) {
					if (k!=0 || l!=0) {
						if (position.y +k >= 0 && position.y+k < model.getSizey() && position.x+l >=0 && position.x+l < model.getSizex()) {
							//clearNeighbour(new Point(position.x+l,position.y+k),grid);
																				
						}
					}
				}
			}
		}
				
	}
	public void gotoNewGame(Stage thisStage) {
		
		view.basicGame();
		thisStage.close();
		}
	
}	

	