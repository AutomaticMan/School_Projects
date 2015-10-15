using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InventoryRecords
{
    [Serializable]
    class Inventory
    {

        //Minimum asking price must be changed here.
        private const double MIN_ASKING_PRICE = 1.00;
        
        //Starting ID number to give program a finished look when run:)
        private const int STARTING_ITEM_NUMBER = 123456789; 
        private int itemNumber;
        private string description;
        private double askingPrice;

        //Create a list of Inventory objects.
        public static List<Inventory> InventoryItems = new List<Inventory>(); 
        
        //Public accessors.
        public int ItemNumber { get { return itemNumber; } }
        public string Description { get { return description; } set { description = value; } }
        public double AskingPrice
        {
            get
            {
                return askingPrice;
            }
            set
            {
                if (value >= MIN_ASKING_PRICE)  //Check price
                {
                    askingPrice = value;
                }
                else
                {
                    askingPrice = MIN_ASKING_PRICE;
                    throw (new MinPriceException()); //
                }
            }
        }
        public Inventory[] InventoryArray
        {
            get
            {
            return InventoryItems.ToArray(); //return iventory array if its needed.
            }
        }

        public string FormattedId
        {
            get
            {
            StringBuilder formatter = new StringBuilder();
            
                formatter.AppendFormat("{0:###-###-##-#}", itemNumber); //Show pretty item number.
            
                return formatter.ToString();
            }
        }

        //Constructor for class.
        public Inventory()  
        {
            itemNumber = STARTING_ITEM_NUMBER;

            //Find item number.
            foreach (Inventory inventoryItem in InventoryItems)  
            {
                if (itemNumber <= inventoryItem.itemNumber)
                {
                    itemNumber = inventoryItem.itemNumber;
                }
            }

            ++itemNumber;

            askingPrice = 0.00;
            description = null;

            //Add to our list
            InventoryItems.Add(this); 
        }

        public static double MinAskingPrice()
        {

            //Return Minimum price to other classes.    
            return MIN_ASKING_PRICE;
        }

        public static Inventory GetItemById(string enteredId)
        {
            int tempInt;

            //Convert the incoming number to integer.
            int.TryParse(enteredId, out tempInt);

            //Loop through inventory.
            foreach (Inventory inventoryItem in InventoryItems) 
            {

                //Check input against each record in list.
                if (enteredId == inventoryItem.FormattedId || tempInt == inventoryItem.itemNumber)

                    //If result, then return object.
                    return inventoryItem; 
            }

            //No result, throw exception.
            throw(new NoResultException()); 
        }
    }
}
