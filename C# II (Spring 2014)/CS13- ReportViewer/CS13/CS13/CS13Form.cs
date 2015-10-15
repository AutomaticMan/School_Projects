// Name: John Gardiner
// Date: 4/22/2014 
// Assignment: CS13 Report Viewer

using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CS13
{
    public partial class CS13Form : Form
    {
        public CS13Form()
        {
            InitializeComponent();
        }

        private void CS13Form_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'RnrBooksDataSet.Books' table. You can move, or remove it, as needed.
            this.BooksTableAdapter.Fill(this.RnrBooksDataSet.Books);

            this.reportViewer1.RefreshReport();
        }
    }
}
