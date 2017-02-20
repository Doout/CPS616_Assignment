/**
 * Created by Baheer.
 */
public abstract class Sort {

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public abstract void sort(int[] array);

}
