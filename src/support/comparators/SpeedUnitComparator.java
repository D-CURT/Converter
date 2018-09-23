package support.comparators;

import beans.Speed;

import java.util.Comparator;

public class SpeedUnitComparator implements Comparator<Speed> {
    @Override
    public int compare(Speed o1, Speed o2) {
        return Integer.compare(o1.getUnit().ordinal(), o2.getUnit().ordinal());
    }
}