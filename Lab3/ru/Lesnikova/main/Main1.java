//package Lab3.ru.Lesnikova.main;
//
//import java.util.Scanner;
//// Импорты всех необходимых классов
//import Lab3.ru.Lesnikova.weapons.Task1_5;
//import Lab3.ru.Lesnikova.people.Task1_7;
//import Lab3.ru.Lesnikova.data.Task2_3;
//import Lab3.ru.Lesnikova.weapons.Task3_4;
//import Lab3.ru.Lesnikova.weapons.Task4_1;
//import Lab3.ru.Lesnikova.weapons.Task4_1_Weapon;
//import Lab3.ru.Lesnikova.weapons.Task5_8;
//import Lab3.ru.Lesnikova.geometry.Task6_2;
//import Lab3.ru.Lesnikova.geometry.Task7_3;
//
///**
// * Главный класс программы с точкой входа
// * Демонстрирует работу всех реализованных классов
// * Соответствует требованиям задач 7.1 и 7.2
// */
//public class Main {
//
//    /**
//     * Точка входа в программу с обработкой аргументов командной строки
//     */
//    public static void main(String[] args) {
//        // Обработка аргументов командной строки для Task7.3
//        if (args.length >= 2) {
//            try {
//                System.out.println("=== ОБРАБОТКА АРГУМЕНТОВ КОМАНДНОЙ СТРОКИ ===");
//                System.out.println("Переданные аргументы: " + String.join(" ", args));
//
//                double result = Task7_3.power(args[0], args[1]);
//                System.out.println("Результат: " + args[0] + " в степени " + args[1] + " = " + result);
//
//                // Дополнительные операции для демонстрации
//                if (args.length >= 3) {
//                    try {
//                        System.out.println("Квадрат " + args[2] + " = " + Task7_3.square(args[2]));
//                    } catch (Exception e) {
//                        System.out.println("Ошибка при вычислении квадрата: " + e.getMessage());
//                    }
//                }
//                return; // Завершаем выполнение после обработки аргументов
//            } catch (Exception e) {
//                System.out.println("Ошибка обработки аргументов командной строки: " + e.getMessage());
//                System.out.println("Использование: java Main <число> <степень> [дополнительное_число]");
//                System.out.println("Запускаю интерактивный режим...\n");
//            }
//        }
//
//        // ИНТЕРАКТИВНЫЙ РЕЖИМ
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("=== ЛАБОРАТОРНАЯ РАБОТА 3 - ДЕМОНСТРАЦИЯ ВСЕХ ЗАДАНИЙ ===");
//
//        // Демонстрация всех заданий
//        demoTask1_5(scanner);
//        System.out.println("\n" + "=".repeat(50) + "\n");
//
//        demoTask1_7(scanner);
//        System.out.println("\n" + "=".repeat(50) + "\n");
//
//        demoTask2_3(scanner);
//        System.out.println("\n" + "=".repeat(50) + "\n");
//
//        demoTask3_4(scanner);
//        System.out.println("\n" + "=".repeat(50) + "\n");
//
//        demoTask4_1(scanner);
//        System.out.println("\n" + "=".repeat(50) + "\n");
//
//        demoTask5_8(scanner);
//        System.out.println("\n" + "=".repeat(50) + "\n");
//
//        demoTask6_2(scanner);
//        System.out.println("\n" + "=".repeat(50) + "\n");
//
//        demoTask7_3(scanner);
//
//        scanner.close();
//        System.out.println("\n=== ВСЕ ДЕМОНСТРАЦИИ ЗАВЕРШЕНЫ ===");
//    }
//
//    // ========== ДЕМОНСТРАЦИОННЫЕ МЕТОДЫ ==========
//
//    /**
//     * Демонстрация задания 1.5 - Пистолет с перезарядкой
//     */
//    public static void demoTask1_5(Scanner scanner) {
//        System.out.println("=== ЗАДАНИЕ 1.5 - ПИСТОЛЕТ С ПЕРЕЗАРЯДКОЙ ===");
//
//        System.out.println("Выберите способ создания пистолета:");
//        System.out.println("1 - Пистолет по умолчанию (вместимость 7)");
//        System.out.println("2 - Пистолет с указанием вместимости");
//
//        int choice = getPositiveInt(scanner, "Введите номер варианта (1 или 2): ");
//
//        Task1_5 pistol;
//        if (choice == 1) {
//            pistol = new Task1_5();
//            System.out.println("Создан пистолет по умолчанию: " + pistol);
//        } else {
//            int capacity = getPositiveInt(scanner, "Введите вместимость пистолета: ");
//            try {
//                pistol = new Task1_5(capacity);
//                System.out.println("Создан пистолет: " + pistol);
//            } catch (IllegalArgumentException e) {
//                System.out.println("Ошибка создания пистолета: " + e.getMessage());
//                pistol = new Task1_5(); // Используем по умолчанию
//            }
//        }
//
//        // Демонстрация сценария из задания
//        System.out.println("\n--- Демонстрационный сценарий из задания ---");
//        System.out.println("1. Заряжаем 3 патрона:");
//        pistol.reload(3);
//        System.out.println("После зарядки: " + pistol);
//
//        System.out.println("\n2. Стреляем 5 раз:");
//        for (int i = 0; i < 5; i++) {
//            pistol.shoot();
//        }
//
//        System.out.println("\n3. Заряжаем 8 патронов:");
//        int remaining = pistol.reload(8);
//        System.out.println("Осталось лишних патронов: " + remaining);
//        System.out.println("После зарядки: " + pistol);
//
//        System.out.println("\n4. Стреляем 2 раза:");
//        pistol.shoot();
//        pistol.shoot();
//
//        System.out.println("\n5. Разряжаем пистолет:");
//        int unloaded = pistol.unload();
//        System.out.println("Разряжено патронов: " + unloaded);
//
//        System.out.println("\n6. Контрольный выстрел:");
//        pistol.shoot();
//
//        System.out.println("\n--- Ожидаемый вывод: Бах! Бах! Бах! Клац! Клац! Бах! Бах! Клац! ---");
//    }
//
//    /**
//     * Демонстрация задания 1.7 - Неизменяемые имена
//     */
//    public static void demoTask1_7(Scanner scanner) {
//        System.out.println("=== ЗАДАНИЕ 1.7 - НЕИЗМЕНЯЕМЫЕ ИМЕНА ===");
//
//        int count = getPositiveInt(scanner, "Введите количество имен для создания: ");
//
//        for (int i = 0; i < count; i++) {
//            System.out.println("\n--- Создание имени " + (i + 1) + " ---");
//            String firstName = getNonEmptyInput(scanner, "Введите имя: ");
//            String lastName = getInput(scanner, "Введите фамилию (или Enter чтобы пропустить): ");
//            String middleName = getInput(scanner, "Введите отчество (или Enter чтобы пропустить): ");
//
//            try {
//                Task1_7 name;
//                if (!lastName.isEmpty() && !middleName.isEmpty()) {
//                    name = new Task1_7(lastName, firstName, middleName);
//                } else if (!lastName.isEmpty()) {
//                    name = new Task1_7(firstName, lastName);
//                } else {
//                    name = new Task1_7(firstName);
//                }
//                System.out.println("✓ Создано имя: " + name);
//                System.out.println("  Компоненты: Имя='" + name.getFirstName() +
//                        "', Фамилия='" + name.getLastName() +
//                        "', Отчество='" + name.getMiddleName() + "'");
//            } catch (IllegalArgumentException e) {
//                System.out.println("✗ Ошибка: " + e.getMessage());
//                i--; // Повторяем попытку для этого имени
//            }
//        }
//
//        // Демонстрация неизменяемости
//        System.out.println("\n--- Демонстрация неизменяемости ---");
//        try {
//            Task1_7 demoName = new Task1_7("Иван", "Петров", "Сергеевич");
//            System.out.println("Создано имя: " + demoName);
//            System.out.println("Объект неизменяемый - нет методов для изменения состояния");
//        } catch (IllegalArgumentException e) {
//            System.out.println("Ошибка: " + e.getMessage());
//        }
//    }
//
//    /**
//     * Демонстрация задания 2.3 - Телефонный справочник
//     */
//    public static void demoTask2_3(Scanner scanner) {
//        System.out.println("=== ЗАДАНИЕ 2.3 - ТЕЛЕФОННЫЙ СПРАВОЧНИК ===");
//
//        Task2_3 directory = new Task2_3();
//
//        // Добавим несколько тестовых контактов
//        System.out.println("Добавляем тестовые контакты...");
//        directory.addContact("+79161234567", "Иван Иванов");
//        directory.addContact("+79035556677", "Мария Петрова");
//        directory.addContact("+79219876543", "Алексей Сидоров");
//        System.out.println("Добавлено контактов: " + directory.getContactCount());
//
//        boolean continueUsing = true;
//        while (continueUsing) {
//            System.out.println("\n=== ТЕЛЕФОННЫЙ СПРАВОЧНИК ===");
//            System.out.println("1 - Добавить/обновить контакт");
//            System.out.println("2 - Удалить контакт");
//            System.out.println("3 - Найти телефон по имени");
//            System.out.println("4 - Проверить наличие имени");
//            System.out.println("5 - Проверить наличие телефона");
//            System.out.println("6 - Показать все контакты");
//            System.out.println("7 - Показать статистику");
//            System.out.println("8 - Поиск имен по началу");
//            System.out.println("9 - Экспорт данных");
//            System.out.println("0 - Выйти из справочника");
//
//            int choice = getPositiveInt(scanner, "Выберите действие: ");
//
//            switch (choice) {
//                case 1:
//                    System.out.println("\n--- ДОБАВЛЕНИЕ КОНТАКТА ---");
//                    String name = getNonEmptyInput(scanner, "Введите имя: ");
//                    String phone = getNonEmptyInput(scanner, "Введите телефон: ");
//                    String oldPhone = directory.addContact(phone, name);
//                    if (oldPhone != null) {
//                        System.out.println("✓ Контакт обновлен. Старый телефон: " + oldPhone);
//                    } else {
//                        System.out.println("✓ Контакт добавлен");
//                    }
//                    break;
//
//                case 2:
//                    System.out.println("\n--- УДАЛЕНИЕ КОНТАКТА ---");
//                    String deleteName = getNonEmptyInput(scanner, "Введите имя для удаления: ");
//                    boolean removed = directory.removeContact(deleteName);
//                    if (removed) {
//                        System.out.println("✓ Контакт удален");
//                    } else {
//                        System.out.println("✗ Контакт не найден");
//                    }
//                    break;
//
//                case 3:
//                    System.out.println("\n--- ПОИСК ТЕЛЕФОНА ---");
//                    String searchName = getNonEmptyInput(scanner, "Введите имя для поиска: ");
//                    String foundPhone = directory.getPhone(searchName);
//                    if (foundPhone != null) {
//                        System.out.println("✓ Телефон " + searchName + ": " + foundPhone);
//                    } else {
//                        System.out.println("✗ Контакт не найден");
//                    }
//                    break;
//
//                case 4:
//                    System.out.println("\n--- ПРОВЕРКА ИМЕНИ ---");
//                    String checkName = getNonEmptyInput(scanner, "Введите имя для проверки: ");
//                    boolean nameExists = directory.containsName(checkName);
//                    if (nameExists) {
//                        System.out.println("✓ Имя найдено в справочнике");
//                    } else {
//                        System.out.println("✗ Имя не найдено в справочнике");
//                    }
//                    break;
//
//                case 5:
//                    System.out.println("\n--- ПРОВЕРКА ТЕЛЕФОНА ---");
//                    String checkPhone = getNonEmptyInput(scanner, "Введите телефон для проверки: ");
//                    boolean phoneExists = directory.containsPhone(checkPhone);
//                    if (phoneExists) {
//                        System.out.println("✓ Телефон найден в справочнике");
//                    } else {
//                        System.out.println("✗ Телефон не найден в справочнике");
//                    }
//                    break;
//
//                case 6:
//                    System.out.println("\n--- ВСЕ КОНТАКТЫ ---");
//                    String contacts = directory.toString();
//                    if (contacts.isEmpty()) {
//                        System.out.println("Справочник пуст");
//                    } else {
//                        System.out.println(contacts);
//                    }
//                    break;
//
//                case 7:
//                    System.out.println("\n--- СТАТИСТИКА ---");
//                    System.out.println("Количество контактов: " + directory.getContactCount());
//                    System.out.println("Все имена: " + java.util.Arrays.toString(directory.getAllNames()));
//                    System.out.println("Все телефоны: " + java.util.Arrays.toString(directory.getAllPhones()));
//                    break;
//
//                case 8:
//                    System.out.println("\n--- ПОИСК ИМЕН ПО НАЧАЛУ ---");
//                    String prefix = getNonEmptyInput(scanner, "Введите начало имени: ");
//                    String[] matchingNames = directory.getNamesStartingWith(prefix);
//                    if (matchingNames.length > 0) {
//                        System.out.println("Найдены имена: " + java.util.Arrays.toString(matchingNames));
//                    } else {
//                        System.out.println("Имена не найдены");
//                    }
//                    break;
//
//                case 9:
//                    System.out.println("\n--- ЭКСПОРТ ДАННЫХ ---");
//                    String[][] allPairs = directory.getAllPairs();
//                    if (allPairs.length > 0) {
//                        System.out.println("Все пары (имя-телефон):");
//                        for (String[] pair : allPairs) {
//                            System.out.println("  " + pair[0] + " - " + pair[1]);
//                        }
//                    } else {
//                        System.out.println("Справочник пуст");
//                    }
//                    break;
//
//                case 0:
//                    continueUsing = false;
//                    System.out.println("Выход из телефонного справочника");
//                    break;
//
//                default:
//                    System.out.println("Неверный выбор! Попробуйте снова.");
//            }
//        }
//    }
//
//    /**
//     * Демонстрация задания 3.4 - Автомат (исправленная версия)
//     */
//    public static void demoTask3_4(Scanner scanner) {
//        System.out.println("=== ЗАДАНИЕ 3.4 - АВТОМАТ ===");
//
//        // Выбор способа инициализации автомата
//        System.out.println("Выберите способ создания автомата:");
//        System.out.println("1 - Без параметров (скорострельность 30, вместимость 30)");
//        System.out.println("2 - С указанием вместимости (скорострельность = половина обоймы)");
//        System.out.println("3 - С указанием вместимости и скорострельности");
//
//        int choice = getPositiveInt(scanner, "Введите номер варианта (1-3): ");
//
//        Task3_4 machineGun;
//
//        switch (choice) {
//            case 1:
//                machineGun = new Task3_4();
//                System.out.println("Создан автомат по умолчанию: " + machineGun);
//                break;
//
//            case 2:
//                int capacity1 = getPositiveInt(scanner, "Введите вместимость автомата: ");
//                try {
//                    machineGun = new Task3_4(capacity1);
//                    System.out.println("Создан автомат: " + machineGun);
//                } catch (IllegalArgumentException e) {
//                    System.out.println("Ошибка: " + e.getMessage());
//                    machineGun = new Task3_4(); // Используем по умолчанию при ошибке
//                }
//                break;
//
//            case 3:
//                int capacity2 = getPositiveInt(scanner, "Введите вместимость автомата: ");
//                int fireRate = getPositiveInt(scanner, "Введите скорострельность: ");
//                try {
//                    machineGun = new Task3_4(capacity2, fireRate);
//                    System.out.println("Создан автомат: " + machineGun);
//                } catch (IllegalArgumentException e) {
//                    System.out.println("Ошибка: " + e.getMessage());
//                    machineGun = new Task3_4(); // Используем по умолчанию при ошибке
//                }
//                break;
//
//            default:
//                System.out.println("Неверный выбор! Создан автомат по умолчанию.");
//                machineGun = new Task3_4();
//                break;
//        }
//
//        // Основной цикл взаимодействия с автоматом
//        boolean continueUsing = true;
//        while (continueUsing) {
//            System.out.println("\nВыберите действие:");
//            System.out.println("1 - Зарядить патроны");
//            System.out.println("2 - Одиночный выстрел (автоматическая очередь)");
//            System.out.println("3 - Стрельба N секунд");
//            System.out.println("4 - Разрядить автомат");
//            System.out.println("5 - Показать состояние");
//            System.out.println("0 - Выйти из демонстрации");
//
//            int action = getPositiveInt(scanner, "Введите номер действия: ");
//
//            switch (action) {
//                case 1:
//                    int bullets = getPositiveInt(scanner, "Сколько патронов зарядить? ");
//                    try {
//                        int remaining = machineGun.reload(bullets);
//                        System.out.println("Заряжено, осталось лишних: " + remaining);
//                        System.out.println("После зарядки: " + machineGun);
//                    } catch (IllegalArgumentException e) {
//                        System.out.println("Ошибка: " + e.getMessage());
//                    }
//                    break;
//
//                case 2:
//                    System.out.println("Одиночный выстрел (автоматическая очередь):");
//                    machineGun.shoot();
//                    System.out.println("После выстрела: " + machineGun);
//                    break;
//
//                case 3:
//                    int seconds = getPositiveInt(scanner, "Сколько секунд стрелять? ");
//                    machineGun.shootSeconds(seconds);
//                    System.out.println("После стрельбы: " + machineGun);
//                    break;
//
//                case 4:
//                    int unloaded = machineGun.unload();
//                    System.out.println("Разряжено патронов: " + unloaded);
//                    System.out.println("После разрядки: " + machineGun);
//                    break;
//
//                case 5:
//                    System.out.println("Текущее состояние: " + machineGun);
//                    System.out.println("Скорострельность: " + machineGun.getFireRate() + " выстр/сек");
//                    System.out.println("Максимальная вместимость: " + machineGun.getMaxCapacity());
//                    break;
//
//                case 0:
//                    continueUsing = false;
//                    System.out.println("Завершение демонстрации автомата");
//                    break;
//
//                default:
//                    System.out.println("Неверный выбор действия!");
//            }
//        }
//    }
//
//    /**
//     * Демонстрация задания 4.1 - Наследование от Weapon
//     */
//    public static void demoTask4_1(Scanner scanner) {
//        System.out.println("=== ЗАДАНИЕ 4.1 - КЛАСС WEAPON И НАСЛЕДОВАНИЕ ===");
//
//        // Выбор способа создания пистолета
//        System.out.println("Выберите способ создания пистолета:");
//        System.out.println("1 - Пистолет по умолчанию (вместимость 7)");
//        System.out.println("2 - Пистолет с указанием вместимости");
//
//        int choice = getPositiveInt(scanner, "Введите номер варианта (1 или 2): ");
//
//        Task4_1 pistol;
//        if (choice == 1) {
//            pistol = new Task4_1();
//            System.out.println("Создан пистолет по умолчанию: " + pistol);
//        } else {
//            int capacity = getPositiveInt(scanner, "Введите вместимость пистолета: ");
//            try {
//                pistol = new Task4_1(capacity);
//                System.out.println("Создан пистолет: " + pistol);
//            } catch (IllegalArgumentException e) {
//                System.out.println("Ошибка: " + e.getMessage());
//                pistol = new Task4_1(); // Используем по умолчанию
//            }
//        }
//
//        // Основной цикл взаимодействия с пистолетом
//        boolean continueUsing = true;
//        while (continueUsing) {
//            System.out.println("\nВыберите действие:");
//            System.out.println("1 - Зарядить патроны");
//            System.out.println("2 - Выстрелить");
//            System.out.println("3 - Выстрелить несколько раз");
//            System.out.println("4 - Разрядить пистолет");
//            System.out.println("5 - Показать состояние");
//            System.out.println("6 - Демонстрация наследования");
//            System.out.println("0 - Выйти из демонстрации");
//
//            int action = getPositiveInt(scanner, "Введите номер действия: ");
//
//            switch (action) {
//                case 1:
//                    int bullets = getPositiveInt(scanner, "Сколько патронов зарядить? ");
//                    try {
//                        int remaining = pistol.reload(bullets);
//                        System.out.println("Заряжено, осталось лишних: " + remaining);
//                        System.out.println("После зарядки: " + pistol);
//                    } catch (IllegalArgumentException e) {
//                        System.out.println("Ошибка: " + e.getMessage());
//                    }
//                    break;
//
//                case 2:
//                    System.out.println("Выстрел:");
//                    pistol.shoot();
//                    System.out.println("После выстрела: " + pistol);
//                    break;
//
//                case 3:
//                    int shots = getPositiveInt(scanner, "Сколько раз выстрелить? ");
//                    System.out.println("Стреляем " + shots + " раз:");
//                    for (int i = 0; i < shots; i++) {
//                        pistol.shoot();
//                    }
//                    System.out.println("После стрельбы: " + pistol);
//                    break;
//
//                case 4:
//                    int unloaded = pistol.unload();
//                    System.out.println("Разряжено патронов: " + unloaded);
//                    System.out.println("После разрядки: " + pistol);
//                    break;
//
//                case 5:
//                    System.out.println("Текущее состояние: " + pistol);
//                    System.out.println("Количество патронов: " + pistol.getAmmo());
//                    System.out.println("Максимальная вместимость: " + pistol.getMaxCapacity());
//                    System.out.println("Заряжен: " + pistol.isLoaded());
//                    break;
//
//                case 6:
//                    System.out.println("\n--- Демонстрация наследования ---");
//                    System.out.println("Пистолет является наследником Weapon: " + (pistol instanceof Task4_1_Weapon));
//                    System.out.println("Метод getAmmo() унаследован от Weapon");
//                    System.out.println("Метод shoot() переопределен в пистолете");
//                    System.out.println("Метод useAmmo() унаследован от Weapon");
//                    System.out.println("Метод load() унаследован от Weapon");
//                    break;
//
//                case 0:
//                    continueUsing = false;
//                    System.out.println("Завершение демонстрации");
//                    break;
//
//                default:
//                    System.out.println("Неверный выбор действия!");
//            }
//        }
//    }
//
//    /**
//     * Демонстрация задания 5.8 - Стрелки с оружием
//     */
//    public static void demoTask5_8(Scanner scanner) {
//        System.out.println("=== ЗАДАНИЕ 5.8 - ЛУЧШИЙ СТРЕЛОК ===");
//
//        // Создаем стрелков
//        Task5_8 shooter1 = new Task5_8("Безоружный");
//
//        Task4_1 pistol = new Task4_1();
//        pistol.reload(3);
//        Task5_8 shooter2 = new Task5_8("Пистолетчик", pistol);
//
//        Task3_4 machineGun = new Task3_4(10, 2);
//        machineGun.reload(5);
//        Task5_8 shooter3 = new Task5_8("Автоматчик", machineGun);
//
//        System.out.println("Созданы стрелки:");
//        System.out.println("1. " + shooter1);
//        System.out.println("2. " + shooter2);
//        System.out.println("3. " + shooter3);
//
//        int shots = getPositiveInt(scanner, "Сколько выстрелов сделать каждому стрелку? ");
//
//        System.out.println("\n=== СТРЕЛЬБА СТРЕЛКОВ ===");
//        for (int i = 0; i < shots; i++) {
//            System.out.println("\n--- Выстрел " + (i + 1) + " ---");
//            System.out.print("Стрелок 1: ");
//            shooter1.shoot();
//            System.out.print("Стрелок 2: ");
//            shooter2.shoot();
//            System.out.print("Стрелок 3: ");
//            shooter3.shoot();
//        }
//
//        System.out.println("\n=== ФИНАЛЬНОЕ СОСТОЯНИЕ ===");
//        System.out.println(shooter1);
//        System.out.println(shooter2);
//        System.out.println(shooter3);
//
//        // Демонстрация смены оружия
//        System.out.println("\n--- Демонстрация смены оружия ---");
//        Task4_1 newPistol = new Task4_1();
//        newPistol.reload(2);
//        shooter1.setWeapon(newPistol);
//        System.out.println("Стрелок 1 теперь имеет: " + shooter1.getWeapon());
//        System.out.print("Стрелок 1 стреляет: ");
//        shooter1.shoot();
//    }
//
//    /**
//     * Демонстрация задания 6.2 - Сравнение точек
//     */
//    public static void demoTask6_2(Scanner scanner) {
//        System.out.println("=== ЗАДАНИЕ 6.2 - СРАВНЕНИЕ ТОЧЕК ===");
//
//        // Выбор количества точек
//        int pointCount = getPositiveInt(scanner, "Сколько точек вы хотите создать? ");
//
//        // Создаем массив точек
//        Task6_2[] points = new Task6_2[pointCount];
//
//        // Ввод координат для каждой точки
//        for (int i = 0; i < pointCount; i++) {
//            System.out.println("\n--- Точка " + (i + 1) + " ---");
//            int x = getInt(scanner, "Введите координату X: ");
//            int y = getInt(scanner, "Введите координату Y: ");
//            points[i] = new Task6_2(x, y);
//        }
//
//        // Вывод всех точек
//        System.out.println("\n--- ВВЕДЕННЫЕ ТОЧКИ ---");
//        for (int i = 0; i < pointCount; i++) {
//            System.out.println("Точка " + (i + 1) + ": " + points[i] + " (hashCode: " + points[i].hashCode() + ")");
//        }
//
//        // Меню выбора режима сравнения
//        boolean continueComparing = true;
//        while (continueComparing) {
//            System.out.println("\n=== РЕЖИМЫ СРАВНЕНИЯ ===");
//            System.out.println("1 - Сравнить все точки попарно");
//            System.out.println("2 - Сравнить две конкретные точки");
//            System.out.println("3 - Найти одинаковые точки");
//            System.out.println("4 - Показать все точки");
//            System.out.println("0 - Выйти из сравнения");
//
//            int choice = getPositiveInt(scanner, "Выберите режим: ");
//
//            switch (choice) {
//                case 1:
//                    System.out.println("\n--- ПОПАРНОЕ СРАВНЕНИЕ ВСЕХ ТОЧЕК ---");
//                    for (int i = 0; i < points.length; i++) {
//                        for (int j = i + 1; j < points.length; j++) {
//                            boolean areEqual = points[i].equals(points[j]);
//                            System.out.println("Точка " + (i + 1) + points[i] + " == Точка " + (j + 1) + points[j] + " : " + areEqual);
//                        }
//                    }
//                    break;
//
//                case 2:
//                    System.out.println("\n--- СРАВНЕНИЕ ДВУХ КОНКРЕТНЫХ ТОЧЕК ---");
//                    if (points.length < 2) {
//                        System.out.println("Нужно как минимум 2 точки для сравнения!");
//                        break;
//                    }
//                    int point1 = getPointIndex(scanner, points.length, "Введите номер первой точки (1-" + points.length + "): ");
//                    int point2 = getPointIndex(scanner, points.length, "Введите номер второй точки (1-" + points.length + "): ");
//
//                    boolean areEqual = points[point1].equals(points[point2]);
//                    System.out.println("Точка " + (point1 + 1) + points[point1] + " == Точка " + (point2 + 1) + points[point2] + " : " + areEqual);
//
//                    // Демонстрация hashCode
//                    System.out.println("HashCode точки 1: " + points[point1].hashCode());
//                    System.out.println("HashCode точки 2: " + points[point2].hashCode());
//                    break;
//
//                case 3:
//                    System.out.println("\n--- ПОИСК ОДИНАКОВЫХ ТОЧЕК ---");
//                    boolean foundDuplicates = false;
//                    for (int i = 0; i < points.length; i++) {
//                        for (int j = i + 1; j < points.length; j++) {
//                            if (points[i].equals(points[j])) {
//                                System.out.println("✓ Точка " + (i + 1) + points[i] + " и Точка " + (j + 1) + points[j] + " - одинаковые");
//                                foundDuplicates = true;
//                            }
//                        }
//                    }
//                    if (!foundDuplicates) {
//                        System.out.println("Одинаковых точек не найдено");
//                    }
//                    break;
//
//                case 4:
//                    System.out.println("\n--- ВСЕ ТОЧКИ ---");
//                    for (int i = 0; i < points.length; i++) {
//                        System.out.println("Точка " + (i + 1) + ": " + points[i] + " (hashCode: " + points[i].hashCode() + ")");
//                    }
//                    break;
//
//                case 0:
//                    continueComparing = false;
//                    System.out.println("Завершение сравнения точек");
//                    break;
//
//                default:
//                    System.out.println("Неверный выбор!");
//            }
//        }
//    }
//
//    /**
//     * Демонстрация задания 7.3 - Возведение в степень
//     */
//    public static void demoTask7_3(Scanner scanner) {
//        System.out.println("=== ЗАДАНИЕ 7.3 - ВОЗВЕДЕНИЕ В СТЕПЕНЬ ===");
//
//        System.out.println("Этот метод использует статические импорты:");
//        System.out.println("import static java.lang.Integer.parseInt;");
//        System.out.println("import static java.lang.Math.pow;");
//
//        String xStr = getNonEmptyInput(scanner, "Введите число X: ");
//        String yStr = getNonEmptyInput(scanner, "Введите степень Y: ");
//
//        try {
//            double result = Task7_3.power(xStr, yStr);
//            System.out.println(xStr + " в степени " + yStr + " = " + result);
//
//            // Дополнительные демонстрации
//            System.out.println("\n--- Дополнительные операции ---");
//            System.out.println("Квадрат " + xStr + " = " + Task7_3.square(xStr));
//            System.out.println("Квадратный корень из " + xStr + " = " + Task7_3.squareRoot(xStr));
//
//        } catch (NumberFormatException e) {
//            System.out.println("Ошибка: неверный формат чисел - введите целые числа");
//        } catch (IllegalArgumentException e) {
//            System.out.println("Ошибка: " + e.getMessage());
//        }
//    }
//
//    // ========== ВСПОМОГАТЕЛЬНЫЕ МЕТОДЫ ДЛЯ ВВОДА ==========
//
//    /**
//     * Получение положительного целого числа от пользователя
//     */
//    private static int getPositiveInt(Scanner scanner, String prompt) {
//        while (true) {
//            System.out.print(prompt);
//            try {
//                int number = Integer.parseInt(scanner.nextLine().trim());
//                if (number >= 0) return number;
//                System.out.println("Число не может быть отрицательным!");
//            } catch (NumberFormatException e) {
//                System.out.println("Введите целое неотрицательное число!");
//            }
//        }
//    }
//
//    /**
//     * Получение любого целого числа от пользователя
//     */
//    private static int getInt(Scanner scanner, String prompt) {
//        while (true) {
//            System.out.print(prompt);
//            try {
//                return Integer.parseInt(scanner.nextLine().trim());
//            } catch (NumberFormatException e) {
//                System.out.println("Введите целое число!");
//            }
//        }
//    }
//
//    /**
//     * Получение непустой строки от пользователя
//     */
//    private static String getNonEmptyInput(Scanner scanner, String prompt) {
//        String input;
//        do {
//            System.out.print(prompt);
//            input = scanner.nextLine().trim();
//            if (input.isEmpty()) {
//                System.out.println("Поле не может быть пустым!");
//            }
//        } while (input.isEmpty());
//        return input;
//    }
//
//    /**
//     * Получение любой строки от пользователя (может быть пустой)
//     */
//    private static String getInput(Scanner scanner, String prompt) {
//        System.out.print(prompt);
//        return scanner.nextLine().trim();
//    }
//
//    /**
//     * Получение корректного индекса точки
//     */
//    private static int getPointIndex(Scanner scanner, int maxIndex, String prompt) {
//        while (true) {
//            int index = getPositiveInt(scanner, prompt) - 1;
//            if (index >= 0 && index < maxIndex) {
//                return index;
//            }
//            System.out.println("Неверный номер точки! Должен быть от 1 до " + maxIndex);
//        }
//    }
//}