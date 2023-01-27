package com.aptech.async;

import jakarta.servlet.AsyncEvent;
import jakarta.servlet.AsyncListener;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/simple", asyncSupported = true)
public class FirstAsyncServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log(String.format("FirstAsyncServlet in 'doGet', thread id: %s",Thread.currentThread().getId()));
        final  var ctx = req.startAsync();
        ctx.setTimeout(3000);
        ctx.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent asyncEvent) throws IOException {
                log(String.format("FirstAsyncServlet onComplete called, thread id: %s",Thread.currentThread().getId()));
            }

            @Override
            public void onTimeout(AsyncEvent asyncEvent) throws IOException {
                log(String.format("FirstAsyncServlet onTimeout, thread id: %s",Thread.currentThread().getId()));
            }

            @Override
            public void onError(AsyncEvent asyncEvent) throws IOException {
                log(String.format("FirstAsyncServlet onError, thread id: %s",Thread.currentThread().getId()));
            }

            @Override
            public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
                log(String.format("FirstAsyncServlet onError, thread id: %s",Thread.currentThread().getId()));
            }
        });
        ctx.start(()->{


            try {
                log(String.format("FirstAsyncServlet in 'Start', thread id: %s",Thread.currentThread().getId()));

                ctx.getResponse().getWriter().write(String.format("<h1>FirstAsyncServlet in 'Start', thread id: %s</h1>",Thread.currentThread().getId()));
            } catch (IOException  e) {
                log(String.format("FirstAsyncServlet Problem processing task, thread id: %s",Thread.currentThread().getId()),e);
            }
            ctx.complete();
        });

    }
}
