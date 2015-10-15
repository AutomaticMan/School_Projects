// Name: John Gardiner
// Assignment: CS6
// Description: This program allows for maintenance of customer records in the MMABooks
//              database.  Records can be viewed (by customer id), added, modified, or
//              deleted.

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.SqlClient;

namespace CustomerMaintenance
{
    class MMABooksDB
    {
        public static SqlConnection GetConnection()
        {
            string strConnectionString =
                "Data Source=(LocalDB)\\v11.0;AttachDbFilename=|DataDirectory|" +
                "\\MMABooks.mdf;Integrated Security=True";
            
            SqlConnection connection = new SqlConnection(strConnectionString);
            
            return connection;
        }
    }
}