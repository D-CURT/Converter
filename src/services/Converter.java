package services;

import beans.Speed;
import beans.Time;

import java.util.List;

public class Converter {
    private List<Speed> list;
    private Time time;

    public Converter(List<Speed> list, Time time) {
        this.list = list;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Converter{" +
                "list=" + list +
                ", time=" + time +
                '}';
    }
}
