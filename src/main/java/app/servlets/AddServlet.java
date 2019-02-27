package app.servlets;

import app.entities.User;
import app.model.Model;
import app.model.SavedNameException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {
    private String existingName;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("pass");
        User user = new User(name, password);
        Model model = Model.getInstance();
        try {
            model.add(user);
        } catch (SavedNameException e) {
            existingName = e.getExistingElement();
        }
        req.setAttribute("name", name);
        req.setAttribute("existingName", existingName);
        doGet(req, resp);
    }
}
