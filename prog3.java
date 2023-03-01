/* Дана json строка (можно сохранить в файл и читать из файла)
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
Пример вывода:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.*/

import java.io.*;

public class prog3 {
    public static void main(String[] args) {
        File file = new File("testProg3.json");
        System.out.println(parseStr(file));
    }

    public static String parseStr(File file) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String[] arrStr = br.readLine().split("[{(\\[\\]}\\n)]");
            for (String el : arrStr) {
                if (el.length() > 1) {
                    String[] param = el.split(",");
                    String[] p1 = param[0].split(":");
                    String[] p2 = param[1].split(":");
                    String[] p3 = param[2].split(":");
                    sb.append("Студент ").append(p1[1], 1, p1[1].length() - 1).append(" получил оценку ")
                            .append(p2[1], 1, p2[1].length() - 1).append(" по предмету ")
                            .append(p3[1], 1, p3[1].length() - 1).append(".\n");
                }
            }
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}