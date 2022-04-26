
// NC2 重排链表
// 原链表：L0 -> L1 -> ... -> Ln-1 -> Ln
// 重排后：L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 -> ...
public class Solution {
    // 方法一：使用数组保存节点
    // 方法二：将链表分成两段，反转第二段，再合并链表
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)return;
        ListNode mid = getMid(head);
        ListNode p1 = head, p2 = mid.next;
        mid.next = null;
        p2 = reverse(p2);
        merge(p1,p2);
    }
    public ListNode getMid(ListNode head){
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head){
        ListNode pre = head, cur = head.next;
        while(cur != null){
            head.next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = head.next;
        }
        return pre;
    }
    public void merge(ListNode p1, ListNode p2){
        ListNode t1, t2;
        while(p1 != null && p2 != null){
            t1 = p1.next;
            t2 = p2.next;
            p1.next = p2;
            p2.next = t1;
            p1 = t1;
            p2 = t2;
        }
    }
    
}