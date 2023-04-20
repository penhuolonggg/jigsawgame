package ui;

import javax.swing.*;

public class RegisterJFrame extends JFrame {
    //register interface

    public RegisterJFrame() {

        //set tittle
        this.setTitle("jigsaw game register");

        //set width and height
        this.setSize(488, 500);

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
