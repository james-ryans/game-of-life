package com.meneketehe.gameoflife;

import com.meneketehe.grid.Point;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n = 10;
        int m = 20;
        ArrayList<Point> activeCells = new ArrayList<Point>(
                List.of(
                        new Point(1, 3),
                        new Point(2, 1),
                        new Point(2, 3),
                        new Point(3, 2),
                        new Point(3, 3)
                )
        );
        GameOfLife game = new GameOfLife(n, m, activeCells);

        App app = new App(game);
        app.run();
    }
}
