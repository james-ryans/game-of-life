package com.meneketehe.gameoflife.gui;

import javax.swing.*;
import java.awt.*;

public class GridPanel extends JPanel {
    CellPanel[][] cellPanels;

    int rows;
    int cols;
    boolean[][] cells;

    GridPanel(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        GridLayout layout = new GridLayout(rows, cols, 1, 1);
        setLayout(layout);

        initializeCellPanels(rows, cols);
        initializeCells(rows, cols);

        setBackground(Color.GRAY);
        setVisible(true);
    }

    private void initializeCellPanels(int rows, int cols) {
        this.cellPanels = new CellPanel[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cellPanels[i][j] = new CellPanel();
                add(cellPanels[i][j]);
            }
        }
    }

    private void initializeCells(int rows, int cols) {
        cells = new boolean[rows][cols];
    }

    public void repaintGrid(boolean[][] cellsIsAlive) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (cellsIsAlive[i][j]) {
                    cellPanels[i][j].setAlive();
                } else {
                    cellPanels[i][j].setDead();
                }
            }
        }
    }
}
