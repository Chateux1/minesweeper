package com.company;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class Button extends JToggleButton {

    private int id;
    private int minesAround, row, col;
    private boolean isMine;
    private int buttonSize = 40;
    private double mineExpectancy;
    private final DecimalFormat numberFormat = new DecimalFormat("#.000");

    public Button() {
        super("Empty");
    }

    public Button(int row, int col, int id) {

        //super(String.valueOf(row)+String.valueOf(col));
        this.row = row;
        this.col = col;
        this.minesAround = 0;
        this.isMine = false;
        this.mineExpectancy = Double.parseDouble(numberFormat.format(Math.random()));
        this.setup();
        this.id = id;
    }

    public Button(String id, int row, int col) {

        super(id);
        this.row = row;
        this.col = col;
        this.minesAround = 0;
        this.isMine = false;
        this.setup();
    }

    public void setMineExpectancy(double mineExpectancy) {
        this.mineExpectancy = mineExpectancy;
    }

    public void setMine() {
        this.isMine = true;
    }

    public boolean getMine() {
        return this.isMine;
    }

    public double getMineExpectancy() {
        return this.mineExpectancy;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
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
