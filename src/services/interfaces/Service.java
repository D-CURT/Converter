package services.interfaces;

import beans.Result;
import support.sections.Operations;

import java.util.List;

public interface Service {
    List<Result> action(Operations service);
}
