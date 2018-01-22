package controller;
import model.*;

public class MoveController {

    final Field field;

    public MoveController(final Field field) {
        this.field = field;
    }

    public Field getField() {
        return this.field;
    }

    public Figure currentMove() {
        if (field.getMoveCount() == field.getSize()*field.getSize()) return Figure.noWinner;
        return field.getMoveCount() % 2 == 0 ? Figure.X : Figure.O;
    }
}
