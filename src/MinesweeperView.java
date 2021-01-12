import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MinesweeperView {
	MinesweeperController controller;
	GridPane grid;
	int x,y;
	
	public MinesweeperView() {

	}
	
	public Image[] pictures() {
		Image[] pictures = new Image[10];
		
		for(int i = 1; i<10; i++) {
			String name = i + ".png";
			pictures [i] = new Image(name);
			
		}
		return pictures;	
	}


	
}
