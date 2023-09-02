package com.levochka108.classGB.day_03.task1;
/*
 * arrayOutOfBoundsException()
 * Если нам нужно преданамеренно получить ошибку в блоке
 * arrayOutOfBoundsException, то нам нужно для этого вызвать элимент который не входит
 * в диапозон созданного массива int[] array = {1,2,3,4}; массив начинает отсчет с 0 и до 3
 * в нашем случаи.
 *
 * divisionByZero()
 * Если нужно получить ошибку Делить на ноль нельзя
 * то можно использовать как вариант такой способ
 * Создаем переменную типа int даем ей название в нашем это sum
 * производим запись внутри переменной, деление на ноль
 * выводи ответ в консоль, получает нужную ошибку.
 *
 * numberFormatException()
 * Если нужно получить ошибку в преобразовании текста как текста в цило
 * Создаем переменную типа String, записываем там строку пример "Несдавайся ты молодец."
 * А потом создаем переменную пита int и делаем преобразование
 * в число через класс Integer вызывая метод .parseInt(text) передаем параметор наш тексте,
 * делаем вывод в консоль.
 * */

class Answer {
    public static void arrayOutOfBoundsException() {
        int[] array = {1, 2, 3, 4};
        System.out.println(array[4]);
    }

    public static void divisionByZero() {
        int sum = 5 / 0;
        System.out.println(sum);
    }

    public static void numberFormatException() {
        String text = "Hello World";
        int outText = Integer.parseInt(text);
        System.out.println(outText);
    }
}

public class Printer {
    public static void main(String[] args) {
        Answer ans = new Answer();
        try {
            ans.arrayOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за пределы массива");
        }

        try {
            ans.divisionByZero();
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        }

        try {
            ans.numberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования строки в число");
        }
    }
}