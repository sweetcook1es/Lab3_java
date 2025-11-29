package Lab3.ru.Lesnikova.main;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import Lab3.ru.Lesnikova.weapons.Task1_5;
import Lab3.ru.Lesnikova.people.Task1_7;
import Lab3.ru.Lesnikova.data.Task2_3;
import Lab3.ru.Lesnikova.weapons.Task3_4;
import Lab3.ru.Lesnikova.weapons.Task4_1;
import Lab3.ru.Lesnikova.weapons.Task5_8;
import Lab3.ru.Lesnikova.geometry.Task6_2;
import Lab3.ru.Lesnikova.geometry.Task7_3;


public class Main {

    public static void main(String[] args) {

        while (true){
            Scanner scanner = new Scanner(System.in);

            System.out.println("1 - Task1_5");
            System.out.println("2 - Task1_7");
            System.out.println("3 - Task2_3");
            System.out.println("4 - Task3_4");
            System.out.println("5 - Task4_1");
            System.out.println("6 - Task5_8");
            System.out.println("7 - Task6_2");
            System.out.println("8 - Task7_3");
            System.out.println("9 - Close");

            int task = getPositiveInt(scanner, "\nВыберите номер задания: ");

            switch (task) {
                case 1:
                    demoTask1_5(scanner);
                    break;
                case 2:
                    demoTask1_7(scanner);
                    break;
                case 3:
                    demoTask2_3(scanner);
                    break;
                case 4:
                    demoTask3_4(scanner);
                    break;
                case 5:
                    demoTask4_1(scanner);
                    break;
                case 6:
                    demoTask5_8(scanner);
                    break;
                case 7:
                    demoTask6_2(scanner);
                    break;
                case 8:
                    demoTask7_3(scanner);
                    break;
                case 9:
                    scanner.close();
                    System.out.println("Конец");
                    break;
                default:
                    System.out.println("Неверный номер задания");
                    break;

            }
        }
    }


    public static void demoTask1_5(Scanner scanner) {
        System.out.println("ЗАДАНИЕ 1.5");

        boolean kontrol = true;
        while (kontrol) {
            System.out.println("1 - Пистолет по умолчанию (вместимость 7)");
            System.out.println("2 - Пистолет с указанием вместимости");
            System.out.println("3 - Выход");

            int choice = getPositiveInt(scanner, "Введите номер варианта: ");

            Task1_5 pistol;

            switch (choice) {
                case 1:
                    pistol = new Task1_5();
                    System.out.println("Создан пистолет по умолчанию: " + pistol);
                    workWithPistol(scanner, pistol);
                    break;
                case 2:
                    int capacity = getPositiveInt(scanner, "Введите вместимость пистолета: ");

                    pistol = new Task1_5(capacity);
                    System.out.println("Создан пистолет: " + pistol);
                    workWithPistol(scanner, pistol);
                    break;
                case 3:
                    kontrol = false;
                    break;
                default:
                    System.out.println("Неверный выбор варианта");
                    break;
            }
        }
    }

    private static void workWithPistol(Scanner scanner, Task1_5 pistol) {
        boolean workingWithPistol = true;

        while (workingWithPistol) {
            System.out.println("\n=== РАБОТА С ПИСТОЛЕТОМ ===");
            System.out.println("Текущее состояние: " + pistol);
            System.out.println("1 - Перезарядить");
            System.out.println("2 - Разрядить");
            System.out.println("3 - Проверить состояние");
            System.out.println("4 - Выстрелить");
            System.out.println("0 - Вернуться к выбору пистолета");

            int choice = getPositiveInt(scanner, "Выберите действие: ");

            switch (choice) {
                case 1:
                    int ammoToReload = getPositiveInt(scanner, "Введите количество патронов для перезарядки: ");
                    int excess = pistol.reload(ammoToReload);
                    System.out.println("Пистолет перезаряжен. Лишние патроны: " + excess);
                    System.out.println("Текущее состояние: " + pistol);
                    break;
                case 2:
                    int returnedAmmo = pistol.unload();
                    System.out.println("Пистолет разряжен. Возвращено патронов: " + returnedAmmo);
                    System.out.println("Текущее состояние: " + pistol);
                    break;
                case 3:
                    System.out.println("Максимальная вместимость: " + pistol.getMaxCapacity());
                    System.out.println("Текущее количество патронов: " + pistol.getAmmo());
                    System.out.println("Состояние: " + (pistol.isLoaded() ? "ЗАРЯЖЕН" : "РАЗРЯЖЕН"));
                    break;
                case 4:
                    int vistrel = getPositiveInt(scanner, "Введите количество выстрелов: ");
                    while (vistrel > 0) {
                        System.out.print("Выстрел: ");
                        pistol.shoot();
                        System.out.println("Текущее состояние: " + pistol);
                        vistrel -= 1;
                    }
                    break;
                case 0:
                    workingWithPistol = false;
                    break;
                default:
                    System.out.println("Неверный выбор");
                    break;
            }
        }
    }

    public static void demoTask1_7(Scanner scanner) {
        System.out.println("ЗАДАНИЕ 1.7");

        int count = getPositiveInt(scanner, "Введите количество имен для создания: ");

        for (int i = 0; i < count; i++) {
            System.out.println("Создание имени " + (i + 1));
            String firstName = getNonEmptyInput(scanner, "Введите имя: ");
            String lastName = getInput(scanner, "Введите фамилию (или Enter чтобы пропустить): ");
            String middleName = getInput(scanner, "Введите отчество (или Enter чтобы пропустить): ");


            Task1_7 name;
            // проверка на то что строки непустые
            if (!lastName.isEmpty() && !middleName.isEmpty()) {
                name = new Task1_7(lastName, firstName, middleName);
            } else if (!lastName.isEmpty()) {
                name = new Task1_7(firstName, lastName);
            } else {
                name = new Task1_7(firstName);
            }
            System.out.println("Создано имя: " + name);
            System.out.println("Имя='" + name.getFirstName() +
                    "', Фамилия='" + name.getLastName() +
                    "', Отчество='" + name.getMiddleName() + "'");

        }
    }

    public static void demoTask2_3(Scanner scanner) {
        System.out.println("ЗАДАНИЕ 2.3");

        Task2_3 directory = new Task2_3();

        boolean continueUsing = true;
        while (continueUsing) {
            System.out.println("1 - Добавить/обновить контакт");
            System.out.println("2 - Удалить контакт");
            System.out.println("3 - Найти телефон по имени");
            System.out.println("4 - Проверить наличие имени");
            System.out.println("5 - Проверить наличие телефона");
            System.out.println("6 - Показать все контакты");
            System.out.println("7 - Показать статистику");
            System.out.println("8 - Поиск имен по началу");
            System.out.println("9 - Экспорт данных");
            System.out.println("0 - Выход");

            int choice = getPositiveInt(scanner, "Выберите действие: ");

            switch (choice) {
                case 1:
                    String name = getNonEmptyInput(scanner, "Введите имя: ");
                    String phone = getNonEmptyInput(scanner, "Введите телефон: ");
                    String oldPhone = directory.addContact(phone, name);
                    if (oldPhone != null) {
                        System.out.println("Контакт обновлен. Старый телефон: " + oldPhone);
                    } else {
                        System.out.println("Контакт добавлен");
                    }
                    break;
                case 2:
                    String deleteName = getNonEmptyInput(scanner, "Введите имя для удаления: ");
                    boolean removed = directory.removeContact(deleteName);
                    if (removed) {
                        System.out.println("Контакт удален");
                    } else {
                        System.out.println("Контакт не найден");
                    }
                    break;
                case 3:
                    String searchName = getNonEmptyInput(scanner, "Введите имя для поиска: ");
                    String foundPhone = directory.getPhone(searchName);
                    if (foundPhone != null) {
                        System.out.println("Телефон " + searchName + ": " + foundPhone);
                    } else {
                        System.out.println("Контакт не найден");
                    }
                    break;

                case 4:
                    String checkName = getNonEmptyInput(scanner, "Введите имя для проверки: ");
                    boolean nameExists = directory.containsName(checkName);
                    if (nameExists) {
                        System.out.println("Имя найдено в справочнике");
                    } else {
                        System.out.println("Имя не найдено в справочнике");
                    }
                    break;

                case 5:
                    String checkPhone = getNonEmptyInput(scanner, "Введите телефон для проверки: ");
                    boolean phoneExists = directory.containsPhone(checkPhone);
                    if (phoneExists) {
                        System.out.println("Телефон найден в справочнике");
                    } else {
                        System.out.println("Телефон не найден в справочнике");
                    }
                    break;

                case 6:
                    String contacts = directory.toString();
                    if (contacts.isEmpty()) {
                        System.out.println("Справочник пуст");
                    } else {
                        System.out.println(contacts);
                    }
                    break;

                case 7:
                    System.out.println("Количество контактов: " + directory.getContactCount());
                    System.out.println("Все имена: " + java.util.Arrays.toString(directory.getAllNames()));
                    System.out.println("Все телефоны: " + java.util.Arrays.toString(directory.getAllPhones()));
                    break;

                case 8:
                    String prefix = getNonEmptyInput(scanner, "Введите начало имени: ");
                    String[] matchingNames = directory.getNamesStartingWith(prefix);
                    if (matchingNames.length > 0) {
                        System.out.println("Найдены имена: " + java.util.Arrays.toString(matchingNames));
                    } else {
                        System.out.println("Имена не найдены");
                    }
                    break;

                case 9:
                    String[][] allPairs = directory.getAllPairs();
                    if (allPairs.length > 0) {
                        System.out.println("Все пары (имя-телефон):");
                        for (String[] pair : allPairs) {
                            System.out.println("  " + pair[0] + " - " + pair[1]);
                        }
                    } else {
                        System.out.println("Справочник пуст");
                    }
                    break;

                case 0:
                    continueUsing = false;
                    System.out.println("Выход");
                    break;

                default:
                    System.out.println("Неверный выбор");
            }
        }
    }


    public static void demoTask3_4(Scanner scanner) {
        System.out.println("ЗАДАНИЕ 3.4");

        System.out.println("1 - Без параметров (скорострельность 30, вместимость 30)");
        System.out.println("2 - С указанием вместимости (скорострельность = половина обоймы)");
        System.out.println("3 - С указанием вместимости и скорострельности");

        int choice = getPositiveInt(scanner, "Введите номер варианта: ");

        Task3_4 machineGun;

        switch (choice) {
            case 1:
                machineGun = new Task3_4();
                System.out.println("Создан автомат по умолчанию: " + machineGun);
                break;

            case 2:
                int capacity1 = getPositiveInt(scanner, "Введите вместимость автомата: ");

                machineGun = new Task3_4(capacity1);
                System.out.println("Создан автомат: " + machineGun);
                break;

            case 3:
                int capacity2 = getPositiveInt(scanner, "Введите вместимость автомата: ");
                int fireRate = getPositiveInt(scanner, "Введите скорострельность: ");

                machineGun = new Task3_4(capacity2, fireRate);
                System.out.println("Создан автомат: " + machineGun);
                break;

            default:
                System.out.println("Неверный выбор");
                machineGun = new Task3_4();
                break;
        }


        boolean continueUsing = true;
        while (continueUsing) {
            System.out.println("\nВыберите действие:");
            System.out.println("1 - Зарядить патроны");
            System.out.println("2 - Одиночный выстрел (автоматическая очередь)");
            System.out.println("3 - Стрельба N секунд");
            System.out.println("4 - Разрядить автомат");
            System.out.println("5 - Показать состояние");
            System.out.println("0 - Выход");

            int action = getPositiveInt(scanner, "Введите номер действия: ");

            switch (action) {
                case 1:
                    int bullets = getPositiveInt(scanner, "Сколько патронов зарядить? ");

                    int remaining = machineGun.reload(bullets);
                    System.out.println("Заряжено, осталось лишних: " + remaining);
                    System.out.println("После зарядки: " + machineGun);
                    break;

                case 2:
                    System.out.println("Одиночный выстрел (автоматическая очередь):");
                    machineGun.shoot();
                    System.out.println("После выстрела: " + machineGun);
                    break;

                case 3:
                    int seconds = getPositiveInt(scanner, "Сколько секунд стрелять? ");
                    machineGun.shootSeconds(seconds);
                    System.out.println("После стрельбы: " + machineGun);
                    break;

                case 4:
                    int unloaded = machineGun.unload();
                    System.out.println("Разряжено патронов: " + unloaded);
                    System.out.println("После разрядки: " + machineGun);
                    break;

                case 5:
                    System.out.println("Текущее состояние: " + machineGun);
                    System.out.println("Скорострельность: " + machineGun.getFireRate() + " выстр/сек");
                    System.out.println("Максимальная вместимость: " + machineGun.getMaxCapacity());
                    break;

                case 0:
                    continueUsing = false;
                    System.out.println("Выход");
                    break;

                default:
                    System.out.println("Неверный выбор");
            }
        }
    }


    public static void demoTask4_1(Scanner scanner) {
        System.out.println("ЗАДАНИЕ 4.1");

        boolean kontrol = true;
        while (kontrol) {
            System.out.println("1 - Пистолет по умолчанию (вместимость 7)");
            System.out.println("2 - Пистолет с указанием вместимости");
            System.out.println("3 - Выход");

            int choice = getPositiveInt(scanner, "Введите номер варианта: ");

            Task4_1 pistol;

            switch (choice) {
                case 1:
                    pistol = new Task4_1 ();
                    System.out.println("Создан пистолет по умолчанию: " + pistol);
                    workWithPistol2(scanner, pistol);
                    break;
                case 2:
                    int capacity = getPositiveInt(scanner, "Введите вместимость пистолета: ");

                    pistol = new Task4_1 (capacity);
                    System.out.println("Создан пистолет: " + pistol);
                    workWithPistol2(scanner, pistol);
                    break;
                case 3:
                    kontrol = false;
                    break;
                default:
                    System.out.println("Неверный выбор варианта");
                    break;
            }
        }
    }

    private static void workWithPistol2(Scanner scanner, Task4_1 pistol) {
        boolean workingWithPistol = true;

        while (workingWithPistol) {
            System.out.println("\n=== РАБОТА С ПИСТОЛЕТОМ ===");
            System.out.println("Текущее состояние: " + pistol);
            System.out.println("1 - Перезарядить");
            System.out.println("2 - Разрядить");
            System.out.println("3 - Проверить состояние");
            System.out.println("4 - Выстрелить");
            System.out.println("0 - Вернуться к выбору пистолета");

            int choice = getPositiveInt(scanner, "Выберите действие: ");

            switch (choice) {
                case 1:
                    int ammoToReload = getPositiveInt(scanner, "Введите количество патронов для перезарядки: ");
                    int excess = pistol.reload(ammoToReload);
                    System.out.println("Пистолет перезаряжен. Лишние патроны: " + excess);
                    System.out.println("Текущее состояние: " + pistol);
                    break;
                case 2:
                    int returnedAmmo = pistol.unload();
                    System.out.println("Пистолет разряжен. Возвращено патронов: " + returnedAmmo);
                    System.out.println("Текущее состояние: " + pistol);
                    break;
                case 3:
                    System.out.println("Максимальная вместимость: " + pistol.getMaxCapacity());
                    System.out.println("Текущее количество патронов: " + pistol.getAmmo());
                    System.out.println("Состояние: " + (pistol.isLoaded() ? "ЗАРЯЖЕН" : "РАЗРЯЖЕН"));
                    break;
                case 4:
                    int vistrel = getPositiveInt(scanner, "Введите количество выстрелов: ");
                    while (vistrel > 0) {
                        System.out.print("Выстрел: ");
                        pistol.shoot();
                        System.out.println("Текущее состояние: " + pistol);
                        vistrel -= 1;
                    }
                    break;
                case 0:
                    workingWithPistol = false;
                    break;
                default:
                    System.out.println("Неверный выбор");
                    break;
            }
        }
    }

    public static void demoTask5_8(Scanner scanner) {
        System.out.println("ЗАДАНИЕ 5.8");

        List<Task5_8> shooters = new ArrayList<>();
        boolean running = true;
        while (running) {
            System.out.println("1 - Создать стрелка");
            System.out.println("2 - Показать стрелков");
            System.out.println("3 - Стрельба");
            System.out.println("0 - Выход");

            int choice = getPositiveInt(scanner, "Выберите действие: ");

            switch (choice) {
                case 1:
                    System.out.print("Введите имя стрелка: ");
                    String name = scanner.nextLine();

                    System.out.println("1 - Без оружия");
                    System.out.println("2 - Пистолет");
                    System.out.println("3 - Автомат");

                    int weaponType = getPositiveInt(scanner, "Выберите оружие: ");

                    Task5_8 shooter;
                    if (weaponType == 1) {
                        shooter = new Task5_8(name);
                    } else if (weaponType == 2) {
                        Task4_1 pistol = new Task4_1();
                        System.out.print("Сколько патронов зарядить? ");
                        int ammo = scanner.nextInt();
                        scanner.nextLine();
                        pistol.reload(ammo);
                        shooter = new Task5_8(name, pistol);
                    } else if (weaponType == 3) {
                        System.out.print("Вместимость автомата: ");
                        int capacity = scanner.nextInt();
                        System.out.print("Скорострельность: ");
                        int fireRate = scanner.nextInt();
                        System.out.print("Сколько патронов зарядить? ");
                        int ammo = scanner.nextInt();
                        scanner.nextLine();

                        Task3_4 machineGun = new Task3_4(capacity, fireRate);
                        machineGun.reload(ammo);
                        shooter = new Task5_8(name, machineGun);
                    } else {
                        System.out.println("Неверный выбор, создан без оружия");
                        shooter = new Task5_8(name);
                    }

                    shooters.add(shooter);
                    System.out.println("Стрелок создан: " + shooter);
                    break;

                case 2:
                    if (shooters.isEmpty()) {
                        System.out.println("Стрелки не созданы");
                    } else {
                        System.out.println("Все стрелки:");
                        for (int i = 0; i < shooters.size(); i++) {
                            System.out.println((i + 1) + ". " + shooters.get(i));
                        }
                    }
                    break;

                case 3:
                    if (shooters.isEmpty()) {
                        System.out.println("Сначала создайте стрелков");
                        break;
                    }

                    System.out.print("Сколько выстрелов сделать? ");
                    int shots = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 0; i < shots; i++) {
                        System.out.println("Выстрел " + (i + 1) + ":");
                        for (Task5_8 s : shooters) {
                            System.out.print(s.getName() + ": ");
                            s.shoot();
                        }
                    }

                    for (Task5_8 s : shooters) {
                        System.out.println(s);
                    }
                    break;

                case 0:
                    running = false;
                    System.out.println("Выход");
                    break;

                default:
                    System.out.println("Неверный выбор");
                    break;
            }
        }
    }


    public static void demoTask6_2(Scanner scanner) {
        System.out.println("ЗАДАНИЕ 6.2");

        int pointCount = getPositiveInt(scanner, "Сколько точек вы хотите создать? ");

        Task6_2[] points = new Task6_2[pointCount];

        for (int i = 0; i < pointCount; i++) {
            System.out.println("Точка " + (i + 1));
            int x = getInt(scanner, "Введите координату X: ");
            int y = getInt(scanner, "Введите координату Y: ");
            points[i] = new Task6_2(x, y);
        }

        System.out.println("Все точки:");
        for (int i = 0; i < pointCount; i++) {
            System.out.println("Точка " + (i + 1) + ": " + points[i]);
        }

        boolean continueComparing = true;
        while (continueComparing) {
            System.out.println("1 - Сравнить все точки попарно");
            System.out.println("2 - Сравнить две конкретные точки");
            System.out.println("3 - Найти одинаковые точки");
            System.out.println("4 - Показать все точки");
            System.out.println("0 - Выход");

            int choice = getPositiveInt(scanner, "Выберите режим: ");

            switch (choice) {
                case 1:
                    for (int i = 0; i < points.length; i++) {
                        for (int j = i + 1; j < points.length; j++) {
                            boolean areEqual = points[i].equals(points[j]);
                            System.out.println("Точка " + (i + 1) + points[i] + " == Точка " + (j + 1) + points[j] + " : " + areEqual);
                        }
                    }
                    break;

                case 2:
                    if (points.length < 2) {
                        System.out.println("Нужно как минимум 2 точки для сравнения");
                        break;
                    }
                    int point1 = getPointIndex(scanner, points.length, "Введите номер первой точки (1-" + points.length + "): ");
                    int point2 = getPointIndex(scanner, points.length, "Введите номер второй точки (1-" + points.length + "): ");

                    boolean areEqual = points[point1].equals(points[point2]);
                    System.out.println("Точка " + (point1 + 1) + points[point1] + " == Точка " + (point2 + 1) + points[point2] + " : " + areEqual);
                    break;

                case 3:
                    boolean foundDuplicates = false;
                    for (int i = 0; i < points.length; i++) {
                        for (int j = i + 1; j < points.length; j++) {
                            if (points[i].equals(points[j])) {
                                System.out.println("Точка " + (i + 1) + points[i] + " и Точка " + (j + 1) + points[j] + " - одинаковые");
                                foundDuplicates = true;
                            }
                        }
                    }
                    if (!foundDuplicates) {
                        System.out.println("Одинаковых точек не найдено");
                    }
                    break;

                case 4:
                    for (int i = 0; i < points.length; i++) {
                        System.out.println("Точка " + (i + 1) + ": " + points[i]);
                    }
                    break;

                case 0:
                    continueComparing = false;
                    System.out.println("Выход");
                    break;

                default:
                    System.out.println("Неверный выбор");
            }
        }
    }

    public static void demoTask7_3(Scanner scanner) {
        System.out.println("ЗАДАНИЕ 7.3");

        String xStr = getNonEmptyInput(scanner, "Введите число X: ");
        String yStr = getNonEmptyInput(scanner, "Введите степень Y: ");

        double result = Task7_3.power(xStr, yStr);
        System.out.println(xStr + " в степени " + yStr + " = " + result);
    }


    private static int getPositiveInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int number = Integer.parseInt(scanner.nextLine().trim());
                if (number >= 0) return number;
                System.out.println("Число не может быть отрицательным!");
            } catch (NumberFormatException e) {
                System.out.println("Введите целое неотрицательное число!");
            }
        }
    }


    private static int getInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Введите целое число!");
            }
        }
    }


    private static String getNonEmptyInput(Scanner scanner, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Поле не может быть пустым!");
            }
        } while (input.isEmpty());
        return input;
    }


    private static String getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }


    private static int getPointIndex(Scanner scanner, int maxIndex, String prompt) {
        while (true) {
            int index = getPositiveInt(scanner, prompt) - 1;
            if (index >= 0 && index < maxIndex) {
                return index;
            }
            System.out.println("Неверный номер точки! Должен быть от 1 до " + maxIndex);
        }
    }
}