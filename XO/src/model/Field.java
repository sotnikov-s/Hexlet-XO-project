package model;

import exceptions.*;

public class Field {

    private static final int FIELD_SIZE = 3;

    private int moveCount = 0;

    private final int MAX_COORDINATE = FIELD_SIZE - 1;

    private final int MIN_COORDINATE = 0;

    private Figure[][] figures = new Figure[FIELD_SIZE][FIELD_SIZE];

    public void setFigure(final Point point, final Figure figure) throws InvalidCoordinateException, AlreadyOccupiedException {
        if (!checkPointCoordinate(point)) {
            throw new InvalidCoordinateException();
        }
        if (!checkPointFigure(point)) {
            throw new AlreadyOccupiedException();
        }
        this.moveCount++;
        this.figures[point.getX()][point.getY()] = figure;

    }

    public int getMoveCount() {
        return moveCount;
    }

    public int getMAX_COORDINATE() {
        return MAX_COORDINATE;
    }

    public int getMIN_COORDINATE() {
        return MIN_COORDINATE;
    }

    public Figure getFigure(final Point point) throws RuntimeException {
        if (!checkPointCoordinate(point)) {
            throw new RuntimeException();
        }
        return this.figures[point.getX()][point.getY()];
    }

    public int getSize() {
        return FIELD_SIZE;
    }

    private boolean checkPointCoordinate(final Point point){
        if (point.getX() < MIN_COORDINATE || point.getX() > MAX_COORDINATE) {
            return false;
        }

        if (point.getY() < MIN_COORDINATE || point.getY() > MAX_COORDINATE) {
            return false;
        }

        return true;
    }

    private boolean checkPointFigure(final Point point) {
        if (this.figures[point.getX()][point.getY()] == null) {
            return true;
        }
        return false;
    }

}
