package com.meneketehe.gameoflife;

import com.meneketehe.grid.Cell;
import com.meneketehe.grid.Grid;
import com.meneketehe.grid.Point;

import java.util.ArrayList;

public class GameOfLife implements CellularAutomaton {
    Grid world;

    GameOfLife(int rows, int cols, ArrayList<Point> aliveCells) {
        this.world = new Grid(rows, cols, aliveCells);
    }

    @Override
    public void lifeCycle() {
        Grid futureWorld = new Grid(world.getRows(), world.getCols());

        for (int x = 0; x < world.getRows(); x++) {
            for (int y = 0; y < world.getCols(); y++) {
                if (rule(world.getCell(x, y))) {
                    futureWorld.populate(x, y);
                } else {
                    futureWorld.unpopulate(x, y);
                }
            }
        }

        world = futureWorld;
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
