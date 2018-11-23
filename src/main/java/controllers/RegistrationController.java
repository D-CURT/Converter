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

@WebServlet("/jsp/registration")
public class RegistrationController extends AbstractController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name"),
               login = req.getParameter("login"),
               password = req.getParameter("password");
        User user;
        UserStorage base;
        try {
            user = UserFactory.create(name, login, password);
            base = UserStorage.getInstance();
            if (!base.check(user)) {
                base.add(user);
                forward(Constants.INDEX_URL, req, resp);
            }
            throw new ConverterException();
        } catch (Exception e) {
            forwardError(Constants.REGISTRATION_URL, "Incorrect input data", req, resp);
        }
    }
}
