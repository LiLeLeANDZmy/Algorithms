package 哈希;

import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            System.out.println("当前数字: " + nums[i] + "，目标差值: " + complement);

            if(map.containsKey(complement)){
                System.out.println("找到匹配: " + complement + " 在位置 " + map.get(complement));

                return new int[]{map.get(complement), i};
            } else {
                map.put(nums[i], i);

                System.out.println("加入map: " + nums[i] + " -> " + i);
            }
        }
        return new int[]{-1};
    }

    // 测试用例主函数
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();

        // 测试用例 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = twoSum.twoSum(nums1, target1);
        System.out.println("结果1: " + Arrays.toString(result1)); // 预期：[0, 1]

        // 测试用例 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = twoSum.twoSum(nums2, target2);
        System.out.println("结果2: " + Arrays.toString(result2)); // 预期：[1, 2]

        // 测试用例 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = twoSum.twoSum(nums3, target3);
        System.out.println("结果3: " + Arrays.toString(result3)); // 预期：[0, 1]
    }
}
