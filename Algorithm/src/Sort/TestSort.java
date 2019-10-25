package Sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TestSort {

    @Disabled
    @Test
    public void testSort() {
        int[] input = new int[]{3, 7, 12, 1, 9, 71};
        int[] expected = new int[]{1, 3, 7, 9, 12, 71};
        Merge.sort(input, 0, input.length - 1);
        Assertions.assertArrayEquals(expected, input);
    }

    @Test
    public void testSelectionSort() {
        String[] input = {"great", "aa", "the", "space", "niddle", "aha"};
        int expected = 1;

        int actual = Selection.indexOfMimimum(input, 0);
        Assertions.assertEquals(expected, actual);
    }
}
