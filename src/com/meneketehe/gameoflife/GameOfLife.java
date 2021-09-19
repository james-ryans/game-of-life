package com.meneketehe.gameoflife;

import com.meneketehe.grid.Cell;
import com.meneketehe.grid.Grid;
import com.meneketehe.grid.Point;

import java.util.ArrayList;

public class GameOfLife implements CellularAutomaton {
    Grid world;

    GameOfLife(int width, int height, ArrayList<Point> aliveCells) {
        this.world = new Grid(width, height, aliveCells);
    }

    @Override
    public void lifeCycle() {
        Grid futureWorld = new Grid(world.getWidth(), world.getHeight());

        for (int x = 0; x < world.getHeight(); x++) {
            for (int y = 0; y < world.getWidth(); y++) {
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
}
