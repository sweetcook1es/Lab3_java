package Lab3.ru.Lesnikova.weapons;

public class Task8_2 extends Task8_2_Weapon {
    private final int maxCapacity;

    public Task8_2(int maxCapacity) {
        super(0);
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("Вместимость должна быть положительной");
        }
        this.maxCapacity = maxCapacity;
    }

    public Task8_2() {
        this(7);
    }

    @Override
    public void shoot() {
        if (ammo > 0) {
            System.out.println("Бах!");
            ammo--;
        } else {
            System.out.println("Клац!");
        }
    }

    public int reload(int bullets) {
        if (bullets < 0) {
            throw new IllegalArgumentException("Нельзя зарядить отрицательное количество патронов");
        }

        int spaceAvailable = maxCapacity - ammo;
        int bulletsToLoad = Math.min(bullets, spaceAvailable);
        load(bulletsToLoad);

        return bullets - bulletsToLoad;
    }


    public boolean isLoaded() {
        return ammo > 0;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    @Override
    public String toString() {
        return "Пистолет {патронов=" + ammo + "/" + maxCapacity +
                ", состояние=" + (isLoaded() ? "заряжен" : "разряжен") + "}";
    }
}