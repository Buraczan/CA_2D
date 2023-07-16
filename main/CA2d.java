package com.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CA2d {
    private int height = 0;
    private int width = 0;

    private int[][] mainCA;
    private int[][] tempCA;

    private JButton[][] grid;
    private JButton next;
    private JButton reset;

    public CA2d(int width, int height, JButton[][] grid, JButton next, JButton reset) {
        this.width = width;
        this.height = height;

        this.grid = grid;
        this.next = next;
        this.reset = reset;

        mainCA = new int[width][height];
        tempCA = new int[width][height];

        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                mainCA[i][j] = 0;
                tempCA[i][j] = 0;
            }
        }

        buttonControls();
        update();
    }

    private int countNeighbours(int x, int y) {
        int count = 0;

        if(x - 1 >= 0 && y - 1 >= 0) {
            count += mainCA[x-1][y-1];
        }
        if(x - 1 >= 0) {
            count += mainCA[x-1][y];
        }
        if(x - 1 >= 0 && y + 1 < height ) {
            count += mainCA[x-1][y+1];
        }
        if(y - 1 >= 0) {
            count += mainCA[x][y-1];
        }
        if(y + 1 < height) {
            count += mainCA[x][y+1];
        }
        if(x + 1 < width && y - 1 >= 0) {
            count += mainCA[x+1][y-1];
        }
        if(x + 1 < width) {
            count += mainCA[x+1][y];
        }
        if(x + 1 < width && y + 1 < height) {
            count += mainCA[x+1][y+1];
        }

//        count += mainCA[x-1][y-1] + mainCA[x-1][y] + mainCA[x-1][y+1]
//                + mainCA[x][y-1] + mainCA[x][y+1] + mainCA[x+1][y-1]
//                + mainCA[x+1][y] + mainCA[x+1][y+1];

        return count;
    }

    private void play() {
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                if(mainCA[i][j] == 0 && countNeighbours(i, j) == 3) {
                    tempCA[i][j] = 1;
                }
                if(mainCA[i][j] == 1 && countNeighbours(i, j) < 2 || countNeighbours(i, j) > 3) {
                    tempCA[i][j] = 0;
                }
                if(mainCA[i][j] == 1 && countNeighbours(i, j) == 2 || countNeighbours(i, j) == 3) {
                    tempCA[i][j] = 1;
                }
            }
        }

        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                int temp = tempCA[i][j];
                mainCA[i][j] = temp;
            }
        }

        update();
    }

    private void reset() {
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                mainCA[i][j] = 0;
                tempCA[i][j] = 0;
            }
        }

        update();
    }

    private void buttonControls() {
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {

                final int x = i;
                final int y = j;

                grid[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(mainCA[x][y] == 0) {
                            mainCA[x][y] = 1;
                            grid[x][y].setBackground(Color.BLACK);
                        } else {
                            mainCA[x][y] = 0;
                            grid[x][y].setBackground(Color.WHITE);
                        }
                    }
                });

            }
        }

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                play();
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });
    }

    public void update() {
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                if(mainCA[i][j] == 0) {
                    grid[i][j].setBackground(Color.WHITE);
                } else {
                    grid[i][j].setBackground(Color.BLACK);
                }
            }
        }
    }

}
