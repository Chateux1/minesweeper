package com.company;

import java.util.Map;

public class MVC_Controller {

    private MVC_Model model;
    private MVC_View view;
    private int row, col;

    public MVC_Controller(MVC_View view, MVC_Model model, int row, int col) {

        this.model = model;
        this.view = view;
        this.row = row;
        this.col = col;
        this.model.setRow(this.getRow());
        this.model.setCol(this.getCol());
        this.view.setRow(this.getRow());
        this.view.setCol(this.getCol());
        this.view.setJFrame();
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }
}
