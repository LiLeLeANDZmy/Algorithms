package 链表;

public class ReverseGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode preGroupEnd = dummy;
        int groupIndex = 1;

        while (true) {
            System.out.println("\n==== 第 " + groupIndex + " 组开始处理 ====");
            System.out.print("当前链表：");
            printList(dummy.next);

            ListNode kth = getKthNode(preGroupEnd, k);
            if (kth == null) {
                System.out.println("不足 " + k + " 个节点，终止处理");
                break;
            }

            ListNode groupStart = preGroupEnd.next;
            ListNode nextGroupStart = kth.next;

            // 打印当前要反转的组
            System.out.print("当前组（待反转）: ");
            printSubList(groupStart, kth);

            // 开始反转
            ListNode prev = nextGroupStart;
            ListNode curr = groupStart;
            System.out.println("开始反转：");
            while (curr != nextGroupStart) {
                ListNode temp = curr.next;
                System.out.println("  curr = " + curr.val + ", temp = " + (temp != null ? temp.val : "null") + ", prev = " + (prev != null ? prev.val : "null"));
                curr.next = prev;
                System.out.println("  设置 curr.next = " + (prev != null ? prev.val : "null"));
                prev = curr;
                curr = temp;
                System.out.println("  prev 前移 -> " + prev.val);
                System.out.println("  curr 前移 -> " + (curr != null ? curr.val : "null"));
            }

            // 连接前一组与当前反转后的部分
            preGroupEnd.next = kth;
            preGroupEnd = groupStart;

            System.out.print("反转后的链表：");
            printList(dummy.next);
            groupIndex++;
        }

        return dummy.next;
    }

    // 找从 curr 开始的第 k 个节点
    private ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }

    // 打印整个链表
    private void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // 打印当前组的子链表
    private void printSubList(ListNode start, ListNode end) {
        ListNode curr = start;
        while (curr != end) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println(end.val + " -> null");
    }

    public static void main(String[] args) {
        // 构造测试链表 [1, 2, 3, 4, 5]
        ListNode head = new ListNode(1);
        ListNode curr = head;
        for (int i = 2; i <= 5; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }

        int k = 3;  // 设定每组反转的个数
        ReverseGroup solution = new ReverseGroup();
        ListNode result = solution.reverseKGroup(head, k);

        System.out.println("\n==== 最终链表结果 ====");
        solution.printList(result);
    }
}

