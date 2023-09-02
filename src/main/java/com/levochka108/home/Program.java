package com.levochka108.home;


import java.util.Scanner;

/**
 * Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение.
 * Ввод текста вместо числа не должно приводить к падению приложения,
 * вместо этого, необходимо повторно запросить у пользователя ввод данных.
 */


import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Program2 program2 = new Program2();
        Program3 program3 = new Program3();
        Program4 program4 = new Program4();

        //run();
       // program2.run();
       // program3.run();
        program4.run();
    }

    public static void run(){
        Scanner scanner = new Scanner(System.in);

        float userInput = getFloatInputWithValidation(scanner);

        System.out.println("Вы ввели дробное число: " + userInput);

        scanner.close();
    }
    public static float getFloatInputWithValidation(Scanner scanner) {
        float result = 0.0f;
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Введите дробное число: ");
            String input = scanner.next();

            if (isInteger(input)) {
                System.out.println("\nОшибка: Введено целое число. Пожалуйста, введите дробное число.");
            } else {
                try {
                    result = Float.parseFloat(input.replace(",", ".")); // Заменяем запятую на точку
                    isValid = true;
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: Введено недопустимое значение. Пожалуйста, введите дробное число.");
                }
            }
        }

        return result;
    }

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

/**
 * Если необходимо, исправьте данный код
 * Задание 2
 * try {
 *    int d = 0;
 *    double catchedRes1 = intArray[8] / d;
 *    System.out.println("catchedRes1 = " + catchedRes1);
 * } catch (ArithmeticException e) {
 *    System.out.println("Catching exception: " + e);
 * }
 */
class Program2{
    public static void run(){
        try {
            int[] intArray = new int[10];
            int d = 0;
            double catchedRes1 = intArray[8] / d; // Попытка деления на ноль
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) { // Обработка исключения ArithmeticException
            System.out.println("Перехват исключения: " + e.getMessage()); // Вывод сообщения об ошибке
            // Или используйте e.printStackTrace(); для более подробной информации об ошибке
        }
    }
}

/**
 * Дан следующий код, исправьте его там, где требуется
 * Задание 3
 *
 * public static void main(String[] args) throws Exception {
 *    try {
 *        int a = 90;
 *        int b = 3;
 *        System.out.println(a / b);
 *        printSum(23, 234);
 *        int[] abc = { 1, 2 };
 *        abc[3] = 9;
 *    } catch (Throwable ex) {
 *        System.out.println("Что-то пошло не так...");
 *    } catch (NullPointerException ex) {
 *        System.out.println("Указатель не может указывать на null!");
 *    } catch (IndexOutOfBoundsException ex) {
 *        System.out.println("Массив выходит за пределы своего размера!");
 *    }
 * }
 * public static void printSum(Integer a, Integer b) throws FileNotFoundException {
 *    System.out.println(a + b);
 * }
 */
class Program3{
    public static void run() {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }

    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }

}

/**
 * Разработайте программу, которая выбросит Exception,
 * когда пользователь вводит пустую строку. Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
 *
 */

class Program4{
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст: ");

        try {
            if (scanner.hasNextLine()) { // Проверка на наличие ввода
                String input = scanner.nextLine().trim(); // Удаляем начальные и конечные пробелы
                if (input.isEmpty()) {
                    throw new Exception("Пустые строки вводить нельзя!");
                }
                System.out.println("Вы ввели: " + input);
            } else {
                System.out.println("Ввод не был осуществлен.");
            }
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
