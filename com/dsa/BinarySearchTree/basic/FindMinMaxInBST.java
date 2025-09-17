import com.dsa.BinaryTree.util.Node;

public class FindMinMaxInBST {
    public Node findMax(Node root) {
        if (root.right != null) {
            return findMax(root.right);
        } else {
            return root;
        }
    }

    public Node findMin(Node root) {
        if (root.left != null) {
            return findMin(root.left);
        } else {
            return root;
        }
    }
}
