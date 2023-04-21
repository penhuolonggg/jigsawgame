package tool;

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
                result[i][j] = array[i * 4 + j];
            }
        }
        return result;
    }


}
