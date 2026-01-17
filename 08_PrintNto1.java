import java.util.Scanner;

public class PrintNto1 {
    static void printNumbers(int n) {
        if (n == 0)
            return;
        System.out.print(n + " ");
        printNumbers(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        System.out.println("Numbers from " + n + " to 1:");
        printNumbers(n);

        sc.close();
    }
}