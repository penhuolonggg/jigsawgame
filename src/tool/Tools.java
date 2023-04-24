package tool;

import ui.GameJFrame;

import java.util.Random;

public final class Tools {
    private Tools() {

    }

    //打乱一维数组
    public static void shuffleArray(int[] array) {
        Random rnd = new Random();
        int index;
        int temp;
        for (int i = 0; i < array.length; i++) {
            index = rnd.nextInt(0, array.length);
            temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
    }

    //把一维16元素数组拆分成4*4二维数组
    public static int[][] splitArray(int[] array) {
        int[][] result = new int[4][4];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                if (array[i * 4 + j] == 16) {
                    GameJFrame.x = i;
                    GameJFrame.y = j;
                } else {
                    result[i][j] = array[i * 4 + j];
                }
            }
        }
        return result;
    }

    //复制二维数组数据值
    public static int[][] copyArray(int[][] array) {
        int[][] result = new int[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                result[i][j] = array[i][j];
            }
        }
        return result;
    }

    //判断二维数组是否相等
    public static boolean equalArray(int[][] array1, int[][] array2) {
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[i].length; j++) {
                if (array1[i][j] != array2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }


}
