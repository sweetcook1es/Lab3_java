package Lab3.ru.Lesnikova.geometry;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class Task7_3 {

    public static double power(String xStr, String yStr) {
        if (xStr == null || yStr == null) {
            throw new IllegalArgumentException("Аргументы не могут быть null");
        }
        int x = parseInt(xStr); // строковое представление
        int y = parseInt(yStr);

        return pow(x, y);
    }
}