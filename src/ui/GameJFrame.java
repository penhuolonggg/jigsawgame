package ui;

import tool.Tools;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.event.*;


public class GameJFrame extends JFrame {


    //二维数组记录图片的顺序
    private int[][] data = new int[4][4];


    //main interface
    public GameJFrame() {

        //初始化界面
        initJFrame();
        //初始化菜单
        initJMenuBar();
        //初始化数据（打乱图片）
        initOrder();
        //初始化图片
        initImage();

        //show the interface
        this.setVisible(true);
    }


    public void initJFrame() {
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

        //set background
        JLabel background = new JLabel(new ImageIcon("image/background.png"));
        background.setBounds(40, 40, 508, 560);
        this.getContentPane().add(background);

        //set shortcut key
        //EXIT退出快捷键
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                }
            }
        });

        //取消默认局中放置
        this.setLayout(null);
    }

    public void initJMenuBar() {
        //default  menu

        JMenuBar jMenuBar = new JMenuBar();

        JMenu functionJMenu = new JMenu("Function");
        JMenu aboutUsJMenu = new JMenu("About us");


        JMenuItem replayItem = new JMenuItem("Replay");
        JMenuItem reLoginItem = new JMenuItem("ReLogin");
        JMenuItem closeItem = new JMenuItem("Close Game");

        JMenuItem accountItem = new JMenuItem("Private WeChat");

        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        aboutUsJMenu.add(accountItem);

        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutUsJMenu);

        this.setJMenuBar(jMenuBar);
    }

    private void initImage() {

        //添加图片
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                JLabel jLabel = new JLabel(new ImageIcon("image/animal/animal6/" + data[i][j] + ".jpg"));
                //指定图片位置，加的数字是偏移量，为了美观
                jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                //给图像设置边框
                jLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
                //添加到界面中
                this.getContentPane().add(jLabel);
                //将图片置于background图片的上面
                this.getContentPane().setComponentZOrder(jLabel, 0);
            }
        }

    }

    private void initOrder() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        Tools.shuffleArray(array);
        data = Tools.splitArray(array);
    }


}









