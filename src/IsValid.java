import java.util.*;

public class IsValid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') stack.push(')');
            else if(c == '[') stack.push(']');
            else if(c == '{') stack.push('}');
            else if(stack.isEmpty() || c != stack.pop()) return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        IsValid validator = new IsValid();

        // ✅ 测试用例 1
        System.out.println("测试1：" + validator.isValid("()[]{}")); // true

        // ✅ 测试用例 2
        System.out.println("测试2：" + validator.isValid("([{}])")); // true

        // ❌ 测试用例 3
        System.out.println("测试3：" + validator.isValid("(]")); // false

        // ❌ 测试用例 4
        System.out.println("测试4：" + validator.isValid("([)]")); // false

        // ❌ 测试用例 5
        System.out.println("测试5：" + validator.isValid("(((")); // false

        // ✅ 测试用例 6：空字符串
        System.out.println("测试6：" + validator.isValid("")); // true
    }
}
