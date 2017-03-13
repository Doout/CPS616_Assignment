import java.util.Comparator;

/**
 * Created by Baheer.
 */
public class QuickSort<T> extends Sort<T> {


    private Comparator<T> c;

    @Override
    public void sort(T[] array, Comparator<T> c) {
        this.c = c;
        quickSort(array, 0, array.length - 1);
    }

    public void quickSort(T[] array, int start, int end) {
        int i = start;
        int j = end;
        T pivot = array[(int) (start + (Math.random() * (end - start) / 2d))];
        while (i <= j) {
            while (c.compare(array[i], pivot) < 0) i++;
            while (c.compare(array[j], pivot) > 0) j--;
            if (i <= j) {
                swap(array, i++, j--);
            }
        }
        if (start < j)
            quickSort(array, start, j);
        if (i < end)
            quickSort(array, i, end);
    }
}
