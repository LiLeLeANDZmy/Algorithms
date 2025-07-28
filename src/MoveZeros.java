import java.util.Arrays;

public class MoveZeros {

    public void moveZeroes(int[] nums) {
        int index = 0;
        System.out.println("初始数组: " + java.util.Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            System.out.println("\n遍历到索引 i = " + i + "，值 = " + nums[i]);
            if (nums[i] != 0) {
                int n = nums[i];
                System.out.println("  非零元素，准备移动：nums[" + i + "] = " + n);

                nums[i] = 0;
                System.out.println("  置零当前位置：nums[" + i + "] = 0");

                nums[index] = n;
                System.out.println("  放入目标位置：nums[" + index + "] = " + n);

                index++;
            } else {
                System.out.println("  是零，跳过");
            }
            System.out.println("  当前数组状态: " + java.util.Arrays.toString(nums));
        }

        System.out.println("\n最终结果: " + java.util.Arrays.toString(nums));
    }

    // 测试用例主方法
    public static void main(String[] args) {
        MoveZeros solution = new MoveZeros();

        // 测试用例1：混合0和非0
        int[] test1 = {0, 1, 0, 3, 12};
        solution.moveZeroes(test1);
        System.out.println("测试1: " + Arrays.toString(test1)); // [1, 3, 12, 0, 0]

        // 测试用例2：全为0
        int[] test2 = {0, 0, 0, 0};
        solution.moveZeroes(test2);
        System.out.println("测试2: " + Arrays.toString(test2)); // [0, 0, 0, 0]

        // 测试用例3：全为非0
        int[] test3 = {1, 2, 3, 4};
        solution.moveZeroes(test3);
        System.out.println("测试3: " + Arrays.toString(test3)); // [1, 2, 3, 4]

        // 测试用例4：只有一个0
        int[] test4 = {0};
        solution.moveZeroes(test4);
        System.out.println("测试4: " + Arrays.toString(test4)); // [0]

        // 测试用例5：只有一个非0
        int[] test5 = {5};
        solution.moveZeroes(test5);
        System.out.println("测试5: " + Arrays.toString(test5)); // [5]

        // 测试用例6：0在中间
        int[] test6 = {4, 0, 5, 0, 6};
        solution.moveZeroes(test6);
        System.out.println("测试6: " + Arrays.toString(test6)); // [4, 5, 6, 0, 0]

        // 测试用例7：0开头和结尾
        int[] test7 = {0, 1, 2, 0};
        solution.moveZeroes(test7);
        System.out.println("测试7: " + Arrays.toString(test7)); // [1, 2, 0, 0]

        // 测试用例8：空数组
        int[] test8 = {};
        solution.moveZeroes(test8);
        System.out.println("测试8: " + Arrays.toString(test8)); // []
    }
}
