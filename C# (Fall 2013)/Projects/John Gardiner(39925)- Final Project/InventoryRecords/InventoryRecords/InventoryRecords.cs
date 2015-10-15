using System;
using System.IO;
using System.Runtime.Serialization.Formatters.Binary;
using System.Runtime.Serialization;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InventoryRecords
{
    class MinPriceException : Exception
    {
    }

    class NoResultException : Exception
    {
    }

    class InventoryRecords
    {

        //Filename for saving data.
        const string FILENAME= "records.bin"; 

        public static void AddInventoryItem()
        {
            const string TITLE = "add inventory item";
            bool priceCheck = false;
            double askingPrice;

            Inventory inventoryItem = new Inventory();

            //Show fancy title bar!
            ShowTitleBar(TITLE); 
            
            Console.WriteLine();

            Console.WriteLine("New item added to inventory.  Item number is {0}", inventoryItem.FormattedId);
            
            Console.Write("Enter a description for this item >> ");
           
            inventoryItem.Description = Console.ReadLine();

            //Checking minimum price.
            while(!priceCheck)  
            {

                try
                {
                    Console.Write("Enter asking price for item.  Minimum price is {0:C} >> ", Inventory.MinAskingPrice());

                    double.TryParse(Console.ReadLine(), out askingPrice);

                    inventoryItem.AskingPrice = askingPrice;

                    priceCheck = true;
                }

                //Re-enter until valid minimum price is found
                catch (MinPriceException) 
                {
                    Console.Write("Re-");
                }
            }

            //Add new item to hard storage.
            SaveInventoryItem(inventoryItem);  

        }

        public static void RemoveInventoryItem()
        {

            //Creating container.
            Inventory inventoryItem = null; 

            Console.Write("Enter an item number to delete its record >> ");

            try
            {
                inventoryItem = Inventory.GetItemById(Console.ReadLine());
            }
            catch (NoResultException)
            {
                Console.Write("Invalid entry.  ");
                GetMainMenu(true);
            }

            //Remove from list.
            Inventory.InventoryItems.Remove(inventoryItem);  

            //Update hard storage to reflect changes.
            RefreshInventoryItems();  

        }

        public static void EditInventoryItem()
        {
            Inventory inventoryItem = null;
            double askingPrice;

            //Char determines whether field will be edited.
            char controlChar = 'Y';

            //If editing occurs, this bool tells program to save to file.
            bool editCheck = false; 

            Console.Write("Enter an item number for the record to be edited >> ");

            try
            {
                inventoryItem = Inventory.GetItemById(Console.ReadLine());
            }

            //Invalid inputs are just re-routed back to main menu.
            catch (NoResultException)  
            {
                Console.Write("Invalid entry.  ");
                GetMainMenu(true);
            }
            Console.WriteLine("Editing inventory.  Item number {0}", inventoryItem.FormattedId);
            
            Console.WriteLine();
            Console.WriteLine("Description >> {0}", inventoryItem.Description);

            Console.Write("Press {0} to edit >> ", controlChar);

            //Only edit if wanted.
            if (Console.ReadLine().ToLower() == controlChar.ToString().ToLower()) 
            {
                Console.Write("Enter a new description >> ");

                inventoryItem.Description = Console.ReadLine();

                //Edited.
                editCheck = true; 
            }

            Console.WriteLine("Asking Price >> {0:C}", inventoryItem.AskingPrice);

            Console.Write("Press {0} to edit >> ", controlChar);

            //Only edit if wanted.
            if (Console.ReadLine().ToLower() == controlChar.ToString().ToLower()) 
            {
                Console.Write("Enter a new asking price >> ");

                double.TryParse(Console.ReadLine(), out askingPrice);

                inventoryItem.AskingPrice = askingPrice;

                //Edit happened.
                editCheck = true; 
            }

            //If edit, then write file.
            if (editCheck) 
                RefreshInventoryItems();
        }

        public static void LoadInventoryItems()
        {

            //Open file, or create if none exists.
            FileStream file = new FileStream(FILENAME, FileMode.OpenOrCreate, FileAccess.Read);

            //New serializer.
            BinaryFormatter bFormatter = new BinaryFormatter();

            while (file.Position < file.Length)
            {
                Inventory item = (Inventory)bFormatter.Deserialize(file);

                //Load data back into memory. 
                Inventory.InventoryItems.Add(item);   
            }

            //Close file.
            file.Close(); 
        }

        public static void RefreshInventoryItems()
        {

            //We must override the entire bin file with updated version made here.
            FileStream file = new FileStream(FILENAME, FileMode.Create, FileAccess.Write); 

            BinaryFormatter bFormatter = new BinaryFormatter();

            foreach (Inventory inventoryItem in Inventory.InventoryItems)
            {
                bFormatter.Serialize(file, inventoryItem);
            }

            //Close file.
            file.Close(); 
        }

        public static void SaveInventoryItem(Inventory inventoryItem)
        {
            //Append a new entry to data file.
            FileStream file = new FileStream(FILENAME, FileMode.Append, FileAccess.Write);  

            BinaryFormatter bFormatter = new BinaryFormatter();

            //Serialize item, and save it to file.
            bFormatter.Serialize(file, inventoryItem);

            //Close file.
            file.Close(); 

        }

        public static void GetMainMenu(bool reEnter = false)
        {
            const string TITLE = "main menu";
            int menuIndex;
            string[] menuItems = { "Add Item to Inventory", "Edit Item in Inventory", "Remove Item from Inventory", 
                                     "Show all Inventory", "Search by Item Number", "Search by Item Price" };  //Main menu options

            if (reEnter) //If re-entering a short msg is displayed.  Helps with re-entry.
            {

                Console.Write("Press any key to continue... ");

                Console.ReadKey();

                Console.WriteLine();
            }

            ShowTitleBar(TITLE); //Get title bar.

            ShowMenu(menuItems); //Shows formatted menu.

            int.TryParse(Console.ReadLine(), out menuIndex);

            switch (menuIndex)  //Switch to appropriate method based on user input.
            {
                case 1:
                    AddInventoryItem();
                    GetMainMenu(true);
                    break;
                case 2:
                    EditInventoryItem();
                    GetMainMenu(true);
                    break;
                case 3:
                    RemoveInventoryItem();
                    GetMainMenu(true);
                    break;
                case 4:
                    ReadRecords.ShowRecords();
                    GetMainMenu(true);
                    break;
                case 5:
                    FindInventory.FindByItemNumber();
                    GetMainMenu(true);
                    break;
                case 6:
                    FindInventory.FindByStartingPrice();
                    GetMainMenu(true);
                    break;
                default:
                    GetMainMenu(true);
                    break;
            }

        }

        public static void ShowTitleBar(string title)
        {
            const string WHITESPACE = " ";

            //Calculate star count.
            int starCount = Console.WindowWidth - 2;

            //Find whitespace count.
            int spaceCount = (starCount - title.Length);  
            
            StringBuilder whiteSpaceHolder = new StringBuilder();

            //Probably an easier way of doing the following
            //Divide space count to center text in-between.
            for (int i = 0; i < spaceCount / 2; i++) 
            {
                whiteSpaceHolder.Append(WHITESPACE);
            }

            //Make title bar fancy with colors.
            Console.BackgroundColor = ConsoleColor.Blue; 
            Console.ForegroundColor = ConsoleColor.Yellow;

            Console.WriteLine();
            ShowStars(starCount);

            //Deal with those pesky odd numbers.
            if(spaceCount % 2 == 0) 
            {
                Console.WriteLine(whiteSpaceHolder.ToString() + title.ToUpper() + whiteSpaceHolder.ToString());
            }
            else
            {
                Console.WriteLine(whiteSpaceHolder.ToString() + title.ToUpper() + whiteSpaceHolder.Append(WHITESPACE).ToString());
            }

            //More stars across the bottom.
            ShowStars(starCount);

            //Back to default scheme.
            Console.ResetColor(); 
        }

        public static void ShowStars(int starCount)
        {
            //Loop some stars.
            for (int i = 0; i < starCount; i++) 
            {
                Console.Write("*");
            }

            Console.WriteLine();
        }

        public static void ShowMenu(string[] menuItems)
        {
            string[] formattedMenuItems = new string[menuItems.Length];

            Console.WriteLine();

            //Format string array into pretty menu items.
            for (int i = 0; i < menuItems.Length; ++i)
            {
                formattedMenuItems[i] = "(" + (i + 1) + "): " + menuItems[i];
            }

            foreach (string menuItem in formattedMenuItems)
            {
                Console.WriteLine(menuItem);
            }

            Console.Write("Select an item >> ");
        }

        public static void ShowSearchResult(Inventory inventoryItem)
        {
            //Output results to console.
            Console.WriteLine();
            Console.WriteLine("Item Number >> {0,-15} Asking Price >> {1:C}", inventoryItem.FormattedId, inventoryItem.AskingPrice); 

            Console.WriteLine("Description >> {0}", inventoryItem.Description);
        }

        static void Main(string[] args)
        {
            try
            {

                //Load item file on start-up.
                LoadInventoryItems(); 
            }
            catch (IOException e)
            {
                Console.WriteLine("Error, check system settings.  Failed to load {0}.  {1}", FILENAME, e.ToString());
            }
            
            //Load Main Menu
            GetMainMenu();
        }
    }
}
