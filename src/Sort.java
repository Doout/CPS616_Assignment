import java.util.Comparator;

/**
 * Created by Baheer.
 */
public abstract class Sort<T> {

    public void swap(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;

    }

    public abstract void sort(T[] array, Comparator<T> c);

}
