import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TrueCallerClient {

    private final static String USER_AGENT = "Mozilla/5.0 (X11; Linux i686) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/35.0.1916.114 Safari/537.36";

    private static String sendGETRequest(String phoneNumber) throws Exception {

        /* Change the shorthand of your country. Check True Caller Website for that.
           This is specifically for India "/in" */

        String baseURL = "http://www.truecaller.com/in/";
        String finalURL = baseURL.concat(phoneNumber);

        URL objectForURL = new URL(finalURL);
        HttpURLConnection objectForHttp = (HttpURLConnection) objectForURL.openConnection();

        objectForHttp.setRequestMethod("GET");
        objectForHttp.setRequestProperty("user-agent",USER_AGENT);
        objectForHttp.setRequestProperty("Cookie", "YOUR_FACEBOOK_COOKIE");

        BufferedReader bufferObject = new BufferedReader(new InputStreamReader(objectForHttp.getInputStream()));

        String inputLine;
        StringBuffer responseMessage = new StringBuffer();

        while((inputLine = bufferObject.readLine())!=null)
            responseMessage.append(inputLine);

        bufferObject.close();

        return responseMessage.toString();
    }

    private static String parseResponse(String textToParse) {

        Document htmlResponse = Jsoup.parse(textToParse);

        org.jsoup.select.Elements containerTag = htmlResponse.select("h1");

        return containerTag.text();
    }

    public static void main(String args[]) throws Exception {

        // Write your phone number in the argument of sendGETRequest.
        String htmlResponse = sendGETRequest("");

        // Capturing the name of the caller
        String fetchCaller = parseResponse(htmlResponse);

        System.out.println(fetchCaller);
    }
}