package model;

import exceptions.AlreadyOccupiedException;
import exceptions.InvalidCoordinateException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sotnikov on 11.05.17.
 */
public class FieldTest {
    @Test
    public void testGetSize() throws Exception {
        Field field = new Field();
        int expectedSize = 3;
        int actualSize = field.getSize();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testSetFigureToInvalidCoordinate() throws InvalidCoordinateException, AlreadyOccupiedException {
        final Field field = new Field();
        final Point inputPoint = new Point(-1, 0);

        try {
            field.setFigure(inputPoint, Figure.X);
            fail();
        }
            catch (InvalidCoordinateException e) {}

    }

    @Test
    public void testGetFigureFromInvalidCoordinate() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(-1, 0);

        try {
            field.getFigure(inputPoint);
            fail();
        }
        catch (RuntimeException e) {}

    }

    @Test
    public void testSetFigureToAlreadyOccupiedCoordinate() throws AlreadyOccupiedException, InvalidCoordinateException {
        final Field field = new Field();
        final Point inputPoint = new Point(0, 0);
        field.setFigure(inputPoint, Figure.X);
        try {
            field.setFigure(inputPoint, Figure.X);
            fail();
        }
        catch (AlreadyOccupiedException e) {}

    }



}