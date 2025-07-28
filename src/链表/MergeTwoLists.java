package 链表;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(l1 != null && l2 != null){
            System.out.println("比较节点值，左链表当前值 = " + l1.val + "，右链表当前值 = " + l2.val);
            if(l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
            System.out.print("当前合并链表状态：");
            printList(dummy.next);
        }
        tail.next = (l1 == null) ? l2 : l1;
        System.out.print("合并完成，最终链表状态：");
        printList(dummy.next);
        return dummy.next;
    }

    // 辅助打印链表
    private void printList(ListNode head){
        ListNode cur = head;
        while(cur != null){
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        MergeTwoLists merger = new MergeTwoLists();

        // 测试用例1: 两个空链表
        System.out.println("测试用例1：两个链表均为空");
        merger.mergeTwoLists(null, null);

        // 测试用例2: 一个空链表，一个非空链表
        System.out.println("\n测试用例2：一个链表为空，另一个链表非空");
        ListNode l2 = createList(new int[]{1,3,5});
        merger.mergeTwoLists(null, l2);

        // 测试用例3: 两个有序链表
        System.out.println("\n测试用例3：两个非空有序链表");
        ListNode l1 = createList(new int[]{1,2,4});
        l2 = createList(new int[]{1,3,4});
        merger.mergeTwoLists(l1, l2);

        // 测试用例4: 两个链表长度不同
        System.out.println("\n测试用例4：两个链表长度不同");
        l1 = createList(new int[]{2,5,7,9});
        l2 = createList(new int[]{1,3});
        merger.mergeTwoLists(l1, l2);
    }

    // 创建链表的辅助函数
    private static ListNode createList(int[] arr){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for(int v : arr){
            tail.next = new ListNode(v);
            tail = tail.next;
        }
        return dummy.next;
    }
}