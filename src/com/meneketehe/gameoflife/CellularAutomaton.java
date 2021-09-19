package com.meneketehe.gameoflife;

import com.meneketehe.grid.Cell;

public interface CellularAutomaton {
    public void lifeCycle();
    public boolean rule(Cell cell);
}
