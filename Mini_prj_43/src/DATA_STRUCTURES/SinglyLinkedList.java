package DATA_STRUCTURES;

class NodeSingly {
    int data;
    NodeSingly next;

    NodeSingly(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {
    private NodeSingly head;

    public SinglyLinkedList() {
        this.head = null;
    }

    public void append(int data) {
        NodeSingly newNodeSingly = new NodeSingly(data);
        if (head == null) {
            head = newNodeSingly;
            return;
        }
        NodeSingly lastNodeSingly = head;
        while (lastNodeSingly.next != null) {
            lastNodeSingly = lastNodeSingly.next;
        }
        lastNodeSingly.next = newNodeSingly;
    }

    public void prepend(int data) {
        NodeSingly newNodeSingly = new NodeSingly(data);
        newNodeSingly.next = head;
        head = newNodeSingly;
    }

    public void deleteNode(int key) {
        NodeSingly temp = head, prev = null;

        if (temp != null && temp.data == key) {
            head = temp.next;
            return;
        }

        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) return;

        prev.next = temp.next;
    }

    public void display() {
        NodeSingly current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.display(); // Output: 1 -> 2 -> 3 -> 4 -> null

        linkedList.prepend(0);
        linkedList.display(); // Output: 0 -> 1 -> 2 -> 3 -> 4 -> null

        linkedList.deleteNode(2);
        linkedList.display(); // Output: 0 -> 1 -> 3 -> 4 -> null
    }
}
