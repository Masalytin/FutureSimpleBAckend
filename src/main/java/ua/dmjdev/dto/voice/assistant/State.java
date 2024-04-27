package ua.dmjdev.dto.voice.assistant;


public enum State {
    DO_YOU_NEED_VOICE_ASSISTANT("You ask the user if he needs an his assistant to control the application", "YES", "NO"),
    LOGIN_PAGE("The user is on the authorization page", "LOGIN"),
    COURSE("The user chooses which section to go to. The main page is COURSE", "COURSE", "TRAINING", "CHAT_ASSISTANT", "MY_DICTIONARY", "PROFILE"),
    SELECT_CHAT_ASSISTANT_THEME("The user selects a  topic for communication with the chat assistant. " +
            "You can also redirect the user to one of the following endpoints SETTINGS, COURSE, TRAINING, CHAT_ASSISTANT, MY_DICTIONARY, PROFILE. " +
            "The main page is COURSE.", "IN_HOSPITAL", "IN_TAXI", "IN_RESTAURANT",
            "IN_INTERVIEW", "IN_HOTEL", "FIRS_DATE"),
    SETTINGS(" The user is in the settings menu. " +
            "The user selects a  topic for communication with the chat assistant. " +
            "You can also redirect the user to one of the following endpoints SETTINGS, COURSE, TRAINING, CHAT_ASSISTANT, MY_DICTIONARY, PROFILE. " +
            "The main page is COURSE.", "DISABLE_VOICE_ASSISTANT");

    String[] answerOptions;
    private String description;

    State(String description, String... answerOptions) {
        this.description = description;
        this.answerOptions = answerOptions;
    }

    public String[] getAnswerOptions() {
        return answerOptions;
    }

    public String getDescription() {
        return description;
    }
}
