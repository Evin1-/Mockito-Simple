package com.example.simplemockito;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by jonathanhavstad on 9/26/16.
 */

public class QuickSortTest {
    private final static int TEST_DATA_SIZE = 10;
    List<Integer> testData = new ArrayList<>();

    @Before
    public void init_data() {
        for (int i = 0; i < TEST_DATA_SIZE; i++) {
            testData.add((int) (Math.random() * TEST_DATA_SIZE));
        }
    }

    @Test
    public void quickSort_returnsSorted() {
        QuickSort quickSort = new QuickSort(testData);
        quickSort.sort();
        for (int i = 1; i < TEST_DATA_SIZE; i++) {
            assert(testData.get(i-1) <= testData.get(i));
        }
    }

    @After
    public void clear_data() {
        testData.clear();
    }

}
