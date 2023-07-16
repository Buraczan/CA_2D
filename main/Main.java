package com.main;

public class Main {

    public static void main(String[] args) {
        Frame mainFrame = new Frame();
        mainFrame.setup("CA2D!!!");

        CA2d cellularAutomata = new CA2d(mainFrame.cax, mainFrame.cay, mainFrame.getGrid(), mainFrame.getNext(), mainFrame.getReset());
    }
}
