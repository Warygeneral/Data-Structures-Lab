import java.util.Scanner;

public class FirstLastOccurrence {
    static int firstOcc(int[] arr, int n, int x) {
        int low = 0, high = n - 1, result = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                result = mid;
                high = mid - 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    static int lastOcc(int[] arr, int n, int x) {
        int low = 0, high = n - 1, result = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                result = mid;
                low = mid + 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter sorted array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter element to search: ");
        int x = sc.nextInt();
        int first = firstOcc(arr, n, x);
        int last = lastOcc(arr, n, x);

        if (first == -1)
            System.out.println("Element not found");
        else {
            System.out.println("First Occurrence at index: " + first);
            System.out.println("Last Occurrence at index: " + last);
        }

        sc.close();
    }
}