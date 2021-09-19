package com.meneketehe.grid;

import java.util.ArrayList;

public class Grid {
    int cols, rows;
    Cell[][] cells;

    public Grid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        this.cells = new Cell[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.cells[i][j] = new Cell(i, j);
            }
        }
    }

    public Grid(int cols, int rows, ArrayList<Point> activeCells) {
        this(cols, rows);

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

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public boolean[][] show() {
        boolean[][] grid = new boolean[rows][cols];
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                grid[x][y] = cells[x][y].isAlive();
            }
        }

        return grid;
    }

    private boolean isWithinBoundaries(Point point) {
        return 0 <= point.getX() && point.getX() < rows && 0 <= point.getY() && point.getY() < cols;
    }
}
