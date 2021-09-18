package com.meneketehe.grid;

enum State {
    DEAD, ALIVE
}

public class Cell {
    Point point;
    State state;

    Cell(int x, int y) {
        this.point = new Point(x, y);
        this.state = State.DEAD;
    }

    public int getX() {
        return point.getX();
    }

    public int getY() {
        return point.getY();
    }

    public void setAlive() {
        state = State.ALIVE;
    }
}
