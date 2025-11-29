package Lab3.ru.Lesnikova.weapons;

public class Task1_5 {
    private int ammo;               // текущее количество патронов
    private final int maxCapacity;  // максимальная вместимость

    public Task1_5(int maxCapacity) {
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("Максимальная вместимость должна быть положительной");
        }
        this.maxCapacity = maxCapacity;
        this.ammo = 0;
    }

    public Task1_5() {
        this(7);
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getAmmo() {
        return ammo;
    }

    public boolean isLoaded() {
        return ammo > 0;
    }

    public int reload(int bullets) {
        if (bullets < 0) {
            throw new IllegalArgumentException("Нельзя зарядить отрицательное количество патронов");
        }

        int spaceAvailable = maxCapacity - ammo; // свободное место
        int bulletsToLoad = Math.min(bullets, spaceAvailable);
        ammo += bulletsToLoad;

        return bullets - bulletsToLoad;  // лишние патроны
    }

    public int unload() {
        int currentAmmo = ammo;
        ammo = 0;
        return currentAmmo;
    }

    public void shoot() {
        if (ammo > 0) {
            System.out.println("Бах!");
            ammo--;
        } else {
            System.out.println("Клац!");
        }
    }

    @Override
    public String toString() {
        return "Пистолет {патронов=" + ammo + "/" + maxCapacity +
                ", состояние=" + (isLoaded() ? "заряжен" : "разряжен") + "}";
    }
}