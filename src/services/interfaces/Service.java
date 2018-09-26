package services.interfaces;

import beans.Result;
import support.sections.Operations;
import support.sections.Services;

public interface Service {
    Result action(Services section, Operations service);
}
