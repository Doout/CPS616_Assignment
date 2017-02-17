import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Baheer.
 */
class MainTest {

    @Test
    void slowsort() {
        int[] arrays = new int[10_000];
        int[] arrays2 = new int[10_000];
        int value;
        for (int i = 0; i < arrays.length; i++) {
            value = (int) (Math.random() * 100_000d);
            arrays[i] = value;
            arrays2[i] = value;
        }
        Arrays.sort(arrays);
        Main.slowsort(arrays2);
        for (int i = 0; i < arrays.length; i++)
            assertEquals(arrays[i], arrays2[i]);
    }

    @Test
    void fastsort() {
        int[] arrays = new int[100_000];
        int[] arrays2 = new int[100_000];
        int value;
        for (int i = 0; i < arrays.length; i++) {
            value = (int) (Math.random() * 1_000_000d);
            arrays[i] = value;
            arrays2[i] = value;
        }
        Arrays.sort(arrays);
        Main.fastsort(arrays2);
        for (int i = 0; i < arrays.length; i++)
            assertEquals(arrays[i], arrays2[i]);
    }
}