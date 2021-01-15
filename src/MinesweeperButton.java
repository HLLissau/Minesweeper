import java.awt.Point;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;

// extension of javafx button
public class MinesweeperButton extends Button{
	private Point position;
	private ArrayList<MinesweeperButton> neightbours;

	/*
	 * construktor taking x and y coordinates of the button.
	 * Input: x and y coordinates of the buttons position in grid.
	 *  
	 */
	public MinesweeperButton(int x, int y) {
		this.position = new Point(x,y);
		neightbours = new ArrayList<MinesweeperButton>() ;
	
	}
	
	/*
	 * Returns the poisition of this button
	 * Output: Position
	 */
	public Point getPos() {
		return this.position;
	}
	
	/*
	 * Returns this buttons neighbours
	 * Output: ArrayList of neighbours.
	 */
	public ArrayList<MinesweeperButton> getneighbours() {
		return this.neightbours;
	}
	
	/*
	 * Sets the buttons neighbours. The loops makes sure the found buttons exists within the grid.
	 * Input: M is the with of the grid, n is the height. ObservableList<Node> is the list of all buttons generated.
	 * 
	 */
	
	public void setNeighbours(int m, int n, ObservableList<Node> list) {
		for (int k = -1; k <= 1; k++) {
			for (int l =-1; l <= 1; l++) {
				if (k!=0 || l!=0) {
					if (this.position.y+k >= 0 && this.position.y+k < n && this.position.x+l >=0 && this.position.x+l < m) {
						MinesweeperButton temp = (MinesweeperButton) list.get(((position.x+l)+((position.y+k)*m)));
						this.neightbours.add(temp);
						
					}
				}
			}
		}
	}
}
