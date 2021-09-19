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

    private JFrame frame;
    private TopPanel topPanel;
    private GridPanel gridPanel;

    GameOfLife game;

    public App(GameOfLife game) {
        this.game = game;

        frame = new JFrame("Game Of Life");
        frame.setSize(new Dimension(WIDTH, HEIGHT));
        frame.setResizable(false);

        topPanel = new TopPanel();
        frame.add(topPanel, BorderLayout.PAGE_START);

        gridPanel = new GridPanel(game.getWorld().getRows(), game.getWorld().getCols(), game.getWorld().show());
        frame.add(gridPanel, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void run() {
        final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(() -> {
            if (topPanel.simulate) {
                game.lifeCycle();
                gridPanel.repaintGrid(game.getWorld().show());
            }
        }, 0, 400, TimeUnit.MILLISECONDS);
    }
}
