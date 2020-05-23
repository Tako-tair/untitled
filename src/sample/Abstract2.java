package sample;

public class Abstract2  extends Abstract {
    private String data;
    private String message;

    public Abstract2(String data, String message) {
        this.data = data;
        this.message = message;
    }

    @Override
    String getName() {
        return data;
    }

    @Override
    String getSurname() {
        return message;
    }
}
