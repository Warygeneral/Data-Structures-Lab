import java.util.Scanner;

public class CircularQueue {
    int[] queue;
    int front, rear, size;

    CircularQueue(int size) {
        this.size = size;
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    boolean isFull() {
        return ((rear + 1) % size == front);
    }

    boolean isEmpty() {
        return (front == -1);
    }

    void push(int value) {
        if (isFull()) {
            System.out.println("Queue is Full! Cannot insert.");
        } else {
            if (front == -1)
                front = 0;
            rear = (rear + 1) % size;
            queue[rear] = value;
            System.out.println(value + " inserted.");
        }
    }

    void pop() {
        if (isEmpty()) {
            System.out.println("Queue is Empty! Cannot delete.");
        } else {
            System.out.println("Deleted element: " + queue[front]);
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % size;
            }
        }
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Queue empty.");
            return;
        }
        System.out.print("Circular Queue: ");
        int i = front;
        while (i != rear) {
            System.out.print(queue[i] + " ");
            i = (i + 1) % size;
        }
        System.out.print(queue[rear]);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of queue: ");
        int size = sc.nextInt();
        CircularQueue cq = new CircularQueue(size);
        int choice;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Enqueue (Push)");
            System.out.println("2. Dequeue (Pop)");
            System.out.println("3. isEmpty");
            System.out.println("4. isFull");
            System.out.println("5. Display");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    cq.push(sc.nextInt());
                    break;
                case 2:
                    cq.pop();
                    break;
                case 3:
                    System.out.println(cq.isEmpty() ? "Queue is empty." : "Queue is not empty.");
                    break;
                case 4:
                    System.out.println(cq.isFull() ? "Queue is full." : "Queue is not full.");
                    break;
                case 5:
                    cq.display();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 6);
        sc.close();
    }
}