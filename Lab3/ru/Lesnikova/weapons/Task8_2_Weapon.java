package Lab3.ru.Lesnikova.weapons;

public abstract class Task8_2_Weapon {
    protected int ammo; // тек класс, класс насл, классы проекта

    public Task8_2_Weapon(int ammo) {
        if (ammo < 0) throw new RuntimeException("Количество патронов не может быть отрицательным");
        this.ammo = ammo;
    }

    public abstract void shoot();

    public int getAmmo() {
        return ammo;
    }

    protected boolean useAmmo() {
        if (ammo == 0) return false;
        ammo--;
        return true;
    }

    public void load(int additionalAmmo) {
        if (additionalAmmo < 0) {
            throw new RuntimeException("Количество патронов не может быть отрицательным");
        }
        this.ammo += additionalAmmo;
    }

    public int unload() {
        int currentAmmo = ammo;
        ammo = 0;
        return currentAmmo;
    }
}