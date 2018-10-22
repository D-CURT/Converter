package domain;

public abstract class Essence {
    private String value;

    Essence(String value) {
        this.value = value;
    }

    String getValue() {
        return value;
    }
}
