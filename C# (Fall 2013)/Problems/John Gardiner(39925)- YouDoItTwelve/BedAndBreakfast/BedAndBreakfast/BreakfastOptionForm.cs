using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace BedAndBreakfast
{
    public partial class BreakfastOptionForm : Form
    {
        private const double CONT = 6.00;
        private const double FULL = 9.95;
        private const double DELUXE = 16.50;
        public BreakfastOptionForm()
        {
            InitializeComponent();
        }

        private void BreakfastOptionForm_Load(object sender, EventArgs e)
        {
            priceLabel.Text = "Price: " + CONT.ToString("C");
        }

        private void contButton_CheckedChanged(object sender, EventArgs e)
        {
            priceLabel.Text = "Price: " + CONT.ToString("C");
        }

        private void fullButton_CheckedChanged(object sender, EventArgs e)
        {
            priceLabel.Text = "Price: " + FULL.ToString("C");
        }

        private void deluxeButton_CheckedChanged(object sender, EventArgs e)
        {
            priceLabel.Text = "Price: " + DELUXE.ToString("C");
        }
    }
}
