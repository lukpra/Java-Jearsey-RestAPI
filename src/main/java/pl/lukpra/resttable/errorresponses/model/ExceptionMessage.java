package pl.lukpra.resttable.errorresponses.model;

public class ExceptionMessage {
    private String message;
    private String userMessage;
    private String info;

    public ExceptionMessage(String message, String userMessage, String info) {
        this.message = message;
        this.userMessage = userMessage;
        this.info = info;
    }

    public String getMessage() {
        return message;
    }

    public String getInfo() {
        return info;
    }
}
