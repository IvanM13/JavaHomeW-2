/*Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json строки.
Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class prog1 {
    public static void main(String[] args) {
        File file = new File("testProg1.json");
        System.out.println(getRequest(file));
    }

    public static StringBuilder getRequest(File file) {
        StringBuilder sb = new StringBuilder("SELECT * FROM students WHERE ");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String jsonString = br.readLine();
            jsonString = jsonString.replaceAll("[\"}{\\s+]", "")
                    .replace(":", ",");
            String[] arr = jsonString.split(",");
            for (int i = 0; i < arr.length; i += 2) {
                if (!arr[i + 1].equals("null")) {
                    if (i > 0) {
                        if (!arr[i - 1].equals("null")) {
                            sb.append(" AND ");
                        }
                    }
                    if (!isDigit(arr[i + 1])) {
                        sb.append(arr[i])
                                .append(" = ")
                                .append("'")
                                .append(arr[i + 1])
                                .append("'");
                    } else {
                        sb.append(arr[i])
                                .append(" = ")
                                .append(arr[i + 1]);
                    }
                }
            }
            return sb;
        } catch (IOException ex) {
            return new StringBuilder(ex.getLocalizedMessage());
        }
    }

    public static boolean isDigit(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}