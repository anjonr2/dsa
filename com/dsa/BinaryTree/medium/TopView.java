import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.dsa.BinaryTree.util.Node;
import com.dsa.BinaryTree.util.PairGeneric;

public class TopView {
    public List<Integer> topView(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        Queue<PairGeneric<Integer, Node>> queue = new LinkedList<>();
        queue.offer(new PairGeneric<>(0, root));
        if (!queue.isEmpty()) {
            PairGeneric<Integer, Node> pair = queue.poll();
            int verticalLevel = pair.getKey();
            if (!map.containsKey(verticalLevel))
                map.put(verticalLevel, pair.getValue().val);
            Node node = pair.getValue();
            if (node.left != null) {
                queue.offer(new PairGeneric<Integer, Node>(verticalLevel - 1, node.left));
            }
            if (node.right != null) {
                queue.offer(new PairGeneric<Integer, Node>(verticalLevel + 1, node.right));
            }
        }
        for (Integer value : map.values()) {
            result.add(value);
        }
        return result;
    }
}
