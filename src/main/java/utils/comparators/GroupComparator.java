package utils.comparators;

import domain.dto_models.Result;
import java.util.Comparator;

public class GroupComparator implements Comparator<Result> {
    @Override
    public int compare(Result o1, Result o2) {
        return Integer.compare(o1.getGroupIndex(), o2.getGroupIndex());
    }
}