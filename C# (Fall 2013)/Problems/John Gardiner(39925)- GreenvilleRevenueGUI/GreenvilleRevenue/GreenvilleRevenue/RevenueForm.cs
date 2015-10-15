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
            const double ENTRANCE_FEE = 25;
            double thisYears, lastYears;
            double revenue, contestDif;
            string output;
            thisYears = Convert.ToDouble(thisYearsTextBox.Text);
            lastYears = Convert.ToDouble(lastYearsTextBox.Text);
            output = "This year's competition has " + thisYears + " contestants, while last year's competition had " + lastYears + " contestants, so ";
            if (thisYears == lastYears)
                output += "both competitions have the same number of participants.  ";
            else if (thisYears > lastYears)
            {
                contestDif = thisYears - lastYears;
                output += "there will be " + contestDif + " more contestant(s) than in last year's competition.  ";
            }
            else
            {
                contestDif = lastYears - thisYears;
                output += "there will be " + contestDif + " fewer contestant(s) this year.  ";
            }
            revenue = thisYears * ENTRANCE_FEE;
            output += "This year's event should generate " + revenue.ToString("C") + " in revenue for the Greenville County Fair, if a " + ENTRANCE_FEE.ToString("C") + " entrance fee is charged.";

            outputRichTextBox.Text = output;
        }
    }
}