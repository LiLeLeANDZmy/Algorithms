import java.util.*;

public class SubArraySum {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int pre = 0;

        // 哈希表：前缀和 -> 出现次数
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1); // 处理从头开始的子数组

        System.out.println("开始遍历数组：nums = " + Arrays.toString(nums));
        System.out.println("目标和 k = " + k);
        System.out.println();

        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            System.out.println("索引 i = " + i + "，当前元素 nums[i] = " + nums[i]);
            System.out.println("当前前缀和 pre = " + pre);

            if (mp.containsKey(pre - k)) {
                int matched = mp.get(pre - k);
                count += matched;
                System.out.println("  找到前缀和 pre-k = " + (pre - k) + "，匹配到 " + matched + " 个子数组");
            } else {
                System.out.println("  没有找到前缀和 pre-k = " + (pre - k));
            }

            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
            System.out.println("  哈希表更新：pre = " + pre + "，次数 = " + mp.get(pre));
            System.out.println("  当前总计 count = " + count);
            System.out.println("----------------------------------");
        }

        System.out.println("遍历完成，最终结果 count = " + count);
        return count;
    }

    public static void main(String[] args) {
        SubArraySum solution = new SubArraySum();

        // 测试用例 1
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("测试用例 1：nums = [1,1,1], k = 2");
        int result1 = solution.subarraySum(nums1, k1);
        System.out.println("返回结果：" + result1);
        System.out.println("\n==============================\n");

        // 测试用例 2
        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        System.out.println("测试用例 2：nums = [1,2,3], k = 3");
        int result2 = solution.subarraySum(nums2, k2);
        System.out.println("返回结果：" + result2);
        System.out.println("\n==============================\n");

        // 测试用例 3
        int[] nums3 = {1, -1, 0};
        int k3 = 0;
        System.out.println("测试用例 3：nums = [1,-1,0], k = 0");
        int result3 = solution.subarraySum(nums3, k3);
        System.out.println("返回结果：" + result3);
    }
}

