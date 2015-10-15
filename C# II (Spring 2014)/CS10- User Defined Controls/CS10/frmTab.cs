// John Gardiner
// 3/21/2014
// CS10

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
    public partial class frmTab : Form
    {
        public frmTab()
        {
            InitializeComponent();
        }

        private void tabPage1_Click(object sender, EventArgs e)
        {

        }

        private void cuteButton2_Click(object sender, EventArgs e)
        {
            if (tabCalculations.SelectedIndex == 0)
                DisplayFutureValue();
            else
                DisplayDepreciation();
        }

        private void DisplayFutureValue()
        {
            try
            {

                decimal monthlyInvestment = Convert.ToDecimal(txtMonthlyInvestment.Text);
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

        private void DisplayDepreciation()
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

        private void btnClose_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void frmTab_Load(object sender, EventArgs e)
        {
            // populate the Life combo box with ints from 1 to 40
            for (int i = 1; i <= 40; i++)
            {
                cboLife.Items.Add(i);
            }
            cboLife.SelectedIndex = 4;  //default value is 5
        }


    }
}
