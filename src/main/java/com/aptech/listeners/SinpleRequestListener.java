package com.aptech.listeners;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class SinpleRequestListener implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        sre.getServletContext().log(String.format("Application called from %s", sre.getServletRequest().getRemoteHost()));
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        sre.getServletContext().log(String.format("Application call ended from %s",sre.getServletRequest().getRemoteHost()));
    }
}
