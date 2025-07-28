package 链表;

import java.util.PriorityQueue;

public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        // 1. 创建一个最小堆，按节点值排序
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // 2. 加入所有链表的头节点
        for (ListNode node : lists) {
            if (node != null) {
                System.out.println("加入堆节点：" + node.val);
                minHeap.offer(node);
            }
        }

        // 3. 创建虚拟头节点
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // 4. 不断弹出最小节点，构建结果链表
        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();
            System.out.println("弹出最小节点：" + minNode.val);
            tail.next = minNode; //把 minNode 接到链表末尾（钩上）
            tail = tail.next; // 把 tail 移动到最新的尾巴（往后走一步）

            if (minNode.next != null) {
                System.out.println("加入堆下一个节点：" + minNode.next.val);
                minHeap.offer(minNode.next);
            }
        }

        return dummy.next;
    }

    // 打印链表
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // 构造链表
    public static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int num : arr) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        return dummy.next;
    }

    // 测试主函数
    public static void main(String[] args) {
        MergeKLists sol = new MergeKLists();

        // 🔹测试用例1：合并 [1->4->5], [1->3->4], [2->6]
        ListNode[] lists1 = new ListNode[] {
                buildList(new int[]{1, 4, 5}),
                buildList(new int[]{1, 3, 4}),
                buildList(new int[]{2, 6})
        };
        System.out.println("🔹合并链表：[[1,4,5], [1,3,4], [2,6]]");
        ListNode merged1 = sol.mergeKLists(lists1);
        System.out.print("合并结果：");
        printList(merged1);

        // 🔹测试用例2：空链表数组
        ListNode[] lists2 = new ListNode[] {};
        System.out.println("\n🔹合并链表：[]");
        ListNode merged2 = sol.mergeKLists(lists2);
        System.out.print("合并结果：");
        printList(merged2);

        // 🔹测试用例3：全部为null的链表
        ListNode[] lists3 = new ListNode[] {null, null};
        System.out.println("\n🔹合并链表：[null, null]");
        ListNode merged3 = sol.mergeKLists(lists3);
        System.out.print("合并结果：");
        printList(merged3);

        // 🔹测试用例4：链表长度不同
        ListNode[] lists4 = new ListNode[] {
                buildList(new int[]{1}),
                buildList(new int[]{0, 7}),
                buildList(new int[]{3, 3, 3})
        };
        System.out.println("\n🔹合并链表：[[1], [0,7], [3,3,3]]");
        ListNode merged4 = sol.mergeKLists(lists4);
        System.out.print("合并结果：");
        printList(merged4);
    }
}
