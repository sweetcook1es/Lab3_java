package Lab3.ru.Lesnikova.weapons;

public abstract class Task4_1_Weapon {
    private int ammo;  // Количество патронов

    public Task4_1_Weapon(int ammo) {
        if (ammo < 0) throw new RuntimeException("Количество патронов не может быть отрицательным");
        this.ammo = ammo;
    }

    public abstract void shoot();

    public int getAmmo() {
        return ammo;
    }

    public boolean useAmmo() {
        if (ammo == 0) return false;
        ammo--;
        return true;
    }

    public int load(int additionalAmmo) {
        if (additionalAmmo < 0) {
            throw new RuntimeException("Количество патронов не может быть отрицательным");
        }
        int oldAmmo = this.ammo;
        this.ammo += additionalAmmo;  // добавляем патроны
        return oldAmmo;
    }
}