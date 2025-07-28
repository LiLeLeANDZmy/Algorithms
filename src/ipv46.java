import java.util.*;

public class ipv46 {

    /**
     * 主方法：判断给定字符串是否是合法的 IPv4 或 IPv6 地址
     */
    public String validIPAddress(String ip) {
        if (ip.contains(".") && checkIPv4(ip)) {
            return "IPv4";
        }

        if (ip.contains(":") && checkIPv6(ip)) {
            return "IPv6";
        }

        return "Neither";
    }

    /**
     * 检查是否是合法的 IPv4 地址
     * 格式：x1.x2.x3.x4，满足：
     * - 共 4 段
     * - 每段为十进制数字（0~255）
     * - 不能有前导零（如 "01" 非法）
     * - 每段长度 ≤ 3
     */
    private boolean checkIPv4(String ip) {
        // 分割字符串，允许空字段（-1）
        String[] parts = ip.split("\\.", -1);

        // 必须恰好 4 段
        if (parts.length != 4) return false;

        for (String part : parts) {
            // 非空 & 长度不能超过 3
            if (part.isEmpty() || part.length() > 3) return false;

            // 前导零非法（除了 "0"）
            if (part.length() > 1 && part.charAt(0) == '0') return false;

            // 检查是否只含数字
            for (char c : part.toCharArray()) {
                if (!Character.isDigit(c)) return false;
            }

            // 数值范围必须在 0~255
            int num = Integer.parseInt(part);
            if (num < 0 || num > 255) return false;
        }

        return true;
    }

    /**
     * 检查是否是合法的 IPv6 地址
     * 格式：x1:x2:x3:x4:x5:x6:x7:x8，满足：
     * - 共 8 段
     * - 每段为 1~4 位的十六进制字符
     * - 允许前导零
     * - 字符可以是 [0-9a-fA-F]
     */
    private boolean checkIPv6(String ip) {
        String[] parts = ip.split(":", -1);

        // 必须恰好 8 段
        if (parts.length != 8) return false;

        for (String part : parts) {
            // 非空，且长度在 1~4 之间
            if (part.isEmpty() || part.length() > 4) return false;

            // 检查是否都是合法的十六进制字符
            for (char c : part.toCharArray()) {
                if (!isHex(c)) return false;
            }
        }

        return true;
    }

    /**
     * 判断一个字符是否是合法的十六进制字符
     */
    private boolean isHex(char c) {
        return Character.isDigit(c) ||
                ('a' <= c && c <= 'f') ||
                ('A' <= c && c <= 'F');
    }

    /**
     * 测试函数
     */
    public static void main(String[] args) {
        ipv46 sol = new ipv46();

        // 合法 IPv4
        System.out.println(sol.validIPAddress("192.168.1.1")); // IPv4

        // 非法 IPv4：前导零
        System.out.println(sol.validIPAddress("192.168.01.1")); // Neither

        // 非法 IPv4：值超范围
        System.out.println(sol.validIPAddress("256.256.256.256")); // Neither

        // 合法 IPv6
        System.out.println(sol.validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334")); // IPv6

        // 非法 IPv6：包含非法字符
        System.out.println(sol.validIPAddress("2001:db8:85a3:0:0:8A2E:037j:7334")); // Neither

        // 非法 IPv6：字段太长
        System.out.println(sol.validIPAddress("02001:0db8:85a3:0000:0000:8a2e:0370:7334")); // Neither
    }
}
