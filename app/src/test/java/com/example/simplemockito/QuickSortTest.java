package com.example.simplemockito;

import java.util.ArrayList;
import java.util.Arrays;
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
    private static final int NUM_TEST_CASES = 5;
    private static final int TEST_DATA_SIZE = 10;

    @Mock
    List<Integer> mockData = mock(List.class);

    private List<List<Integer>> testData = new ArrayList<>();

    @Before
    public void init_data() {
        for (int i = 0; i < NUM_TEST_CASES; i++) {
            testData.add(generateTestData());
        }
    }

    public List<Integer> generateTestData() {
        List<Integer> testData = new ArrayList<>();
        for (int i = 0; i < TEST_DATA_SIZE; i++) {
            int testValue = (int) (Math.random() * 100);
            testData.add(testValue);
        }
        return testData;
    }

    @Test
    public void quickSort_testRandom() {
        for (int i = 0; i < NUM_TEST_CASES; i++) {
            List<Integer> testCaseData = testData.get(i);
            QuickSort quickSort = new QuickSort();
            quickSort.sort(testCaseData);
            for (int j = 1; j < TEST_DATA_SIZE - 1; j++) {
                assert (testCaseData.get(i) <= testCaseData.get(i + 1));
            }
        }
    }

    @Test
    public void quickSort_testGetPivot1() {
        QuickSort quickSort = new QuickSort();
        List<Integer> test1 = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        int pivotIndex = quickSort.getPivotIndex(0, test1.size(), test1);
        for (int i = 0; i < pivotIndex; i++) {
            assert (test1.get(i) <= test1.get(pivotIndex));
        }

        for (int i = pivotIndex + 1; i < test1.size(); i++) {
            assert (test1.get(i) >= test1.get(pivotIndex));
        }
    }

    @Test
    public void quickSort_testGetPivot2() {
        QuickSort quickSort = new QuickSort();
        List<Integer> test2 = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        int pivotIndex = quickSort.getPivotIndex(0, test2.size(), test2);
        for (int i = 0; i < pivotIndex; i++) {
            assert (test2.get(i) <= test2.get(pivotIndex));
        }

        for (int i = pivotIndex + 1; i < test2.size(); i++) {
            assert (test2.get(i) >= test2.get(pivotIndex));
        }
    }

    @Test
    public void quickSort_testGetPivot3() {
        QuickSort quickSort = new QuickSort();
        List<Integer> test3 = Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1, 0);
        int pivotIndex = quickSort.getPivotIndex(0, test3.size(), test3);
        for (int i = 0; i < pivotIndex; i++) {
            assert (test3.get(i) <= test3.get(pivotIndex));
        }

        for (int i = pivotIndex + 1; i < test3.size(); i++) {
            assert (test3.get(i) >= test3.get(pivotIndex));
        }
    }

    @Test
    public void quickSort_testGetPivot4() {
        QuickSort quickSort = new QuickSort();
        List<Integer> test4 = Arrays.asList(1, 0, 3, 2, 5, 4, 7, 6, 9, 8);
        int pivotIndex = quickSort.getPivotIndex(0, test4.size(), test4);
        for (int i = 0; i < pivotIndex; i++) {
            assert (test4.get(i) <= test4.get(pivotIndex));
        }

        for (int i = pivotIndex + 1; i < test4.size(); i++) {
            assert (test4.get(i) >= test4.get(pivotIndex));
        }
    }

    @Test
    public void quickSort_testGetPivot5() {
        QuickSort quickSort = new QuickSort();
        List<Integer> test5 = Arrays.asList(5, 6, 7, 8, 9, 0, 1, 2, 3, 4);
        int pivotIndex = quickSort.getPivotIndex(0, test5.size(), test5);
        for (int i = 0; i < pivotIndex; i++) {
            assert (test5.get(i) <= test5.get(pivotIndex));
        }

        for (int i = pivotIndex + 1; i < test5.size(); i++) {
            assert (test5.get(i) >= test5.get(pivotIndex));
        }
    }

    @After
    public void clear_data() {
        testData.clear();
    }

}
