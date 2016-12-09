using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.Sql;
using System.Data.SqlClient;

// HttpHandler for getting user information from database

namespace SkateSpots
{
    public class UserInfoHandler : IHttpHandler
    {
        public bool IsReusable
        {
            get { return true; }
        }

        // String for query text
        public string queryText = "SELECT * FROM users";

        // Connection object to SQL Server
        public SqlConnection conn;

        /// <summary>
        /// Main entry point when handler is called
        /// </summary>
        public void ProcessRequest(HttpContext context)
        {
            // Parse the URL for parameters
            Uri incomingUrl = new Uri("http://localhost" + context.Request.RawUrl);

            string email = HttpUtility.ParseQueryString(incomingUrl.Query).Get("email");
            string userId = HttpUtility.ParseQueryString(incomingUrl.Query).Get("uid");
            string action = HttpUtility.ParseQueryString(incomingUrl.Query).Get("a");
            string password = HttpUtility.ParseQueryString(incomingUrl.Query).Get("pass");
            string userName = HttpUtility.ParseQueryString(incomingUrl.Query).Get("uname");
            string name = HttpUtility.ParseQueryString(incomingUrl.Query).Get("name");

            // Execute the specified query
            switch (action)
            {
                // Get User Id
                case "get_id":
                    queryText = "SELECT user_id FROM users WHERE user_email=" + email;

                    // Create a connection to the SQL Server
                    conn = new SqlConnection("Data Source=tcp:104.199.118.241,1433;Initial Catalog=skatespots;Persist Security Info=True;User ID=skatespots;Password=Bos0co12");
                    using (SqlCommand cmd = new SqlCommand())
                    {

                        cmd.CommandText = queryText;
                        cmd.CommandType = System.Data.CommandType.Text;
                        cmd.Connection = conn;

                        conn.Open();
                        using (SqlDataReader reader = cmd.ExecuteReader())
                        {
                            while (reader.Read())
                            {
                                context.Response.Write(reader.GetValue(0));
                            }
                        }

                        conn.Close();
                        cmd.Dispose();
                    }
                    break;
                
                // Get User Password
                case "get_pass":
                    queryText = "SELECT user_password FROM users WHERE user_email=" + email;

                    // Create a connection to the SQL Server
                    conn = new SqlConnection("Data Source=tcp:104.199.118.241,1433;Initial Catalog=skatespots;Persist Security Info=True;User ID=skatespots;Password=Bos0co12");
                    using (SqlCommand cmd = new SqlCommand())
                    {

                        cmd.CommandText = queryText;
                        cmd.CommandType = System.Data.CommandType.Text;
                        cmd.Connection = conn;

                        conn.Open();
                        using (SqlDataReader reader = cmd.ExecuteReader())
                        {
                            while (reader.Read())
                            {
                                context.Response.Write(reader.GetValue(0));
                            }
                        }

                        conn.Close();
                        cmd.Dispose();
                    }
                    break;

                // Get first name
                case "get_name":
                    queryText = "SELECT user_firstname FROM users WHERE user_id=" + userId;

                    // Create a connection to the SQL Server
                    conn = new SqlConnection("Data Source=tcp:104.199.118.241,1433;Initial Catalog=skatespots;Persist Security Info=True;User ID=skatespots;Password=Bos0co12");
                    using (SqlCommand cmd = new SqlCommand())
                    {

                        cmd.CommandText = queryText;
                        cmd.CommandType = System.Data.CommandType.Text;
                        cmd.Connection = conn;

                        conn.Open();
                        using (SqlDataReader reader = cmd.ExecuteReader())
                        {
                            while (reader.Read())
                            {
                                context.Response.Write(reader.GetValue(0));
                            }
                        }

                        conn.Close();
                        cmd.Dispose();
                    }
                    break;
                
                // Get Username
                case "get_uname":
                    queryText = "SELECT user_name FROM users WHERE user_id=" + userId;

                    // Create a connection to the SQL Server
                    conn = new SqlConnection("Data Source=tcp:104.199.118.241,1433;Initial Catalog=skatespots;Persist Security Info=True;User ID=skatespots;Password=Bos0co12");
                    using (SqlCommand cmd = new SqlCommand())
                    {

                        cmd.CommandText = queryText;
                        cmd.CommandType = System.Data.CommandType.Text;
                        cmd.Connection = conn;

                        conn.Open();
                        using (SqlDataReader reader = cmd.ExecuteReader())
                        {
                            while (reader.Read())
                            {
                                context.Response.Write(reader.GetValue(0));
                            }
                        }

                        conn.Close();
                        cmd.Dispose();
                    }
                    break;

                // Get new spot
                case "get_new":
                    queryText = "SELECT * FROM spots WHERE spots.spot_id NOT IN (SELECT spot_id from user_spot_collection WHERE user_id = " + userId + ")";

                    // Create a connection to the SQL Server
                    conn = new SqlConnection("Data Source=tcp:104.199.118.241,1433;Initial Catalog=skatespots;Persist Security Info=True;User ID=skatespots;Password=Bos0co12");
                    using (SqlCommand cmd = new SqlCommand())
                    {

                        cmd.CommandText = queryText;
                        cmd.CommandType = System.Data.CommandType.Text;
                        cmd.Connection = conn;

                        conn.Open();
                        using (SqlDataReader reader = cmd.ExecuteReader())
                        {
                            while (reader.Read())
                            {
                                // read only the first row.
                            }
                        }

                        conn.Close();
                        cmd.Dispose();
                    }
                    break;

                // Get user's token count
                case "get_token":
                    queryText = "SELECT token_count FROM users WHERE user_id = " + userId;

                    // Create a connection to the SQL Server
                    conn = new SqlConnection("Data Source=tcp:104.199.118.241,1433;Initial Catalog=skatespots;Persist Security Info=True;User ID=skatespots;Password=Bos0co12");
                    using (SqlCommand cmd = new SqlCommand())
                    {

                        cmd.CommandText = queryText;
                        cmd.CommandType = System.Data.CommandType.Text;
                        cmd.Connection = conn;

                        conn.Open();
                        using (SqlDataReader reader = cmd.ExecuteReader())
                        {
                            while (reader.Read())
                            {
                                // read only the first row.
                            }
                        }

                        conn.Close();
                        cmd.Dispose();
                    }
                    break;
                
                // Set user's password
                case "set_pass":
                    queryText = "UPDATE users SET user_password = " + password + " WHERE user_id = " + userId;

                    // Create a connection to the SQL Server
                    conn = new SqlConnection("Data Source=tcp:104.199.118.241,1433;Initial Catalog=skatespots;Persist Security Info=True;User ID=skatespots;Password=Bos0co12");
                    using (SqlCommand cmd = new SqlCommand())
                    {

                        cmd.CommandText = queryText;
                        cmd.CommandType = System.Data.CommandType.Text;
                        cmd.Connection = conn;

                        conn.Open();
                        using (SqlDataReader reader = cmd.ExecuteReader())
                        {
                            // do nothing
                        }

                        conn.Close();
                        cmd.Dispose();
                    }
                    break;
    
                // Set user's first name
                case "set_name":
                    queryText = "UPDATE users SET user_name = " + userName + " WHERE user_id = " + userId;

                    // Create a connection to the SQL Server
                    conn = new SqlConnection("Data Source=tcp:104.199.118.241,1433;Initial Catalog=skatespots;Persist Security Info=True;User ID=skatespots;Password=Bos0co12");
                    using (SqlCommand cmd = new SqlCommand())
                    {

                        cmd.CommandText = queryText;
                        cmd.CommandType = System.Data.CommandType.Text;
                        cmd.Connection = conn;

                        conn.Open();
                        using (SqlDataReader reader = cmd.ExecuteReader())
                        {
                            // do nothing
                        }

                        conn.Close();
                        cmd.Dispose();
                    }
                    break;

                // Set user's username
                case "set_uname":
                    queryText = "UPDATE users SET user_name = " + userName + " WHERE user_id = " + userId;

                    // Create a connection to the SQL Server
                    conn = new SqlConnection("Data Source=tcp:104.199.118.241,1433;Initial Catalog=skatespots;Persist Security Info=True;User ID=skatespots;Password=Bos0co12");
                    using (SqlCommand cmd = new SqlCommand())
                    {

                        cmd.CommandText = queryText;
                        cmd.CommandType = System.Data.CommandType.Text;
                        cmd.Connection = conn;

                        conn.Open();
                        using (SqlDataReader reader = cmd.ExecuteReader())
                        {
                            // do nothing
                        }

                        conn.Close();
                        cmd.Dispose();
                    }
                    break;

                default:
                    Console.WriteLine("Bad Request Url.");
                    break;
            }
        }
    }
}