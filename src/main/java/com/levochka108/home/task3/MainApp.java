package com.levochka108.home.task3;

import com.levochka108.home.task3.model.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите имя: ");
            String firstName = scanner.nextLine();

            System.out.print("Введите фамилию: ");
            String lastName = scanner.nextLine();

            System.out.print("Введите отчество: ");
            String patronymic = scanner.nextLine();

            System.out.print("Введите ваш телефон: ");
            long phoneNumber;
            try {
                phoneNumber = Long.parseLong(scanner.nextLine());
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
                writer.write("Имя: " + user.getFirstName());
                writer.newLine();
                writer.write("Фамилия: " + user.getLastName());
                writer.newLine();
                writer.write("Отчество: " + user.getSurname());
                writer.newLine();
                writer.write("Телефон: " + user.getPhoneNumber());
                System.out.println("Данные успешно записаны в файл " + fileName);
            } catch (IOException e) {
                System.err.println("Ошибка при записи в файл: " + e.getMessage());
            }
        }
    }
}
