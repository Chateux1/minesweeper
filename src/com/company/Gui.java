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
    public ArrayList<ArrayList<String>> listAllOut;
    public ArrayList<String> listAllIn;
    public ArrayList<ArrayList<Button>> table;
    public ArrayList<Button> listCol, listAll;
    private ImageIcon explodeIcon, bombIcon, buttonIcon;
    private int buttonSize = 40;

    public Gui(int row, int col, int mineCount) {
        super("Minesweeper");
        this.row = row;
        this.col = col;
        this.mineCount = mineCount;
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
    public void setSettings() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setResizable(false);
    }

    public void setMines() {
        this.sortList();
        for (int i = 0; i < this.getMineCount(); i++) {
            int id = Integer.parseInt(listAllOut.get(i).get(1));
            table1.get(id).setMine();
        }

    }

    public void printHash() {
        System.out.println();
        for (int i = 0; i < this.table1.size(); i++) {
            System.out.print("(");
            System.out.print(table1.get(i).getMine());
            System.out.println(")");
        }
    }
    public void sortList() {
        Collections.sort(this.listAllOut, new CompareMineExpectancies());
    }

    public void setLayout() {
        this.setLayout(new GridBagLayout());
    }

    public void setImages(int x, int y) {

        this.listIcons = new ArrayList<>();
        int scalingMethod = Image.SCALE_DEFAULT;

        String[] paths = {"images/button.png",
                "images/bomb.png",
                "images/explode.png"};
        String[] names = { "button",
                        "bomb",
                        "explode"};

        for (int i = 0; i < paths.length; i++) {
            ImageIcon tempIcon = new ImageIcon(paths[i]);
            Image tempImg = tempIcon.getImage();
            Image tempResized = tempImg.getScaledInstance(x, y, scalingMethod);
            this.listIcons.add(i, new ImageIcon(tempResized));
        }


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
        int counter = 0;
        this.table = new ArrayList<>();
        this.listAll = new ArrayList<>();
        this.table1 = new HashMap<>();
        this.listAllOut = new ArrayList<>();


        for (int row = 0; row < this.getRow(); row++) {

            this.listCol = new ArrayList<>();

            for (int col = 0; col < this.getCol(); col++) {

                this.listAllIn = new ArrayList<>();

                Button btn = new Button(row, col, counter);
                btn.setBounds(row * btn.getButtonSize(),
                        col * btn.getButtonSize(),
                        btn.getButtonSize(),btn.getButtonSize());

                btn.setIcon(this.buttonIcon);
                btn.setSelectedIcon(this.explodeIcon);
                this.listAllIn.add(Double.toString(btn.getMineExpectancy()));
                this.listAllIn.add(Integer.toString(btn.getId()));
                this.listAllIn.add(Boolean.toString(btn.getMine()));
                this.listCol.add(btn);
                this.table1.put(counter, btn);
                counter +=1;
                gamePanel.add(this.listCol.get(col));
                this.listAllOut.add(this.listAllIn);
            }

            this.table.add(this.listCol);
        }
        gamePanel.setPreferredSize(new Dimension( (row + 1) * this.buttonSize,
                                                  (col +1 ) * this.buttonSize));
    }

    public void printList() {
        System.out.println();
        for (int i = 0; i < this.listAllOut.size(); i++) {
            System.out.println();
            System.out.print("(" + this.listAllOut.get(i).get(0));
            System.out.print(", " + this.listAllOut.get(i).get(1));
            System.out.print(", " + this.listAllOut.get(i).get(2) + ")");
        }
    }

    public void printTable() {
        System.out.println();
        for (int i = 0; i < table.get(0).size(); i++) {
            System.out.println();
            for (int j = 0; j < table.size(); j++) {
                System.out.print("( ");
                //System.out.print(table.get(i).get(j).getRow());
                //System.out.print(", ");
                DecimalFormat numberFormat = new DecimalFormat("#.00");
                double output = table.get(i).get(j).getMineExpectancy();
                System.out.print(numberFormat.format(output));
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
