package 哈希;
import java.util.HashSet;
import java.util.Set;
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLen = 0;
        System.out.println("初始Set内容: " + set);

        for (int num : set) {
            // 只从序列的起点开始扩展（num-1不在set中）
            if (!set.contains(num - 1)) {

                int currentNum = num;
                int currentStreak = 1;

                System.out.println("\n从起点 " + num + " 开始查找连续序列");

                // 向右寻找连续数字
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                    System.out.println("  找到连续数字: " + currentNum);
                }

                maxLen = Math.max(maxLen, currentStreak);
                System.out.println("  当前序列长度: " + currentStreak + ", 当前最长: " + maxLen);
            }
        }

        System.out.println("\n最终最长连续序列长度: " + maxLen);
        return maxLen;
    }

    public static void main(String[] args) {
        LongestConsecutive solution = new LongestConsecutive();

        int[] test1 = {100, 4, 200, 1, 3, 2};
        System.out.println("测试用例1: [100, 4, 200, 1, 3, 2]");
        solution.longestConsecutive(test1);

        int[] test2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("\n测试用例2: [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]");
        solution.longestConsecutive(test2);

        int[] test3 = {};
        System.out.println("\n测试用例3: []");
        solution.longestConsecutive(test3);

        int[] test4 = {1, 2, 0, 1};
        System.out.println("\n测试用例4: [1, 2, 0, 1]");
        solution.longestConsecutive(test4);
    }
}
