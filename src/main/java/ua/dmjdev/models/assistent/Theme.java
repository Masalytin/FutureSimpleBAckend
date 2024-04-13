package ua.dmjdev.models.assistent;

public enum Theme {
    IN_HOSPITAL("Doctor"),
    IN_TAXI("Taxi driver"),
    IN_RESTAURANT("Waiter"),
    IN_INTERVIEW("Hiring manager"),
    IN_HOTEL("Manager"),
    FIRS_DATE("Girlfriend");
    private String role;

    Theme(String role) {
        this.role = role;
    }
}
