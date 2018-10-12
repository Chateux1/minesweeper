package com.company;

import java.util.Collections;

public class Main {

    private static Gui gui;

    public static void main(String[] args) {

        gui = new Gui(20, 10, 100);
        gui.showGui();

        gui.printHash();
        gui.printTable();
        gui.printList();

        //gui.setMines();
        gui.printTable();
        gui.printList();
        gui.printHash();
    }
}
