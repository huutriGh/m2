package com.aptech.listeners;

import com.aptech.blog.ApplicationSettings;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class AppInitialListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        var applicationSetting = new ApplicationSettings();
        sce.getServletContext().setAttribute("app", applicationSetting);
    }
}
