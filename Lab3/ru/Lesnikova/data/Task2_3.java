package Lab3.ru.Lesnikova.data;

import java.util.*;

public class Task2_3 {
    private Map<String, String> contacts; // имя, телефон

    public Task2_3() {
        this.contacts = new HashMap<>();
    }

    public String addContact(String phone, String name) {
        if (phone == null || name == null) {
            throw new IllegalArgumentException("Телефон и имя не могут быть null");
        }

        String oldPhone = contacts.get(name); // получения значения по ключу
        contacts.put(name, phone.trim()); // добавление
        return oldPhone;
    }

    public boolean removeContact(String name) {
        if (name == null) return false;
        return contacts.remove(name) != null; // удаление по ключу
    }

    public String getPhone(String name) {
        return contacts.get(name);
    }

    public boolean containsPhone(String phone) {
        return contacts.containsValue(phone); // проверка наличия значения
    }

    public boolean containsName(String name) {
        return contacts.containsKey(name); //проверка наличия ключа
    }

    public int getContactCount() {
        return contacts.size();
    }

    public String[][] getAllPairs() {
        String[][] pairs = new String[contacts.size()][2];
        int i = 0;
        for (Map.Entry<String, String> entry : contacts.entrySet()) { // возвращает все пары
            pairs[i][0] = entry.getKey();
            pairs[i][1] = entry.getValue();
            i++;
        }
        return pairs;
    }

    public String[] getAllPhones() {
        return contacts.values().toArray(new String[0]); // возвращает значения и преобразует в массив
    }

    public String[] getAllNames() {
        return contacts.keySet().toArray(new String[0]); // возвращает множество ключей, преобразует в массив
    }

    public String[] getNamesStartingWith(String prefix) {
        if (prefix == null) return new String[0];

        List<String> matchingNames = new ArrayList<>();
        for (String name : contacts.keySet()) {
            if (name.startsWith(prefix)) {
                matchingNames.add(name);
            }
        }
        return matchingNames.toArray(new String[0]);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            sb.append(entry.getValue()).append(" - ").append(entry.getKey()).append("\n");
        }
        return sb.toString().trim();
    }
}