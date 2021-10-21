package ru.job4j.iterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);

        assertThat(input, is(Arrays.asList(1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);

        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test
    public void whenAddAfterRemoveIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        ListUtils.removeIf(input, (s) -> (s % 2 == 0));

        assertThat(input, is(Arrays.asList(1, 3, 5)));
    }

    @Test
    public void whenAddAfterReplaceIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        ListUtils.replaceIf(input, (s) -> (s % 2 == 0), 777);

        assertThat(input, is(Arrays.asList(1, 777, 3, 777, 5, 777)));
    }

    @Test
    public void whenAddAfterRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> inputCorrect = new ArrayList<>(Arrays.asList(1, 3, 5));
        ListUtils.replaceIf(input, (s) -> (s % 2 == 0), 777);
        ListUtils.removeAll(input, inputCorrect);

        assertThat(input, is(Arrays.asList(777, 777, 777)));
    }
}