import java.util.*;

public class findAngrams {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        System.out.println("原始字符串 s = " + s);
        System.out.println("模式字符串 p = " + p);

        if (sLen < pLen) {
            System.out.println("s 比 p 短，直接返回空列表");
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<>();

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        // 1. 初始化频次数组
        for (int i = 0; i < pLen; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }

        System.out.println("初始窗口 sCount：" + Arrays.toString(sCount));
        System.out.println("目标频次 pCount：" + Arrays.toString(pCount));

        // 2. 判断初始窗口
        if (Arrays.equals(sCount, pCount)) {
            System.out.println("初始窗口匹配，添加索引 0");
            ans.add(0);
        }

        // 3. 滑动窗口
        for (int i = 0; i < sLen - pLen; i++) {
            int outCharIndex = s.charAt(i) - 'a';
            int inCharIndex = s.charAt(i + pLen) - 'a';
            System.out.println(sLen - pLen);
            System.out.println(outCharIndex);
            System.out.println(inCharIndex);

            System.out.println("\n滑动窗口：从位置 " + (i + 1) + " 开始");
            System.out.println("移出字符：" + s.charAt(i));
            System.out.println("移入字符：" + s.charAt(i + pLen));

            sCount[outCharIndex]--;
            sCount[inCharIndex]++;

            System.out.println("当前窗口 sCount：" + Arrays.toString(sCount));
            System.out.println("当前窗口 pCount：" + Arrays.toString(pCount));

            if (Arrays.equals(sCount, pCount)) {
                System.out.println("窗口匹配，添加索引：" + (i + 1));
                ans.add(i + 1);
            } else {
                System.out.println("窗口不匹配");
            }
        }

        System.out.println("\n最终匹配索引列表：" + ans);
        return ans;
    }
    public static void main(String[] args) {
        findAngrams f = new findAngrams();
        // 示例测试用例
        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> result = f.findAnagrams(s, p);

        System.out.println("\n返回结果：" + result);
    }

}


