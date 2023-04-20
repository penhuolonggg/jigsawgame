package ui;

import javax.swing.*;

public class GameJFrame extends JFrame {
    //main interface

    public GameJFrame() {

        //set tittle
        this.setTitle("jigsaw game V1.0");

        //set width and height
        this.setSize(603, 680);

        //set on top
        this.setAlwaysOnTop(true);

        //set on middle
        this.setLocationRelativeTo(null);

        //The program stops when I try to exit the window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //show the interface
        this.setVisible(true);
    }


}
