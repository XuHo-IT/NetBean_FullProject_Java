//public class LinkedList {
//
//        Node head;
//        Node tail;
//        int size;
//
//        this.head = null;
//        this.tail = null;
//        this.size = 0;
//    }
//
//    void insertToHead(Web data) {
//        Node newNode = new Node(data);
//        if (head == null) {
//            head = newNode;
//            tail = newNode;
//        } else {
//            newNode.next = head;
//            head.prev = newNode;
//            head = newNode;
//        }
//        size++;
//    }
//
//    void insertToTail(Web data) {
//        Node newNode = new Node(data);
//        if (tail == null) {
//            tail = newNode;
//            head = newNode;
//        } else {
//            tail.next = newNode;
//            newNode.prev = tail;
//            tail = newNode;
//        }
//        size++;
//    }
//
//}
