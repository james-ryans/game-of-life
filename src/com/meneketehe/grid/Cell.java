package com.meneketehe.grid;

import java.util.ArrayList;
import java.util.List;

enum State {
    DEAD, ALIVE
}

public class Cell {
    Point point;
    State state;
    int neighbours;

    Cell(int x, int y) {
        this.point = new Point(x, y);
        this.state = State.DEAD;
        this.neighbours = 0;
    }

    public int getX() {
        return point.getX();
    }

    public int getY() {
        return point.getY();
    }

    public State getState() {
        return state;
    }

    public void setAlive() {
        state = State.ALIVE;
    }

    public void setDead() {
        state = State.DEAD;
    }

    public boolean isAlive() {
        return state == State.ALIVE;
    }

    public boolean isDead() {
        return state == State.DEAD;
    }

    protected ArrayList<Point> getAdjacents() {
        int x = point.getX();
        int y = point.getY();

        return new ArrayList<>(
                List.of(
                        new Point(x - 1, y - 1),
                        new Point(x - 1, y),
                        new Point(x - 1, y + 1),
                        new Point(x, y - 1),
                        new Point(x, y + 1),
                        new Point(x + 1, y - 1),
                        new Point(x + 1, y),
                        new Point(x + 1, y + 1)
                )
        );
    }

    public int getNeighbours() {
        return neighbours;
    }

    public void addNeighbour() {
        ++neighbours;
    }

    public void subtractNeighbour() {
        --neighbours;
    }
}
