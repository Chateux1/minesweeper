package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Gui extends JFrame {

    private int row, col;
    private JPanel gamePanel;
    public ArrayList<Button>[][] listRow;
    public ArrayList<Button> listCol;

    public Gui(int row, int col) {
        super("Minesweeper");
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public void setSettings() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setSize(500,300);
        this.setVisible(true);
      //this.setResizable(false);
    }

    public void setLayout() {
        this.setLayout(new BorderLayout());
    }

    public void setMainPanel() {
        gamePanel = new JPanel();
        GridLayout panelLayout = new GridLayout(this.getRow(),this.getCol());
        gamePanel.setLayout(panelLayout);
        listRow = new ArrayList[this.getRow()][this.getCol()];
        for (int row = 0; row < this.getRow(); row++) {
            for (int col = 0; col < this.getCol(); col++) {
                Button tmp = new Button(row,col);
                tmp.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        tmp.setText("pressed");
                        tmp.setEnabled(false);
                    }
                });
                listCol = new ArrayList<>();
                listRow[row][col] = listCol;
                listCol.add(tmp);
                gamePanel.add(tmp);
                gamePanel.setPreferredSize(new Dimension(row * tmp.getButtonSize(),col * tmp.getButtonSize()));
            }
        }
    }

    public void showGui() {
        this.setLayout();
        this.setMainPanel();
        JPanel gameContainer = new JPanel();
        gameContainer.add(gamePanel);
        this.getContentPane().add(gameContainer, BorderLayout.PAGE_END);
        this.setSettings();
    }

}
