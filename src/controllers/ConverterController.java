package controllers;


import factories.ServiceFactory;
import services.Converter;
import support.DataReader;
import support.jgh;
import support.sections.Services;
import support.sections.SpeedConversion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/converter")
public class ConverterController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("hid", new Converter().action(SpeedConversion.TO_MS));
        //System.out.println(list);
        req.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
