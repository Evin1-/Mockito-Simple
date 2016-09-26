package com.example.simplemockito;

import java.util.List;

/**
 * Created by jonathanhavstad on 9/26/16.
 */

public class QuickSort {
    private List<Integer> data;
    public QuickSort(List<Integer> data) {
        this.data = data;
    }

    public void sort() {
        if (data == null || data.size() == 0) {
            return;
        }
        quickSort(0, data.size() - 1);
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pivot = data.get(high);
            int i = low, j = 0;
            for (j = i; j < high; j++) {
                if (data.get(j) <= pivot) {
                    swap(i, j);
                    i++;
                }
            }
            swap(i, j);
            quickSort(low, i - 1);
            quickSort(i, high);
        }
    }

    private void swap(int i, int j) {
        int temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }
}
