package com.learn.demo.interview.algorithm.zuochengyun;

/**
 * <p> 主要用于包括XXXX</p>
 *
 * @Author <a href="mailto:immarktube@gmail.com">Marktube</a>
 * @Since 2023/2/9 12:56
 **/
public class P6 {

    public static void main(String[] args) {
        int[] s = {2, 5, 8, 2, 3, 9, 6, 3, 8, 7, 6, 5, 4, 3, 1, 0};

        print(s);
        selectSorted(s);
        print(s);
    }

    private static void selectSorted(int[] arr) {
        int N = arr.length;
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < N; i++) {

            int minNumberIndex = i;
            for (int j = i + 1; j < N; j++) {
                minNumberIndex = arr[j] < arr[minNumberIndex] ? j : minNumberIndex;
            }
            swap(arr,i,minNumberIndex);
        }

    }

    private static void swap(int[] arr, int i, int minNumberIndex) {
        int temp = arr[minNumberIndex];
        arr[minNumberIndex] = arr[i];
        arr[i] = temp;
    }

    private static void print(int[] arr) {
        for (int i :
                arr) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
