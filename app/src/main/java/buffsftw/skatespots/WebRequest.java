package buffsftw.skatespots;

/**
 * Created by Jack on 11/16/2016.
 */
 
import android.os.AsyncTask;
import java.net.HttpURLConnection;
import java.net.URL;

 
public class WebRequest {

	// Task to make the request
	// AsyncTask ensures it executes on a separate thread
	class serverRequest extends AsyncTask<String,String,String> {
		
		private String urlString;
		
		public serverRequest(String urlString){
			this.urlString = urlString;
		}
		
		@Override protected String doInBackground(String...strings) {
			try{
				URL url = new URL(urlString);
				HtppURLConnection urlConnection = (HttpUrlConnection) url.openConnection();
				return urlConnection.getContent().toString();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			return "";
		}
	}

	// Get userID query
    public int getUserId(String userEMail) {
		String response = "";
		
		serverRequest request = new ServerRequest("http://skatespots.live/user?a=get_id&email=" + userEMail);
		requset.execute();
		try {
			response = request.get();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

        return Integer.parseInt(response);
    }

    public String getPassword(String userEMail) {
        String response = "";

        /*
        SELECT user_password FROM users WHERE user_email = userEMail;
        */

        serverRequest request = new ServerRequest("http://skatespots.live/user?a=get_pass&email=" + userEMail)
		request.execute();
		try {
			response = request.get();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
        return response;
    }


    public String getName(int userID) {
        String response = "";

        /*
         SELECT user_first_name FROM users WHERE user_id = userID;
         */

        serverRequest request = new ServerRequest("http://skatespots.live/user?a=get_name&uid=" + userID)
		request.execute();
		try {
			response = request.get();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
        return response;
    }


    public String getUserName(int userID) {
        String response = "";

       /*
       SELECT user_name FROM users WHERE user_id = userID;
       */

        serverRequest request = new ServerRequest("http://skatespots.live/user?a=get_uname&uid=" + userID)
		request.execute();
		try {
			response = request.get();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
        return response;
    }


    public int[] getSpotCollection(int userID) {
        int[] spotCollection = new int[]{};

        /*
         SELECT spot_id FROM user_spot_collection WHERE user_id = userID;
         */

         /* Jack */

        return spotCollection;
    }

    public getNewSpot(int userID) {
		String response = "";
	
        /*
        SELECT *
        FROM spots
		WHERE spots.spot_id NOT IN (SELECT spot_id from user_spot_collection where user_id = userID)
		*/
		
	    serverRequest request = new ServerRequest("http://skatespots.live/user?a=get_spot&uid=" + userID)
		request.execute();
		try {
			response = request.get();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
        return response;
        
    }


    public int getTokenCount(int userID) {
        String response = "";

        /*
        SELECT token_count FROM users WHERE user_id = userID;
        */

	    serverRequest request = new ServerRequest("http://skatespots.live/user?a=get_token&uid=" + userID)
		request.execute();
		try {
			response = request.get();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
        return Integer.parseInt(response);
    }


    public void setPassword(String password, int userID) {

        /*
        UPDATE users SET user_password = 'NEWPASSWORD' where user_id = userID;
        */

        serverRequest request = new ServerRequest("http://skatespots.live/user?a=set_pass&uid=" + userID + "&pass=" + password)
		request.execute();
		return;
	}


    public void setName(String name, int userID) {
        /*
        UPDATE users SET user_first_name = 'NEWNAME' WHERE user_id = userID;
        */

        serverRequest request = new ServerRequest("http://skatespots.live/user?a=set_name&uid=" + userID + "&name=" + name)
		request.execute();
		return;
    }


    public void setUserName(String userName, int userID) {
        /*
        UPDATE users SET user_name = 'NEWUSERNAME' WHERE user_id = userID;
        */

        serverRequest request = new ServerRequest("http://skatespots.live/user?a=set_uname&uid=" + userID + "&uname=" + userName)
		request.execute();
		return;
    }


    public void setTokenCount(int tokenCount, int userID) {
        /*
        UPDATE users SET token_count = tokenCount WHERE user_id = userID;
       */

	    serverRequest request = new ServerRequest("http://skatespots.live/user?a=set_token&uid=" + userID + "&token=" + tokenCount)
		request.execute();
		return;
    }


    public void addSpot(double xCoordinate, double yCoordinate, String country, String city, String state, String spotType, char spotDifficulty, int userID) {
        /*
        INSERT INTO spots (x_coordinate, y_coordinate, country, city, state, spot_type, spot_difficulty) VALUES (xCoordinate, yCordinate, country, city, state, spotType, spotDifficulty);
        INSERT INTO spot_stats VALUES ((SELECT spot_id FROM spots WHERE spots.x_coordinate = xCoordinate AND spots.y_coordinate = yCoordinate) , 0, 1, 0, 0, 0);
        INSERT INTO user_spot_collection VALUES (userID, (SELECT spot_id FROM spots WHERE spots.x_coordinate = xCoordinate AND spots.y_coordinate = yCoordinate));
        INSERT INTO user_spot_contribution VALUES (userID, (SELECT spot_id FROM spots WHERE spots.x_coordinate = xCoordinate AND spots.y_coordinate = yCoordinate));
        */

		serverRequest request = new ServerRequest("http://skatespots.live/user?a=add_spot&uid=" + userID + "&x=" + xCoordinate + "&y=" + yCoordinate + "&country=" + country + "&city=" 
			+ city + "&state=" + state + "&type=" + spotType + "&diff=" + spotDifficulty);
		request.execute();
		return;
    }


    public void addUser(String userName, String userFirstName, String userPassword, String userEMail) {
        /*
        INSERT INTO users (user_name, user_first_name, user_password, user_email, user_rating, token_count) VALUES (userName, userFirstName, userPassword, userEmail, userRating, tokenCount);
        */
       
		serverRequest request = new ServerRequest("http://skatespots.live/user?a=add_user&uid=" + userID + "&uname=" + userName + "&name=" + userFirstName + "&pass=" + userPassword + "&email=" + userEmail)
		request.execute();
		return;
    }


}


