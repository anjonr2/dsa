import java.util.HashMap;

public class DetectLoopInLinkedList {
    static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }

        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode temp = head;
        HashMap<ListNode, Integer> map = new HashMap<>();
        while (temp != null) {
            if (map.containsKey(temp)) {
                return true;
            }
            map.put(temp, 1);
            temp = temp.next;
        }
        return false;
    }

    public boolean hasCycle1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
