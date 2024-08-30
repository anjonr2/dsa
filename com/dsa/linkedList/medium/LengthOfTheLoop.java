import java.util.HashMap;

import com.dsa.linkedList.utils.ListNode;

public class LengthOfTheLoop {
    public static int findLengthOfTheLoop(ListNode head) {
        HashMap<ListNode, Integer> map = new HashMap<>();
        ListNode temp = head;
        int cnt = 1;
        while (temp != null) {
            if (map.containsKey(temp)) {
                return Math.abs(cnt - map.get(temp));
            }
            map.put(temp, cnt);
            cnt++;
            temp = temp.next;
        }
        return 0;
    }

    public static int findLength(ListNode slow, ListNode fast) {
        int cnt = 0;
        while (slow != fast) {
            cnt++;
            fast = fast.next;
        }
        return cnt;
    }

    public static int findLengthOfTheLoop1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return findLength(slow, fast);
            }
        }
        return 0;
    }
}
