package com.company;

import javax.swing.*;
import java.awt.*;

public class Button extends JToggleButton {

    private String id;
    private int mineCount, row, col;
    private boolean isMine;
    private int buttonSize = 40;
    private double mineExpectancy;

    public Button() {
        super("Empty");
    }

    public Button(int row, int col) {

        //super(String.valueOf(row)+String.valueOf(col));
        this.row = row;
        this.col = col;
        this.mineCount = 0;
        this.isMine = false;
        this.mineExpectancy = Math.random();
        this.setup();
    }

    public Button(String id, int row, int col) {

        super(id);
        this.row = row;
        this.col = col;
        this.mineCount = 0;
        this.isMine = false;
        this.setup();
    }

    public void setId(String id) {
        this.id = String.valueOf(this.getRow())+String.valueOf(this.getCol());
    }

    public String getId() {
        return this.id;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    private void setup() {
        this.setSize();
        this.setModel(new ButtonModel());
    }

    private void setSize() {
        Dimension size = new Dimension(this.getButtonSize(),this.getButtonSize());
        this.setSize(size);
        this.setMargin(new Insets(0,0,0,0));
        this.setFocusable(false);
        this.setContentAreaFilled(false);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public int getButtonSize() {
        return this.buttonSize;
    }

}
