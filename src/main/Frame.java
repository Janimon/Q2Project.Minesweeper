package main;

import javax.swing.*;
import java.awt.*;

public class Frame {

    private int gameSize = 9;
    private MyPanel[][] fields = new MyPanel[gameSize][gameSize];
    public Frame(){


        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(500,600);
        frame.setResizable(true);
        frame.setMinimumSize(new Dimension(550,600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.BLACK);



        frame.add(mainPanel);

        JButton resetButton = new JButton();
        resetButton.setText("Reset");

        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.BLACK);
        mainPanel.add(topPanel,BorderLayout.PAGE_START);

        topPanel.add(resetButton);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.BLACK);
        mainPanel.add(bottomPanel,BorderLayout.PAGE_END);

        JPanel mineField = new JPanel(new GridLayout(gameSize,gameSize,50/gameSize,50/gameSize));
        mineField.setPreferredSize(new Dimension(500,500));
        mineField.setBackground(Color.BLACK);

        bottomPanel.add(mineField);



        for(int i = 0; i <= gameSize-1;i++){

            for(int j = 0; j <= gameSize-1;j++){
                fields[i][j] = new MyPanel(i,j);
                mineField.add(fields[i][j]);
            }
        }
        Minefield mines = new Minefield(fields);

        frame.setVisible(true);



    }

    public MyPanel[][] getFields (){
        return fields;
    }

    public MyPanel getFieldAt(int x,int y){
        return fields[x][y];
    }
}
