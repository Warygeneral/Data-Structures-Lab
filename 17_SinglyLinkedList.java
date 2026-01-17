import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {
    Node head = null;
    Scanner sc = new Scanner(System.in);

    void insertAtStart() {
        System.out.print("Enter data: ");
        int data = sc.nextInt();
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        System.out.println("Inserted at beginning.");
    }

    void insertAtEnd() {
        System.out.print("Enter data: ");
        int data = sc.nextInt();
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
        System.out.println("Inserted at end.");
    }

    void insertAtPosition() {
        System.out.print("Enter position: ");
        int pos = sc.nextInt();
        System.out.print("Enter data: ");
        int data = sc.nextInt();
        Node newNode = new Node(data);
        if (pos == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node temp = head;
        for (int i = 1; i < pos - 1; i++) {
            if (temp == null) {
                System.out.println("Invalid position!");
                return;
            }
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println("Inserted at position.");
    }

    void deleteAtStart() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
        System.out.println("Deleted from beginning.");
    }

    void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null)
            temp = temp.next;
        temp.next = null;
        System.out.println("Deleted from end.");
    }

    void deleteAtPosition() {
        System.out.print("Enter position: ");
        int pos = sc.nextInt();
        if (head == null) {
            System.out.println("List empty.");
            return;
        }
        if (pos == 1) {
            head = head.next;
            return;
        }
        Node temp = head;
        for (int i = 1; i < pos - 1; i++) {
            if (temp.next == null) {
                System.out.println("Invalid position.");
                return;
            }
            temp = temp.next;
        }
        temp.next = temp.next.next;
        System.out.println("Deleted from position.");
    }

    void search() {
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();
        Node temp = head;
        int pos = 1;
        boolean found = false;
        while (temp != null) {
            if (temp.data == key) {
                System.out.println("Element found at position " + pos);
                found = true;
                break;
            }
            temp = temp.next;
            pos++;
        }
        if (!found)
            System.out.println("Element not found.");
    }

    void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        System.out.print("Linked List: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Insert at start");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert at position");
            System.out.println("4. Delete at start");
            System.out.println("5. Delete at end");
            System.out.println("6. Delete at position");
            System.out.println("7. Search");
            System.out.println("8. Display");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    list.insertAtStart();
                    break;
                case 2:
                    list.insertAtEnd();
                    break;
                case 3:
                    list.insertAtPosition();
                    break;
                case 4:
                    list.deleteAtStart();
                    break;
                case 5:
                    list.deleteAtEnd();
                    break;
                case 6:
                    list.deleteAtPosition();
                    break;
                case 7:
                    list.search();
                    break;
                case 8:
                    list.display();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 9);
    }
}