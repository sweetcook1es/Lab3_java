package Lab3.ru.Lesnikova.weapons;

public class Task4_1 extends Task4_1_Weapon {
    private final int maxCapacity;  // максимальная вместимость

    public Task4_1(int maxCapacity) {
        super(0);  // вызов конструктора род класса
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("Вместимость должна быть положительной");
        }
        this.maxCapacity = maxCapacity;
    }

    public Task4_1() {
        this(7);
    }

    @Override
    public void shoot() {
        if (useAmmo()) {
            System.out.println("Бах!");
        } else {
            System.out.println("Клац!");
        }
    }

    public int reload(int bullets) {
        if (bullets < 0) {
            throw new IllegalArgumentException("Нельзя зарядить отрицательное количество патронов");
        }

        int currentAmmo = getAmmo();
        int spaceAvailable = maxCapacity - currentAmmo;
        int bulletsToLoad = Math.min(bullets, spaceAvailable);

        load(bulletsToLoad);

        return bullets - bulletsToLoad;
    }

    public int unload() {
        int currentAmmo = getAmmo();
        load(-currentAmmo);  // убираем все патроны
        return currentAmmo;
    }

    public boolean isLoaded() {
        return getAmmo() > 0;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    @Override
    public String toString() {
        return "Пистолет {патронов=" + getAmmo() + "/" + maxCapacity +
                ", состояние=" + (isLoaded() ? "заряжен" : "разряжен") + "}";
    }
}