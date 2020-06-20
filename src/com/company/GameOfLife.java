package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GameOfLife extends JFrame {
    private JLabel genLabel;
    private JLabel aliveLabel;
    private JPanel labels;
    private JPanel grid;

    private JButton start;
    private JButton reset;
    private JSlider slider;
    private JPanel controller;
    private JButton smallBtn;
    private JButton midBtn;
    private JButton bigBtn;
    private JButton hugeBtn;

    public boolean isAction;

    public GameOfLife() {
        super("Game Of Life");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1138, 950);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        createWindow(this);
    }

    private void createWindow(GameOfLife gof) {
        gof.setGenLabel(new JLabel("Generation #0"));
        gof.setAliveLabel(new JLabel("Alive: 0"));
        gof.getGenLabel().setName("GenerationLabel");
//        gof.getGenLabel().setForeground(Color.WHITE);
        gof.getAliveLabel().setName("AliveLabel");
        gof.getGenLabel().setAlignmentX(Component.CENTER_ALIGNMENT);
        gof.getAliveLabel().setAlignmentX(Component.CENTER_ALIGNMENT);
//        gof.getAliveLabel().setForeground(Color.WHITE);
        gof.setLabels(new JPanel());
        gof.getLabels().setLayout(new BoxLayout(gof.getLabels(), BoxLayout.PAGE_AXIS));
        gof.getLabels().add(gof.getGenLabel());
        gof.getLabels().add(gof.getAliveLabel());
        gof.getLabels().setBorder(new EmptyBorder(10, 0, 10, 0));
//        gof.getLabels().setBackground(Color.BLACK);
//        gof.getLabels().setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        gof.add(gof.getLabels(), BorderLayout.NORTH);
//        gof.add(new JPanel(), BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//        panel.setLayout(new GridLayout());
//        panel.setSize(500, 950);

        JPanel btns = new JPanel();
        gof.setStart(new JButton("start/pause"));
        gof.setReset(new JButton("reset"));
        btns.add(gof.getStart());
        btns.add(gof.getReset());
        btns.setAlignmentX(Component.CENTER_ALIGNMENT);
        gof.getLabels().setAlignmentX(Component.CENTER_ALIGNMENT);
        btns.setMaximumSize(btns.getPreferredSize());
//        gof.getLabels().setMaximumSize(gof.getLabels().getPreferredSize());
        gof.getLabels().setSize(100, (int)gof.getLabels().getPreferredSize().getHeight());

        slider = new JSlider(1, 100);
        slider.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel test = new JPanel();
//        test.setSize(100, 200);
        JPanel sizeBtns = new JPanel();
        sizeBtns.setLayout(new GridLayout(2, 2));
//        sizeBtns.setSize(30, 30);
//        sizeBtns.setMaximumSize(sizeBtns.getPreferredSize());
//        sizeBtns.setBorder(BorderFactory.createEtchedBorder(Color.LIGHT_GRAY, Color.DARK_GRAY));
        smallBtn = new JButton("small");
        midBtn = new JButton("mid");
        bigBtn = new JButton("big");
        hugeBtn = new JButton("huge");
        sizeBtns.add(smallBtn);
        sizeBtns.add(midBtn);
        sizeBtns.add(bigBtn);
        sizeBtns.add(hugeBtn);
        test.add(sizeBtns);

        panel.add(gof.getLabels());
        panel.add(btns);
        panel.add(slider);
        panel.add(test);

        gof.add(panel, BorderLayout.WEST);
    }

//    public static void createController(GameOfLife gof) {
//        gof.setController(new JPanel());
//        gof.getController().setLayout(new GridBagLayout());
//
//        gof.setGenLabel(new JLabel("Generation #0"));
//        gof.setAliveLabel(new JLabel("Alive: 0"));
//        gof.getGenLabel().setName("GenerationLabel");
//        gof.getGenLabel().setForeground(Color.GREEN);
//        gof.getAliveLabel().setName("AliveLabel");
//        gof.getAliveLabel().setForeground(Color.GREEN);
//
//        gof.getController().add(gof.getGenLabel());
//    }

    public JLabel getGenLabel() {
        return genLabel;
    }

    public void setGenLabel(JLabel genLabel) {
        this.genLabel = genLabel;
    }

    public JLabel getAliveLabel() {
        return aliveLabel;
    }

    public void setAliveLabel(JLabel aliveLabel) {
        this.aliveLabel = aliveLabel;
    }

    public JPanel getLabels() {
        return labels;
    }

    public void setLabels(JPanel labels) {
        this.labels = labels;
    }

    public JPanel getGrid() {
        return grid;
    }

    public void setGrid(JPanel grid) {
        this.grid = grid;
    }

    public JPanel getController() {
        return controller;
    }

    public void setController(JPanel controller) {
        this.controller = controller;
    }

    public JButton getStart() {
        return start;
    }

    public void setStart(JButton start) {
        this.start = start;
    }

    public JButton getReset() {
        return reset;
    }

    public void setReset(JButton reset) {
        this.reset = reset;
    }

    public JSlider getSlider() {
        return slider;
    }

    public void setSlider(JSlider slider) {
        this.slider = slider;
    }

    public JButton getSmallBtn() {
        return smallBtn;
    }

    public void setSmallBtn(JButton smallBtn) {
        this.smallBtn = smallBtn;
    }

    public JButton getMidBtn() {
        return midBtn;
    }

    public void setMidBtn(JButton midBtn) {
        this.midBtn = midBtn;
    }

    public JButton getBigBtn() {
        return bigBtn;
    }

    public void setBigBtn(JButton bigBtn) {
        this.bigBtn = bigBtn;
    }

    public JButton getHugeBtn() {
        return hugeBtn;
    }

    public void setHugeBtn(JButton hugeBtn) {
        this.hugeBtn = hugeBtn;
    }

//    @Override
//    public void paintComponents(Graphics g) {
//        super.paintComponents(g);
//    }
//    @Override
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        for (int x = 10; x <= 300; x += 10)
//            for (int y = 10; y <= 300; y += 10)
//                g.drawRect(x, y, 10, 10);
//    }
}