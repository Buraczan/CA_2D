package com.main;

import javax.swing.*;
import java.awt.*;

public class Frame {
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JButton grid[][];
    private JButton next;
    private JButton reset;

    static final int WIDTH = 900;
    static final int HEIGHT = 900;

    int cax = 25;
    int cay = 25;

    public void setup(String title) {

        mainFrame = new JFrame(title);
        mainPanel = new JPanel();
        grid = new JButton[cax][cay];
        next = new JButton("NEXT");
        reset = new JButton("RESET");

        mainPanel.setLayout(new GridLayout(cax, cay));

        mainFrame.setLayout(new BorderLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocation(new Point(500,100));
//        mainFrame.setLocationRelativeTo(null);
        mainFrame.setSize(new Dimension(WIDTH, HEIGHT));
        mainFrame.setResizable(false);

        for(int i = 0; i < cax; i++) {
            for(int j = 0; j < cay; j++) {
                grid[i][j] = new JButton("");

                mainPanel.add(grid[i][j]);
            }
        }

        mainFrame.add(next, BorderLayout.NORTH);
        mainFrame.add(reset, BorderLayout.SOUTH);

        mainFrame.add(mainPanel, BorderLayout.CENTER);
        mainFrame.setVisible(true);
    }

    public JButton[][] getGrid() {
        return grid;
    }

    public JButton getNext() {
        return next;
    }

    public JButton getReset() {
        return reset;
    }
}