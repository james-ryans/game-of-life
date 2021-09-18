package com.meneketehe.grid;

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
}
