package com.aptech.async;

import jakarta.servlet.AsyncEvent;
import jakarta.servlet.AsyncListener;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/downloadAsync", asyncSupported = true)
public class TransferDataAsyncServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var ctx = req.startAsync();
        ctx.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent asyncEvent) throws IOException {
                log(String.format("TransferDataAsyncServlet onComplete, thread id: %s",Thread.currentThread().getId()));
            }

            @Override
            public void onTimeout(AsyncEvent asyncEvent) throws IOException {
                log(String.format("TransferDataAsyncServlet onTimeout, thread id: %s",Thread.currentThread().getId()));
            }

            @Override
            public void onError(AsyncEvent asyncEvent) throws IOException {
                log(String.format("TransferDataAsyncServlet onError, thread id: %s",Thread.currentThread().getId()));
            }

            @Override
            public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
                log(String.format("TransferDataAsyncServlet onStartAsync, thread id: %s",Thread.currentThread().getId()));
            }
        });
        ctx.setTimeout(15 * 60 * 1000);
        ClientTransfer.addClient(new Client(ctx));

    }
}
