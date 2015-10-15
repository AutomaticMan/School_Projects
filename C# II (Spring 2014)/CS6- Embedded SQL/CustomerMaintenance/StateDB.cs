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
    class StateDB
    {
        public static List<State> GetStates()
        {
            List<State> states = new List<State>();

            SqlConnection connection = MMABooksDB.GetConnection();

            string selectStatement = "SELECT StateCode, StateName " +
                "FROM States " +
                "ORDER BY StateName ";

            SqlCommand selectCommand = new SqlCommand(selectStatement, connection);

            try
            {
                connection.Open();
                
                SqlDataReader reader = selectCommand.ExecuteReader();
                
                while (reader.Read())
                {
                    State state = new State();

                    state.StateCode = reader["StateCode"].ToString();
                    state.StateName = reader["StateName"].ToString();

                    states.Add(state);
                }

                reader.Close();
            }
            catch (SqlException e)
            {
                throw e;
            }
            finally
            {
                connection.Close();
            }

            return states;
        }
    }
}