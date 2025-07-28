package 链表;

public class AddTwoNumbers {
    // 两数相加的主逻辑
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1); // 虚拟头节点
        ListNode tail = dummy;
        int carry = 0;  // 进位

        int step = 1;  // 步骤编号
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            int digit = sum % 10;

            System.out.println("步骤 " + step + "：");
            System.out.println("  当前位值：l1 = " + val1 + "，l2 = " + val2 + "，进位 = " + carry);
            System.out.println("  相加结果：" + val1 + " + " + val2 + " + 进位 = " + sum);
            System.out.println("  新节点值 = " + digit + "，新的进位 = " + carry);

            tail.next = new ListNode(digit);
            tail = tail.next;

            // 打印当前链表状态
            System.out.print("  当前链表结果：");
            printList(dummy.next);
            System.out.println("--------------------------------");

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            step++;
        }

        return dummy.next;
    }

    // 打印链表
    private void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // 构造链表的工具方法
    private static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        for (int val : arr) {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
        return dummy.next;
    }

    // 测试用例主函数
    public static void main(String[] args) {
        AddTwoNumbers solution = new AddTwoNumbers();

        // 测试用例1：342 + 465 = 807
        System.out.println("【测试用例1】输入：l1 = [2,4,3], l2 = [5,6,4]");
        ListNode l1 = buildList(new int[]{2, 4, 3}); // 表示 342
        ListNode l2 = buildList(new int[]{5, 6, 4}); // 表示 465
        ListNode result = solution.addTwoNumbers(l1, l2);
        System.out.print("最终结果：");
        solution.printList(result);
        System.out.println("================================\n");

        // 测试用例2：99 + 1 = 100
        System.out.println("【测试用例2】输入：l1 = [9,9], l2 = [1]");
        l1 = buildList(new int[]{9, 9});
        l2 = buildList(new int[]{1});
        result = solution.addTwoNumbers(l1, l2);
        System.out.print("最终结果：");
        solution.printList(result);
        System.out.println("================================\n");

        // 测试用例3：两个空链表（全0）
        System.out.println("【测试用例3】输入：l1 = [0], l2 = [0]");
        l1 = buildList(new int[]{0});
        l2 = buildList(new int[]{0});
        result = solution.addTwoNumbers(l1, l2);
        System.out.print("最终结果：");
        solution.printList(result);
        System.out.println("================================\n");

        // 测试用例4：不同长度，如 81 + 0 = 81
        System.out.println("【测试用例4】输入：l1 = [1,8], l2 = [0]");
        l1 = buildList(new int[]{1, 8});
        l2 = buildList(new int[]{0});
        result = solution.addTwoNumbers(l1, l2);
        System.out.print("最终结果：");
        solution.printList(result);
        System.out.println("================================");
    }
}