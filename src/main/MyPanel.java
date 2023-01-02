package main;


import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyPanel extends JPanel implements MouseListener {

    private JLabel label;

    private boolean mine;
    private int mineCount;
    private int imageState;
    private boolean revealed;

    private int x;
    private int y;

    private MyPanel[] nextPanels = new MyPanel[4];


    private Images images = new Images();


    public MyPanel(int x, int y) {
        super();

        this.x = x;
        this.y = y;

        this.setLayout(new GridBagLayout());
        label = new JLabel();
        add(label);


        addMouseListener(this);
        this.setBackground(Color.gray);

    }

    public void setMine(boolean mine) {
        this.mine = mine;
    }

    public boolean isMine() {
        return mine;
    }

    public void setMineCount(int mineCount) {
        this.mineCount = mineCount;
    }

    public int getMineCount() {
        return mineCount;
    }

    public void setImageState(int imageState) {
        this.imageState = imageState;
    }

    public int getImageState() {
        return imageState;
    }

    public void setRevealed(boolean revealed) {
        this.revealed = revealed;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public MyPanel[] getNextPanels() {
        return nextPanels;
    }

    public void setNextPanels(int direction, MyPanel nextPanel) {
        nextPanels[direction] = nextPanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {


        if (e.getButton() == MouseEvent.BUTTON1) {
            if (getImageState() != 1) {
                if (isMine()) {
                    label.setIcon(images.getIMage(10, getWidth(), getHeight()));
                } else {
                    switchLabel(mineCount);
                }
                setRevealed(true);
            }

        } else if (e.getButton() == MouseEvent.BUTTON3) {
            if (!isRevealed()) {
                if (getImageState() == 1) {
                    label.setIcon(images.getIMage(12, getWidth(), getHeight()));
                    setImageState(0);
                } else {
                    label.setIcon(images.getIMage(9, getWidth(), getHeight()));
                    setImageState(1);
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBackground(Color.lightGray);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBackground(Color.gray);
    }

    public void revealArea() {
        if (getMineCount() == 0) {
            label.setIcon(images.getIMage(11, getWidth(), getHeight()));
            setRevealed(true);
            for (int i = 0; i <= nextPanels.length - 1; i++) {
                if (nextPanels[i] != null && !nextPanels[i].isRevealed()) {
                    nextPanels[i].revealArea();
                }

            }
        } else {
            switchLabel(mineCount);
            setRevealed(true);
        }
    }

    public void switchLabel(int z) {
        switch (z) {
            case 0 -> {
                revealArea();
            }
            case 1 -> {
                label.setIcon(images.getIMage(1, getWidth(), getHeight()));
            }
            case 2 -> {
                label.setIcon(images.getIMage(2, getWidth(), getHeight()));
            }
            case 3 -> {
                label.setIcon(images.getIMage(3, getWidth(), getHeight()));
            }
            case 4 -> {
                label.setIcon(images.getIMage(4, getWidth(), getHeight()));
            }
            case 5 -> {
                label.setIcon(images.getIMage(5, getWidth(), getHeight()));
            }
            case 6 -> {
                label.setIcon(images.getIMage(6, getWidth(), getHeight()));
            }
            case 7 -> {
                label.setIcon(images.getIMage(7, getWidth(), getHeight()));
            }
            case 8 -> {
                label.setIcon(images.getIMage(8, getWidth(), getHeight()));
            }
        }
    }
}
