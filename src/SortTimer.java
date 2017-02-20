import java.util.Random;

/**
 * Created by Baheer.
 */
public class SortTimer {

    private static void initArrays(int size, int[][] arrays) {
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

    private static long timer(Runnable method) {
        long start = System.currentTimeMillis();
        method.run();
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long[] run(int sizeOfArray, Sort... list) {
        long[] times = new long[list.length];
        int[][] arrays = new int[list.length][sizeOfArray];
        initArrays(sizeOfArray, arrays);
        for (int i = 0; i < times.length; i++) {
            final int sortIndex = i;
            times[i] = timer(() -> list[sortIndex].sort(arrays[sortIndex]));
        }
        return times;
    }

}
