package com.meneketehe.gameoflife.gui;

import com.meneketehe.grid.Cell;
import com.meneketehe.grid.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GridPanel extends JPanel {
    CellPanel[][] cellPanels;

    int rows;
    int cols;

    GridPanel(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        GridLayout layout = new GridLayout(rows, cols, 1, 1);
        setLayout(layout);

        initializeCellPanels();

        setBackground(Color.GRAY);
        setVisible(true);
    }

    private void initializeCellPanels() {
        this.cellPanels = new CellPanel[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cellPanels[i][j] = new CellPanel();
                addClickListener(cellPanels[i][j]);
                add(cellPanels[i][j]);
            }
        }
    }

    public void repaintGrid(ArrayList<Cell> changedCells) {
        for (Cell cell : changedCells) {
            if (cell.isAlive()) {
                cellPanels[cell.getX()][cell.getY()].setAlive();
            } else {
                cellPanels[cell.getX()][cell.getY()].setDead();
            }
        }

        repaint();
    }

    public ArrayList<Point> getAliveCellsList() {
        ArrayList<Point> aliveCells = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (cellPanels[i][j].isAlive()) {
                    aliveCells.add(new Point(i, j));
                }
            }
        }

        return aliveCells;
    }

    private void addClickListener(CellPanel cellPanel) {
        cellPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (isEnabled()) {
                    if (cellPanel.isAlive()) {
                        cellPanel.setDead();
                    } else {
                        cellPanel.setAlive();
                    }
                }
            }
        });
    }
}
