package support.comparators;

import beans.Speed;
import beans.enums.SpeedUnits;

import java.util.Collections;
import java.util.Comparator;

public class SpeedComparator implements Comparator<Speed> {
    @Override
    public int compare(Speed o1, Speed o2) {
            int p1 = SpeedUnits.getUnit(o1.getUnit()).getPriority();
            int p2 = SpeedUnits.getUnit(o2.getUnit()).getPriority();
            return (p1 >= p2 && o1.getIntValue() > o2.getIntValue()) ? -3 :
                    (p1 >= p2 && o1.getIntValue() < o2.getIntValue()) ? -2 :
                            (p1 > p2 && o1.getIntValue().equals(o2.getIntValue())) ? -1 :
                                    (p1 < p2 && o1.getIntValue().equals(o2.getIntValue())) ? 1 :
                                            (p1 <= p2 && o1.getIntValue() > o2.getIntValue()) ? 2 :
                                                    (p1 <= p2 && o1.getIntValue() < o2.getIntValue()) ? 3 : 0;
    }

    @Override
    public Comparator<Speed> reversed() {
        return Collections.reverseOrder(this);
    }
}
