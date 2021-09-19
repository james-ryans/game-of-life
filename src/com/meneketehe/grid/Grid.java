package com.meneketehe.grid;

import java.util.ArrayList;

public class Grid {
    int width, height;
    Cell[][] cells;

    public Grid(int height, int width) {
        this.height = height;
        this.width = width;
        this.cells = new Cell[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.cells[i][j] = new Cell(i, j);
            }
        }
    }

    public Grid(int height, int width, ArrayList<Point> activeCells) {
        this(height, width);

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

    public boolean[][] show() {
        boolean[][] grid = new boolean[height][width];
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                grid[x][y] = cells[x][y].isAlive();
            }
        }

        return grid;
    }

    private boolean isWithinBoundaries(Point point) {
        return 0 <= point.getX() && point.getX() < height && 0 <= point.getY() && point.getY() < width;
    }
}
