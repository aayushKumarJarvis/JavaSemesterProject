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
        objectForHttp.setRequestProperty("Cookie", "fbm_126694440681943=base_domain=.truecaller.com; PHPSESSID=2lbu8i6i73r5q9m4ud7eoikud1; __gads=ID=68f128aa84d8a063:T=1409568878:S=ALNI_MYFxzZnrdLrgqKwPuCm7QlwGM8sUg; XLBS=XLBS|VARUF|VARQG; __utma=99565659.708189400.1409568750.1409668083.1409668083.1; __utmc=99565659; __utmz=99565659.1409668083.1.1.utmcsr=apps.facebook.com|utmccn=(referral)|utmcmd=referral|utmcct=/truecaller/; user=eyJpdiI6InBoWmUwQjQ1RklIT2lVS2F0QzZ1VVJxTHBIb1wvQU9VanEzc0UxdnNkNkxBPSIsInZhbHVlIjoiUzFPUmhWZzA1SmxpRkJBeGZwczNlbHgzelNHTXJhZG1uN3l6N0dkdG1YejJlNWZ1VG5oWTNnNmNrTmFQNVdGdkRoOVBibUhHaEh4cHJlSFJ4dDVIYTdcL3NGZE00OWh0a2pLTzhjc2s5bW5qVU1aRldhNWI5TURpVDZiYlwvWVlBTGFnVGdhVEpDdUM4bmpmQ295a21TT2FFMm5UUzhiem9JSk94RXh3TE1HWEMxTzhxZ29aa1d3S055Z3BFbEQzbExhMFc1ZWFYYll6c2gwVWFEaUpxVzBybXBBUVpoOHE3K2ZTVTVpM1hrM2VndVErb0J2RmpwYmptUDNZNXhJeEQzVmdJbUlZNndPaEdZR0Z6QVRuRTVMeFd5djZoT3EyeEVMZGRTWEhuREY4ajh1NWxnWDllZmxLVHVWQUludElQbTg2eldSeXRQaWZNYThMcmFGVlRnRUcrYmR2azRoTjRuRVJ3VjdBY2hoZ0FLTTM3bmFpTjd5SERPQUllZjVEdUM4dDFjSllcL28yYmUzYTYxTGRKRjBSM3g3NnVVcFlvMGltajFsUlwvNG00M2JqZVpESzZyajJFY2xERXptaStDeXI4VmE2YTk3SlkxaHMxZmlmNVVRT2NIXC9YWjVcL3JjRkFCK21oWFRScTJUUnUzTVJLWHpLNDUyajdYTkx5M2JkK05FWWNMa3I4TlFEUlZ5bmVMdjd2MHdlZ2xOY00zMXRxdnk1ZjRcL0k1a1RzaTBcL2czc0VPcnhFeHpMOTM0Wmp3YVwvQzRQaVVIa2Y2b0ZUbms4a0FaRkR3bk53b2dkNzc2YitnT0hLVHRSM0MrNjkrTXczOUx0VmlmbWtHMzU3MmgrQ2I3eDNqVGUyQlo2RFVwZlRkc0JtNXNmMXdRY1Z2Q1VqSjVuVzFjUko2em9CVXQ4eWRKSVlcL2J3bFJkbXg0XC9DbFc3M0YycDdGcEpUS2piYzRmRkR0aFdUalwvMW40MVBtVkwwaUZJSm5WbFNoQlVhU2s5VW1VRWpETEE5eU5yUUM3ZjZkY0JIRFJDdG1GMG5SYTBYdUVBcUs4dTRyVURVRXB0WXdORlFmeVZNVT0iLCJtYWMiOiI0ODUwN2MxODVjMjFiZGUzMzg3OGY2Y2VmMDU4NWU0MDA3NmMyMmRhZjBiNDcwNTU0YzVlNzVhZDgzMjg0MzZlIn0%3D; _ga=GA1.2.708189400.1409568750; truecaller-session=eyJpdiI6IlhYS1hndjVTSlNwN3EyNFQ1cVY2UUt0UDZFR0gyZ1U3MnMxcnUrTDBrd3c9IiwidmFsdWUiOiIwOEpsdGhuYkRlcFU2QXl0azhqOGVMcENydkxQVDkzK1RqQktKS3ZJVlwvQk1ma0Z5b3ZXSkR3SFV0NHpDQ2taQ29WWWJyZXVINFwvRlhOSEZhRGV0dCtnPT0iLCJtYWMiOiIxNzFiZGIzZWU5NDllZWYzMDU4ZTkyNzQzNzc5MmFmOWZmMzE1NTdhMjk3ZjhlMzVjODM0ODUwZmZkMDZjNzcyIn0%3D; XLBS2=XLBS2|VAbqn|VAbqk");

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