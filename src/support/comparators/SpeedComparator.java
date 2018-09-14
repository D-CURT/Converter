package support.comparators;
import beans.Speed;

import java.util.Collections;
import java.util.Comparator;

public class SpeedComparator implements Comparator<Speed> {
    @Override
    public int compare(Speed o1, Speed o2) {
        return Integer.compare(o1.getIntValue(), o2.getIntValue());
    }

    @Override
    public Comparator<Speed> reversed() {
        return Collections.reverseOrder(this);
    }
}
