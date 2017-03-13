import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Baheer.
 */
public class BubbleSort<T> extends Sort<T> {

    @Override
    public void sort(T[] array, Comparator<T> c) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (c.compare(array[i], array[j]) > 0) {
                    swap(array, i, j);
                }
            }
        }
    }

}
