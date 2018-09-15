package beans;

public abstract class Essence {
    private String value;

    public Essence(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
