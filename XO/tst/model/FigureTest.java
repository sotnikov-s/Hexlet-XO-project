package model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sotnikov on 12.05.17.
 */
public class FigureTest {
    @Test
    public void testToString() throws Exception {
        assertEquals("X", Figure.X.toString());
    }

}