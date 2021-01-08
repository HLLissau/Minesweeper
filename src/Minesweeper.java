import java.util.Scanner;


// Main program file. Contains main and controllor
public class Minesweeper {
	
	public static void main(String[] args) {
		
		preconfiguration();
		introduction();
		mainMenu();
	}
	public static void preconfiguration() {
		
	}
	public static void introduction() {
		
	}
	public static void mainMenu() {
		MinesweeperGame game = new MinesweeperGame();
		//point size= game.getSize();
		int spilTilstand = 0;
		for(;;) {
			Scanner input= new Scanner(System.in);
			int[] nextTile = getNextInput(game, input);
			game.getPos(nextTile);
			//test new pos
			spilTilstand=game.testConditions(nextTile);
			if (spilTilstand == 9 && spilTilstand == 8) {
				break;
			}
			showGameState(game);
		}
		if (spilTilstand == 8) {
			victory();
		}
		if (spilTilstand == 9) {
			defeat();
		}
		
	}
	public static void victory() {
		System.out.println("Victory Royale!");
	}
	public static void defeat() {
		System.out.println("Defeat screen :(");
	}

	// get next cell from console to check, returned as int[] {x,y}
	public static int[] getNextInput(MinesweeperGame game, Scanner input) {
	System.out.println("Enter x and y coordinates");
	int[] nextInput = new int[] {getUserInt(input,0,game.getSizex()-1), getUserInt(input,0,game.getSizey()-1)}; 
	System.out.println("You entered: x=" + nextInput[0] + ", y=" + nextInput[1]);
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
       /*     if (i == -1) {
                quit(0);
            } */
            if (min <= i && i <= max) {
                break;
            }
        }
        return i;
    }

	public static void showGameState(MinesweeperGame game) {
		for (int i=game.getSizey();i>0; i--) {
			for ( int j=0; j<game.getSizex();j++) {
				System.out.print(game.knownGameState[j][i-1]);
			}
		System.out.println();	
		}
	}
}
	