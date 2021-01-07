import java.util.Scanner;

// Main program file. Contains main and controllor
public class minesweeper {
	Scanner input= new Scanner(System.in);
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
		point size= game.getSize();
		for(;;) {
			Point nextInput=getNextInput();
		}
	}
	
	public static Point getNextInput() {
	Point nextInput = new Point(getUserInt(input,minx, maxx),getUserInt(input,miny,maxy)); 
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
            if (i == -1) {
                quit(0);
            }
            if (min <= i && i <= max) {
                break;
            }
        }
        return i;
    }
}
