import ui.GameJFrame;
import ui.LoginJFrame;
import ui.RegisterJFrame;


import javax.swing.*;
import java.util.Random;

public class APP {
    public static void main(String[] args) {
        /* 把JFrame理解成一个JavaBean类*/

//        new RegisterJFrame();

        new LoginJFrame();

        new GameJFrame();
    }
}
