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
    public String exampleJson = "{\"spotNumber\":3,\"spotsList\":[{\"id\":100,\"name\":\"VACStairs\",\"pictureURL\":\"http://applianceelite.com/skateSpotsCU/defaultStairs.png\",\"rail\":false,\"stair\":true,\"gap\":true,\"ledge\":true,\"rating\":5,\"lat\":40.006947,\"lon\":-105.270652,\"difficulty\":5,\"security\":4},{\"id\":101,\"name\":\"DuanePhysics\",\"pictureURL\":\"http://applianceelite.com/skateSpotsCU/defaultStairs.png\",\"rail\":false,\"stair\":true,\"gap\":true,\"ledge\":false,\"rating\":3,\"lat\":40.007806,\"lon\":-105.267915,\"difficulty\":4,\"security\":3},{\"id\":102,\"name\":\"FarrandField\",\"pictureURL\":\"http://applianceelite.com/skateSpotsCU/defaultStairs.png\",\"rail\":false,\"stair\":true,\"gap\":false,\"ledge\":true,\"rating\":2,\"lat\":40.006369,\"lon\":-105.268411,\"difficulty\":3,\"security\":2}]}";
    /**
     * An array of sample (dummy) items.
     */
    public static final List<Spots> ITEMS = new ArrayList<Spots>();

/*
    public static final Map<String, Spots> ITEM_MAP = new HashMap<Spots>();
*/
    public void populateList () throws JSONException {
        // Add some items.
        clearList();
        JSONObject jsonRoot = new JSONObject(exampleJson);
        int responseNumber = jsonRoot.getInt("spotNumber");
        String responseString = jsonRoot.getString("spotsList");
        JSONArray jsonSpots = new JSONArray(responseString);
        for (int i = 0; i <= (responseNumber - 1); i++) {
            JSONObject jsonSpot = jsonSpots.getJSONObject(i);
            int id = jsonSpot.getInt("id");
            String name = jsonSpot.getString("name");
            String picture = jsonSpot.getString("pictureURL");
            boolean rail = jsonSpot.getBoolean("rail");
            boolean stair = jsonSpot.getBoolean("stair");
            boolean gap = jsonSpot.getBoolean("gap");
            boolean ledge = jsonSpot.getBoolean("ledge");
            int rating = jsonSpot.getInt("rating");
            double lat = jsonSpot.getDouble("lat");
            double lon = jsonSpot.getDouble("lon");
            int difficultyRating = jsonSpot.getInt("difficulty");
            int securityRating = jsonSpot.getInt("security");
            addItem(createSpots(id,name,picture,rail,stair,gap,ledge,rating,lat,lon,difficultyRating,securityRating));
        }}

     private static void addItem(Spots spot) {
     ITEMS.add(spot);
/*         ITEM_MAP.put(spot.id, spot);*/
     }

    private static void clearList(){
        ITEMS.clear();
    }

     private static Spots createSpots(int id, String name, String picture, boolean rail,boolean stair,boolean gap, boolean ledge, int rating, double lat, double lon, int securityRating, int difficultyRating) {
         return new Spots(id,name,picture,rail,stair,gap,ledge,rating,lat,lon,difficultyRating,securityRating);
     }


    /**
     * A class for Skate Spots
     *
     */
    public static class Spots {
        public final int id;
        public String name;
        private String picture;
        public boolean rail;
        public boolean stair;
        public boolean gap;
        public boolean ledge;
        public int rating;
        private double lat;
        private double lon;
        public int securityRating;
        public int difficultyRating;


 /*       public Spots() {
        }*/

        public Spots(int id, String name, String picture, boolean rail,boolean stair,boolean gap, boolean ledge, int rating, double lat, double lon, int securityRating, int difficultyRating)
        {
            this.id = id;
            this.name = name;
            this.picture = picture;
            this.rail = rail;
            this.stair = stair;
            this.gap = gap;
            this.ledge = ledge;
            this.rating = rating;
            this.lat = lat;
            this.lon = lon;
            this.securityRating = securityRating;
            this.difficultyRating = difficultyRating;
        }

        public int getID() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getPicture() {
            return picture;
        }

        public boolean getRail() {
            return rail;
        }

        public boolean getStair() {
            return stair;
        }

        public boolean getGap() {
            return gap;
        }

        public boolean getLedge() {
            return ledge;
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
