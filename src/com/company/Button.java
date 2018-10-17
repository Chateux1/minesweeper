package com.company;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class Button extends JToggleButton {
// lol haxxed
    private int intId;
    private String strId;
    private int minesAround, row, col;
    private boolean isMine;
    private int buttonSize = 20;
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
        this.intId = id;
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

    public void setMinesAround (int minesAround) {
        this.minesAround = minesAround;
    }

    public int getMinesAround() {
        return this.minesAround;
    }

    public double getMineExpectancy() {
        return this.mineExpectancy;
    }

    public void setIntId(int intId) {
        this.intId = intId;
    }

    public int getIntId() {
        return this.intId;
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
