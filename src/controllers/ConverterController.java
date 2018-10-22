package controllers;

import services.factory.ServiceFactory;
import services.interfaces.Service;
import utils.Constants;
import utils.sections.Services;
import utils.unit_indentifires.SpeedUnits;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.util.Collections.singletonList;
import static utils.Constants.SPACE;

@WebServlet("/converter")
public class ConverterController extends AbstractController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value = req.getParameter("inputValue");
        String unit = req.getParameter("from");
        String toUnit = req.getParameter("to");
        Service service = ServiceFactory.getService(singletonList(value + SPACE + unit), Services.CONVERSION);
        req.setAttribute("results", service.action(SpeedUnits.getUnit(toUnit)));
        forward(Constants.INDEX_URL, req, resp);
    }
}
