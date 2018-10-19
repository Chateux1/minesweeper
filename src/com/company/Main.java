package com.company;

import java.util.Collections;

public class Main {

    private static Gui gui, gui1;

    public static void main(String[] args) {

//        gui = new Gui(50, 50, 100);
//        gui.showGui();
//
//        gui1 = new Gui(20, 20, 100);
//        gui1.showGui();
//
//        gui.printHash();
//        gui.printTable();
//        gui.printList();
//
//        //gui.setMines();
//        gui.printTable();
//        gui.printList();
//        gui.printHash();


        MVC_Model m = new MVC_Model();
        MVC_View v = new MVC_View(m);
        new MVC_Controller(v, m,15,15);
        System.out.println("Test");
    }
}