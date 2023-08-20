package com.learn.demo.interview.algorithm.zuochengyun;

/**
 * <p> 主要用于包括XXXX</p>
 *
 * @Author <a href="mailto:immarktube@gmail.com">Marktube</a>
 * @Since 2023/2/12 19:05
 **/
public class P7 {
    public static void main(String[] args) {
        int[] s = {2, 5, 8, 2, 3, 9, 6, 3, 8, 7, 6, 5, 4, 3, 1, 0};

        print(s);
        bubbleSorted(s);
        print(s);
    }

    private static void print(int[] arr) {
        for (int i :
                arr) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    private static void bubbleSorted(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }


            int n = arr.length;
            int temp;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
