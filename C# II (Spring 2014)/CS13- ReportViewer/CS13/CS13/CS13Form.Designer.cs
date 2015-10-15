namespace CS13
{
    partial class CS13Form
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            Microsoft.Reporting.WinForms.ReportDataSource reportDataSource1 = new Microsoft.Reporting.WinForms.ReportDataSource();
            this.reportViewer1 = new Microsoft.Reporting.WinForms.ReportViewer();
            this.RnrBooksDataSet = new CS13.RnrBooksDataSet();
            this.BooksBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.BooksTableAdapter = new CS13.RnrBooksDataSetTableAdapters.BooksTableAdapter();
            ((System.ComponentModel.ISupportInitialize)(this.RnrBooksDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.BooksBindingSource)).BeginInit();
            this.SuspendLayout();
            // 
            // reportViewer1
            // 
            reportDataSource1.Name = "DataSet1";
            reportDataSource1.Value = this.BooksBindingSource;
            this.reportViewer1.LocalReport.DataSources.Add(reportDataSource1);
            this.reportViewer1.LocalReport.ReportEmbeddedResource = "CS13.Report1.rdlc";
            this.reportViewer1.Location = new System.Drawing.Point(0, 0);
            this.reportViewer1.Name = "reportViewer1";
            this.reportViewer1.Size = new System.Drawing.Size(963, 662);
            this.reportViewer1.TabIndex = 0;
            // 
            // RnrBooksDataSet
            // 
            this.RnrBooksDataSet.DataSetName = "RnrBooksDataSet";
            this.RnrBooksDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // BooksBindingSource
            // 
            this.BooksBindingSource.DataMember = "Books";
            this.BooksBindingSource.DataSource = this.RnrBooksDataSet;
            // 
            // BooksTableAdapter
            // 
            this.BooksTableAdapter.ClearBeforeFill = true;
            // 
            // CS13Form
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(965, 663);
            this.Controls.Add(this.reportViewer1);
            this.Name = "CS13Form";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.CS13Form_Load);
            ((System.ComponentModel.ISupportInitialize)(this.RnrBooksDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.BooksBindingSource)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private Microsoft.Reporting.WinForms.ReportViewer reportViewer1;
        private System.Windows.Forms.BindingSource BooksBindingSource;
        private RnrBooksDataSet RnrBooksDataSet;
        private RnrBooksDataSetTableAdapters.BooksTableAdapter BooksTableAdapter;
    }
}

