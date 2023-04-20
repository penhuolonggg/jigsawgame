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

        //default  menu
        JMenuBar jMenuBar = new JMenuBar();

        JMenu functionJMenu = new JMenu("Function");
        JMenu aboutUsJMenu = new JMenu("About us");

        JMenuItem replayItem = new JMenuItem("Replay");
        JMenuItem reLoginItem = new JMenuItem("ReLogin");
        JMenuItem closeItem = new JMenuItem("Close Game");

        JMenuItem accountItem = new JMenuItem("Official Accounts");


        //show the interface
        this.setVisible(true);
    }


}
