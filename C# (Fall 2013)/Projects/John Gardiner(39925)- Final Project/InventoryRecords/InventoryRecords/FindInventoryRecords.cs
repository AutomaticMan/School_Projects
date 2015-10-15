using System;

namespace InventoryRecords
{
    class FindInventory
    {
        public static void FindByItemNumber()
        {
            const string TITLE = "find items by item number";

            //Creating an empty container for object.
            Inventory inventoryItem = null;

            //Title-bar.
            InventoryRecords.ShowTitleBar(TITLE); 
            Console.WriteLine();

            //Find proper inventory object.
            try
            {
                Console.Write("Enter a valid item number >> ");
                inventoryItem = Inventory.GetItemById(Console.ReadLine()); 
            }

            //Go back to start if entry is invalid.
            catch (NoResultException) 
            {
                Console.WriteLine("Incorrect entry.  ");
                InventoryRecords.GetMainMenu(true);
            }
            
            //Format and display results.
            InventoryRecords.ShowSearchResult(inventoryItem);
        }

        public static void FindByStartingPrice()
        {
            const string TITLE = "find items by price";
            double minimumPrice;

            //Title-bar.
            InventoryRecords.ShowTitleBar(TITLE); 

            Console.WriteLine();

            //Get value for search.
            Console.Write("Enter a minimum value to see all items with a greater starting price >> ");
            double.TryParse(Console.ReadLine(), out minimumPrice);

            //Loops items.
            foreach (Inventory inventoryItem in Inventory.InventoryItems) 
            {

                //Check to see which item starting prices match input.
                if (inventoryItem.AskingPrice >= minimumPrice)  
                {
                    //Method displays formatted a search result.
                    InventoryRecords.ShowSearchResult(inventoryItem); 
                }
            }

            Console.WriteLine();
            Console.WriteLine("Showing items with a minimum starting price of {0:C}", minimumPrice);
        }
    }
}