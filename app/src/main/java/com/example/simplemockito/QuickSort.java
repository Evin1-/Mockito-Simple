package com.example.simplemockito;

import java.util.List;

/**
 * Created by jonathanhavstad on 9/26/16.
 */

public class QuickSort {
    public void sort(List<Integer> data) {
        if (data == null || data.size() == 0) {
            return;
        }
        quickSort(0, data.size(), data);
    }

    public void quickSort(int low, int high, List<Integer> data) {
        int index = getPivotIndex(low, high, data);
        if (index != -1) {
            quickSort(low, index, data);
            quickSort(index, high, data);
        }
    }

    public int getPivotIndex(int low, int high, List<Integer> data) {
        if (low >= high-1) {
            return -1;
        }
        int pivot = data.get(high-1);
        int i = low, j = 0;
        for (j = low; j < high-1; j++) {
            if (data.get(j) <= pivot) {
                swap(i, j, data);
                i += 1;
            }
        }
        swap(i, j, data);
        return i;
    }

    private void swap(int i, int j, List<Integer> data) {
        int temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }
}
