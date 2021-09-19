package com.meneketehe.gameoflife;

public class App {
    GameOfLife game;

    App(GameOfLife game) {
        this.game = game;
    }

    public void run() {
        try {
            while (true) {
                clearScreen();
                show();

                game.lifeCycle();

                Thread.sleep(100);
            }
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }

    private void show() {
        boolean[][] grid = game.world.show();

        StringBuilder result = new StringBuilder();
        for (boolean[] row : grid) {
            for (boolean cell : row) {
                result.append(map(cell));
            }
            result.append('\n');
        }
        System.out.println(result);
    }

    private char map(boolean isAlive) {
        return isAlive ? '#' : '.';
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
