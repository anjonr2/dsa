import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.dsa.BinaryTree.util.Node;
import com.dsa.BinaryTree.util.PairGeneric;

public class BottomView {
    public List<Integer> bottomView(Node root) {
        List<Integer> bottomView = new ArrayList<>();
        if (root == null) {
            return bottomView;
        }
        Map<Integer, Integer> map = new HashMap<>();
        Queue<PairGeneric<Integer, Node>> queue = new LinkedList<>();
        queue.offer(new PairGeneric<Integer, Node>(0, root));
        while (!queue.isEmpty()) {
            PairGeneric<Integer, Node> pair = queue.poll();
            int line = pair.getKey();
            Node node = pair.getValue();
            map.put(line, node.val);
            if (node.left != null) {
                queue.offer(new PairGeneric<Integer, Node>(line - 1, node.left));
            }
            if (node.right != null) {
                queue.offer(new PairGeneric<Integer, Node>(line + 1, node.right));
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            bottomView.add(entry.getValue());
        }
        return bottomView;
    }
}
