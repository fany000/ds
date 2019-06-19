package sort;

import java.util.Arrays;

/**
 * 基数排序
 *
 * @author cyf
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {3, 501, 2, 60, 1, 4};
        int max = arr[0];

        //找出最大的数
        for (int a : arr) {
            if (a > max) {
                max = a;
            }
        }
        //算出最大的数的位数
        int len = (max + "").length();
        //存放排序的桶，行为0-9位数的桶，列为按位数存放的数
        int[][] buckets = new int[10][arr.length];
        //每个桶每次排序的位数
        int[] counts = new int[10];
        //len有多少位数就需要len次排序
        for (int i = 0, n = 1; i < len; i++, n *= 10) {
            //排序开始:
            //在需要排序的数组中依次放入对应的桶
            for (int j = 0; j < arr.length; j++) {
                //算出当前数应该放入哪个桶中,先放个位数，再放十位数，以此类推，n对应得是位数
                int index = arr[j] / n % 10;
                //把数据放入桶中
                buckets[index][counts[index]] = arr[j];
                //桶的数量也需要增加
                counts[index]++;
            }
            //本轮排序结束从桶中把数据放到arr中
            for (int k = 0, l = 0; k < buckets.length; k++) {
                //取出桶中的个数
                int count = counts[k];
                //依次取出
                for (int m = 0; m < count; m++) {
                    arr[l] = buckets[k][m];
                    l++;
                }
                //重置，下轮排序统计用
                counts[k] = 0;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
