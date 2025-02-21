import java.util.LinkedList;
import java.util.Queue;

public class Binarytree {
    Node root;
    Node temp;
    Binarytree(int key){
        root=new Node(key);
    }
    Binarytree(){
        root=null;
    }
    void preOrder(Node temp) {
     if (temp==null){
         return;
     }
        System.out.println(temp.key);
   preOrder(temp.left);
     preOrder(temp.right);

    }
    void postOrder(Node temp) {
        if (temp==null){
            return;
        }
        preOrder(temp.left);
        preOrder(temp.right);
        System.out.println(temp.key);
    }
    void inOrder(Node temp){
        if (temp==null){
            return;
        }
        preOrder(temp.left);
        System.out.println(temp.key);
        preOrder(temp.right);

    }
    void breadthOrder(Node temp){
        Queue<Node> a = new LinkedList<>();
        a.add((temp));
        while (!a.isEmpty()){
            temp=a.peek();
            a.remove();
            System.out.println(temp.key);
            if (temp.left!=null){
                a.add(temp.left);
            }
            if (temp.right!=null){
                a.add(temp.right);
            }
        }
    }

}
