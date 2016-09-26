package com.example.simplemockito;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by jonathanhavstad on 9/26/16.
 */

public class QuickSortTest {
    private final static int TEST_DATA_SIZE = 10;
    @Mock
    List<Integer> mockData = mock(List.class);

    List<Integer> testData = new ArrayList<>(10);

    @Before
    public void init_data() {
        for (int i = 0; i < TEST_DATA_SIZE; i++) {
            testData.add(TEST_DATA_SIZE - i - 1);
            when(mockData.get(i)).thenReturn(i);
        }
    }

    @Test
    public void quickSort_returnsSorted() {
        QuickSort quickSort = new QuickSort(testData);
        quickSort.sort();
        for (int i = 1; i < TEST_DATA_SIZE; i++) {
            assert(testData.get(i) == mockData.get(i));
        }
    }

    @After
    public void clear_data() {
        testData.clear();
    }

}
