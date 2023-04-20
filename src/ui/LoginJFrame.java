package ui;

import javax.swing.*;
import java.awt.*;

public class LoginJFrame extends JFrame {
    //login interface

    public LoginJFrame() {

        //set tittle
        this.setTitle("jigsaw game login");

        //set width and height
        this.setSize(488, 430);

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
