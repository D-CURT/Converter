package controllers;

import utils.Constants;
import utils.exceptions.ConverterException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static utils.Constants.EMPTY;

public class LoginController extends AbstractController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        try {
            if (validate(login, password)) {

            }
            throw new Exception();
        } catch (Exception e) {
            forwardError(Constants.LOGIN_URL, "Incorrect login or password", req, resp);
        }
    }

    private boolean validate(String login, String password) {
        if (login == null || password == null) return false;
        return !login.equals(EMPTY) && !password.equals(EMPTY);
    }
}
