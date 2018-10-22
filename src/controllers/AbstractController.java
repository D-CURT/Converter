package controllers;

import utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AbstractController extends HttpServlet {
    void forward(String url, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    void forwardError(String url, String message, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute(Constants.ERROR, message);
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}
