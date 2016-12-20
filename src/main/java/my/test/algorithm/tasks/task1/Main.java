package my.test.algorithm.tasks.task1;

import java.util.Arrays;
import java.util.Random;

/**
 * Тестовые алгоритмы из книги Скиена С. Алгоритмы.
 */
public class Main {

    private static Random random = new Random();

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10);
        }
        insertionSort(arr);

    }


    public static void myInsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int first = arr[i];
            int comparable = i - 1;
            while (comparable >= 0 && arr[comparable]>first){
                arr[comparable + 1] = arr[comparable];
                comparable--;
            }
            arr[comparable+1]=first;
        }
    }

    public static void insertionSort(int[] arr) {
        System.out.println("arr = " + Arrays.toString(arr));
        for (int i = 1; i < arr.length; i++) {
            System.out.println("Iteration " + i);
            int first = arr[i];
            int comparable = i - 1;
            System.out.println("currElem = " + first);
            System.out.println("prevKey = " + comparable);
            while (comparable >= 0 && arr[comparable] > first) {
                arr[comparable + 1] = arr[comparable];
                comparable--;
                System.out.println("    While go = " + Arrays.toString(arr));
            }
            arr[comparable + 1] = first;
            System.out.println("Iteration End = " + Arrays.toString(arr));
            System.out.println("==========");
        }
    }

}
