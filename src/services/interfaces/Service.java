package services.interfaces;

import beans.Result;

import java.io.IOException;
import java.util.List;

public interface Service {
    List<Result> action(Enum<?> service) throws IOException;
}
