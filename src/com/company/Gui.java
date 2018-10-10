package com.company;

import javax.imageio.ImageIO;
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
    private Icon warnIcon = UIManager.getIcon("OptionPane.warningIcon");

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
                Button btn = new Button(row,col);
                if (!btn.getIsClicked()) {
                    btn.addItemListener(new ItemListener() {
                        @Override
                        public void itemStateChanged(ItemEvent e) {

                            if (!btn.getIsClicked()) {
                                System.out.println("Hi");
                                btn.setSelected(true);
                                //btn.setEnabled(false);
                            } else {
                                btn.setIsClicked(true);
                            }
                        }
                    });
                }
                btn.setIcon(infoIcon);
                btn.setDisabledIcon(warnIcon);
                btn.setSelectedIcon(errorIcon);
                btn.setFocusable(false);
                btn.setContentAreaFilled(false);
                btn.addItemListener(this);

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
