package com.meneketehe.gameoflife.gui;

import javax.swing.*;
import java.awt.*;

public class CellPanel extends JPanel {
    private boolean isAlive;

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

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive() {
        isAlive = true;
        setBackground(new Color(192, 192, 192));
    }

    public void setDead() {
        isAlive = false;
        setBackground(Color.DARK_GRAY);
    }
}
