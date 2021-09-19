package com.meneketehe.gameoflife;

import com.meneketehe.grid.Cell;
import com.meneketehe.grid.Grid;

public interface CellularAutomaton {
    public void lifeCycle();
    public boolean rule(Cell cell);
}
