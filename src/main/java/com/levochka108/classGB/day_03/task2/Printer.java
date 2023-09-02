package com.levochka108.classGB.day_03.task2;

import java.util.Arrays;

/**
 * 2-я задача заключалась в том, чтобы записать 2 массива в один
 * и проверить на равность размеров этих массивов.
 *
 * Нужно было вспомнить как произвдится запись нового массива
 * для этого мы создаем новый пустой массив, чтобы понять какая у него длинна,
 * берем длинну массива А или Б, разницы нет и используем ее.
 * если мыссивы разные у нас выйдет ошибка.
 * с массивом в 1 элимент . это 0.
 */

class Answer {
    public int[] subArrays(int[] a, int[] b){
        if (a.length != b.length){
            return new int[1];
        }else {
            int[] c = new int[a.length];
            for (int i = 0; i < a.length; i++){
                c[i] = a[i] - b[i];
            }
            return c;
        }

    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer{
    public static void main(String[] args) {
        int[] a = {};
        int[] b = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = new int[]{4, 5, 6};
            b = new int[]{1, 2, 3, 4};
        }
        else{
            a = Arrays.stream(args[0].split(", ")).mapToInt(Integer::parseInt).toArray();
            b = Arrays.stream(args[1].split(", ")).mapToInt(Integer::parseInt).toArray();
        }

        Answer ans = new Answer();
        String itresume_res = Arrays.toString(ans.subArrays(a, b));
        System.out.println(itresume_res);
    }
}