package DATA_STRUCTURES;

class NodeDoublyCircular {
    int data;
    NodeDoublyCircular prev;
    NodeDoublyCircular next;

    NodeDoublyCircular(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyCircularLinkedList {
    private NodeDoublyCircular head;

    public DoublyCircularLinkedList() {
        this.head = null;
    }

    public void append(int data) {
        NodeDoublyCircular newNodeDoublyCircular = new NodeDoublyCircular(data);
        if (head == null) {
            head = newNodeDoublyCircular;
            head.next = head;
            head.prev = head;
            return;
        }
        NodeDoublyCircular lastNodeDoublyCircular = head.prev;
        lastNodeDoublyCircular.next = newNodeDoublyCircular;
        newNodeDoublyCircular.prev = lastNodeDoublyCircular;
        newNodeDoublyCircular.next = head;
        head.prev = newNodeDoublyCircular;
    }

    public void prepend(int data) {
        NodeDoublyCircular newNodeDoublyCircular = new NodeDoublyCircular(data);
        if (head == null) {
            head = newNodeDoublyCircular;
            head.next = head;
            head.prev = head;
            return;
        }
        NodeDoublyCircular lastNodeDoublyCircular = head.prev;
        newNodeDoublyCircular.next = head;
        head.prev = newNodeDoublyCircular;
        newNodeDoublyCircular.prev = lastNodeDoublyCircular;
        lastNodeDoublyCircular.next = newNodeDoublyCircular;
        head = newNodeDoublyCircular;
    }

    public void deleteNode(int key) {
        if (head == null)
            return;

        NodeDoublyCircular temp = head, prev = null;
        while (temp.data != key) {
            if (temp.next == head)
                return; // Node not found
            prev = temp;
            temp = temp.next;
        }

        if (temp.next == temp && temp == head) { // Only one node
            head = null;
            return;
        }

        if (temp == head) {
            prev = head.prev;
            head = head.next;
            prev.next = head;
            head.prev = prev;
        } else {
            prev.next = temp.next;
            temp.next.prev = prev;
        }
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        NodeDoublyCircular current = head;
        do {
            System.out.print(current.data + " <-> ");
            current = current.next;
        } while (current != head);
        System.out.println("(Head)");
    }

    public void displayBackward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        NodeDoublyCircular current = head.prev;
        do {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        } while (current != head.prev);
        System.out.println("(Head)");
    }

    public static void main(String[] args) {
        DoublyCircularLinkedList list = new DoublyCircularLinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.displayForward(); // Output: 1 <-> 2 <-> 3 <-> 4 <-> (Head)
        list.displayBackward(); // Output: 4 <-> 3 <-> 2 <-> 1 <-> (Head)

        list.prepend(0);
        list.displayForward(); // Output: 0 <-> 1 <-> 2 <-> 3 <-> 4 <-> (Head)
        list.displayBackward(); // Output: 4 <-> 3 <-> 2 <-> 1 <-> 0 <-> (Head)

        list.deleteNode(2);
        list.displayForward(); // Output: 0 <-> 1 <-> 3 <-> 4 <-> (Head)
        list.displayBackward(); // Output: 4 <-> 3 <-> 1 <-> 0 <-> (Head)
    }
}
