package pl.homelab.prototype;

public class HelloMain {
    public static String defaultPort = "${server.port}";
    public static String sampleApiUrl = "${sample.api.url}";
    public static String sampleApiKey = "${sample.api.key}";

    public static void main(String[] args) {

        int port = Integer.parseInt(System.getProperty("port", defaultPort));
        MyServer httpServer = new MyServer();
        httpServer.Start(port);

        ApiConnection apiConnection = new ApiConnection(sampleApiUrl, sampleApiKey);
        apiConnection.sendGetRequest();
    }
}
