class Node {
    Web data;
    Node next;
    Node prev;

    Node(Web data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    Web getData() {
        return data;
    }

}