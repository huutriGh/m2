package com.aptech.listeners;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class SimpleListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
       // ServletContextListener.super.contextInitialized(sce);
        sce.getServletContext().log("Application Started");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        sce.getServletContext().log("Application now ended");
    }
}
