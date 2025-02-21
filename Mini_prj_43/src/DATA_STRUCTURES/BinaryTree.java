package DATA_STRUCTURES;

import java.util.LinkedList;
import java.util.Queue;

class TreeNodeBinaryTree {
    int val;
    TreeNodeBinaryTree left;
    TreeNodeBinaryTree right;

    TreeNodeBinaryTree(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    private TreeNodeBinaryTree root;

    public BinaryTree() {
        this.root = null;
    }

    // Method to insert a value into the binary tree
    public void insert(int val) {
        root = insertNode(root, val);
    }

    // Recursive method to insert a value into the binary tree
    private TreeNodeBinaryTree insertNode(TreeNodeBinaryTree root, int val) {
        if (root == null) {
            root = new TreeNodeBinaryTree(val);
            return root;
        }
        if (val < root.val) {
            root.left = insertNode(root.left, val);
        } else if (val > root.val) {
            root.right = insertNode(root.right, val);
        }
        return root;
    }

    // Method to perform inorder traversal of the binary tree
    public void inorderTraversal() {
        inorder(root);
    }

    // Recursive method to perform inorder traversal
    private void inorder(TreeNodeBinaryTree root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

    // Method to perform preorder traversal of the binary tree
    public void preorderTraversal() {
        preorder(root);
    }

    // Recursive method to perform preorder traversal
    private void preorder(TreeNodeBinaryTree root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Method to perform postorder traversal of the binary tree
    public void postorderTraversal() {
        postorder(root);
    }

    // Recursive method to perform postorder traversal
    private void postorder(TreeNodeBinaryTree root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.val + " ");
        }
    }

    // Method to perform level-order traversal of the binary tree
    public void levelOrderTraversal() {
        if (root == null) return;

        Queue<TreeNodeBinaryTree> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNodeBinaryTree current = queue.poll();
            System.out.print(current.val + " ");
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Inserting elements into the binary tree
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(1);
        tree.insert(4);

        // Performing inorder traversal to print the elements
        System.out.print("Inorder traversal: ");
        tree.inorderTraversal(); // Output: Inorder traversal: 1 3 4 5 7
        System.out.println();

        // Performing preorder traversal to print the elements
        System.out.print("Preorder traversal: ");
        tree.preorderTraversal(); // Output: Preorder traversal: 5 3 1 4 7
        System.out.println();

        // Performing postorder traversal to print the elements
        System.out.print("Postorder traversal: ");
        tree.postorderTraversal(); // Output: Postorder traversal: 1 4 3 7 5
        System.out.println();

        // Performing level-order traversal to print the elements
        System.out.print("Level-order traversal: ");
        tree.levelOrderTraversal(); // Output: Level-order traversal: 5 3 7 1 4
    }
}
