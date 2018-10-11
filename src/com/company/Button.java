package com.company;

import javax.swing.*;
import java.awt.*;

public class Button extends JToggleButton {

    private String id;
    private int mineCount, row, col;
    private boolean isMine;
    private int buttonSize = 35;

    public Button() {
        super("Empty");
    }

    public Button(int row, int col) {

        //super(String.valueOf(row)+String.valueOf(col));
        this.row = row;
        this.col = col;
        this.mineCount = 0;
        this.isMine = false;
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
    }

    private void setSize() {
        Dimension size = new Dimension(this.getButtonSize(),this.getButtonSize());
        this.setSize(size);
    }

    public int getButtonSize() {
        return this.buttonSize;
    }

}
