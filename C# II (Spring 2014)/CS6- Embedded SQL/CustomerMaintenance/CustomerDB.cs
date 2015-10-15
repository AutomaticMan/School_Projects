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
using System.Data;
using System.Data.SqlClient;

namespace CustomerMaintenance
{
    class CustomerDB
    {
        public static Customer GetCustomer(int intCustomerID)
        {
            SqlConnection connection = MMABooksDB.GetConnection();

            string strSelectStatement =
                "SELECT CustomerID, Name, Address, City, State, ZipCode " +
                "FROM Customers " +
                "WHERE CustomerID = @CustomerID";

            SqlCommand selectCommand = new SqlCommand(strSelectStatement, connection);
            
            selectCommand.Parameters.AddWithValue("@CustomerID", intCustomerID);

            try
            {
                connection.Open();

                SqlDataReader customerReader = 
                    selectCommand.ExecuteReader(CommandBehavior.SingleRow);

                if (customerReader.Read())
                {
                    Customer customer = new Customer();

                    customer.CustomerID = (int)customerReader["CustomerID"];
                    customer.Name = customerReader["Name"].ToString();
                    customer.Address = customerReader["Address"].ToString();
                    customer.City = customerReader["City"].ToString();
                    customer.State = customerReader["State"].ToString();
                    customer.ZipCode = customerReader["ZipCode"].ToString();

                    return customer;
                }
                else
                {
                    return null;
                }
            }
            catch (SqlException e)
            {
                throw e;
            }
            finally
            {
                connection.Close();
            }
        }

        public static int AddCustomer(Customer newCustomer)
        {
            SqlConnection connection = MMABooksDB.GetConnection();

            string strInsertStatement = 
                "INSERT Customers (Name, Address, City, State, ZipCode) " +
                "VALUES (@Name, @Address, @City, @State, @ZipCode)";

            SqlCommand insertCommand = new SqlCommand(strInsertStatement, connection);

            insertCommand.Parameters.AddWithValue("@Name", newCustomer.Name);
            insertCommand.Parameters.AddWithValue("@Address", newCustomer.Address);
            insertCommand.Parameters.AddWithValue("@City", newCustomer.City);
            insertCommand.Parameters.AddWithValue("@State", newCustomer.State);
            insertCommand.Parameters.AddWithValue("@ZipCode", newCustomer.ZipCode);

            try
            {
                connection.Open();

                insertCommand.ExecuteNonQuery();

                string strSelectStatement = "SELECT IDENT_CURRENT('Customers') FROM Customers";
                
                SqlCommand selectCommand = new SqlCommand(strSelectStatement, connection);
                
                int customerID = Convert.ToInt32(selectCommand.ExecuteScalar());
                
                return customerID;
            }
            catch (SqlException e)
            {
                throw e;
            }
            finally 
            {
                connection.Close();
            }
        }

        public static bool UpdateCustomer(Customer oldCustomer, Customer newCustomer)
        {
            SqlConnection connection = MMABooksDB.GetConnection();
            
            string updateStatement = 
                "UPDATE Customers SET " +
                "Name = @NewName, " +
                "Address = @NewAddress, " +
                "City = @NewCity, " +
                "State = @NewState, " +
                "ZipCode = @NewZipCode " +
                "WHERE Name = @OldName " +
                "AND Address = @OldAddress " +
                "AND City = @OldCity " +
                "AND State = @OldState " +
                "AND ZipCode = @OldZipCode";
            
            SqlCommand updateCommand = new SqlCommand(updateStatement, connection);
            
            updateCommand.Parameters.AddWithValue("@NewName", newCustomer.Name);
            updateCommand.Parameters.AddWithValue("@NewAddress", newCustomer.Address);
            updateCommand.Parameters.AddWithValue("@NewCity", newCustomer.City);
            updateCommand.Parameters.AddWithValue("@NewState", newCustomer.State);
            updateCommand.Parameters.AddWithValue("@NewZipCode", newCustomer.ZipCode);
            updateCommand.Parameters.AddWithValue("@OldName", oldCustomer.Name);
            updateCommand.Parameters.AddWithValue("@OldAddress", oldCustomer.Address);
            updateCommand.Parameters.AddWithValue("@OldCity", oldCustomer.City);
            updateCommand.Parameters.AddWithValue("@OldState", oldCustomer.State);
            updateCommand.Parameters.AddWithValue("@OldZipCode", oldCustomer.ZipCode);

            try
            {
                connection.Open();
                
                int count = updateCommand.ExecuteNonQuery();
                
                if (count > 0)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            catch (SqlException e)
            {
                throw e;
            }
            finally
            {
                connection.Close();
            }
        }

        public static bool DeleteCustomer(Customer customer)
        {
            SqlConnection connection = MMABooksDB.GetConnection();
            
            string strDeleteStatement =
                "DELETE FROM Customers WHERE " +
                "Name = @Name " +
                "AND Address = @Address " +
                "AND City = @City " +
                "AND State = @State " +
                "and ZipCode = @ZipCode ";
            
            SqlCommand deleteCommand = new SqlCommand(strDeleteStatement, connection);
            
            deleteCommand.Parameters.AddWithValue("@Name", customer.Name);
            deleteCommand.Parameters.AddWithValue("@Address", customer.Address);
            deleteCommand.Parameters.AddWithValue("@City", customer.City);
            deleteCommand.Parameters.AddWithValue("@State", customer.State);
            deleteCommand.Parameters.AddWithValue("@ZipCode", customer.ZipCode);
            
            try
            {
                connection.Open();
                
                int count = deleteCommand.ExecuteNonQuery();
                
                if (count > 0)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            catch (SqlException e)
            {
                throw e;
            }
            finally
            {
                connection.Close();
            }
        }
    }
}