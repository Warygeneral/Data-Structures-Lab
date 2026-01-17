import java.util.Scanner;

public class Factorial {
    static int factorialRec(int n) {
        if (n == 0 || n == 1)
            return 1;
        else
            return n * factorialRec(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int fact = 1;
        for (int i = 1; i <= num; i++) {
            fact = fact * i;
        }

        System.out.println("Factorial using Iteration = " + fact);
        System.out.println("Factorial using Recursion = " + factorialRec(num));

        sc.close();
    }
}