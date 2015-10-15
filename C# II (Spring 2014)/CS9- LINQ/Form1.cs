// Name: John Gardiner
// Date: 3/10/2014
// Assignment: CS9- LINQ Queries

using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace CustomerInvoices
{
    // This is the starting point for exercise 23-1 from
    // "Murach's C# 2010" by Joel Murach
    // (c) 2010 by Mike Murach & Associates, Inc. 
    // www.murach.com

    public partial class frmInvoices : Form
    {
        public frmInvoices()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            List<Invoice> invoiceList = InvoiceDB.GetInvoices();
            List<Customer> customerList = CustomerDB.GetCustomers();

            var invoices = from invoice in invoiceList
                           join customer in customerList
                           on invoice.CustomerID equals customer.CustomerID
                           orderby invoice.InvoiceTotal descending
                           select new { customer.Name,
                                        invoice.InvoiceID,
                                        invoice.InvoiceDate,
                                        invoice.InvoiceTotal };

            int intCount = 0;
            foreach (var invoice in invoices)
            {
                lvInvoices.Items.Add(invoice.Name.ToString());
                lvInvoices.Items[intCount].SubItems.Add(invoice.InvoiceID.ToString());
                lvInvoices.Items[intCount].SubItems.Add(Convert.ToDateTime(invoice.InvoiceDate).ToShortDateString());
                lvInvoices.Items[intCount].SubItems.Add(invoice.InvoiceTotal.ToString("c"));

                intCount++;
            }
        }
    }
}
