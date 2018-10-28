package controllers;

import dao.UserStorage;
import domain.dao_models.User;
import domain.dao_models.factory.UserFactory;
import utils.Constants;
import utils.exceptions.ConverterException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jsp/login")
public class LoginController extends AbstractController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login"),
               password = req.getParameter("password");
        User user;
        try {
            user = UserFactory.create(login, password);
            if (UserStorage.getInstance().check(user)) {
                req.setAttribute("user", user);
                forward(Constants.INDEX_URL, req, resp);
            }
            throw new ConverterException();
        } catch (Exception e) {
            forwardError(Constants.LOGIN_URL, "Incorrect login or password", req, resp);
        }
    }
}
