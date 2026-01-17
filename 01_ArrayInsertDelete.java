import java.util.Scanner;

public class ArrayInsertDelete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int arr[] = new int[100];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter position to insert (index starts from 0): ");
        int pos = sc.nextInt();
        System.out.print("Enter element to insert: ");
        int element = sc.nextInt();

        for (int i = n; i > pos; i--) {
            arr[i] = arr[i - 1];
        }
        arr[pos] = element;
        n++;

        System.out.println("After Insertion:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.print("\nEnter position to delete: ");
        int del = sc.nextInt();
        for (int i = del; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        n--;

        System.out.println("After Deletion:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}