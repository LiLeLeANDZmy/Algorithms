import java.util.HashSet;

public class NoneHave {
    // 核心函数：滑动窗口求无重复字符最长子串
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int right = 0, left = 0;
        int maxLen = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);
            if (!set.contains(ch)) {
                set.add(ch);
                right++;
                maxLen = Math.max(maxLen, right - left);
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return maxLen;
    }

    // 主函数：测试入口
    public static void main(String[] args) {
        NoneHave noneHave = new NoneHave();

        // ✅ 测试用例 1：一般情况
        String s1 = "abcabcbb";
        System.out.println("用例1：输入：" + s1 + "，输出：" + noneHave.lengthOfLongestSubstring(s1)); // 预期：3

        // ✅ 测试用例 2：全部相同字符
        String s2 = "bbbbbb";
        System.out.println("用例2：输入：" + s2 + "，输出：" + noneHave.lengthOfLongestSubstring(s2)); // 预期：1

        // ✅ 测试用例 3：全是不同字符
        String s3 = "abcdefg";
        System.out.println("用例3：输入：" + s3 + "，输出：" + noneHave.lengthOfLongestSubstring(s3)); // 预期：7

        // ✅ 测试用例 4：有重复但不连续
        String s4 = "pwwkew";
        System.out.println("用例4：输入：" + s4 + "，输出：" + noneHave.lengthOfLongestSubstring(s4)); // 预期：3

        // ✅ 测试用例 5：空字符串
        String s5 = "";
        System.out.println("用例5：输入：" + s5 + "，输出：" + noneHave.lengthOfLongestSubstring(s5)); // 预期：0

        // ✅ 测试用例 6：一个字符
        String s6 = "z";
        System.out.println("用例6：输入：" + s6 + "，输出：" + noneHave.lengthOfLongestSubstring(s6)); // 预期：1
    }
}
