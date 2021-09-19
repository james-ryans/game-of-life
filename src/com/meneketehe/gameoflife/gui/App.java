package com.meneketehe.gameoflife.gui;

import com.meneketehe.gameoflife.GameOfLife;
import com.meneketehe.grid.Cell;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App extends JFrame implements Runnable {
    private static int WIDTH = 800;
    private static int HEIGHT = 800;

    private static final int rows = 40;
    private static final int cols = 40;
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    private Future<?> future;

    private JFrame frame;
    private GridPanel gridPanel;
    JButton playButton;

    public void run() {
        frame = new JFrame("Game Of Life");
        frame.getContentPane().setBackground(Color.GRAY);
        frame.setSize(new Dimension(WIDTH, HEIGHT));
        frame.setResizable(false);

        playButton = new JButton("Start");
        addPlayButtonListener();
        frame.add(playButton, BorderLayout.PAGE_START);

        gridPanel = new GridPanel(rows, cols);
        frame.add(gridPanel, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void addPlayButtonListener() {
        playButton.addActionListener(e -> {
            if (playButton.getText().equals("Start")) {
                play();
            } else {
                stop();
            }
        });
    }

    private void play() {
        playButton.setText("Stop");
        gridPanel.setEnabled(false);

        GameOfLife game = new GameOfLife(rows, cols, gridPanel.getAliveCellsList());

        future = executorService.scheduleAtFixedRate(() -> {
            ArrayList<Cell> changedCells = game.lifeCycle();
            gridPanel.repaintGrid(changedCells);
        }, 500, 500, TimeUnit.MILLISECONDS);
    }

    private void stop() {
        playButton.setText("Start");
        gridPanel.setEnabled(true);

        future.cancel(true);
    }
}
