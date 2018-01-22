package controller;

import org.junit.Test;

import static org.junit.Assert.*;
import model.*;

/**
 * Created by sotnikov on 12.05.17.
 */
public class WinnerControllerTest {

    @Test
    public void testCheckVerticalWithNoWinner() throws Exception {
        Field field = new Field();
        WinnerController wc = new WinnerController(field);

        for (int i = 1; i <= field.getMAX_COORDINATE(); i++) {
            field.setFigure(new Point(i, 0), Figure.X);
        }

        final Figure expectedWinner = Figure.noWinner;
        final Figure actualWinner = wc.checkVertical();

        assertEquals(expectedWinner, actualWinner);
    }

    @Test
    public void testCheckVertical() throws Exception {
        Field field = new Field();
        WinnerController wc = new WinnerController(field);

        for (int i = 0; i <= field.getMAX_COORDINATE(); i++) {
            field.setFigure(new Point(i, 0), Figure.X);
        }

        final Figure expectedWinner = Figure.X;
        final Figure actualWinner = wc.checkVertical();

        assertEquals(expectedWinner, actualWinner);
    }

    @Test
    public void testCheckHorizontalWithNoWinner() throws Exception {
        Field field = new Field();
        WinnerController wc = new WinnerController(field);

        for (int i = 1; i <= field.getMAX_COORDINATE(); i++) {
            field.setFigure(new Point(0, i), Figure.X);
        }

        final Figure expectedWinner = Figure.noWinner;
        final Figure actualWinner = wc.checkHorizontal();

        assertEquals(expectedWinner, actualWinner);
    }

    @Test
    public void testCheckHorizontal() throws Exception {
        Field field = new Field();
        WinnerController wc = new WinnerController(field);

        for (int i = 0; i <= field.getMAX_COORDINATE(); i++) {
            field.setFigure(new Point(0, i), Figure.O);
        }

        final Figure expectedWinner = Figure.O;
        final Figure actualWinner = wc.checkHorizontal();

        assertEquals(expectedWinner, actualWinner);
    }

    @Test
    public void testCheckStraightDiagonal() throws Exception {
        final Field field = new Field();
        final WinnerController wc = new WinnerController(field);

        for (int i = 0, j = 0; i <= field.getMAX_COORDINATE() | j <= field.getMAX_COORDINATE(); i++, j++) {
            field.setFigure(new Point(i, j), Figure.X);
        }

        final Figure expectedWinner = Figure.X;
        final Figure actualWinner = wc.checkDiagonals();

        assertEquals(expectedWinner, actualWinner);
    }

    @Test
    public void testCheckReversedDiagonal() throws Exception {
        final Field field = new Field();
        final WinnerController wc = new WinnerController(field);

        for (int i = 0, j = field.getMAX_COORDINATE(); i <= field.getMAX_COORDINATE() | j >= field.getMIN_COORDINATE(); i++, j--) {
            field.setFigure(new Point(i, j), Figure.X);
        }

        Figure expectedWinner = Figure.X;
        Figure actualWinner = wc.checkDiagonals();
        assertEquals(expectedWinner, actualWinner);
    }

    @Test
    public void testCheckDiagonalWithNoWinner() throws Exception {
        final Field field = new Field();
        final WinnerController wc = new WinnerController(field);

        final Figure expectedWinner = Figure.noWinner;
        final Figure actualWinner = wc.getWinner();

        assertEquals(expectedWinner, actualWinner);
    }

    @Test
    public void testGetWinnerWithNoWinner() throws Exception {
        final Field field = new Field();
        final WinnerController wc = new WinnerController(field);

        final Figure expectedWinner = Figure.noWinner;
        final Figure actualWinner = wc.getWinner();

        assertEquals(expectedWinner, actualWinner);
    }

    @Test
    public void testGetVerticalWinner() throws Exception {
        final Field field = new Field();
        final WinnerController wc = new WinnerController(field);

        for (int i = 0; i <= field.getMAX_COORDINATE(); i++) {
            field.setFigure(new Point(i, 0), Figure.X);
        }

        final Figure expectedWinner = Figure.X;
        final Figure actualWinner = wc.getWinner();

        assertEquals(expectedWinner, actualWinner);
    }

    @Test
    public void testGetHorizontalWinner() throws Exception {
        final Field field = new Field();
        final WinnerController wc = new WinnerController(field);

        for (int i = 0; i <= field.getMAX_COORDINATE(); i++) {
            field.setFigure(new Point(0, i), Figure.O);
        }

        final Figure expectedWinner = Figure.O;
        final Figure actualWinner = wc.getWinner();

        assertEquals(expectedWinner, actualWinner);
    }

    @Test
    public void testGetDiagonalWinner() throws Exception {
        final Field field = new Field();
        final WinnerController wc = new WinnerController(field);

        for (int i = 0, j = field.getMAX_COORDINATE(); i <= field.getMAX_COORDINATE() | j >= field.getMIN_COORDINATE(); i++, j--) {
            field.setFigure(new Point(i, j), Figure.X);
        }

        final Figure expectedWinner = Figure.X;
        final Figure actualWinner = wc.getWinner();

        assertEquals(expectedWinner, actualWinner);
    }

}