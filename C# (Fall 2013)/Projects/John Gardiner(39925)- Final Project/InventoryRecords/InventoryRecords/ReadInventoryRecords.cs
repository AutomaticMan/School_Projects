using System;

namespace InventoryRecords
{
    class ReadRecords
    {
        public static void ShowRecords()
        {
            const string TITLE = "show all records";
            InventoryRecords.ShowTitleBar(TITLE);

            Console.WriteLine();

            Console.WriteLine("Current items for sale in the auction");

            foreach (Inventory inventoryItem in Inventory.InventoryItems)  //Simple loop through inventory list.
            {
                InventoryRecords.ShowSearchResult(inventoryItem); //Method displays formatted search result.
            }
        }
    }
}