package DATA_STRUCTURES;

import java.util.LinkedList;
import java.util.Queue;

class TreeNodeAVL {
    int val;
    int height;
    TreeNodeAVL left;
    TreeNodeAVL right;

    TreeNodeAVL(int val) {
        this.val = val;
        this.height = 1;
        this.left = null;
        this.right = null;
    }
}

public class AVLTree {
    private TreeNodeAVL root;

    public AVLTree() {
        this.root = null;
    }

    // Method to get height of a node
    private int height(TreeNodeAVL node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // Method to get balance factor of a node
    private int getBalanceFactor(TreeNodeAVL node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    // Method to update the height of a node
    private void updateHeight(TreeNodeAVL node) {
        if (node != null) {
            node.height = Math.max(height(node.left), height(node.right)) + 1;
        }
    }

    // Method to perform right rotation
    private TreeNodeAVL rightRotate(TreeNodeAVL y) {
        TreeNodeAVL x = y.left;
        TreeNodeAVL T2 = x.right;

        x.right = y;
        y.left = T2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    // Method to perform left rotation
    private TreeNodeAVL leftRotate(TreeNodeAVL x) {
        TreeNodeAVL y = x.right;
        TreeNodeAVL T2 = y.left;

        y.left = x;
        x.right = T2;

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    // Method to insert a value into the AVL tree
    public void insert(int val) {
        root = insertNode(root, val);
    }

    // Recursive method to insert a value into the AVL tree
    private TreeNodeAVL insertNode(TreeNodeAVL root, int val) {
        if (root == null) {
            return new TreeNodeAVL(val);
        }
        if (val < root.val) {
            root.left = insertNode(root.left, val);
        } else if (val > root.val) {
            root.right = insertNode(root.right, val);
        } else {
            return root; // Duplicate keys not allowed
        }

        updateHeight(root);

        int balance = getBalanceFactor(root);

        // Left Left Case
        if (balance > 1 && val < root.left.val) {
            return rightRotate(root);
        }
        // Right Right Case
        if (balance < -1 && val > root.right.val) {
            return leftRotate(root);
        }
        // Left Right Case
        if (balance > 1 && val > root.left.val) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        // Right Left Case
        if (balance < -1 && val < root.right.val) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // Method to perform inorder traversal of the AVL tree
    public void inorderTraversal() {
        inorder(root);
    }

    // Recursive method to perform inorder traversal
    private void inorder(TreeNodeAVL root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

    // Method to perform preorder traversal of the AVL tree
    public void preorderTraversal() {
        preorder(root);
    }

    // Recursive method to perform preorder traversal
    private void preorder(TreeNodeAVL root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Method to perform postorder traversal of the AVL tree
    public void postorderTraversal() {
        postorder(root);
    }

    // Recursive method to perform postorder traversal
    private void postorder(TreeNodeAVL root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.val + " ");
        }
    }

    // Method to perform level-order traversal of the AVL tree
    public void levelOrderTraversal() {
        if (root == null) return;

        Queue<TreeNodeAVL> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNodeAVL current = queue.poll();
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
        AVLTree tree = new AVLTree();

        // Inserting elements into the AVL tree
        tree.insert(9);
        tree.insert(5);
        tree.insert(10);
        tree.insert(0);
        tree.insert(6);
        tree.insert(11);
        tree.insert(-1);
        tree.insert(1);
        tree.insert(2);

        // Performing inorder traversal to print the elements
        System.out.print("Inorder traversal: ");
        tree.inorderTraversal(); // Output: Inorder traversal: -1 0 1 2 5 6 9 10 11
        System.out.println();

        // Performing preorder traversal to print the elements
        System.out.print("Preorder traversal: ");
        tree.preorderTraversal(); // Output: Preorder traversal: 9 0 -1 5 2 1 6 10 11
        System.out.println();

        // Performing postorder traversal to print the elements
        System.out.print("Postorder traversal: ");
        tree.postorderTraversal(); // Output: Postorder traversal: -1 1 2 0 6 5 11 10 9
        System.out.println();

        // Performing level-order traversal to print the elements
        System.out.print("Level-order traversal: ");
        tree.levelOrderTraversal(); // Output: Level-order traversal: 9 5 10 0 6 11 -1 1 2
        System.out.println();
    }
}
