import java.util.List;
import javafx.application.Application;
import javafx.stage.Stage;

public class startMinesweeper extends Application {
	int m,n,bombs;
	MinesweeperView view;
	MinesweeperModel model;
	MinesweeperController controller;
	
	// Main program file. Contains launch for JavaFX
	public static void main(String[] args) {
		launch(args);
	}
		
	public void start(Stage topLevelStage) throws Exception {
		List<String> cliParams = getParameters().getRaw();
		int[] intParams = fetchArgs(cliParams);
		m = 10; // intParams[0];
		n =  10; // intParams[1];
		bombs = 10; // intParams[2];
		
		view = new MinesweeperView();
		model = new MinesweeperModel(m,n,bombs);
		controller = new MinesweeperController(model, view);
		
		view.SetOptions(topLevelStage, controller, "basicgame");
		topLevelStage = view.basicGame();
		topLevelStage.show();
	}
	
	/* 
	 * Processes the command line arguments so the amount of arguments is at least maxArgs.
	 * If less, an exception is thrown.
	 * Input: A string array containing the command line arguments
	 * Output: An array containing command line the arguments as integers
	 */
	public int[] fetchArgs(List<String> cliParams) {
		int maxArgs = 3;
		if (cliParams.size() < maxArgs) {
			throw new IllegalArgumentException("3 arguments have to be used!");
		}
		int[] intParams = new int[maxArgs];
		for (int i = 0; i < intParams.length; i++) {
			intParams[i] = Integer.parseInt(cliParams.get(i));
		}
		return intParams;
	}
}	