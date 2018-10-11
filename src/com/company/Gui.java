package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Gui extends JFrame implements ComponentListener, ItemListener {

    private int row, col;
    private JPanel gamePanel;
    public ArrayList<Button>[][] listRow;
    public ArrayList<Button> listCol;
    private Icon errorIcon = UIManager.getIcon("OptionPane.errorIcon");
    private Icon infoIcon = UIManager.getIcon("OptionPane.informationIcon");

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
        this.setSize(600,600);
        this.setVisible(true);
      //this.setResizable(false);
    }

    public void setLayout() {
        this.setLayout(new GridBagLayout());
    }

    public void setMainPanel() {
        gamePanel = new JPanel();
        GridLayout panelLayout = new GridLayout(this.getRow(),this.getCol());
        gamePanel.setLayout(null);
        Insets insets = gamePanel.getInsets();
        listRow = new ArrayList[this.getRow()][this.getCol()];
        for (int row = 0; row < this.getRow(); row++) {
            for (int col = 0; col < this.getCol(); col++) {
                Button btn = new Button(row,col);
                btn.setBounds(row * btn.getButtonSize(),
                        col * btn.getButtonSize(),
                        btn.getButtonSize(),btn.getButtonSize());
                btn.setModel(new ButtonModel());
                btn.setIcon(infoIcon);
                btn.setSelectedIcon(errorIcon);
                btn.setFocusable(false);
                btn.setContentAreaFilled(false);
                btn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
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
        //this.getContentPane().add(gameContainer, BorderLayout.CENTER);
        this.getContentPane().add(gameContainer);
        this.setSettings();
    }

    @Override
    public void componentResized(ComponentEvent e) {
    }

    @Override
    public void componentMoved(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println("Hello");
    }
}
