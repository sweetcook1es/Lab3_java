package Lab3.ru.Lesnikova.weapons;

public class Task3_4 extends Task4_1_Weapon {
    private final int fireRate;     // выстрелов в секунду
    private final int maxCapacity;  // максимальная вместимость

    public Task3_4() {
        super(0);
        this.maxCapacity = 30;
        this.fireRate = 30;
    }

    public Task3_4(int maxCapacity) {
        super(0);
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("Вместимость должна быть положительной");
        }
        this.maxCapacity = maxCapacity;
        this.fireRate = Math.max(1, maxCapacity / 2);
    }

    public Task3_4(int maxCapacity, int fireRate) {
        super(0);
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("Вместимость должна быть положительной");
        }
        if (fireRate <= 0) {
            throw new IllegalArgumentException("Скорострельность должна быть положительной");
        }
        this.maxCapacity = maxCapacity;
        this.fireRate = fireRate;
    }

    public int getFireRate() {
        return fireRate;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    @Override
    public void shoot() {
        System.out.println("Автоматическая очередь из " + fireRate + " выстрелов:");
        for (int i = 0; i < fireRate; i++) {
            if (getAmmo() > 0) {
                System.out.println("Бах!");
                useAmmo();
            } else {
                System.out.println("Клац!");
            }
        }
    }

    public void shootSeconds(int seconds) {
        if (seconds <= 0) {
            System.out.println("Время стрельбы должно быть положительным");
            return;
        }

        int totalShots = seconds * fireRate;
        System.out.println("Стрельба " + seconds + " секунд (" + totalShots + " выстрелов):");

        for (int i = 0; i < totalShots; i++) {
            if (getAmmo() > 0) {
                System.out.println("Бах!");
                useAmmo();
            } else {
                System.out.println("Клац!");
            }
        }
    }

    public int reload(int bullets) {
        if (bullets < 0) {
            throw new IllegalArgumentException("Нельзя зарядить отрицательное количество патронов");
        }

        int spaceAvailable = maxCapacity - getAmmo();
        int bulletsToLoad = Math.min(bullets, spaceAvailable);

        load(bulletsToLoad);
        return bullets - bulletsToLoad;
    }

    public int unload() {
        int currentAmmo = getAmmo();

        int shotsFired = 0;
        while (getAmmo() > 0) {
            useAmmo();
            shotsFired++;
        }
        System.out.println("При разрядке произведено " + shotsFired + " выстрелов");

        return currentAmmo;
    }

    public boolean isLoaded() {
        return getAmmo() > 0;
    }

    @Override
    public String toString() {
        return "Автомат {патронов=" + getAmmo() + "/" + maxCapacity +
                ", скорострельность=" + fireRate + " выстр/сек}";
    }
}