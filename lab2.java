import java.util.Scanner;

public class lab2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1
        System.out.println("\n ЗАДАЧА 1");
        System.out.print("Введите x: ");
        double x1 = scanner.nextDouble();
        System.out.print("Введите a: ");
        double a1 = scanner.nextDouble();
        System.out.print("Введите b: ");
        double b1 = scanner.nextDouble();

        double y1;
        if (x1 <= 3) {
            y1 = b1 + 2 * Math.log(Math.abs(x1));
        } else {
            y1 = (x1 * x1) / (x1 * x1 + a1);
        }
        System.out.println("Результат: y = " + y1);

        // 2
        System.out.println("\n ЗАДАЧА 2");
        System.out.print("Введите x: ");
        double x2 = scanner.nextDouble();
        System.out.print("Введите b: ");
        double b2 = scanner.nextDouble();

        double y2;
        if (x2 > 0) {
            y2 = 1 / (Math.exp(-x2) + 2);
        } else {
            y2 = Math.cos(b2 * x2 + 1);
        }
        System.out.println("Результат: y = " + y2);

        // 3
        System.out.println("\n ЗАДАЧА 3");
        System.out.print("Введите x: ");
        double x3 = scanner.nextDouble();
        System.out.print("Введите a: ");
        double a3 = scanner.nextDouble();
        System.out.print("Введите b: ");
        double b3 = scanner.nextDouble();

        double y3;
        if (x3 <= 1) {
            y3 = 1 / (a3 * a3 + x3 * x3);
        } else {
            y3 = b3 * Math.log(Math.abs(x3));
        }
        System.out.println("Результат: y = " + y3);

        // 9
        System.out.println("\n ЗАДАЧА 9");
        System.out.print("Введите x: ");
        double x9 = scanner.nextDouble();
        System.out.print("Введите a: ");
        double a9 = scanner.nextDouble();
        System.out.print("Введите b: ");
        double b9 = scanner.nextDouble();

        double y9;
        if (x9 >= 2) {
            y9 = Math.sqrt(1 + x9 * Math.sqrt(a9 * x9));
        } else {
            y9 = a9 * Math.sin(b9 * x9) + 3;
        }
        System.out.println("Результат: y = " + y9);

        // 10
        System.out.println("\n ЗАДАЧА 10");
        System.out.print("Введите x: ");
        double x10 = scanner.nextDouble();
        System.out.print("Введите a: ");
        double a10 = scanner.nextDouble();
        System.out.print("Введите b: ");
        double b10 = scanner.nextDouble();

        double y10;
        if (x10 <= 0) {
            y10 = Math.sqrt(Math.exp(2 * x10 - b10) - 1);
            if (Double.isNaN(y10)) {
                System.out.println("Ошибка: подкоренное выражение отрицательное. Невозможно вычислить sqrt.");
                return;
            }
        } else {
            y10 = 1 / (x10 * x10 + a10);
        }
        System.out.println("Результат: y = " + y10);

        // 11
        System.out.println("\n ЗАДАЧА 11");
        System.out.print("Введите x: ");
        double x11 = scanner.nextDouble();
        System.out.print("Введите a: ");
        double a11 = scanner.nextDouble();
        System.out.print("Введите b: ");
        double b11 = scanner.nextDouble();

        double y11;
        if (x11 > 4) {
            y11 = Math.sqrt(a11 + Math.sin(x11));
        } else {
            y11 = Math.tan(b11 * x11);
        }
        System.out.println("Результат: y = " + y11);

        scanner.close();
    }
}