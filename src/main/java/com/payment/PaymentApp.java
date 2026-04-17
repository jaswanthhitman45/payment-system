package com.payment;

import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class PaymentApp {
    public static void main(String[] args) throws Exception {
        // Start a server on port 8080 (matching your containerPort)
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", (exchange -> {
            String response = "<h1>Payment Processing System is Online</h1><p>Status: Secure</p>";
            exchange.sendResponseHeaders(200, response.length());
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        }));
        
        System.out.println("--- Payment Server started on port 8080 ---");
        server.setExecutor(null);
        server.start();
    }

    public boolean validatePayment(double amount) {
        return amount > 0 && amount <= 10000;
    }
}
