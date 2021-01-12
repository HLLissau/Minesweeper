import java.awt.Point;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class MinesweeperController {
	MinesweeperModel model;
	MinesweeperView view;
	int gameState;
	public MinesweeperController(MinesweeperModel model, MinesweeperView view) {
		this.view = view;
		this.model = model;
	}
	
	public int getNext(Point updatepoint) {
		
		int cell = model.getPos(updatepoint);
		gameState=model.testConditions(updatepoint);
		if (gameState == 8) {
			//victory();
		}
		if (gameState == 9) {
			//defeat();
		}
	return cell;	
	
	}
	public void buttonPressed(GridPane grid, MinesweeperButton mbutton) {
		MinesweeperButton button =mbutton;
		System.out.println(button.getPos());
		grid.getChildren().remove(button);
		int cell = getNext(button.getPos());
		grid.add(new ImageView(view.pictures()[cell]), button.getPos().x, button.getPos().y);
		//checkneighbours(grid,button.getPos(),text);
	}

}

	/*
	public void checkneighbours(GridPane grid,Point position,int number) {
			
			if (number == 0) {
				for (int k = -1; k <= 1; k++) {
					for (int l =-1; l <= 1; l++) {
						if (k!=0 || l!=0) {
							if (i+k >= 0 && i+k < this.sizey && j+l >=0 && j+l < this.sizex) {
								gameState[j+l][i+k] += 1;
								if (gameState[j+l][i+k] > 9) {
									gameState[j+l][i+k] = 9;
								
							}
						}
					}
				}
			}
		
		}
	}
	*/

	