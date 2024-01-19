package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введіть числа для додавання їх в колекцію, коли ви будете вважати що достатньо чисел напишіть Ok чи ok");
            System.out.print("\nВведіть: ");
            String input = scanner.nextLine();

            if (input.equals("ok") || input.equals("Ok")) {
                break;
            }

            try {
                int number = Integer.parseInt(input);
                list.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Error :(");
            }
        }


        System.out.println("До виконань функцій: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
        bubbleSort(list);
        removeArray(list);
        numbersInSquare(list);
        multiply2(list);

        System.out.println("\nПісля виконань функцій: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
        IntStream.of(50, 80, 100, 120).filter(x -> x < 90).map(x -> x + 10)
                .limit(3).forEach(System.out::print);

        System.out.println("\nАналізуємо: ");

        int sumOfEvenNumbers = list.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Сума всіх парних чисел у списку: " + sumOfEvenNumbers);

        int maxNumber = list.stream()
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt();
        System.out.println("Максимальне число у списку: " + maxNumber);

        String oddNumbers = list.stream()
                .filter(number -> number % 2 != 0)
                .map(Object::toString)
                .reduce((a, b) -> a + ", " + b)
                .orElse("Нема непарних чисел");
        System.out.println("Непарні числа: " + oddNumbers);

        double average = list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        System.out.println("Середнє арифметичне: " + average);
    }
    public static void removeArray(List<Integer> list){ //Функція, яка видаляє числа з масиву, які понад 90
        list.removeIf(i -> i > 90);
    }
    public static void numbersInSquare(List<Integer> list){ //Функція, яка зводить число у квадрат
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) * list.get(i));
        }
    }
    public static void multiply2(List<Integer> list){ //Функція, яка множить весь рядок на 2
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) * 2);
        }
    }
    public static void bubbleSort(List<Integer> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
}