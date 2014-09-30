package sample.hibernate3;

public class SimpleMessage {
    private int id;
    private String message;

    public void setId(int param) {
        id = param;
    }

    public int getId() {
        return id;
    }

    public void setMessage(String param) {
        message = param;
    }

    public String getMessage() {
        return message;
    }
}
