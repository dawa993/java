//var 13
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class SeparateEvenOdd {

    public static int[][] separateEvenOdd(int[] A, int NA) {
        List<Integer> bList = new ArrayList<>();
        List<Integer> cList = new ArrayList<>();
        for (int i = 0; i < NA; i++) {
            if (A[i] % 2 == 0) {
                bList.add(A[i]);
            } else {
                cList.add(A[i]);
            }
        }
        int[] B = new int[bList.size()];
        for (int i = 0; i < bList.size(); i++) {
            B[i] = bList.get(i);
        }
        int[] C = new int[cList.size()];
        for (int i = 0; i < cList.size(); i++) {
            C[i] = cList.get(i);
        }
        return new int[][]{B, C};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int NA = 0;
        while (true) {
            System.out.println("Введите размер массива A (NA):");
            try {
                NA = scanner.nextInt();
                if (NA >= 0) {
                    break;
                } else {
                    System.out.println("Размер массива не может быть отрицательным.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Введите целое число для размера массива.");
                scanner.next();
            }
        }

        scanner.nextLine();

        int[] A = new int[NA];
        if (NA > 0) {
            System.out.println("Введите " + NA + " целочисленных элементов A через пробел:");
            while (true) {
                try {
                    String line = scanner.nextLine();
                    if (line.trim().isEmpty()) {
                        if (NA == 0) {
                            break;
                        } else {
                            System.out.println("Ошибка: Ввод не может быть пустым. Пожалуйста, введите числа через пробел.");
                            continue;
                        }
                    }

                    String[] elements = line.trim().split("\\s+");

                    if (elements.length != NA) {
                        System.out.println("Ошибка: Вы ввели " + elements.length + " элементов, а ожидалось " + NA + ". Введите числа через пробел.");
                        continue;
                    }

                    for (int i = 0; i < NA; i++) {
                        A[i] = Integer.parseInt(elements[i]);
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: Введите числа через пробел.");
                } catch (Exception e) {
                    System.out.println("Произошла непредвиденная ошибка. Пожалуйста, попробуйте снова.");
                }
            }
        } else {
            System.out.println("Массив A пуст, элементы не вводятся.");
        }

        System.out.println("\nИсходный массив A: " + Arrays.toString(A));
        System.out.println("Размер исходного массива NA: " + NA);
        System.out.println("--");

        int[][] result = separateEvenOdd(A, NA);

        int[] B = result[0];
        int NB = B.length;

        int[] C = result[1];
        int NC = C.length;

        System.out.println("Массив B (четные числа):");
        System.out.println("Размер NB: " + NB);
        System.out.println("Содержимое B: " + Arrays.toString(B));
        System.out.println();

        System.out.println("Массив C (нечетные числа):");
        System.out.println("Размер NC: " + NC);
        System.out.println("Содержимое C: " + Arrays.toString(C));

        scanner.close();
    }
}