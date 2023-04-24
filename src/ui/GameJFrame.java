package ui;

import util.ArrayUtil;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class GameJFrame extends JFrame implements KeyListener {


    //二维数组记录图片的顺序
    private int[][] data = new int[4][4];
    //正确的顺序
    private final int[][] CORRECT_DATA = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };
    //x,y记录空白图片位置
    public static int x, y;
    //计步器
    private int step = 0;
    //记录图片位置
    private String imagePath = "image/girl/girl6/";
    private final String BACKGROUND_PATH = "image/background.png";
    private final String WIN_PATH = "image/win.png";
    private final String WECHAT_PATH = "image/WeChat Image.jpg";


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
        this.setTitle("Jigsaw Game V1.0");

        //set width and height
        this.setSize(603, 680);

        //set on top
        this.setAlwaysOnTop(true);

        //set on middle
        this.setLocationRelativeTo(null);

        //The program stops when I try to exit the window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //给整个界面添加键盘监听事件（包括游戏的玩法-移动图片，快捷键等）
        this.addKeyListener(this);

        //取消组件默认局中放置
        this.setLayout(null);
    }

    public void initJMenuBar() {
        //default  menu

        JMenuBar jMenuBar = new JMenuBar();

        JMenu functionJMenu = new JMenu("Function");
        JMenu aboutUsJMenu = new JMenu("About us");
        JMenu changeItem = new JMenu("Change Image");

        JMenuItem girlItem = new JMenuItem("Girl");
        JMenuItem animalItem = new JMenuItem("Animal");
        JMenuItem sportItem = new JMenuItem("Sport");
        JMenuItem replayItem = new JMenuItem("Replay");
        JMenuItem reLoginItem = new JMenuItem("ReLogin");
        JMenuItem closeItem = new JMenuItem("Close Game");
        JMenuItem shortItem = new JMenuItem("Shortcut");

        JMenuItem accountItem = new JMenuItem("Private WeChat");

        changeItem.add(girlItem);
        changeItem.add(animalItem);
        changeItem.add(sportItem);

        functionJMenu.add(changeItem);
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(shortItem);
        functionJMenu.add(closeItem);

        aboutUsJMenu.add(accountItem);

        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutUsJMenu);


        //给条目绑定事件
        girlItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rnd = new Random();
                imagePath = "image/girl/girl" + (rnd.nextInt(11) + 1) + "/";
                step = 0;
                initOrder();
                initImage();

            }
        });
        animalItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rnd = new Random();
                imagePath = "image/animal/animal" + (rnd.nextInt(8) + 1) + "/";
                step = 0;
                initOrder();
                initImage();
            }
        });
        sportItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rnd = new Random();
                imagePath = "image/sport/sport" + (rnd.nextInt(10) + 1) + "/";
                step = 0;
                initOrder();
                initImage();
            }
        });
        replayItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                step = 0;
                initOrder();
                initImage();
            }
        });
        reLoginItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //关闭当前窗口
                GameJFrame.this.setVisible(false);
                //打开登录窗口
                new LoginJFrame();
            }
        });
        shortItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JLabel jLabel1 = new JLabel("Shortcut:");
                JLabel jLabel2 = new JLabel("A - Display full picture");
                JLabel jLabel3 = new JLabel("W - Win");
                JLabel jLabel4 = new JLabel("Esc - Quit a game");

                // 设置每个JLabel的字体和边界
                jLabel1.setFont(new Font("", Font.BOLD, 20));
                jLabel1.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 0));
                jLabel2.setFont(new Font("", Font.BOLD, 15));
                jLabel2.setBorder(BorderFactory.createEmptyBorder(10, 15, 0, 0));
                jLabel3.setFont(new Font("", Font.BOLD, 15));
                jLabel3.setBorder(BorderFactory.createEmptyBorder(10, 15, 0, 0));
                jLabel4.setFont(new Font("", Font.BOLD, 15));
                jLabel4.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 0));


                Box box = Box.createVerticalBox();
                box.add(jLabel1);
                box.add(jLabel2);
                box.add(jLabel3);
                box.add(jLabel4);


                //创建一个弹窗对象
                JDialog jDialog = new JDialog();
                jDialog.setTitle("Shortcut");
                //把box添加到弹窗中
                jDialog.getContentPane().add(box);
                //弹窗设置
                jDialog.setSize(300, 300);
                jDialog.setAlwaysOnTop(true);
                //设置弹窗居中
                jDialog.setLocationRelativeTo(null);
                //只能打开一个弹窗
                jDialog.setModal(true);
                //设置弹窗可见
                jDialog.setVisible(true);

            }
        });
        closeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        accountItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("个人微信");
                //创建一个弹窗对象
                JDialog jDialog = new JDialog();
                jDialog.setTitle("Private WeChat");
                JLabel jLabel = new JLabel(new ImageIcon(WECHAT_PATH));
                jLabel.setBounds(0, 0, 261, 344);
                //把jlabel添加到弹窗中
                jDialog.getContentPane().add(jLabel);

                //弹窗设置
                jDialog.setSize(400, 400);
                //将弹窗背景改为与我图片背景颜色一致
                jDialog.getContentPane().setBackground(new Color(205, 83, 102));
                jDialog.setAlwaysOnTop(true);
                //居中
                jDialog.setLocationRelativeTo(null);
                //弹窗不关闭则无法操作下面界面
                jDialog.setModal(true);
                jDialog.setVisible(true);
            }
        });


        this.setJMenuBar(jMenuBar);
    }

    private void initOrder() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        ArrayUtil.shuffleArray(array);
        data = ArrayUtil.splitArray(array);
    }

    private void initImage() {
        /*先运行的代码在图层的最上面*/

        //1.清空界面
        this.getContentPane().removeAll();


        //2.判断是否胜利
        if (ArrayUtil.equalArray(data, CORRECT_DATA)) {
            //清空计步器
            step = 0;
            JLabel jLabel = new JLabel(new ImageIcon(WIN_PATH));
            jLabel.setBounds(203, 283, 197, 73);
            this.getContentPane().add(jLabel);
            this.getContentPane().setComponentZOrder(jLabel, 0);
        }

        //3.初始化计步器
        initStep();

        //4.添加图片（顺序为当前data存储的数据）
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                JLabel jLabel = new JLabel(new ImageIcon(imagePath + data[i][j] + ".jpg"));
                //指定图片位置，加的数字是偏移量，为了美观
                jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                //给图像设置边框
                jLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
                //添加到界面中
                this.getContentPane().add(jLabel);
            }
        }

        //5.设置背景图片
        setBackground();

        //6.刷新界面
        this.getContentPane().repaint();

    }


    private void initStep() {
        JLabel stepLabel = new JLabel("Steps: " + step);
        stepLabel.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepLabel);
    }

    private void setBackground() {
        //set background
        JLabel background = new JLabel(new ImageIcon(BACKGROUND_PATH));
        background.setBounds(40, 40, 508, 560);
        this.getContentPane().add(background);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        //当按住A不松时，查看完整图片
        if (code == KeyEvent.VK_A) {
            //清空界面
            this.getContentPane().removeAll();
            //初始化计步器
            initStep();
            //设置完整图片
            JLabel jLabel = new JLabel(new ImageIcon(imagePath + "all.jpg"));
            jLabel.setBounds(83, 134, 420, 420);
            this.getContentPane().add(jLabel);
            //设置背景图片
            setBackground();
            //刷新界面
            this.getContentPane().repaint();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();
//        System.out.println(code);
        if (code == 38) {
            System.out.println("向上移动");
            if (x < 3) {
                data[x][y] = data[x + 1][y];
                data[x + 1][y] = 0;
                x++;
                step++;
                initImage();
            }
        } else if (code == 40) {
            System.out.println("向下移动");
            if (x > 0) {
                data[x][y] = data[x - 1][y];
                data[x - 1][y] = 0;
                x--;
                step++;
                initImage();
            }
        } else if (code == 37) {
            System.out.println("向左移动");
            if (y < 3) {
                data[x][y] = data[x][y + 1];
                data[x][y + 1] = 0;
                y++;
                step++;
                initImage();
            }
        } else if (code == 39) {
            System.out.println("向右移动");
            if (y > 0) {
                data[x][y] = data[x][y - 1];
                data[x][y - 1] = 0;
                y--;
                step++;
                initImage();
            }
        } else if (code == KeyEvent.VK_ESCAPE) {
            System.out.println("EXIT");
            System.exit(0);
        } else if (code == KeyEvent.VK_A) {
            initImage();
        } else if (code == KeyEvent.VK_W) {
            System.out.println("作弊码");
            data = ArrayUtil.copyArray(CORRECT_DATA);
            x = 3;
            y = 3;
            initImage();
        }

    }


}









