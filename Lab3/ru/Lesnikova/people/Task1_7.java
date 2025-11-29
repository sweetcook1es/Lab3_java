package Lab3.ru.Lesnikova.people;

public final class Task1_7 {
    private final String lastName;   // Фамилия
    private final String firstName;  // Имя
    private final String middleName; // Отчество

    public Task1_7(String firstName) {
        this("", firstName, "");
    }

    public Task1_7(String firstName, String lastName) {
        this(lastName, firstName, "");
    }

    public Task1_7(String lastName, String firstName, String middleName) {
        // хотя бы один параметр не пустой
        if ((lastName == null || lastName.trim().isEmpty()) &&
                (firstName == null || firstName.trim().isEmpty()) &&
                (middleName == null || middleName.trim().isEmpty())) {
            throw new IllegalArgumentException("Хотя бы один параметр имени должен быть не пустым");
        }

        this.lastName = lastName != null ? lastName.trim() : "";
        this.firstName = firstName != null ? firstName.trim() : "";
        this.middleName = middleName != null ? middleName.trim() : "";
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        // Добавляем компоненты в правильном порядке
        if (!lastName.isEmpty()) {
            result.append(lastName);
        }

        if (!firstName.isEmpty()) {
            if (result.length() > 0) result.append(" ");
            result.append(firstName);
        }

        if (!middleName.isEmpty()) {
            if (result.length() > 0) result.append(" ");
            result.append(middleName);
        }

        return result.toString();
    }
}