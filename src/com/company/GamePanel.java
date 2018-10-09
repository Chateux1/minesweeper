package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {

    public ArrayList<Button>[][] outerList;

    public GamePanel(int rows, int columns) {
        super();
        this.setLayout(setGrid(rows, columns));
        this.createButtons(rows, columns);
    }
    private GridLayout setGrid(int rows, int columns) {

        GridLayout layout = new GridLayout(rows+2,columns+2);
        return layout;
    }
    private void createButtons(int rows, int columns) {

        outerList = new ArrayList[rows+2][columns+2];
        for (int row = 0; row < rows + 2; row++) {
            for (int col = 0; col < columns + 2; col++) {
                Button button = new Button(String.valueOf(row) + String.valueOf(col),row,col);
                ArrayList<Button> innerList = new ArrayList<>();
                outerList[row][col] = innerList;
                innerList.add(button);
                this.add(button);
            }
        }
    }
}
