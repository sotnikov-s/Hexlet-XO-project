package view;

import controller.MoveController;
import controller.WinnerController;
import exceptions.AlreadyOccupiedException;
import exceptions.InvalidCoordinateException;
import model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by sotnikov on 13.05.17.
 */
public class ConsoleView {

    final Field field;
    final Game game;
    final Player[] players;
    final MoveController mc;
    final WinnerController wc;

    public ConsoleView(final Game game) {
        this.field = game.getField();
        this.game = game;
        this.players = game.getPlayers();
        this.mc = new MoveController(field);
        this.wc = new WinnerController(field);
    }

    public void runGame() {
        do {
            showGame();
            move();
            clearConsole();
        } while (!endOfTheGame());

        showGame();
        if (!moveability()) System.out.println("Round draw!");
        else System.out.format("The winner is %s", wc.getWinner());
    }

    private boolean endOfTheGame() {
        if (!moveability()) return true;
        if (winnerIsX()) return true;
        if (winnerIsO()) return true;
        return false;
    }

    private boolean moveability() {
        return (mc.currentMove() != Figure.noWinner);
    }

    private boolean winnerIsX() {
        return (wc.getWinner() == Figure.X);
    }

    private boolean winnerIsO() {
        return (wc.getWinner() == Figure.O);
    }

    private void move() {
        Scanner sc = new Scanner(System.in);
        int row, column;

        try {
            System.out.format("%s move: enter where to place your next figure. \n", mc.currentMove());
            System.out.print("Row: ");
            row = sc.nextInt();
            System.out.print("Column: ");
            column = sc.nextInt();
            field.setFigure(new Point(row, column), mc.currentMove());
        }
        catch (InvalidCoordinateException e) {
            System.out.println("Invalid coordinate! Please try again.");
            move();
        }
        catch (AlreadyOccupiedException e) {
            System.out.println("This point is already taken. Please try another point.");
            move();
        }

    }

    private void showGame() {
        showPlayers();
        System.out.println("\n");
        showField();
        System.out.println("\n");
    }

    private void clearConsole() {
        System.out.println("\n \n \n \n \n \n \n \n \n \n \n");
    }

    private void showPlayers() {
        for (Player player : game) {
            System.out.format("%s plays as %s\n", player.getName(), player.getFigure());
        }
    }

    private void showRow(int row) {
        for (int col = 0; col < field.getSize(); col++) {
            String outSymbol;
            if (field.getFigure(new Point(row, col)) == null) outSymbol = " ";
            else outSymbol = field.getFigure(new Point(row, col)).toString();
            System.out.print(" " + outSymbol + " ");
            if (col != field.getMAX_COORDINATE()) System.out.print("|");
            else System.out.println();
        }
        if (row != field.getMAX_COORDINATE()) {
            System.out.print("~~~");
            for (int i = 1; i < field.getSize(); i++) {
                System.out.print("~~~~");
            }
            System.out.println();

        }
    }

    private void showField() {
        for (int row = 0; row < field.getSize(); row++) {
            showRow(row);
        }
    }
}
