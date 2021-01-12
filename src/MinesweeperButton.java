import java.awt.Point;

import javafx.scene.control.Button;

public class MinesweeperButton extends Button{
	private Point position;
	public MinesweeperButton() {
		
	}
	public MinesweeperButton(int x, int y) {
		this.position = new Point(x,y);
	}
	public Point getPos() {
		return this.position;
	}
}
