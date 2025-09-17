import com.dsa.BinaryTree.util.Node;

public class SearchInBST {
    public Node searchBST(Node root, int val) {
        while (root != null && root.val != val) {
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }
}
