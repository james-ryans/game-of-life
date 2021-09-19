package com.meneketehe.gameoflife.gui;

import javax.swing.*;
import java.awt.*;

public class CellPanel extends JPanel {
    CellPanel() {
        setDead();
    }

    CellPanel(boolean isAlive) {
        if (isAlive) {
            setAlive();
        } else {
            setDead();
        }
    }

    public void setAlive() {
        setBackground(new Color(192, 192, 192));
    }

    public void setDead() {
        setBackground(Color.DARK_GRAY);
    }
}
