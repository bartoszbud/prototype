package pl.homelab.prototype;

public class HelloMain {
    public static String defaultPort = "8080";

    public static void main(String[] args) {

        int port = Integer.parseInt(System.getProperty("port", defaultPort));
        MyServer httpServer = new MyServer();
        httpServer.Start(port);

    }
}
