package com.company;

public class Main {

    public static void main(String[] args) {
        Gui gui = new Gui(10,12);
        gui.showGui();
        System.out.println(gui.listRow[1][1].get(0).getText());
    }
}
