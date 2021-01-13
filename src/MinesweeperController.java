import java.awt.Point;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MinesweeperController {
	MinesweeperModel model;
	MinesweeperView view;
	ObservableList<Node> childrens;
	GridPane grid;
	int gameState;
	int buttonAmount;
	
	
	
	public MinesweeperController(MinesweeperModel model, MinesweeperView view) {
		this.view = view;
		this.model = model;
	}
	
	public int getNext(Point updatepoint) {
		int cell = model.getPos(updatepoint);
		return cell;	
	}
	
	public void checkGameState(Point point) {
		
		this.gameState=model.testConditions(point);
		System.out.println(this.gameState);
		if (gameState == 8) {
			view.victory();
		}
		if (gameState == 9) {
			view.gameOver();
		}
	
	}
	public int buttonPressed(MinesweeperButton pressedButton) {
		grid.getChildren().remove(pressedButton);
		int cell = getNext(pressedButton.getPos());
		grid.add(new ImageView(view.getPicture(cell)), pressedButton.getPos().x, pressedButton.getPos().y);
		
		//int gameState = model.testConditions(button.getPos());
		
		//childrens = grid.getChildren();
		/*
		if (cell==0) {
			ArrayList<MinesweeperButton> temp = pressedButton.getneighbours();
			while (temp.size()>0) {
				
				buttonPressed(temp.remove(0));
			}
		}
		*/
		checkGameState(pressedButton.getPos());
		
		
		return cell;
	}
	
	public GridPane getGrid() {
		grid = new GridPane();
		this.buttonAmount=0;
		for (int i =0; i<model.getSizey(); i++) {
			for (int j =0; j<model.getSizex(); j++) {
				MinesweeperButton button = new MinesweeperButton(j,i);
				button.setText("  ");
				button.setOnAction(e->buttonPressed(button));
				this.buttonAmount ++;
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
	
	public void gotoNewGame(Stage thisStage) {
		model = new MinesweeperModel(model.getSizex(),model.getSizey(),model.getBombAmount() );
		view.basicGame();
		
		thisStage.close();
		}
	
}	

	