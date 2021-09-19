package com.meneketehe.gameoflife.gui;

import com.meneketehe.gameoflife.GameOfLife;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App extends JFrame implements Runnable {
    private static int WIDTH = 800;
    private static int HEIGHT = 800;

    private GridPanel gridPanel;

    GameOfLife game;

    public App(GameOfLife game) {
        this.game = game;

        JFrame frame = new JFrame("Game Of Life");
        frame.setSize(new Dimension(WIDTH, HEIGHT));
        frame.setResizable(false);

        gridPanel = new GridPanel(game.getWorld().getRows(), game.getWorld().getCols());
        frame.add(gridPanel, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void run() {
        final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(() -> {
            gridPanel.repaintGrid(game.getWorld().show());
            game.lifeCycle();
        }, 0, 500, TimeUnit.MILLISECONDS);
    }
}
