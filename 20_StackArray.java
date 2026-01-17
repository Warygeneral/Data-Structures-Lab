import java.util.Scanner;

public class StackArray {
    int[] stack;
    int top;
    int max;

    StackArray(int size) {
        max = size;
        stack = new int[max];
        top = -1;
    }

    boolean isEmpty() {
        return (top == -1);
    }

    boolean isFull() {
        return (top == max - 1);
    }

    void push(int data) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push.");
        } else {
            stack[++top] = data;
            System.out.println(data + " pushed.");
        }
    }

    void pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Cannot pop.");
        } else {
            System.out.println("Popped element: " + stack[top--]);
        }
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Stack empty.");
            return;
        }
        System.out.print("Stack elements: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter stack size: ");
        int size = sc.nextInt();
        StackArray stack = new StackArray(size);
        int choice;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. isEmpty");
            System.out.println("4. isFull");
            System.out.println("5. Display");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    stack.push(sc.nextInt());
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    System.out.println(stack.isEmpty() ? "Stack is empty." : "Stack is not empty.");
                    break;
                case 4:
                    System.out.println(stack.isFull() ? "Stack is full." : "Stack is not full.");
                    break;
                case 5:
                    stack.display();
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