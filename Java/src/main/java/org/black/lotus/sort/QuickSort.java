package org.black.lotus.sort;

public class QuickSort {

    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int low = left;
            int high = right;
            int pivot = array[left];
            while (low < high) {
                while (low < high && array[high] >= pivot) {
                    high--;
                }
                array[low] = array[high];
                while (low < high && array[low] <= pivot) {
                    low++;
                }
                array[high] = array[low];
            }
            array[low] = pivot;
            quickSort(array, left, low - 1);
            quickSort(array, low + 1, right);
        }
    }

    public static void main(String... args) {
        int[] array = new int[]{7, 6, 8, 9, 12, 1, 6};
        quickSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.println(i);
        }
    }
}
