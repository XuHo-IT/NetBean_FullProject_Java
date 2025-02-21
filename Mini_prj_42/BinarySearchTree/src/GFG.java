

    class GFG {

        static class node {
            int key;
            node left, right;
        };

        static node newNode(int item)
        {
            node temp = new node();
            temp.key = item;
            temp.left = temp.right = null;
            return temp;
        }


        static node insert(node node, int key)
        {

            if (node == null)
                return newNode(key);
            if (key < node.key) {
                node.left = insert(node.left, key);
            }
            else if (key > node.key) {
                node.right = insert(node.right, key);
            }
            return node;
        }
        static node minValueNode(node node)
        {
            node current = node;
            while (current != null && current.left != null)
                current = current.left;
            return current;
        }

        static node deleteNode(node root, int key)
        {
            if (root == null)
                return root;

            if (key < root.key) {
                root.left = deleteNode(root.left, key);
            }
            else if (key > root.key) {

                root.right = deleteNode(root.right, key);
            }
            else {
                if (root.left == null) {
                    node temp = root.right;
                    return temp;
                }
                else if (root.right == null) {
                    node temp = root.left;
                    return temp;
                }

                node temp = minValueNode(root.right);
                root.key = temp.key;
                root.right = deleteNode(root.right, temp.key);
            }
            return root;
        }


        static void inorder(node root)
        {
            if (root != null) {
                inorder(root.left);
                System.out.print(" " + root.key);
                inorder(root.right);
            }
        }
        public static void main(String[] args)
        {
            node root = null;
            root = insert(root, 50);
            insert(root, 30);
            insert(root, 20);
            insert(root, 40);
            insert(root, 70);
            insert(root, 60);
            insert(root, 80);
            inorder(root);
        }
    }

