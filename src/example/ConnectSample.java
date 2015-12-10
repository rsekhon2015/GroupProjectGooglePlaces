package example;
/**
 * Created by Ranjit on 12/9/2015.

// The Java class will be hosted at the URI path "/helloworld"
@Path("/helloworld")
public class HelloWorld {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public String getClichedMessage() {
        // Return some cliched textual content
        return "Hello World";
    }

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServerFactory.create("http://localhost:9998/");
        server.start();

        System.out.println("Server running");
        System.out.println("Visit: http://localhost:9998/helloworld");
        System.out.println("Hit return to stop...");
        System.in.read();
        System.out.println("Stopping server");
        server.stop(0);
        System.out.println("Server stopped");
    }
}
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author paulawaite
 * @version 1.0 12/8/15.
 */

public class ConnectSample {

    public static void main(String[] args) {
        String response = "";
//https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=500&types=food&name=cruise&key=AIzaSyCoMDYtoiZegI871v33nMp0OklyYBAGFS4
        try {
            //  URL url = new URL("http://tomcat-mademailservice.rhcloud.com/NewEmailWebservice_war/rest/sendEmail/test");
            URL url = new URL("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=500&types=food&name=cruise&key=AIzaSyCoMDYtoiZegI871v33nMp0OklyYBAGFS4");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                response += line;
            }
            reader.close();
            System.out.println("The response was: " + response);

        } catch (MalformedURLException e) {
            System.out.println("malformed url");
        } catch (IOException e) {
            System.out.println("io exception");
            e.printStackTrace();
        }
    }
}
