package Homework;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Calc03 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Введите первое число: ");
        double result = Double.parseDouble(scanner.nextLine());
        Deque<Double> resStack = new ArrayDeque<>();

        while (true) {
            System.out.println("Введите операцию (+ - * /), \"b\" - откат");
            String op = scanner.nextLine();
            if (op.equals("")) {
                System.out.println("Завершение работы программы.");
                break;
            }
            double b = 0;
            if (!op.equals("b")) {
                System.out.println("Введите следующее число: ");
                b = Double.parseDouble(scanner.nextLine());
            }

            switch (op) {
                case "+":
                    result += b;
                    logResult(result);
                    resStack.push(result);
                    break;
                case "-":
                    result -= b;
                    logResult(result);
                    resStack.push(result);
                    break;
                case "*":
                    result *= b;
                    logResult(result);
                    resStack.push(result);
                    break;
                case "/":
                    if (b != 0) {
                        result /= b;
                        logResult(result);
                        resStack.push(result);
                    } else
                        System.out.println("Ошибка! Деление на ноль! Введите другое число или операцию");

                    break;
                case "b":
                    if (resStack.size() > 1) {
                        System.out.println("Откат операции");
                        resStack.pop();
                        result = resStack.peek();
                    } else
                        System.out.println("Откат невозможен, выберите другую операцию");
                    break;
                default:
                    System.out.println("Неверная операция!");
            }

            System.out.println("Результат: " + result);
        }
    }

    static void logResult(double res) {
        File logFile = new File("log.txt");
        try (FileWriter fileWriter = new FileWriter(logFile, true)) {
            fileWriter.write("Result: " + res + "\n");
            fileWriter.flush();
        } catch (IOException ex) {

        }

    }
}
