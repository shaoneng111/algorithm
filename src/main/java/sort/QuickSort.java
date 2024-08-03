package sort;

import java.util.Arrays;

public class QuickSort {

    private static void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int tmp = arr[l];
        int start = l;
        int end = r;
        while (start < end) {
            while (arr[end] > tmp && start < end) {
                end--;
            }
            while (arr[start] <= tmp && start < end) {
                start++;
            }
            swap(arr, start, end);
        }
        swap(arr, l, start);
        quickSort(arr, l, start-1);
        quickSort(arr, start+1, r);
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {

        int[] arr = {3,2,4,6,1,8,4};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
}
