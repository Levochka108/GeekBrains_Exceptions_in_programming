package com.levochka108.home.task3;

import com.levochka108.home.task3.model.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Напишите приложение, которое будет запрашивать у пользователя следующие данные, разделенные пробелом:
 * Фамилия Имя Отчество номертелефона
 *
 * Форматы данных:
 * фамилия, имя, отчество - строки
 * номертелефона - целое беззнаковое число без форматирования
 *
 * Ввод всех элементов через пробел
 *
 * Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
 *
 * Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.
 *
 * Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида
 *
 * <Фамилия><Имя><Отчество><номер_телефона>
 *
 * Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
 *
 * Не забудьте закрыть соединение с файлом.
 *
 * При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите данные в формате: Фамилия Имя Отчество номертелефона");
            String input = scanner.nextLine();

            // Разделите введенные данные на отдельные элементы по пробелу
            String[] inputData = input.split(" ");

            // Проверьте количество введенных элементов
            if (inputData.length != 4) {
                System.err.println("Ошибка: введено недостаточно или слишком много данных.");
                return;
            }

            // Извлеките данные из массива
            String lastName = inputData[0];
            String firstName = inputData[1];
            String patronymic = inputData[2];

            // Попытайтесь преобразовать номер телефона в целое число
            int phoneNumber;
            try {
                phoneNumber = Integer.parseInt(inputData[3]);
            } catch (NumberFormatException e) {
                System.err.println("Ошибка: номер телефона должен быть целым числом.");
                return;
            }

            // Создайте экземпляр класса User
            User user = new User(firstName, lastName, patronymic, phoneNumber);

            // Создайте файл с именем, равным фамилии пользователя
            String fileName = lastName + ".txt";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                // Запишите данные пользователя в файл
                writer.write(user.toString());
                System.out.println("Данные успешно записаны в файл " + fileName);
            } catch (IOException e) {
                System.err.println("Ошибка при записи в файл: " + e.getMessage());
            }
        }
    }
}

