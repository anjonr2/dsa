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
}
