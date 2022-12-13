package Crio.DSA_3;

public class DetectAndRemoveCycle {
    public boolean detectAndRemoveCycle(ListNode head){
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return removeCycle(head, fast, slow);
        }
        return false;
    }

    private boolean removeCycle(ListNode head, ListNode fast, ListNode slow) {
        int count =1;
        do {
            slow = slow.next;
            count++;
        } while (fast != slow.next);

        ListNode tHead = head;
        while (count > 0){
            --count;
            tHead = tHead.next;
        }

        while (tHead.next != head.next){
            head = head.next;
            tHead = tHead.next;
        }

        tHead.next = null;
        return true;
    }
}