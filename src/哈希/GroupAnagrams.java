package 哈希;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        System.out.println("开始分组处理...");

        for (String s : strs) {
            System.out.println("\n处理字符串: " + s);

            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            System.out.println("  排序后key: " + key);

            if (!map.containsKey(key)) {
                System.out.println("  map中没有这个key，创建新分组");
                map.put(key, new ArrayList<>());
            } else {
                System.out.println("  map中已有这个key，添加到已有分组中");
            }

            map.get(key).add(s);
            System.out.println("  当前key对应的分组: " + map.get(key));
        }

        System.out.println("\n所有分组结果：");
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + " -> " + entry.getValue());
        }

        return new ArrayList<>(map.values());
    }


    // 测试入口
    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();

        // 测试用例 1：基础输入
        String[] input1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("测试1 输入: " + Arrays.toString(input1));
        List<List<String>> result1 = solution.groupAnagrams(input1);
        printResult(result1);

        // 测试用例 2：包含重复字符串
        String[] input2 = {"abc", "bca", "cab", "abc"};
        System.out.println("测试2 输入: " + Arrays.toString(input2));
        List<List<String>> result2 = solution.groupAnagrams(input2);
        printResult(result2);

        // 测试用例 3：只有一个字符串
        String[] input3 = {"hello"};
        System.out.println("测试3 输入: " + Arrays.toString(input3));
        List<List<String>> result3 = solution.groupAnagrams(input3);
        printResult(result3);

        // 测试用例 4：空数组
        String[] input4 = {};
        System.out.println("测试4 输入: " + Arrays.toString(input4));
        List<List<String>> result4 = solution.groupAnagrams(input4);
        printResult(result4);

        // 测试用例 5：包含空字符串
        String[] input5 = {"", ""};
        System.out.println("测试5 输入: " + Arrays.toString(input5));
        List<List<String>> result5 = solution.groupAnagrams(input5);
        printResult(result5);
    }

    // 打印结果工具方法
    public static void printResult(List<List<String>> result) {
        System.out.println("输出分组：");
        for (List<String> group : result) {
            System.out.println(group);
        }
        System.out.println("----------");
    }
}
