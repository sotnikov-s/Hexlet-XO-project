import controller.WinnerController;
import exceptions.*;
import model.*;
import view.ConsoleView;

import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws InvalidCoordinateException, IOException {

        Scanner scanner = new Scanner(System.in);
        Field field = new Field();
        System.out.println("Type the name of the first player: ");
        Player Player1 = new Player(scanner.nextLine(), Figure.X);
        System.out.println("Type the name of the second player: ");
        Player Player2 = new Player(scanner.nextLine(), Figure.O);
        Game game = new Game(Player1, Player2, field);
        ConsoleView cv = new ConsoleView(game);
        cv.runGame();
    }


}
