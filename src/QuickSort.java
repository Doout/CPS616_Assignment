/**
 * Created by Baheer.
 */
public class QuickSort extends Sort{


    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int start, int end) {
        int i = start;
        int j = end;
        int pivot = array[(int) (start + (Math.random() * (end - start) / 2d))];
        while (i <= j) {
            while (array[i] < pivot) i++;
            while (array[j] > pivot) j--;
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
