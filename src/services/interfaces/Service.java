package services.interfaces;

import dto.Result;

import java.io.IOException;
import java.util.List;

public interface Service {
    List<Result> action(Enum<?> service) throws IOException;
}
