package Lab3.ru.Lesnikova.weapons;

public class Task5_8 {
    private String name;
    private Task4_1_Weapon weapon;

    public Task5_8(String name) {
        this(name, null);
    }

    public Task5_8(String name, Task4_1_Weapon weapon) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя стрелка не может быть пустым");
        }
        this.name = name;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Task4_1_Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Task4_1_Weapon weapon) {
        this.weapon = weapon;
    }

    public void shoot() {
        if (weapon != null) {
            weapon.shoot();
        } else {
            System.out.println(": не могу участвовать в перестрелке");
        }
    }

    @Override
    public String toString() {
        return "Стрелок {" + name +
                ", оружие=" + (weapon != null ? weapon.toString() : "нет") + "}";
    }
}