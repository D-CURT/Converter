package services.interfaces;

import domain.dto_models.Result;

import java.io.IOException;
import java.util.List;

public interface Service {
    List<Result> action(Enum<?> service) throws IOException;
}
