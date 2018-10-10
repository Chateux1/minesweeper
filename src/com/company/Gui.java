package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class Gui extends JFrame implements WindowListener,ActionListener {

    private int row, col;
    private JPanel gamePanel;
    public ArrayList<Button>[][] listRow;
    public ArrayList<Button> listCol;

    public void actionPerformed(ActionEvent e) {
        System.out.println("Hello");
    }
    public void windowClosing(WindowEvent e) {
        dispose();
        System.exit(0);
    }
    public void windowOpened(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {}

    public Gui(int row, int col) {
        super("Minesweeper");
        this.row = row;
        this.col = col;
        addWindowListener(this); // ???
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

    public void setIcon() {

    }
    public void setMainPanel() {
        gamePanel = new JPanel();
        GridLayout panelLayout = new GridLayout(this.getRow(),this.getCol());
        gamePanel.setLayout(panelLayout);
        listRow = new ArrayList[this.getRow()][this.getCol()];
        for (int row = 0; row < this.getRow(); row++) {
            for (int col = 0; col < this.getCol(); col++) {
                Button btn = new Button(row,col);
                btn.addActionListener(this);
                btn.getIcon();
                listCol = new ArrayList<>();
                listRow[row][col] = listCol;
                listCol.add(btn);
                gamePanel.add(btn);
                gamePanel.setPreferredSize(new Dimension(row * btn.getButtonSize(),col * btn.getButtonSize()));
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
