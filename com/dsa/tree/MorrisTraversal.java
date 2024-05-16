import java.util.ArrayList;
import java.util.List;

public class MorrisTraversal {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static List<Integer> inorder(Node root) {
        List<Integer> ans = new ArrayList<Integer>();
        while (root != null) {
            // if left part doesn't exist
            if (root.left == null) {
                ans.add(root.data);
                root = root.right;
            } else {
                Node current = root.left;
                while (current.right != null && current.right != root) {
                    current = current.right;
                }
                // if left sub tree is not traversed
                if (current.right == null) {
                    // create a link between right most element and the root node
                    current.right = root;
                    root = root.left;
                } else {
                    // if left side is traversed
                    // then print root and the root move to right
                    current.right = null;
                    ans.add(root.data);
                    root = root.right;
                }
            }
        }
        return ans;
    }
}
