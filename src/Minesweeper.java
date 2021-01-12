import java.awt.Point;
import java.util.Arrays;
import java.util.Scanner;


// Main program file. Contains main and controllor
public class Minesweeper {
	
	public static void main(String[] args) {
				
			MinesweeperModel game = new MinesweeperModel(10, 10, 10);
			MinesweeperController controller = new MinesweeperController(game);
			MinesweeperView view = new MinesweeperView(10, 10, controller);
	}
}
	