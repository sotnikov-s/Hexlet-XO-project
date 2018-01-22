package controller;

import exceptions.*;
import org.junit.Test;

import static org.junit.Assert.*;
import model.*;

/**
 * Created by sotnikov on 12.05.17.
 */
public class MoveControllerTest {
    @Test
    public void testCurrentMoveWhenTheFieldIsFull() throws Exception {
        Field field = new Field();
        MoveController mc = new MoveController(field);

        for (int i = 0; i <= field.getMAX_COORDINATE(); i++) {
            for (int j = 0;  j <= field.getMAX_COORDINATE(); j++) {
                field.setFigure(new Point(i, j), mc.currentMove());
            }
        }
        assertEquals(Figure.noWinner, mc.currentMove());

    }

    @Test
    public void testCurrentMove() throws Exception {
        Field field = new Field();
        MoveController mc = new MoveController(field);

        assertEquals(Figure.X, mc.currentMove());
        field.setFigure(new Point(field.getMIN_COORDINATE(), field.getMIN_COORDINATE()), Figure.X);
        assertEquals(Figure.O, mc.currentMove());
        field.setFigure(new Point(field.getMAX_COORDINATE(), field.getMAX_COORDINATE()), Figure.O);
        assertEquals(Figure.X, mc.currentMove());

    }

    @Test
    public void testGetField() {
        Field inputField = new Field();
        MoveController mc = new MoveController(inputField);
        Field expectedField = inputField;
        Field actualField = mc.getField();

        assertEquals(expectedField, actualField);
    }

}