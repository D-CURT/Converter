package controllers;

import dao.UserStorage;
import domain.dao_models.User;
import domain.dao_models.factory.UserFactory;
import utils.Constants;
import utils.exceptions.ConverterException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationController extends AbstractController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        try {
            User user = UserFactory.create(login, password);
            UserStorage base = UserStorage.getInstance();
            if (!base.check(user)) {
                user.setName(name);
                base.add(user);
            }
            throw new ConverterException();
        } catch (Exception e) {
            forwardError(Constants.REGISTRATION_URL, "Incorrect input data", req, resp);
        }
    }
}
