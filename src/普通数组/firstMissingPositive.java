package 普通数组;
import java.util.Arrays;

public class firstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        System.out.println("原始数组: " + Arrays.toString(nums));

        // 第一步：把 <= 0 的数换成 n+1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        System.out.println("预处理后: " + Arrays.toString(nums));

        // 第二步：标记出现过的数字
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                System.out.println("标记数字 " + num + " 出现过，将 nums[" + (num - 1) + "] 置为负数");
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        System.out.println("标记后: " + Arrays.toString(nums));

        // 第三步：找出第一个正数对应的下标 + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                System.out.println("第一个未出现的正整数是: " + (i + 1));
                return i + 1;
            }
        }

        System.out.println("所有 1~n 都出现了，返回: " + (n + 1));
        return n + 1;
    }

    public static void main(String[] args) {
        firstMissingPositive solution = new firstMissingPositive();

        int[][] testCases = {
                {1, 2, 0},
                {3, 4, -1, 1},
                {7, 8, 9, 11, 12},
                {-1, -2, -3},
                {1, 2, 3, 4, 5},
                {2, 2, 1},
                {}
        };

        for (int[] test : testCases) {
            System.out.println("====================================================");
            System.out.println("测试用例: " + Arrays.toString(test));
            int result = solution.firstMissingPositive(Arrays.copyOf(test, test.length)); // 防止原地修改污染其他用例
            System.out.println("返回结果: " + result);
            System.out.println("====================================================\n");
        }
    }
}
