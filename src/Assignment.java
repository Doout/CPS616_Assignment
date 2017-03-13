/**
 * Created by Baheer.
 */
public class Assignment {


    public static void main(String... args) {
        int[] NS = {10, 20, 50, 100, 200, 500, 1_000, 2_000, 5_000, 10_000, 20_000, 50_000, 100_000, 200_000, 500_000, 1_000_000};
        Sort[] sorts = {new BubbleSort<Integer>(), new QuickSort<Integer>()};
        for (int N : NS) {
            long[] time = new long[sorts.length];
            int AVERAGEOVER = 1000000 / N;
            if (AVERAGEOVER == 0) AVERAGEOVER = 1;
            for (int i = 0; i < AVERAGEOVER; i++) {
                long[] times = SortTimer.run(N, sorts);
                for(int j = 0; j< times.length;j++){
                    time[j] += times[j];
                }
            }
            System.out.println(String.format("%d\t%d\t%d", N, time[0] / AVERAGEOVER, time[1] / AVERAGEOVER));
        }

    }
}
