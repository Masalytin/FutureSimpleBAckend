package ua.dmjdev.dto.voice.assistant;


public enum State {
    DO_YOU_NEED_VOICE_ASSISTANT("YES", "NO"),
    START_PAGE("LOGIN"),
    HOME("COURSE", "TRAINING", "CHAT_ASSISTANT", "MY_VOCABULARY", "PROFILE"),
    SELECT_CHAT_ASSISTANT_THEME("IN_HOSPITAL", "IN_TAXI", "IN_RESTAURANT","IN_INTERVIEW","IN_HOTEL","FIRS_DATE", "BACK_TO_HOME_PAGE");
    String[] answerOptions;

    State(String... answerOptions) {
        this.answerOptions = answerOptions;
    }

    public String[] getAnswerOptions() {
        return answerOptions;
    }
}
