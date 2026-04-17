package com.payment; // MUST MATCH THE POM.XML

import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class PaymentApp {
    public static void main(String[] args) throws Exception {
        // Use 0.0.0.0 to allow external connections from the K8s Service
        HttpServer server = HttpServer.create(new InetSocketAddress("0.0.0.0", 8080), 0);
        server.createContext("/", (exchange -> {
            String response = "<h1>Payment Processing System is Online</h1>";
            exchange.sendResponseHeaders(200, response.length());
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        }));
        
        System.out.println("--- Payment Server started on port 8080 ---");
        server.setExecutor(null);
        server.start();
    }
}
