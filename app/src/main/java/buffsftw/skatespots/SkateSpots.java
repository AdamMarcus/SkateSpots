package buffsftw.skatespots;

import android.support.annotation.Nullable;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 */
// class hnadles data for the listview
 // should contain dataaccess indirectly ->
 // data retrieval via remote web service -> json
// local library -> Volley
    //

public class SkateSpots {
    public String exampleJson = " { \"spotNumber\": 5, \"spotsList\":[ { \"id\":100, \"name\":\"VAC Stairs\", \"pictureURL\":\"http://applianceelite.com/skateSpotsCU/defaultStairs.png\", \"details\":\"Details go here\", \"rating\":3, \"lat\":40.006947, \"lon\":-105.270652, \"difficulty\":5, \"security\":4} ,{ \"id\":101, \"name\":\"Duane Physics\", \"pictureURL\":\"http://applianceelite.com/skateSpotsCU/defaultStairs.png\", \"details\":\"Details go here\", \"rating\":2, \"lat\":40.007806, \"lon\":-105.267915, \"difficulty\":4, \"security\":1}, { \"id\":103, \"name\":\"Farrand Field\", \"pictureURL\":\"http://applianceelite.com/skateSpotsCU/defaultStairs.png\", \"details\":\"Details go here\", \"rating\":4, \"lat\":40.006369, \"lon\":-105.268411, \"difficulty\":3, \"security\":2} ]}";
    /**
     * An array of sample (dummy) items.
     */
    public static final List<Spots> ITEMS = new ArrayList<Spots>();

/*
    public static final Map<String, Spots> ITEM_MAP = new HashMap<Spots>();
*/
//Number of spots to create
    private static final int COUNT = 10;
    public void populateList () throws JSONException {
        // Add some sample items.
        JSONObject jsonRoot = new JSONObject(exampleJson);
        int responseNumber = jsonRoot.getInt("spotNumber");
        String responseString = jsonRoot.getString("spotsList");
        JSONArray jsonSpots = new JSONArray(responseString);
        for (int i = 0; i <= responseNumber; i++) {
            JSONObject jsonSpot = jsonSpots.getJSONObject(i);
            String id = jsonSpot.getString("id");
            String name = jsonSpot.getString("name");
            String picture = jsonSpot.getString("pictureURL");
            String details = jsonSpot.getString("details");
            int rating = jsonSpot.getInt("rating");
            double lat = jsonSpot.getDouble("lat");
            double lon = jsonSpot.getDouble("lon");
            int difficultyRating = jsonSpot.getInt("difficulty");
            int securityRating = jsonSpot.getInt("security");
            Log.d("myTag", name);
            addItem(createSpots(id,name,picture,details,rating,lat,lon,difficultyRating,securityRating));
        }}

     private static void addItem(Spots spot) {
     ITEMS.add(spot);
/*         ITEM_MAP.put(spot.id, spot);*/
     }

     private static Spots createSpots(String id, String name, String picture, String details, int rating, double lat, double lon, int securityRating, int difficultyRating) {
         return new Spots(id,name,picture,details,rating,lat,lon,difficultyRating,securityRating);
     }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A class for Skate Spots
     *
     */
    public static class Spots {
        public final String id;
        public String name;
        private String picture;
        public String details;
        public int rating;
        private double lat;
        private double lon;
        public int securityRating;
        public int difficultyRating;


 /*       public Spots() {
        }*/

        public Spots(String id, String name, String picture, String details, int rating, double lat, double lon, int securityRating, int difficultyRating)
        {
            this.id = id;
            this.name = name;
            this.picture = picture;
            this.details = details;
            this.rating = rating;
            this.lat = lat;
            this.lon = lon;
            this.securityRating = securityRating;
            this.difficultyRating = difficultyRating;
        }

        public String getName() {
            return name;
        }

        public String getPicture() {
            return picture;
        }

        public String getDetails() {
            return details;
        }

        public int getRating() {
            return rating;
        }

        public double getLat() {
            return lat;
        }

        public double getLon() {
            return lon;
        }

        public int getSecurityRating() {
            return securityRating;
        }

        public int getDifficultyRating() {
            return difficultyRating;
        }
    }

}
