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
}
