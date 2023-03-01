/*
 * 4*. К калькулятору из предыдущего дз добавить логирование.
 */

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class prog4 {
    private static final Logger logger = Logger.getLogger(prog4.class.getName());

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        double a = scanner.nextDouble();
        System.out.println("Введите операцию (+, -, *, /): ");
        char op = scanner.next().charAt(0);
        System.out.println("Введите второе число: ");
        double b = scanner.nextDouble();
        double res = 0;
        scanner.close();
        getLog();
        System.out.println(Calc(a, op, b, res));
    }

    private static void getLog() throws IOException {
        logger.setLevel(Level.INFO);
        FileHandler fh = new FileHandler("logProg4.json");
        fh.setFormatter(new SimpleFormatter());
        logger.addHandler(fh);
        logger.setUseParentHandlers(false);
    }

    public static String Calc(double a, char op, double b, double res) {
        logger.info("Введено первое число: " + a);
        logger.info("Введена операция: " + op);
        logger.info("Введено второе число: " + b);
        if (b == 0 && op == '/') return "Деление на 0 запрещено!";
        else {
            switch (op) {
                case '+':
                    res = a + b;
                    break;
                case '-':
                    res = a - b;
                    break;
                case '/':
                    res = a / b;
                    break;
                case '*':
                    res = a * b;
                    break;
            }
            logger.info("Решение: " + a + " " + op + " " + b + " = " + res);
            return "Решение: " + a + " " + op + " " + b + " = " + res;
        }
    }
}
