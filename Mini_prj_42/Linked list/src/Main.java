class LinkList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
        public void prelist(){
           del(8);
}
    public void nextlist(int data){
        push(this,data);
    }

    public static LinkList push(LinkList list, int data) {
        Node new_node = new Node(data);

        if (list.head == null) {
            list.head = new_node;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = new_node;
        }
        return list;
    }

    public void del(int position) {
        if (head == null || position < 0) {
            return;
        }
        if (position == 0) {
            head = head.next;
            return;
        }
        Node current = head;
        Node previous = null;
        int count = 0;
        while (current != null && count < position) {
            previous = current;
            current = current.next;
            count++;
        }
        if (current == null) {
            return;
        }
        previous.next = current.next;
    }
    public void dequeue() {
        if (head != null) {
            head = head.next;
        }
    }
    public void enqueue(int data) {
       push(this,data);
    }
    public static void printList(LinkList list) {
        Node currNode = list.head;
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }

    public static void main(String[] args) {
        LinkList list = new LinkList();

        list = push(list, 1);
        list = push(list, 9);
        list = push(list, 3);
        list = push(list, 4);
        list = push(list, 5);
        list = push(list, 6);
        list = push(list, 7);
        list = push(list, 8);
        list.prelist();
        printList(list);
    }
}
