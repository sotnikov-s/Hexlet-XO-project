package model;
import java.util.Arrays;
import java.util.Iterator;

public class Game implements Iterable<Player>{

    private final Player player1;

    private final Player player2;

    private final Player[] players = new Player[2];

    private final String gameName = "XO";

    private final Field field;

    public Game(Player player1, Player player2, Field field) {
        this.player1 = player1;
        this.player2 = player2;
        this.field = field;
        this.players[0] = player1;
        this.players[1] = player2;
    }

    public Field getField() {
        return this.field;
    }

    public Player[] getPlayers() {
        return this.players;
    }

    public String getName() {
        return this.gameName;
    }

    @Override
    public Iterator<Player> iterator() {
        return new PlayerIterator();
    }

    private class PlayerIterator implements Iterator<Player> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return Game.this.players.length > index;
        }

        @Override
        public Player next() {
            return Game.this.players[index++];
        }
    }
}
