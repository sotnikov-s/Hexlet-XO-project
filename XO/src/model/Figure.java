package model;

public enum Figure {

    X("X"), O("O"), noWinner("No winner!");

    final String figure;

    Figure(String s) {
        this.figure = s;
    }

    @Override
    public String toString() {
        return figure;
    }
}
