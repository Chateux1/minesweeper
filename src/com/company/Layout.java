package com.company;

import javax.swing.*;
import java.awt.*;

public class Layout extends JFrame{

    public Layout(){

        super("Flow Layout");
        for (int i = 0; i < 10; i++) {
            add(new JButton("Button" + i));
        }
        this.setLayout();
    }

    private void setLayout() {
        this.setLayout(new GridLayout(2,3));
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
}
