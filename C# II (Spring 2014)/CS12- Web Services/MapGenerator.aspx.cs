// Name: John Gardiner
// Date: 4/15/2014
// Assignment: CS12 Web Services

using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class MapGenerator : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void btnGetMap_Click(object sender, EventArgs e)
    {
        imgMap.ImageUrl =
            "http://maps.googleapis.com/maps/api/staticmap?center=" + txtAddress.Text +
             "&zoom=14&size=540x320&maptype=roadmap&markers=color:blue%7Clabel:A%7C" +
             txtAddress.Text + "&sensor=false";

        lblURL.Text = imgMap.ImageUrl; //display URL in label 
    }
}