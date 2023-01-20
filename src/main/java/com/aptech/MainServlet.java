package com.aptech;

import java.io.IOException;

import com.aptech.blog.ApplicationSettings;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/home"}, name = "Main")
public class MainServlet extends HttpServlet {

    String product = "My Blog";

    @Override
    public void init() throws ServletException {
        product = getServletContext().getInitParameter("productName");
        var applicationSetting = new ApplicationSettings();
        getServletContext().setAttribute("app", applicationSetting);

        if (product == null || product.isEmpty()) {
            throw new ServletException("Unable to initialise the application");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setUpData(req, ApplicationSettings.topic, ApplicationSettings.all);
        var dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");
        dispatcher.forward(req, resp);
    }

    private void setUpData(HttpServletRequest req, String type, String detail) {
        ApplicationSettings applicationSettings = (ApplicationSettings) getServletContext().getAttribute("app");
        var data = applicationSettings.setUpData(type, detail);
        req.setAttribute("items", data);

    }


}
