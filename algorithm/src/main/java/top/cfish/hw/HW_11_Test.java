package top.cfish.hw;

/**
 * @author: isisiwish
 * @date: 2019/12/12
 * @time: 00:23
 */
public class HW_11_Test {

    private static int max(int x, int y, int z) {
        return Math.max(x, Math.max(y, z));
    }

    private static int maxContainMiddleSum(int[] arr, int left, int mid, int right) {
        // 包含arr[mid]
        int sum = 0;
        int leftArraySum = Integer.MIN_VALUE;
        // 计算以 mid 结尾的最大的子数组的和
        for (int i = mid; i >= left; i--) {
            sum += arr[i];
            if (sum > leftArraySum) {
                leftArraySum = sum;
            }
        }

        sum = 0;
        int rightArraySum = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= right; i++) {
            sum += arr[i];
            if (sum > rightArraySum) {
                rightArraySum = sum;
            }
        }
        return leftArraySum + rightArraySum;

    }

    private static int maxSubArraySum(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }
        int mid = (left + right) / 2;
        return max(maxSubArraySum(arr, left, mid), maxContainMiddleSum(arr, left, mid, right), maxSubArraySum(arr, mid + 1, right));
    }

    public static int maxSubArray(int[] arr) {
        int len = arr.length;
        if (len == 0) {
            return 0;
        }
        return maxSubArraySum(arr, 0, len - 1);
    }

    public static void main(String[] args) {
        // int[] arr = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
        // int[] arr = {-2, -8, -1, -5, -9};
        int[] arr = {2, 8, 1, 5, 9};

        int max = maxSubArray(arr);
        System.out.println(max);
    }
}
