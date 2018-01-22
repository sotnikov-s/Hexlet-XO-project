package model;

public class Player {

    public final String name;

    public final Figure figure;

    public Player(final String name, final Figure figure) {
        this.name = name;
        this.figure = figure;
    }

    public Figure getFigure() {
        return this.figure;
    }

    public String getName() {
        return name;
    }
}
