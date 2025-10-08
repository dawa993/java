import java.util.Scanner;

public class lab3 {

    // Helper function to calculate factorial
    public static double factorial(int n) {
        if (n == 0) {
            return 1;
        }
        double result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Helper function to calculate double factorial
    public static double doubleFactorial(int n) {
        if (n <= 0) {
            return 1;
        }
        double result = 1;
        for (int i = n; i > 0; i -= 2) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x;
        int nTerms = 20;


        // 1
        System.out.println("\n ЗАДАЧА 1");
        System.out.print("Введите x (-1 < x < 1): ");
        x = scanner.nextDouble();
        if (x <= -1 || x >= 1) {
            System.out.println("Ошибка: x должен быть в диапазоне (-1, 1)");
            return;
        }

        double sum1 = 0;
        for (int n = 1; n <= nTerms; n++) {
            double term = Math.pow(-1, n) * Math.pow(x, 2 * n + 1) / factorial(2 * n + 1);
            sum1 += term;
        }
        System.out.println("Результат: S = " + sum1);


        // 2
        System.out.println("\n ЗАДАЧА 2");
        System.out.print("Введите x (-1 < x < 1): ");
        x = scanner.nextDouble();
        if (x <= -1 || x >= 1) {
            System.out.println("Ошибка: x должен быть в диапазоне (-1, 1)");
            return;
        }

        double sum2 = 0;
        for (int n = 0; n <= nTerms; n++) {
            double term = Math.pow(x, 2 * n + 1) / (2 * n + 1);
            sum2 += term;
        }
        System.out.println("Результат: S = " + sum2);

        // 3
        System.out.println("\n ЗАДАЧА 3");
        System.out.print("Введите x (-1 < x < 1): ");
        x = scanner.nextDouble();
        if (x <= -1 || x >= 1) {
            System.out.println("Ошибка: x должен быть в диапазоне (-1, 1)");
            return;
        }

        double sum3 = 0;
        for (int n = 0; n <= nTerms; n++) {
            double term = Math.pow(x, 4 * n + 1) / (4.0 * n + 1);
            sum3 += term;
        }
        System.out.println("Результат: S = " + sum3);


        // 9
        System.out.println("\n ЗАДАЧА 9");
        System.out.print("Введите x (-1 <= x < 1): ");
        x = scanner.nextDouble();
        if (x < -1 || x >= 1) {
            System.out.println("Ошибка: x должен быть в диапазоне [-1, 1)");
            return;
        }

        double sum9 = 0;
        for (int n = 1; n <= nTerms; n++) {
            double a = 0;
            for (int k = 1; k <= n; k++) {
                a += 1.0 / k;
            }
            double term = a * Math.pow(x, n + 1) / (n + 1);
            sum9 += term;
        }
        System.out.println("Результат: S = " + 2 * sum9);

        // 10
        System.out.println("\n ЗАДАЧА 10");
        System.out.print("Введите x (-1 < x < 1): ");
        x = scanner.nextDouble();
        if (x <= -1 || x >= 1) {
            System.out.println("Ошибка: x должен быть в диапазоне (-1, 1)");
            return;
        }
        double sum10 = 0;
        for (int n = 1; n <= nTerms; n++) {
            double a = 0;
            for (int k = 1; k <= n; k++) {
                a += 1.0 / k;
            }
            double term = Math.pow(-1, n - 1) * a * Math.pow(x, n);
            sum10 += term;
        }
        System.out.println("Результат: S = " + sum10);


        // 11
        System.out.println("\n ЗАДАЧА 11");
        System.out.print("Введите x (-1 < x < 1): ");
        x = scanner.nextDouble();
        if (x <= -1 || x >= 1) {
            System.out.println("Ошибка: x должен быть в диапазоне (-1, 1)");
            return;
        }

        double sum11 = 0;
        for (int n = 0; n <= nTerms; n++) {
            double term = (doubleFactorial(2 * n + 1) * Math.pow(x, 2 * n)) / doubleFactorial(2 * n);
            sum11 += term;
        }
        System.out.println("Результат: S = " + sum11);

        scanner.close();
    }
}