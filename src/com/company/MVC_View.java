package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MVC_View extends JFrame {

    int row, col, buttonSize = 10;
    private final int allAroundMargin = 5;
    private final int menuHeight = 40;
    private final int xCorrection = 16, yCorrection = 39;
    ArrayList<ArrayList<JToggleButton>> listOuter;
    ArrayList<JToggleButton> listInner;

    public MVC_View(MVC_Model model) {
        super("Frame");
    }

    public void setJFrame() {

        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.add(setTopPanel());
        this.add(setGamePanel());

        this.pack();
        this.setSize(
                this.getCol() * this.getButtonSize() + 2 * allAroundMargin + xCorrection,
                this.getRow() * this.getButtonSize() + menuHeight + 3 * allAroundMargin + yCorrection);
        this.setVisible(true);
    }

    public JPanel setTopPanel() {
        JPanel panel = new JPanel();
        //panel.setLayout(null);
        JButton startButton = new JButton(this.getRow() + " x " + this.getCol());
        panel.add(startButton);
        panel.setBounds(
                allAroundMargin,
                allAroundMargin,
                this.getCol()*this.getButtonSize(),
                menuHeight);
        return panel;
    }

    private JPanel setGamePanelSettings(JPanel panel) {
        panel.setSize(new Dimension(this.getRow() * this.getButtonSize(),
                this.getCol() * this.getButtonSize()));
        panel.setBounds(
                allAroundMargin,
                allAroundMargin * 2 + menuHeight,
                this.getCol() * this.getButtonSize(),
                this.getRow() * this.getButtonSize());

        return panel;
    }

    private JToggleButton setGameButtonSettings(JToggleButton btn, int row, int col) {
        btn.setMargin(new Insets(0,0,0,0));
        btn.setFocusable(false);
        btn.setContentAreaFilled(false);
        btn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Dimension size = new Dimension(this.getButtonSize(),this.getButtonSize());
        btn.setSize(size);
        btn.setBounds(
                col * this.getButtonSize(),
                row * this.getButtonSize(),
                this.getButtonSize(),
                this.getButtonSize());
        return btn;
    }

    public JPanel setGamePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        listOuter = new ArrayList<>();
        for (int row = 0; row < this.getRow(); row++) {

            listInner = new ArrayList<>();
            for (int col = 0; col < this.getCol(); col++) {

                JToggleButton btn = new JToggleButton(""+row+col);

                panel.add(setGameButtonSettings(btn,row,col));
                listInner.add(btn);
            }
            listOuter.add(listInner);
        }

        return setGamePanelSettings(panel);
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public int getButtonSize() {
        return this.buttonSize;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
