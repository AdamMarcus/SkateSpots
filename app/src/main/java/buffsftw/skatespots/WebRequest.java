package buffsftw.skatespots;

/**
 * Created by Jack on 11/16/2016.
 */

public class WebRequest {

    public int getUserId(String userEMail) {
        int userID = 0;

        return userID;
    }

    public String getPassword(String userEMail) {
        String password = "0";

        /*
        SELECT user_password FROM users WHERE user_email = userEMail;
        */

        /* Jack */

        return password;
    }


    public String getName(int userID) {
        String name = "0";

        /*
         SELECT user_first_name FROM users WHERE user_id = userID;
         */

        /* Jack */

        return name;
    }


    public String getUserName(int userID) {
        String userName = "0";

       /*
       SELECT user_name FROM users WHERE user_id = userID;
       */

        /* Jack */

        return userName;
    }


    public int[] getSpotCollection(int userID) {
        int[] spotCollection = new int[]{};

        /*
         SELECT spot_id FROM user_spot_collection WHERE user_id = userID;
         */

         /* Jack */

        return spotCollection;
    }

    public void getNewSpot(int userID) {

        /*
        SELECT *
        FROM spots
       WHERE spots.spot_id NOT IN (SELECT spot_id from user_spot_collection where user_id = 2)

         /* Jack*/

        //SkateSpots.Spots newSpot = new SkateSpots.Spots();
        //return newSpot;
    }


    public int getTokenCount(int userID) {
        int tokenCount = 0;

        /*
        SELECT token_count FROM users WHERE user_id = userID;
        */

        /* Jack */

        return tokenCount;
    }


    public void setPassword(String password, int userID) {

        /*
        UPDATE users SET user_password = 'NEWPASSWORD' where user_id = userID;
        */

        /* Jack */
    }


    public void setName(String name, int userID) {
        /*
        UPDATE users SET user_first_name = 'NEWNAME' WHERE user_id = userID;
        */

        /* Jack */
    }


    public void setUserName(String userName, int userID) {
        /*
        UPDATE users SET user_name = 'NEWUSERNAME' WHERE user_id = userID;
        */


       /* Jack */
    }


    public void setTokenCount(int tokenCount, int userID) {
        /*
        UPDATE users SET token_count = tokenCount WHERE user_id = userID;
       */

       /* Jack */
    }


    public void addSpot(double xCoordinate, double yCoordinate, String country, String city, String state, String spotType, char spotDifficulty, int userID) {
        /*
        INSERT INTO spots (x_coordinate, y_coordinate, country, city, state, spot_type, spot_difficulty) VALUES (xCoordinate, yCordinate, country, city, state, spotType, spotDifficulty);
        INSERT INTO spot_stats VALUES ((SELECT spot_id FROM spots WHERE spots.x_coordinate = xCoordinate AND spots.y_coordinate = yCoordinate) , 0, 1, 0, 0, 0);
        INSERT INTO user_spot_collection VALUES (userID, (SELECT spot_id FROM spots WHERE spots.x_coordinate = xCoordinate AND spots.y_coordinate = yCoordinate));
        INSERT INTO user_spot_contribution VALUES (userID, (SELECT spot_id FROM spots WHERE spots.x_coordinate = xCoordinate AND spots.y_coordinate = yCoordinate));
        */


        /* Jack */
    }


    public void addUser(String userName, String userFirstName, String userPassword, String userEMail, int userRating, int tokenCount) {
        /*
        INSERT INTO users (user_name, user_first_name, user_password, user_email, user_rating, token_count) VALUES (userName, userFirstName, userPassword, userEmail, userRating, tokenCount);
        */
       /* Jack */


    }


}


