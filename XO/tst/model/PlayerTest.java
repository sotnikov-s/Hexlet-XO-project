package model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sotnikov on 12.05.17.
 */
public class PlayerTest {
    @Test
    public void testGetFigure() throws Exception {
        Player player = new Player("Sergey", Figure.X);
        Figure expectedFigure = Figure.X;
        Figure actualFigure = player.getFigure();

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void testGetName() throws Exception {
        Player player = new Player("Sergey", Figure.X);
        String expectedName = "Sergey";
        String actualName = player.getName();

        assertEquals(expectedName, actualName);
    }

}