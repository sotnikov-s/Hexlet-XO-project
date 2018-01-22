package controller;

import exceptions.InvalidCoordinateException;
import model.*;

public class WinnerController {

    final Field field;

    public WinnerController(final Field field) {
        this.field = field;
    }

    public Figure getWinner() {
        if (checkDiagonals() != Figure.noWinner) return checkDiagonals();
        if (checkHorizontal() != Figure.noWinner) return checkHorizontal();
        if (checkVertical() != Figure.noWinner) return checkVertical();
        return Figure.noWinner;
    }

    public Figure checkVertical() throws RuntimeException {
        int count = 0;
        Figure refFigure = Figure.noWinner;

        for (int column = field.getMIN_COORDINATE(); column <= field.getMAX_COORDINATE(); column ++) {
                if (field.getFigure(new Point(0, column)) != null) {
                    count = 1;
                    refFigure = field.getFigure(new Point(0, column));
                    for (int row = field.getMIN_COORDINATE()+1; row <= field.getMAX_COORDINATE(); row ++) {
                        if (field.getFigure(new Point(row, column)) == refFigure) count ++;
                        else break;
                }
            }
            if (count == field.getSize()) return refFigure;
        }
        return Figure.noWinner;
    }

    public Figure checkHorizontal() throws RuntimeException {
        int count = 0;
        Figure refFigure = Figure.noWinner;

        for (int column = field.getMIN_COORDINATE(); column <= field.getMAX_COORDINATE(); column ++) {
            if (field.getFigure(new Point(column, 0)) != null) {
                count = 1;
                refFigure = field.getFigure(new Point(column, 0));
                for (int row = field.getMIN_COORDINATE()+1; row <= field.getMAX_COORDINATE(); row ++) {
                    if (field.getFigure(new Point(column, row)) == refFigure) count ++;
                    else break;
                }
            }
            if (count == field.getSize()) return refFigure;
        }
        return Figure.noWinner;
    }

    public Figure checkDiagonals() throws RuntimeException {
        Figure noWinner = Figure.noWinner;
        Figure refFigure;
        int count;

        if (field.getFigure(new Point(0, field.getMAX_COORDINATE())) != null) { // check straight diagonal
            count = 1;
            refFigure = field.getFigure(new Point (0, field.getMAX_COORDINATE()));
            for (int x = field.getMIN_COORDINATE()+1, y = field.getMAX_COORDINATE()-1;
                 x <= field.getMAX_COORDINATE() || y >= field.getMIN_COORDINATE()+1;
                 x++, y--) {
                if (field.getFigure(new Point(x, y)) == refFigure) count++;
            }
            if (count == field.getSize()) return refFigure;
        }

        if (field.getFigure(new Point(0, 0)) != null) { // check reversed diagonal
            count = 1;
            refFigure = field.getFigure(new Point (0, 0));
            for (int x = field.getMIN_COORDINATE()+1, y = field.getMIN_COORDINATE()+1;
                 x <= field.getMAX_COORDINATE() || y <= field.getMIN_COORDINATE()+1;
                 x++, y++) {
                if (field.getFigure(new Point(x, y)) == refFigure) count++;
            }
            if (count == field.getSize()) return refFigure;
        }

        return noWinner;
    }
}
