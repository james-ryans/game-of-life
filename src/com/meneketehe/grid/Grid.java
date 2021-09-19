package com.meneketehe.grid;

import java.util.ArrayList;

public class Grid {
    int width, height;
    Cell[][] cells;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new Cell[width][height];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.cells[i][j] = new Cell(i, j);
            }
        }
    }

    public Grid(int width, int height, ArrayList<Point> activeCells) {
        this(width, height);

        for (Point point : activeCells) {
            populate(point.getX(), point.getY());
        }
    }

    public void populate(int x, int y) {
        if (cells[x][y].isAlive()) {
            return;
        }

        cells[x][y].setAlive();
        for (Point adjacent : cells[x][y].getAdjacents()) {
            if (isWithinBoundaries(adjacent)) {
                cells[adjacent.getX()][adjacent.getY()].addNeighbour();
            }
        }
    }

    public void unpopulate(int x, int y) {
        if (cells[x][y].isDead()) {
            return;
        }

        cells[x][y].setDead();
        for (Point adjacent : cells[x][y].getAdjacents()) {
            if (isWithinBoundaries(adjacent)) {
                cells[adjacent.getX()][adjacent.getY()].subtractNeighbour();
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    private boolean isWithinBoundaries(Point point) {
        return 0 <= point.getX() && point.getX() < height && 0 <= point.getY() && point.getY() < width;
    }
}
