package com.meneketehe.gameoflife;

import com.meneketehe.grid.Cell;
import com.meneketehe.grid.Grid;
import com.meneketehe.grid.Point;

import java.util.ArrayList;

public class GameOfLife implements CellularAutomaton {
    Grid world;

    public GameOfLife(int rows, int cols, ArrayList<Point> aliveCells) {
        this.world = new Grid(rows, cols, aliveCells);
    }

    @Override
    public ArrayList<Cell> lifeCycle() {
        ArrayList<Cell> changedCells = new ArrayList<>();
        Grid futureWorld = new Grid(world.getRows(), world.getCols());

        for (int x = 0; x < world.getRows(); x++) {
            for (int y = 0; y < world.getCols(); y++) {
                if (rule(world.getCell(x, y))) {
                    futureWorld.populate(x, y);
                } else {
                    futureWorld.unpopulate(x, y);
                }

                if (world.getCell(x, y).getState() != futureWorld.getCell(x, y).getState()) {
                    changedCells.add(world.getCell(x, y));
                }
            }
        }

        world = futureWorld;

        return changedCells;
    }

    @Override
    public boolean rule(Cell cell) {
        return (cell.isAlive() && 2 <= cell.getNeighbours() && cell.getNeighbours() <= 3)
                || (cell.isDead() && cell.getNeighbours() == 3);
    }

    public Grid getWorld() {
        return world;
    }
}
