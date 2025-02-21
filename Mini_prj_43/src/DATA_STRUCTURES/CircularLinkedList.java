package DATA_STRUCTURES;

class NodeCircular {
    int data;
    NodeCircular next;

    NodeCircular(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularLinkedList {
    private NodeCircular head;

    public CircularLinkedList() {
        this.head = null;
    }

    public void append(int data) {
        NodeCircular newNodeCircular = new NodeCircular(data);
        if (head == null) {
            head = newNodeCircular;
            head.next = head; // Circular reference
            return;
        }
        NodeCircular lastNodeCircular = head;
        while (lastNodeCircular.next != head) {
            lastNodeCircular = lastNodeCircular.next;
        }
        lastNodeCircular.next = newNodeCircular;
        newNodeCircular.next = head;
    }

    public void prepend(int data) {
        NodeCircular newNodeCircular = new NodeCircular(data);
        if (head == null) {
            head = newNodeCircular;
            head.next = head; // Circular reference
            return;
        }
        NodeCircular lastNodeCircular = head;
        while (lastNodeCircular.next != head) {
            lastNodeCircular = lastNodeCircular.next;
        }
        newNodeCircular.next = head;
        head = newNodeCircular;
        lastNodeCircular.next = newNodeCircular;
    }

    public void deleteNode(int key) {
        if (head == null)
            return;

        NodeCircular curr = head, prev = null;
        while (curr.data != key) {
            if (curr.next == head) {
                System.out.println("Node with data " + key + " not found in the list.");
                return;
            }
            prev = curr;
            curr = curr.next;
        }

        if (curr == head && curr.next == head) { // Only one node in the list
            head = null;
            return;
        }

        if (curr == head) {
            prev = head;
            while (prev.next != head)
                prev = prev.next;
            head = head.next;
            prev.next = head;
        } else if (curr.next == head) {
            prev.next = head;
        } else {
            prev.next = curr.next;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        NodeCircular current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("(Head)");
    }

    public static void main(String[] args) {
        CircularLinkedList circularList = new CircularLinkedList();
        circularList.append(1);
        circularList.append(2);
        circularList.append(3);
        circularList.append(4);
        circularList.display(); // Output: 1 -> 2 -> 3 -> 4 -> (Head)

        circularList.prepend(0);
        circularList.display(); // Output: 0 -> 1 -> 2 -> 3 -> 4 -> (Head)

        circularList.deleteNode(2);
        circularList.display(); // Output: 0 -> 1 -> 3 -> 4 -> (Head)
    }
}
