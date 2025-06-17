package pl.homelab.prototype;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;


public class MyServer {

    private HttpServer server;

    public void Start(int port) {
        try {
            server = HttpServer.create(new InetSocketAddress(port), 0);
            System.out.println("Server is listening on port " + port);
            server.createContext("/hello", new RootHandler());
            server.setExecutor(null);
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Stop() {
        server.stop(0);
        System.out.println("Server stopped");
    }

    public static class RootHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange he) throws IOException {

            String response = "<h1>Welcome</h1>";
            he.sendResponseHeaders(200, response.length());
            OutputStream os = he.getResponseBody();
            os.write(response.getBytes());
            os.close();

        }

    }
}
