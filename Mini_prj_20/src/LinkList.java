import java.util.ArrayList;
import java.util.Scanner;

public class LinkList {
    Node head;
    public void add(Book data) {
        Node new_node = new Node(data);
        Node temp = head;
        if (temp == null){
            head = new_node;
        } else {
            Node last = temp;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
    }
    public void addBook(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter title: ");
        String title =sc.nextLine();
        System.out.println("Enter author: ");
        String author =sc.nextLine();
        System.out.println("Enter ISBN: ");
        String ISBN =sc.nextLine();
        Book firstBook = new Book(title,author,ISBN);
        add(firstBook);
    }
    public void remove(Node node, int index) {
        Node temp = head;
        Node prev = head;
        for (int i = 0; i < index; i++) {
            if (i == 0 && index == 1) {
                node = node.next;
                head = node;
            } else {
                if (i == index - 1 && temp != null) {
                    prev.next = temp.next;
                } else {
                    prev = temp;
                    if (prev == null) break;
                    temp = temp.next;
                }
            }
        }
    }
    public void removeOrder(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name of book to remove: ");
        String name = sc.nextLine();
        Book newBook = new Book(name,"1","1");
        Node temp = head;
        int index = 1;
        while(head != null){
            if(temp.data.getTitle().equals(newBook.getTitle())){
                remove(temp,index);
                System.out.println("Book removed");
                break;
            }
            else {
                temp = temp.next;
                index++;
            }
        }
    }
        public void printList(){
            Node currNode = head;
            System.out.print("Book Catalog: ");
            while (currNode != null) {
                System.out.print(currNode.data + " ");
                currNode = currNode.next;
            }
        }
    }


