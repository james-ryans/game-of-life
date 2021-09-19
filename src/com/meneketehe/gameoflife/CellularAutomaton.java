package com.meneketehe.gameoflife;

import com.meneketehe.grid.Cell;

import java.util.ArrayList;

public interface CellularAutomaton {
    public ArrayList<Cell> lifeCycle();
    public boolean rule(Cell cell);
}
