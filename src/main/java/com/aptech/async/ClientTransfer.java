package com.aptech.async;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebListener;

import java.io.PrintWriter;
import java.util.concurrent.*;

@WebListener
public class ClientTransfer implements ServletContextListener {
    private static final int CLIENT_THREAD_COUNT = 10;
    private final Executor executor = Executors.newFixedThreadPool(CLIENT_THREAD_COUNT);
    private static final BlockingQueue<Client> clients = new LinkedBlockingQueue<>();

    static void addClient(Client client) {
        clients.add(client);
    }

    public void contextInitialized(ServletContextListener event) {
        int count = 0;
        while (count < CLIENT_THREAD_COUNT) {
            executor.execute(this::sendDataToClient);
            count++;
        }
    }

    private void sendDataToClient() {
        while (true) {
            Client client = getClient();
            AsyncContext asyncContext = client.getAsyncContext();
            var response = asyncContext.getResponse();
            var request = asyncContext.getRequest();
            response.setContentType("text/plain");
            String dataChunk = client.getDataChunk();
            sendDataChunk(dataChunk, client, asyncContext);
        }
    }

    private Client getClient() {
        Client client;
        try {
            client = clients.take();

        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted while waiting for remote clients");
        }
        return client;
    }

    private void sendDataChunk(String dataChunk, Client client, AsyncContext asyncContext) {
        ServletRequest request = asyncContext.getRequest();
        ServletResponse response = asyncContext.getResponse();
        try {

            PrintWriter out = response.getWriter();
            out.write(dataChunk);
            out.flush();
            response.flushBuffer();
            if (client.isWorkDone()) {
                asyncContext.complete();
            } else {
                clients.put(client);
            }
        } catch (Exception e) {
            request.getServletContext().log(String.format("Error: %s", e.getMessage()));
            asyncContext.complete();
        }
    }


}
