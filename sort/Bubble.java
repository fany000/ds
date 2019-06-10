package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author cyf
 */
public class Bubble {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 6};
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        int[] arr3 = Arrays.copyOf(arr, arr.length);
        normalBubble(arr);
        betterBubble(arr2);
        bestBubble(arr3);
    }

    /**
     * 未优化的冒泡排序，有序仍然需要排序
     *
     * @param arr
     */
    public static void normalBubble(int[] arr) {
        System.out.println("排序前:" + Arrays.toString(arr));
        int tmp = 0;
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
                count++;
            }
        }
        System.out.printf("未优化的冒泡排序，总共循环%d次\n", count);
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }

    /**
     * 优化的冒泡排序，有序则结束
     *
     * @param arr
     */
    public static void betterBubble(int[] arr) {
        System.out.println("排序前:" + Arrays.toString(arr));
        int tmp = 0;
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                    flag = true;
                }
                count++;
            }
            if (flag) {
                flag = false;
            } else {
                break;
            }
        }
        System.out.printf("优化的冒泡排序，总共循环%d次\n", count);
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }

    /**
     * 在betterBubble基础上优化，找出需排序的边界进行排序
     *
     * @param arr
     */
    public static void bestBubble(int[] arr) {
        System.out.println("排序前:" + Arrays.toString(arr));
        int tmp = 0;
        int count = 0;
        boolean flag = false;
        int innerIndex = arr.length;
        int tmpIndex = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (i > 0)
                innerIndex = tmpIndex;
            for (int j = 1; j < innerIndex; j++) {
                if (arr[j - 1] > arr[j]) {
                    tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                    flag = true;
                    tmpIndex = j;
                }
                count++;
            }
            if (flag) {
                flag = false;
            } else {
                break;
            }
        }
        System.out.printf("优化的冒泡排序，总共循环%d次\n", count);
        System.out.println(Arrays.toString(arr));
    }

}
