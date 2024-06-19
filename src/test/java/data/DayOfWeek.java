package data;

public enum DayOfWeek {
    SUNDAY("Понедельник"),
    MONDAY("Вторник"),
    TUESDAY("Среда"),
    WEDNESDAY("Четверг"),
    THURSDAY("Пятница"),
    FRIDAY("Суббота"),
    SATURDAY ("Воскресенье");

    public final String description;

    DayOfWeek(String description){
        this.description = description;
    }
}
