package model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sotnikov on 12.05.17.
 */
public class GameTest {
    @Test
    public void testGetField() throws Exception {
        Player pl1 = new Player("pl1",Figure.X);
        Player pl2 = new Player("pl2", Figure.O);
        Field field = new Field();
        Game game = new Game(pl1, pl2, field);

        Field expectedField = field;
        Field actualField = game.getField();

        assertEquals(expectedField, actualField);
    }

    @Test
    public void testGetPlayers() throws Exception {
        Player pl1 = new Player("pl1",Figure.X);
        Player pl2 = new Player("pl2", Figure.O);
        Field field = new Field();
        Game game = new Game(pl1, pl2, field);

        Player[] expectedPlayers = new Player[] {pl1, pl2};
        Player[] actualPlayers = game.getPlayers();

        assertEquals(expectedPlayers, actualPlayers);

    }

    @Test
    public void testGetName() throws Exception {
        Player pl1 = new Player("pl1",Figure.X);
        Player pl2 = new Player("pl2", Figure.O);
        Field field = new Field();
        Game game = new Game(pl1, pl2, field);

        String expectedName = "XO";
        String actualName = game.getName();

        assertEquals(expectedName, actualName);
    }

}