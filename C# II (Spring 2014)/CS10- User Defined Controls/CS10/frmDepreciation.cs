using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace FinancialCalculations
{
    // This is the solution to exercise 24-1 from
    // "Murach's C# 2010" by Joel Murach
    // (c) 2010 by Mike Murach & Associates, Inc. 
    // www.murach.com

    public partial class frmDepreciation : Form
	{
		public frmDepreciation()
		{
			InitializeComponent();
		}

		private void frmDepreciation_Load(object sender, System.EventArgs e)
		{
			// populate the Life combo box with ints from 1 to 40
            for (int i = 1; i <= 40; i++)
            {
                cboLife.Items.Add(i);
            }
			cboLife.SelectedIndex = 4;  //default value is 5
		}

		private void btnCalculate_Click(object sender, System.EventArgs e)
		{
			try
			{
				double cost = Convert.ToDouble(txtInitialCost.Text);
				double salvage = Convert.ToDouble(txtFinalValue.Text);
				lstDepreciation.Items.Clear();
				int life = Convert.ToInt32(cboLife.Text);
				double dLife = (double)life;

				for (int i = 1; i <= life; i++)
				{
					double period = (double)i;
					double yearlyAllowance = CalculateSYDDepreciation(cost, salvage, dLife, period);
					lstDepreciation.Items.Add("Year " + i + ": " + yearlyAllowance.ToString("c"));
				}
                txtInitialCost.Focus();
		    }
			catch (Exception ex)
			{
				MessageBox.Show(ex.Message + "\n\n" +
					ex.GetType().ToString() + "\n" +
					ex.StackTrace, "Exception");

                txtInitialCost.Focus();
			}
		}


        //Calculate sum of the years digits (SYD) depreciation
		private double CalculateSYDDepreciation(double cost,
			              double salvage, double life, double period)
		{
			double SYDValue =
				(cost - salvage) * (life - period + 1) * 2 /
				((life) * (life + 1));
			return SYDValue;
		}


		private void btnClose_Click(object sender, System.EventArgs e)
		{
			this.Close();
		}
	}
}