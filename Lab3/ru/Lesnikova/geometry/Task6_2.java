package Lab3.ru.Lesnikova.geometry;

public class Task6_2 {
    private final int x;
    private final int y;

    public Task6_2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Task6_2 other = (Task6_2) obj;
        return x == other.x && y == other.y;
    }

    @Override
    public String toString() {
        return "(" + x + ";" + y + ")";
    }
}