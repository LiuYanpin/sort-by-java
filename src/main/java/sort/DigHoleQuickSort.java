package sort;

/**
 * @author lyp
 * 挖坑填数 + 分治法
 * 1．i = L; j = R; 将基准数挖出形成第一个坑 a[i]。
 * 2．j-- 由后向前找比它小的数，找到后挖出此数填前一个坑 a[i] 中。
 * 3．i++ 由前向后找比它大的数，找到后也挖出此数填到前一个坑 a[j] 中。
 * 4．再重复执行 2，3 二步，直到 i==j，将基准数填入 a[i] 中。
 *
 */
public class DigHoleQuickSort {
    public static void quickSort(int[] arr, int left, int right) {
        if (arr == null || left > right || arr.length <= 1) {
            return;
        }
        int mid = partition(arr, left, right);
        quickSort(arr, left, mid);
        quickSort(arr, mid + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int temp = arr[left];
        while (right > left) {
            //先判断基准数和后面的数依次比较
            while (temp <= arr[right] && left < right) {
                --right;
            }
            //当基准数大于了arr[right]，则填坑
            if (left < right) {
                arr[left] = arr[right];
                ++left;
            }
            //现在是arr[right]需要填坑了
            while (temp >= arr[left] && left < right) {
                ++left;
            }
            if (left < right) {
                arr[right] = arr[left];
                --right;
            }
        }
        arr[left] = temp;
        return left;
    }
}
