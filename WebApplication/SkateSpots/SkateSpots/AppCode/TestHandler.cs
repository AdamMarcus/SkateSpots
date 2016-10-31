using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

// HttpHandler for testing the WebServer setup

namespace SkateSpots
{
    public class TestHandler : IHttpHandler
    {
        public void ProcessRequest(HttpContext context)
        {
            context.Response.Write("Hello!");
        }

        public bool IsReusable
        {
            get { return true; }
        }
    }
}