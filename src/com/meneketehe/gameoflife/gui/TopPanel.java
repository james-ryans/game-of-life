package com.meneketehe.gameoflife.gui;

import javax.swing.*;
import java.awt.*;

public class TopPanel extends JPanel {
    JButton playButton;
    boolean simulate;

    TopPanel() {
        this.simulate = false;
        createPlayButton();

        setBackground(Color.GRAY);
        setVisible(true);
    }

    private void createPlayButton() {
        playButton = new JButton("Start");
        playButton.addActionListener(e -> {
            if (!simulate) {
                play();
            } else {
                stop();
            }
        });
        add(playButton, BorderLayout.CENTER);
    }

    private void play() {
        simulate = true;
        playButton.setText("Stop");
    }

    private void stop() {
        simulate = false;
        playButton.setText("Start");
    }
}
