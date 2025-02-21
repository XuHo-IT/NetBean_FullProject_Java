// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
      Binarytree tree= new Binarytree();
      tree.root=new Node(10);
      tree.root.left=new Node(11);
      tree.root.left.left=new Node(7);
      tree.root.right=new Node(9);
      tree.root.right.left=new Node(15);
      tree.root.right.right=new Node(8);
      tree.breadthOrder(tree.root);
    }

}