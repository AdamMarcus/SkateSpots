package buffsftw.skatespots;

import android.support.annotation.Nullable;

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
public class skateSpots {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Spots> ITEMS = new ArrayList<Spots>();

/*
    public static final Map<String, Spots> ITEM_MAP = new HashMap<Spots>();
*/
//Number of spots to display
    private static final int COUNT = 10;

    public void asd (int num) {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createSpots(i));
        }}

     private static void addItem(Spots spot) {
     ITEMS.add(spot);
/*         ITEM_MAP.put(spot.id, spot);*/
     }

     private static Spots createSpots(int position) {
         return new Spots(String.valueOf(position), "Name" + position, "get picture by id", "Name" + position + "details", 5, 40.0150, -105.2705);
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
        private int rating;
        private double lat;
        private double lon;


 /*       public Spots() {
        }*/

        public Spots(String id, String name, String picture, String details, int rating, double lat, double lon)
        {
            this.id = id;
            this.name = name;
            this.picture = picture;
            this.details = details;
            this.rating = rating;
            this.lat = lat;
            this.lon = lon;
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
    }

}
