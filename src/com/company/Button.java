package com.company;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {

    private String id;
    private int mineCount, row, column;
    private boolean isMine;

    public Button(String id, int row, int col) {
        super();
        this.id = id;
        this.mineCount = 0;
        this.isMine = false;
        this.row = row;
        this.column = col;
        this.setPreferredSize(new Dimension(20,20));
    }
}
