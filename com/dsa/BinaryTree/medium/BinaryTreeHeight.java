import com.dsa.BinaryTree.util.Node;

/*finding max depth or height of a binary tree */
public class BinaryTreeHeight {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }
}
