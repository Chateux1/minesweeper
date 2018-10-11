package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Gui extends JFrame implements ComponentListener, ItemListener {

    private int row, col;
    private JPanel gamePanel;
    public ArrayList<ArrayList<Button>> table;
    public ArrayList<Button> listCol;
    private ImageIcon explodeIcon, bombIcon, buttonIcon;
    private int buttonSize = 40;

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
        this.setVisible(true);
        this.setResizable(false);
    }

    public void setLayout() {
        this.setLayout(new GridBagLayout());
    }

    public void setImages(int x, int y) {
        ImageIcon bombIcon = new ImageIcon("images/bomb.png");
        Image bombImage = bombIcon.getImage();
        Image bombResizedImg = bombImage.getScaledInstance(x, y, Image.SCALE_DEFAULT);
        this.bombIcon = new ImageIcon(bombResizedImg);
        ImageIcon explodeIcon = new ImageIcon("images/explode.png");
        Image explodeImage = explodeIcon.getImage();
        Image explodeResizedImg = explodeImage.getScaledInstance(x, y, Image.SCALE_DEFAULT);
        this.explodeIcon = new ImageIcon(explodeResizedImg);
        ImageIcon buttonIcon = new ImageIcon("images/button.png");
        Image buttonImage = buttonIcon.getImage();
        Image buttonResizedImg = buttonImage.getScaledInstance(x, y, Image.SCALE_DEFAULT);
        this.buttonIcon = new ImageIcon(buttonResizedImg);
    }

    public void setMainPanel() {

        gamePanel = new JPanel();
        gamePanel.setLayout(null);
        this.table = new ArrayList<>();

        for (int row = 0; row < this.getRow(); row++) {

            this.listCol = new ArrayList<>();
            for (int col = 0; col < this.getCol(); col++) {

                Button btn = new Button(row,col);
                btn.setBounds(row * btn.getButtonSize(),
                        col * btn.getButtonSize(),
                        btn.getButtonSize(),btn.getButtonSize());

                btn.setIcon(this.buttonIcon);
                btn.setSelectedIcon(this.explodeIcon);

                this.listCol.add(btn);
                gamePanel.add(this.listCol.get(col));
            }
            this.table.add(this.listCol);
        }
        gamePanel.setPreferredSize(new Dimension( (row + 1) * this.buttonSize,
                                                  (col +1 ) * this.buttonSize));
    }

    public void printTable() {
        for (int i = 0; i < table.get(0).size(); i++) {
            System.out.println();
            for (int j = 0; j < table.size(); j++) {
                System.out.print("( ");
                System.out.print(table.get(i).get(j).getRow());
                System.out.print(", ");
                System.out.print(table.get(i).get(j).isSelected());
                System.out.print(" )  ");
            }
        }
    }

    public void showGui() {
        this.setLayout();
        this.setImages(40,40);
        this.setMainPanel();
        this.add(gamePanel);
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
