package exercise11_01;

public enum Day {
    MONDAY(true), TUESDAY(true), WEDNESDAY(true), THURSDAY(true), FRIDAY(true),SATURDAY(false), SUNDAY(false);

    private boolean weekDay;

    private Day(boolean weekDay) {
        this.weekDay = weekDay;
    }

    public boolean isWeekDay() {
        return this.weekDay;
    }

    public String toString() {
        return name() + (weekDay ? "(weekday)": "(weekend)");
    }
}
