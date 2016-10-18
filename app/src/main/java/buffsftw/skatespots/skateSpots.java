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
 * TODO: Replace all uses of this class before publishing your app.
 */
public class skateSpots {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Spots> ITEMS = new ArrayList<Spots>();


    private static final int COUNT = 24;
/**
 static {
 // Add some sample items.
 for (int i = 0; i <= COUNT; i++)
 ITEMS[i] = new createSpots(String name, picture, );

 }
 }**/
    /**
     private static void addItem(Spots spot) {
     ITEMS.add(spot);
     }

     private static skateSpots createSpots(int position) {
     return new skateSpots kl;
     }**/

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
     */
    public class Spots {
        public String name;
        private String picture;
        public String details;
        private byte rating;
        private short lat;
        private short lon;


        public Spots() {
        }

        public Spots createSpots(String name, String picture, String details, byte rating, short lat, short lon)
        {
            this.name = name;
            this.picture = picture;
            this.details = details;
            this.rating = rating;
            this.lat = lat;
            this.lon = lon;
            return this;
        }

        public String getName() {
            return this.name;
        }

        public String getPicture() {
            return this.picture;
        }

        public String getDetails() {
            return this.details;
        }

        public byte getRating() {
            return this.rating;
        }

        public int getLat() {
            return this.lat;
        }

        public int getLon() {
            return this.lon;
        }
    }

}
