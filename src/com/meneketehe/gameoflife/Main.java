package com.meneketehe.gameoflife;

import com.meneketehe.gameoflife.gui.App;
import com.meneketehe.grid.Point;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n = 40;
        ArrayList<Point> activeCells = new ArrayList<Point>(
                List.of(
                        new Point(1, 3),
                        new Point(2, 1),
                        new Point(2, 3),
                        new Point(3, 2),
                        new Point(3, 3)
                )
        );
        GameOfLife game = new GameOfLife(n, n, activeCells);

        SwingUtilities.invokeLater(new App(game));
    }
}
