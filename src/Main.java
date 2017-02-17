import java.util.Arrays;
import java.util.Random;

/**
 * Created by Baheer.
 */
public class Main {


    public static void main(String... args) {
        int[] NS = {10, 20, 50, 100, 200, 500, 1_000, 2_000, 5_000, 10_000, 20_000, 50_000, 100_000, 200_000, 500_000, 1_000_000};
        for (int N : NS) {
            int AVERAGEOVER = 1000000 / N;
            if (AVERAGEOVER == 0) AVERAGEOVER = 1;
            int[] A, B;
            A = new int[N];
            B = new int[N];
            initArrays(N, A, B);
            long slow = timer(() -> slowsort(B));
            long fast = timer(() -> fastsort(A));
            System.out.println(String.format("%d\t%d\t%d", N, slow / AVERAGEOVER, fast / AVERAGEOVER));
        }
    }

    public static void initArrays(int size, int[]... arrays) {
        int maxValue = size * 10;
        int value;
        Random rand = new Random(System.nanoTime());
        for (int i = 0; i < size; i++) {
            value = rand.nextInt(maxValue);
            for (int j = 0; j < arrays.length; j++) {
                arrays[j][i] = value;
            }
        }
    }

    /**
     * O(n^2) sort
     */
    public static void slowsort(int array[]) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    //This is your O(n logn) algorithm
    public static void fastsort(int array[]) {
        //Arrays.sort(array); // Using timmsort
        quickSort(array, 0, array.length - 1);
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void quickSort(int[] array, int start, int end) {

        int i = start;
        int j = end;
        int pivot = array[(int) (start + (Math.random() * (end - start) / 2d))];
        while (i <= j) {
            while (array[i] < pivot) i++;
            while (array[j] > pivot) j--;
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if (start < j)
            quickSort(array, start, j);
        if (i < end)
            quickSort(array, i, end);
    }

    public static long timer(Runnable method) {
        long start = System.currentTimeMillis();
        method.run();
        long end = System.currentTimeMillis();
        return end - start;
    }

}
