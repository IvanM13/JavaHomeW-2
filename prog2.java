/* Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.*/


import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;

public class prog2 {
    private static final Logger logger = Logger.getLogger(prog2.class.getName());

    public static void main(String[] args) throws IOException {
        int[] arr = {6, 3, 7, 1, 9, 7, 34, -3, 23, -7};
        getLog();
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }

    private static void getLog() throws IOException {
        logger.setLevel(Level.INFO);
        FileHandler fh = new FileHandler("logProg2.txt");
        fh.setFormatter(new SimpleFormatter());
        logger.addHandler(fh);
        logger.setUseParentHandlers(false);
    }

    public static int[] bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    logger.info("Меняем местами элемент с индексом " + j + " (" + arr[j] + ")" +
                            " на элемент с индексом " + (j + 1) + " (" + arr[j + 1] + ")" + ":" + "\n" +
                            Arrays.toString(arr));
                }
            }
        }
        return arr;
    }
}