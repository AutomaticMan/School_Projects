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

    public partial class frmFutureValue : Form
	{
		public frmFutureValue()
		{
			InitializeComponent();
		}

		private void btnCalculate_Click(object sender, EventArgs e)
		{
			try
			{

				decimal monthlyInvestment  = Convert.ToDecimal(txtMonthlyInvestment.Text);
				decimal interestRateYearly = Convert.ToDecimal(txtInterestRate.Text);
				int years = Convert.ToInt32(txtYears.Text);

				int months = years * 12;
				decimal interestRateMonthly = interestRateYearly / 12 / 100;
				decimal futureValue = CalculateFutureValue(monthlyInvestment, interestRateMonthly, months);

				txtFutureValue.Text = futureValue.ToString("c");
                txtMonthlyInvestment.Focus();
			}
			catch (Exception ex)
			{
				MessageBox.Show(ex.Message + "\n\n" +
					ex.GetType().ToString() + "\n" +
					ex.StackTrace, "Exception");

                txtMonthlyInvestment.Focus();
			}
		}


		private decimal CalculateFutureValue(decimal monthlyInvestment,
			                     decimal interestRateMonthly, int months)
		{
			decimal futureValue = 0m;
			for (int i = 0; i < months; i++)
			{
				futureValue = (futureValue + monthlyInvestment)
					* (1 + interestRateMonthly);
			}

			return futureValue;
		}


		private void btnClose_Click(object sender, EventArgs e)
		{
			this.Close();
		}

	}
}