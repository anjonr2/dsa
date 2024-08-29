import java.util.HashMap;

import com.dsa.linkedList.utils.ListNode;

public class StartingPointOfTheLoop {
    public ListNode detectCycle(ListNode head) {
        ListNode temp = head;
        HashMap<ListNode, Integer> map = new HashMap<>();
        while (temp != null) {
            if (map.containsKey(temp)) {
                return temp;
            }
            map.put(temp, 1);
            temp = temp.next;
        }
        return null;
    }
}
