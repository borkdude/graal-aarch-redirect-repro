import java.net.http.*;
import java.net.URI;
import java.net.URISyntaxException;

public class Redirect {

    public static void main(String [] args) throws URISyntaxException, java.io.IOException, InterruptedException {
        var req = HttpRequest.newBuilder(new URI("https://www.postman-echo.com"))
            .GET()
            .timeout(java.time.Duration.ofSeconds(5))
            .build();
        var client = HttpClient.newBuilder()
            .followRedirects(HttpClient.Redirect.ALWAYS)
            .build();
        var handler = HttpResponse.BodyHandlers.discarding();
        var response = client.send(req,handler);
        System.out.println(response.statusCode());
    }
}
