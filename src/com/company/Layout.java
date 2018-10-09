package com.company;

import javax.swing.*;

public class Layout extends JFrame{

    public Layout(int row, int col) {
        super("Title");
        this.add(new GamePanel(row, col));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
}
