package sample;

public class nameSurname {
    private String mess;

    public nameSurname(String mess) {
        this.mess = mess;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    @Override
    public String toString() {
        return "nameSurname{" +
                "mess='" + mess + '\'' +
                '}';
    }
}
