using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace GreenvilleRevenue
{
    public partial class RevenueForm : Form
    {
        public RevenueForm()
        {
            InitializeComponent();
        }

        private void RevenueForm_Load(object sender, EventArgs e)
        {

        }

        private void calculateButton_Click(object sender, EventArgs e)
        {
            const double ENTRANCE_FEE = 25, MULTIPLIER = 2;
            double thisYears, lastYears;
            double revenue;
            string output;
            thisYears = Convert.ToDouble(thisYearsTextBox.Text);
            lastYears = Convert.ToDouble(lastYearsTextBox.Text);
            output = "This year's competition has " + thisYears + " contestants, while last year's competition had " + lastYears + " contestants, so ";
            if (thisYears == lastYears)
                output += "this years competition has the same number of participants as last.  ";
            else if (thisYears > lastYears * MULTIPLIER)
                output += "this years competition has more than " + MULTIPLIER + " times the number of participants!  ";
            else if (thisYears > lastYears)
                output += "this years competition is bigger then ever!  ";
            else
                output += "it's a tighter race this year.  Come out and cast your vote!  ";
            revenue = thisYears * ENTRANCE_FEE;
            output += "\n\nIf a " + ENTRANCE_FEE.ToString("C") + " entrance fee is charged, then this year's event should generate " + revenue.ToString("C") + " in revenue for the Greenville County Fair.";

            MessageBox.Show(output, "Comparison Results");
        }
    }
}