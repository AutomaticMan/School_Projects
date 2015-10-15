using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

//Project:     CS8 Queue Processing
//Programmer:  John Gardiner
//Description: Declare and load a string Queue of names.
//             The user can sort the list by name and search by name.
//             Names can be deleted from the top of the list.


using System.IO;  // FileStream and StreamReader

namespace CS8
{
    public partial class CS8Form : Form
    {
        public CS8Form()
        {
            InitializeComponent();
        }

        //Declare class-level List
        Queue<string> cstrName = new Queue<string>();

        private void CS8Form_Load(object sender, EventArgs e)
        {
            //use a try catch to load the names from the file cs7.txt
            try
            {
                string strPath = "cs8.txt";
                FileStream source = new FileStream(strPath, FileMode.Open, FileAccess.Read);
                StreamReader reader = new StreamReader(source);

                while (reader.Peek() != -1)
                {
                    cstrName.Enqueue(reader.ReadLine());
                }
                reader.Close();
                source.Close();
            }
            catch (IOException ex)
            {
                string message = ex.Message;
                string caption = "I/O error, file currupted or missing. ";
                MessageBox.Show(message, caption);
            }

            //display names in list box
            displayNames();

        }


        void displayNames()
        {

            //Listboxes need to be cleared because this procedure is also
            //called to redisplayed the data
            lstName.Items.Clear();

            //Use cstrName.Count to control loop
            foreach (string strName in cstrName)
            {
                lstName.Items.Add(strName);
            }

        }


        private void btnSortByName_Click(object sender, EventArgs e)
        {
            string[] tempArray = cstrName.ToArray();

            //Sort by name using the Sort method
            Array.Sort(tempArray);

            cstrName.Clear();

            foreach (var strName in tempArray)
	        {
                cstrName.Enqueue(strName);		 
	        }

            //display names in list box
            displayNames();
        }


        private void btnSearchByName_Click(object sender, EventArgs e)
        {
            //delcare int variable to store the result returned by BinarySearch 
            int intIndex;

            //If a match was found select the matching name in the list box and display name found message
            //else just display a message that the name was not found. 
            if (cstrName.Contains(txtSearchName.Text))
            {
                intIndex = 0;

                foreach (var strName in cstrName)
                {
                    if (strName == txtSearchName.Text)
                    {
                        lstName.SelectedIndex = intIndex;
                        txtSearchResults.Text = "Name found! ";

                        break;
                    }

                    intIndex++;
                }
            }
            else
            {
                txtSearchResults.Text = "Name not found. ";
            }

 
        }


        private void btnDelete_Click(object sender, EventArgs e)
        {
            //If the Count is > 0 remove the first item and redisplay names in list box
           {
               if (cstrName.Count > 0)
               {
                   cstrName.Dequeue();
               }
                //display names in list box
                displayNames();
            }
        }


        private void btnExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }

    }//end of class
}//end of namespace