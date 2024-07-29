import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class Map{
	
	public void displayStops(String location){
		String str = "SELECT loc_stop.name FROM PickupAndDrop pd JOIN Locations loc_district ON pd.district = loc_district.id JOIN Locations loc_stop ON pd.stops = loc_stop.id WHERE loc_district.name = ?;";
		try{
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement =connection.prepareStatement(str);
			statement.setString(1,location);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				String stop = resultSet.getString("name");
				System.out.println(" >> " + stop);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public String getLocation(short locationId){
		String str ="SELECT name FROM Locations WHERE id = ?;";
		String location = null;
		try{
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement =connection.prepareStatement(str);
			statement.setShort(1,locationId);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()){
				location = resultSet.getString("name");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return location;
	}
	
	public short getLocationId(String location){
		String str ="SELECT pd.id FROM PickupAndDrop pd JOIN Locations loc ON pd.stops = loc.id WHERE loc.name = ?;";
		Short locationId = -1;
		try{
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement =connection.prepareStatement(str);
			statement.setString(1,location);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()){
				locationId = resultSet.getShort("id");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return locationId;
	}
	
	public int getDistance(String location1 , String location2){
		double[] coordinates1 = getLangLong(location1);
		double[] coordinates2 = getLangLong(location2);
		int distance = findDistance(coordinates1[0],coordinates1[1],coordinates2[0],coordinates2[1]);
		return distance ;
	}
	
	public double[] getLangLong(String address) {
		double[] coordinates = new double[2];
        try
		{
            String encodedAddress = URLEncoder.encode(address, StandardCharsets.UTF_8);
            String apiKey = "426efb6d50msh82dda003509b8a9p1a1899jsnd99b8d3beaa6";
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
				coordinates[0] = latitude ;
				coordinates[1] = longitude ;	
            } else {
                System.out.println("No results found for the given address.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return coordinates ;
	}
	
	public int findDistance(double latitude1, double longitude1, double latitude2, double longitude2) {
		double deltaLat = Math.toRadians(latitude2 - latitude1);
		double deltaLon = Math.toRadians(longitude2 - longitude1);
		double haversineFormula = Math.pow(Math.sin(deltaLat / 2), 2) +
									Math.cos(Math.toRadians(latitude1)) * Math.cos(Math.toRadians(latitude2)) *
									Math.pow(Math.sin(deltaLon / 2), 2);
		double centralAngle = 2 * Math.atan2(Math.sqrt(haversineFormula), Math.sqrt(1 - haversineFormula));
		double earthRadiusKm = 6371;
		int distance = (int)Math.round(earthRadiusKm * centralAngle);
		return distance ;
	}
	
	public static void displayMap(){
		
		System.out.println("\n                                _____*Chennai");
		System.out.println("                            ___/            |");
		System.out.println("                       _ salem *            |");
		System.out.println("                     _/                     |");
		System.out.println("                  Erode*                   /");
		System.out.println("                 /                        /");
		System.out.println("             ___/                     *Trichy");
		System.out.println("     Coimbatore*                       _/");
		System.out.println("             \\                        |");
		System.out.println("              \\__                     |");
		System.out.println("                 \\                    |");
		System.out.println("                  Dindigul*           |");
		System.out.println("                   \\                  |");
		System.out.println("                    Madurai*         /");
		System.out.println("                     \\             _/");
		System.out.println("                      \\            *Tuticorin");
		System.out.println("                   tenkasi*    *Tirunelveli");
		System.out.println("                        \\         /");
		System.out.println("                   kanyakumari*  /");
		System.out.println("                          \\_ _ _/\n");
	
	}
}