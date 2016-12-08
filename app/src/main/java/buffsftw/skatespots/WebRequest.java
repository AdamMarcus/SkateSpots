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


    public void addSpot(int spotID, double xCoordinate, double yCordinate, String country, String city, String state, String spotType, char spotDifficulty, int userID) {
        /*
        INSERT INTO spots VALUES (spotID, xCoordinate, yCordinate, country, city, state, spotType, spotDifficulty);
        INSERT INTO spot_stats VALUES (0, 0, 1, 0, 0, 0);
        INSERT INTO user_spot_collection VALUES (userID, spotID);
        INSERT INTO user_spot_contribution VALUES (userID, spotID);
         */


        /* Jack */
    }


    public void addUser(int userID, String userName, String userFirstName, String userPassword, String userEMail, int userRating, int tokenCount) {
        /*
        WARNING: Needs tested in database
        INSERT INTO users VALUES (userID, userName, userFirstName, userPassword, userEmail, userRating, tokenCount);
        */

       /* Jack */


    }


}


