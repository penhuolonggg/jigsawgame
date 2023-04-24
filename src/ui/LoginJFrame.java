package ui;

import javax.swing.*;
import java.awt.*;

public class LoginJFrame extends JFrame {

    private final String BACKGROUND_PATH = "image/login/background.png";
    private final String USERNAME_PATH = "image/login/用户名.png";
    private final String PASSWORD_PATH = "image/login/密码.png";
    private final String SECURITY_CODE = "image/login/验证码.png";


    //login interface

    public LoginJFrame() {
        initJFrame();

        //向界面中添加内容
        initView();

        //show the interface
        this.setVisible(true);
    }

    private void initJFrame() {

        //set tittle
        this.setTitle("Jigsaw Game Login");

        //set width and height
        this.setSize(488, 430);

        //set on top
        this.setAlwaysOnTop(true);

        //set on middle
        this.setLocationRelativeTo(null);

        //The program stops when I try to exit the window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //取消内部布局
        this.setLayout(null);

    }

    private void initView() {
        //1. 添加用户名文字
        JLabel usernameText = new JLabel(new ImageIcon(USERNAME_PATH));
        usernameText.setBounds(116, 135, 47, 17);
        this.getContentPane().add(usernameText);

        //2.添加用户名输入框
        JTextField username = new JTextField();
        username.setBounds(195, 134, 200, 30);
        this.getContentPane().add(username);

        //3.添加密码文字
        JLabel passwordText = new JLabel(new ImageIcon(PASSWORD_PATH));
        passwordText.setBounds(130, 195, 32, 16);
        this.getContentPane().add(passwordText);

        //4.密码输入框
        JPasswordField password = new JPasswordField();
        password.setBounds(195, 195, 200, 30);
        this.getContentPane().add(password);

        /*showPassword.addActionListener(e -> {
            if (showPassword.isSelected()) {
                password.setEchoChar((char) 0);
            } else {
                password.setEchoChar('*');
            }
        });

        //5.添加显示密码按钮
        JLabel showPass=new JLabel(new ImageIcon());
*/

        //验证码提示
        JLabel codeText = new JLabel(new ImageIcon(SECURITY_CODE));
        codeText.setBounds(133, 256, 50, 30);
        this.getContentPane().add(codeText);
        //验证码的输入框
        JTextField code = new JTextField();
        code.setBounds(195, 256, 100, 30);
        this.getContentPane().add(code);



        //




        //设置背景
        setBackground();

    }


    private void setBackground() {
        JLabel background = new JLabel(new ImageIcon(BACKGROUND_PATH));
        background.setBounds(0, 0, 470, 390);
        this.getContentPane().add(background);
    }


}
