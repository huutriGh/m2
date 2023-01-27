package com.aptech.async;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.AsyncEvent;
import jakarta.servlet.AsyncListener;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/dispatch",asyncSupported = true)
public class DispatchAsyncServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final AsyncContext ctx = req.startAsync();

        ctx.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent asyncEvent) throws IOException {
                log(String.format("DispatchAsyncServlet onComplete called, thread id: %s",Thread.currentThread().getId()));
            }

            @Override
            public void onTimeout(AsyncEvent asyncEvent) throws IOException {
                log(String.format("DispatchAsyncServlet onTimeout, thread id: %s",Thread.currentThread().getId()));
            }

            @Override
            public void onError(AsyncEvent asyncEvent) throws IOException {
                log(String.format("DispatchAsyncServlet onError, thread id: %s",Thread.currentThread().getId()));
            }

            @Override
            public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
                log(String.format("DispatchAsyncServlet onError, thread id: %s",Thread.currentThread().getId()));
            }
        });
        ctx.dispatch(getServletContext(),"/simple");
    }
}
