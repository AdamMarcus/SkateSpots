using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.Sql;
using System.Data.SqlClient;

// HttpHandler for testing the WebServer setup

namespace SkateSpots
{
    public class TestHandler : IHttpHandler
    {
        public void ProcessRequest(HttpContext context)
        {
        }

        public bool IsReusable
        {
            get { return true; }
        }
    }
}