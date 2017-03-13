import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Baheer.
 */
class SortTest {

    @Test
    void bubbleSort() {
        Integer[] arrays = new Integer[10_000];
        Integer[] arrays2 = new Integer[10_000];
        int value;
        for (int i = 0; i < arrays.length; i++) {
            value = (int) (Math.random() * 100_000d);
            arrays[i] = value;
            arrays2[i] = value;
        }
        Comparator<Integer> integerComparator = Integer::compareTo;
        List<Integer> sortList = Arrays.stream(arrays).parallel().sorted(integerComparator).collect(Collectors.toList());
        new BubbleSort<Integer>().sort(arrays2, integerComparator);

        for (int i = 0; i < arrays.length; i++)
            assertEquals(sortList.get(i), arrays2[i]);
    }

    @Test
    void quickSort() {
        Integer[] arrays = new Integer[100_000];
        Integer[] arrays2 = new Integer[100_000];

        int value;
        for (int i = 0; i < arrays.length; i++) {
            value = (int) (Math.random() * 1_000_000d);
            arrays[i] = value;
            arrays2[i] = value;
        }
        Comparator<Integer> integerComparator = Integer::compareTo;
        List<Integer> sortList = Arrays.stream(arrays).parallel().sorted(integerComparator).collect(Collectors.toList());
        new QuickSort<Integer>().sort(arrays2, integerComparator);
        for (int i = 0; i < arrays.length; i++)
            assertEquals(sortList.get(i), arrays2[i]);
    }
}