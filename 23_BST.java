import java.util.Scanner;

class BSTNode {
    int data;
    BSTNode left, right;

    BSTNode(int value) {
        data = value;
        left = right = null;
    }
}

public class BST {
    BSTNode root;

    BSTNode insert(BSTNode root, int key) {
        if (root == null) {
            return new BSTNode(key);
        }
        if (key < root.data)
            root.left = insert(root.left, key);
        else if (key > root.data)
            root.right = insert(root.right, key);
        return root;
    }

    boolean search(BSTNode root, int key) {
        if (root == null)
            return false;
        if (key == root.data)
            return true;
        if (key < root.data)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    int minValue(BSTNode root) {
        int min = root.data;
        while (root.left != null) {
            min = root.left.data;
            root = root.left;
        }
        return min;
    }

    BSTNode delete(BSTNode root, int key) {
        if (root == null)
            return root;
        if (key < root.data)
            root.left = delete(root.left, key);
        else if (key > root.data)
            root.right = delete(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            int minValue = minValue(root.right);
            root.data = minValue;
            root.right = delete(root.right, minValue);
        }
        return root;
    }

    void inorder(BSTNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST tree = new BST();
        int choice, value;
        do {
            System.out.println("\n--- BST MENU ---");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display (Inorder)");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    value = sc.nextInt();
                    tree.root = tree.insert(tree.root, value);
                    break;
                case 2:
                    System.out.print("Enter value to delete: ");
                    value = sc.nextInt();
                    tree.root = tree.delete(tree.root, value);
                    break;
                case 3:
                    System.out.print("Enter value to search: ");
                    value = sc.nextInt();
                    if (tree.search(tree.root, value))
                        System.out.println("Element found.");
                    else
                        System.out.println("Element not found.");
                    break;
                case 4:
                    System.out.print("BST Inorder: ");
                    tree.inorder(tree.root);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
        sc.close();
    }
}