package com.company;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

enum Size {
    SMALL,
    MID,
    BIG,
    HUGE;
}

public class Controller {

    public Universe universe;
    public GameOfLife gof;
    public boolean isAction;
    public Thread action;
    public int delay;
    public int size;

    public Controller() {
        size = 310;
        this.gof = new GameOfLife();
        this.universe = new Universe( size);
        action = null;
        delay = 50;
//        initUniverse();
        gof.setGrid(universe.printMapOnPanel());
        gof.add(gof.getGrid(), BorderLayout.CENTER);
        gof.getAliveLabel().setText("Alive: " + universe.getAlive());
        gof.getGenLabel().setText("Generation #" + universe.getGen());
        gof.repaint();

        gof.getReset().addActionListener(e -> resetButton(size));
        gof.getStart().addActionListener(e -> startButton());
        gof.getSlider().addChangeListener(e -> delay = 100 - ((JSlider)e.getSource()).getValue());
        gof.getSmallBtn().addActionListener(e -> changeSize(Size.SMALL));
        gof.getMidBtn().addActionListener(e -> changeSize(Size.MID));
        gof.getBigBtn().addActionListener(e -> changeSize(Size.BIG));
        gof.getHugeBtn().addActionListener(e -> changeSize(Size.HUGE));
    }

//    public void initUniverse() {
//        gof.setGrid(universe.printMapOnPanel());
//        gof.add(gof.getGrid(), BorderLayout.CENTER);
//        gof.getAliveLabel().setText("Alive: " + universe.getAlive());
//        gof.getGenLabel().setText("Generation #" + universe.getGen());
//        gof.repaint();
//
//        gof.getReset().addActionListener(e -> resetButton());
//        gof.getStart().addActionListener(e -> startButton());
//    }

    public void changeSize(Size size) {
        switch (size) {
            case SMALL:
                this.size = 31;
                resetButton(this.size);
                break;
            case MID:
                this.size = 93;
                resetButton(this.size);
                break;
            case BIG:
                this.size = 310;
                resetButton(this.size);
                break;
            case HUGE:
                this.size = 930;
                resetButton(this.size);
                break;
        }
    }

    public void resetButton(int size) {
        gof.getSlider().setValue(50);
        delay = 50;
        action = null;
        isAction = false;
        gof.remove(gof.getGrid());
        universe = new Universe(size);
        gof.setGrid(universe.printMapOnPanel());
        gof.add(gof.getGrid(), BorderLayout.CENTER);
        gof.getAliveLabel().setText("Alive: " + universe.getAlive());
        gof.getGenLabel().setText("Generation #" + universe.getGen());
        gof.repaint();
    }

    public void startButton() {
//        gof.setGrid(universe.printMapOnPanel());
//        gof.add(gof.getGrid(), BorderLayout.CENTER);
//        gof.getAliveLabel().setText("Alive: " + universe.getAlive());
//        gof.getGenLabel().setText("Generation #" + universe.getGen());
//        universe.changeGen();
//        gof.repaint();

        if (action == null) {
            isAction = true;
            action = new Thread() {
                @Override
                public void run() {
                    super.run();
                    while (isAction) {
//                        System.out.println("CHECK");
//                        gof.setGrid(universe.printMapOnPanel());
//                        gof.add(gof.getGrid(), BorderLayout.CENTER);
                        gof.getAliveLabel().setText("Alive: " + universe.getAlive());
                        gof.getGenLabel().setText("Generation #" + universe.getGen());
                        universe.changeGen();
                        gof.repaint();
                        try {
                            Thread.sleep(delay);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            action.start();
        } else {
            action = null;
            isAction = false;
        }

    }
}
