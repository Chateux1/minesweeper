package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Gui extends JFrame implements ComponentListener, ItemListener {

    private int row, col, mineCount;
    private JPanel gamePanel;
    public ArrayList<ImageIcon> listIcons;
    public HashMap<Integer, Button> table1;
    public ArrayList<ArrayList<String>> listButtonOuter;
    public ArrayList<String> listButtonInner;
    private int buttonSize = new Button().getButtonSize();
    private String[] IconPaths = {"images/button.png",
            "images/bomb.png",
            "images/explode.png"};
    private String[] IconNames = { "button",
            "bomb",
            "explode"};

    public Gui(int row, int col, int mineCount) {
        super("Minesweeper");
        this.row = row;
        this.col = col;
        this.mineCount = mineCount;
    }

    public void showGui() {
        this.setLayout();
        this.setImages(40,40);
        this.setButtonList();
        this.setMainPanel();
        this.add(gamePanel);
        this.setSettings();
    }

    public void setImages(int x, int y) {

        this.listIcons = new ArrayList<>();
        int scalingMethod = Image.SCALE_DEFAULT;

        for (int i = 0; i < this.IconPaths.length; i++) {
            ImageIcon tempIcon = new ImageIcon(IconPaths[i]);
            Image tempImg = tempIcon.getImage();
            Image tempResized = tempImg.getScaledInstance(x, y, scalingMethod);
            this.listIcons.add(i, new ImageIcon(tempResized));
        }
    }

    public void setButtonList() {

        this.listButtonOuter = new ArrayList<>();
        this.table1 = new HashMap<>();
        int id = 0;

        for ( int i = 0; i < this.getRow(); i++ ) {

            for ( int j = 0; j < this.getCol(); j++ ) {

                this.table1.put(id, new Button(i, j, id));
                this.listButtonInner = new ArrayList<>();
                this.listButtonInner.add(Integer.toString(this.table1.get(id).getId()));
                this.listButtonInner.add(Double.toString(this.table1.get(id).getMineExpectancy()));
                this.listButtonOuter.add(this.listButtonInner);
                id += 1;

            }
        }
    }

    public void sortList() {
        Collections.sort(this.listButtonOuter, new CompareMineExpectancies());
    }

    public void setMines() {
        this.sortList();
        for (int i = 0; i < this.getMineCount(); i++) {
            int id = Integer.parseInt(this.listButtonOuter.get(i).get(0));
            table1.get(id).setMine();
        }
    }

    public void setSettings() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setResizable(false);
    }

    public void printHash() {
        System.out.println();
        for (int i = 0; i < this.table1.size(); i++) {
            System.out.print("(");
            System.out.print(table1.get(i).getMine());
            System.out.println(")");
        }
    }

    public void setLayout() {
        this.setLayout(new GridBagLayout());
    }

    public void setMainPanel() {

        gamePanel = new JPanel();
        gamePanel.setLayout(null);
        int counter = 0;
        this.setImages(40,40);

        for (int row = 0; row < this.getRow(); row++) {

            for (int col = 0; col < this.getCol(); col++) {

                Button btn = table1.get(counter);
                btn.setBounds(row * btn.getButtonSize(),
                        col * btn.getButtonSize(),
                        btn.getButtonSize(),btn.getButtonSize());
                btn.setIcon(this.listIcons.get(0));
                btn.setSelectedIcon(this.listIcons.get(2));
                gamePanel.add(btn);
                counter +=1;
            }
        }
        gamePanel.setPreferredSize(new Dimension( (row + 1) * this.buttonSize,
                                                  (col +1 ) * this.buttonSize));
    }

    public void printList() {
        System.out.println();
        for (int i = 0; i < this.listButtonOuter.size(); i++) {
            System.out.println();
            System.out.print("(" + this.listButtonOuter.get(i).get(0));
            System.out.print(", " + this.listButtonOuter.get(i).get(1) + ")");
        }
    }

    public void printTable() {
        System.out.println();
        int counter = 0;
        for (int i = 0; i < table1.get(counter).getRow(); i++) {
            System.out.println();
            for (int j = 0; j < table1.get(counter).getCol(); j++) {
                System.out.print("( ");
                DecimalFormat numberFormat = new DecimalFormat("#.00");
                double output = table1.get(counter).getMineExpectancy();
                System.out.print(numberFormat.format(output));
                System.out.print(" )  ");
                counter += 1;
            }
        }
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public int getMineCount() {
        return this.mineCount;
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
