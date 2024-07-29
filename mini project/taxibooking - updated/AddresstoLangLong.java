import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

public class AddresstoLangLong {
    public static void main(String[] args) {
        try
		{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter an address:");
            String address = reader.readLine();
            String encodedAddress = URLEncoder.encode(address, StandardCharsets.UTF_8);
            String apiKey = "426efb6d50msh82dda003509b8a9p1a1899jsnd99b8d3beaa6";
         //   String apiUrl = "https://trueway-geocoding.p.rapidapi.com/Geocode?address="+encodedAddress+"&language=en&country=%2B91";
			 String apiUrl = "https://trueway-geocoding.p.rapidapi.com/Geocode?address="+encodedAddress+"&language=en&country=in";
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("X-RapidAPI-Key", apiKey)
                .header("X-RapidAPI-Host", "trueway-geocoding.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonObject = new JSONObject(response.body());
            if (jsonObject.has("results") && jsonObject.getJSONArray("results").length() > 0) {
                JSONObject location = jsonObject.getJSONArray("results").getJSONObject(0).getJSONObject("location");
                double latitude = location.getDouble("lat");
                double longitude = location.getDouble("lng");
                System.out.println("Latitude: " + latitude);
                System.out.println("Longitude: " + longitude);
            } else {
                System.out.println("No results found for the given address.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public static void findDistance(double lat1,double lon1,double lat2,double lon2)
	{
		double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                   Math.pow(Math.sin(dLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		if((Math.round(6371 * c))!=0)
			System.out.println("Distance :"+Math.round(6371 * c)+"km") ;
		else
			System.out.println("Invalid Request(Enter Valid To Location)") ;
	}
}
