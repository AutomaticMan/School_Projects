namespace FinancialCalculations
{
    partial class frmTab
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
            this.tabCalculations = new System.Windows.Forms.TabControl();
            this.tabPage1 = new System.Windows.Forms.TabPage();
            this.txtFutureValue = new System.Windows.Forms.TextBox();
            this.txtYears = new System.Windows.Forms.TextBox();
            this.txtInterestRate = new System.Windows.Forms.TextBox();
            this.txtMonthlyInvestment = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.tabPage2 = new System.Windows.Forms.TabPage();
            this.label5 = new System.Windows.Forms.Label();
            this.lstDepreciation = new System.Windows.Forms.ListBox();
            this.cboLife = new System.Windows.Forms.ComboBox();
            this.txtFinalValue = new System.Windows.Forms.TextBox();
            this.txtInitialCost = new System.Windows.Forms.TextBox();
            this.label6 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.label8 = new System.Windows.Forms.Label();
            this.btnClose = new ctlCuteButton.cuteButton();
            this.cuteButton2 = new ctlCuteButton.cuteButton();
            this.tabCalculations.SuspendLayout();
            this.tabPage1.SuspendLayout();
            this.tabPage2.SuspendLayout();
            this.SuspendLayout();
            // 
            // tabCalculations
            // 
            this.tabCalculations.Controls.Add(this.tabPage1);
            this.tabCalculations.Controls.Add(this.tabPage2);
            this.tabCalculations.Location = new System.Drawing.Point(16, 15);
            this.tabCalculations.Name = "tabCalculations";
            this.tabCalculations.SelectedIndex = 0;
            this.tabCalculations.Size = new System.Drawing.Size(284, 263);
            this.tabCalculations.TabIndex = 0;
            // 
            // tabPage1
            // 
            this.tabPage1.Controls.Add(this.txtFutureValue);
            this.tabPage1.Controls.Add(this.txtYears);
            this.tabPage1.Controls.Add(this.txtInterestRate);
            this.tabPage1.Controls.Add(this.txtMonthlyInvestment);
            this.tabPage1.Controls.Add(this.label4);
            this.tabPage1.Controls.Add(this.label3);
            this.tabPage1.Controls.Add(this.label2);
            this.tabPage1.Controls.Add(this.label1);
            this.tabPage1.Location = new System.Drawing.Point(4, 22);
            this.tabPage1.Name = "tabPage1";
            this.tabPage1.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage1.Size = new System.Drawing.Size(276, 237);
            this.tabPage1.TabIndex = 0;
            this.tabPage1.Text = "Future Value";
            this.tabPage1.UseVisualStyleBackColor = true;
            this.tabPage1.Click += new System.EventHandler(this.tabPage1_Click);
            // 
            // txtFutureValue
            // 
            this.txtFutureValue.Location = new System.Drawing.Point(149, 121);
            this.txtFutureValue.Name = "txtFutureValue";
            this.txtFutureValue.ReadOnly = true;
            this.txtFutureValue.Size = new System.Drawing.Size(86, 20);
            this.txtFutureValue.TabIndex = 28;
            this.txtFutureValue.TabStop = false;
            // 
            // txtYears
            // 
            this.txtYears.Location = new System.Drawing.Point(151, 92);
            this.txtYears.Name = "txtYears";
            this.txtYears.Size = new System.Drawing.Size(84, 20);
            this.txtYears.TabIndex = 27;
            // 
            // txtInterestRate
            // 
            this.txtInterestRate.Location = new System.Drawing.Point(151, 65);
            this.txtInterestRate.Name = "txtInterestRate";
            this.txtInterestRate.Size = new System.Drawing.Size(84, 20);
            this.txtInterestRate.TabIndex = 26;
            // 
            // txtMonthlyInvestment
            // 
            this.txtMonthlyInvestment.Location = new System.Drawing.Point(151, 37);
            this.txtMonthlyInvestment.Name = "txtMonthlyInvestment";
            this.txtMonthlyInvestment.Size = new System.Drawing.Size(84, 20);
            this.txtMonthlyInvestment.TabIndex = 25;
            this.txtMonthlyInvestment.Tag = "";
            // 
            // label4
            // 
            this.label4.Location = new System.Drawing.Point(31, 120);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(114, 20);
            this.label4.TabIndex = 24;
            this.label4.Text = "Future Value:";
            this.label4.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // label3
            // 
            this.label3.Location = new System.Drawing.Point(31, 92);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(114, 20);
            this.label3.TabIndex = 23;
            this.label3.Text = "Number of Years:";
            this.label3.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // label2
            // 
            this.label2.Location = new System.Drawing.Point(31, 65);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(114, 20);
            this.label2.TabIndex = 22;
            this.label2.Text = "Yearly Interest Rate:";
            this.label2.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // label1
            // 
            this.label1.Location = new System.Drawing.Point(31, 37);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(114, 20);
            this.label1.TabIndex = 21;
            this.label1.Text = "Monthly Investment:";
            this.label1.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // tabPage2
            // 
            this.tabPage2.Controls.Add(this.label5);
            this.tabPage2.Controls.Add(this.lstDepreciation);
            this.tabPage2.Controls.Add(this.cboLife);
            this.tabPage2.Controls.Add(this.txtFinalValue);
            this.tabPage2.Controls.Add(this.txtInitialCost);
            this.tabPage2.Controls.Add(this.label6);
            this.tabPage2.Controls.Add(this.label7);
            this.tabPage2.Controls.Add(this.label8);
            this.tabPage2.Location = new System.Drawing.Point(4, 22);
            this.tabPage2.Name = "tabPage2";
            this.tabPage2.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage2.Size = new System.Drawing.Size(276, 237);
            this.tabPage2.TabIndex = 1;
            this.tabPage2.Text = "Depreciation";
            this.tabPage2.UseVisualStyleBackColor = true;
            // 
            // label5
            // 
            this.label5.Location = new System.Drawing.Point(32, 98);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(120, 20);
            this.label5.TabIndex = 25;
            this.label5.Text = "SYD Depreciation:";
            // 
            // lstDepreciation
            // 
            this.lstDepreciation.FormattingEnabled = true;
            this.lstDepreciation.Location = new System.Drawing.Point(32, 119);
            this.lstDepreciation.Name = "lstDepreciation";
            this.lstDepreciation.Size = new System.Drawing.Size(207, 69);
            this.lstDepreciation.TabIndex = 24;
            this.lstDepreciation.TabStop = false;
            // 
            // cboLife
            // 
            this.cboLife.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cboLife.FormattingEnabled = true;
            this.cboLife.Location = new System.Drawing.Point(152, 70);
            this.cboLife.Name = "cboLife";
            this.cboLife.Size = new System.Drawing.Size(87, 21);
            this.cboLife.TabIndex = 23;
            this.cboLife.Tag = "Life";
            // 
            // txtFinalValue
            // 
            this.txtFinalValue.Location = new System.Drawing.Point(152, 43);
            this.txtFinalValue.Name = "txtFinalValue";
            this.txtFinalValue.Size = new System.Drawing.Size(84, 20);
            this.txtFinalValue.TabIndex = 20;
            this.txtFinalValue.Tag = "Final Value";
            // 
            // txtInitialCost
            // 
            this.txtInitialCost.Location = new System.Drawing.Point(152, 15);
            this.txtInitialCost.Name = "txtInitialCost";
            this.txtInitialCost.Size = new System.Drawing.Size(84, 20);
            this.txtInitialCost.TabIndex = 18;
            this.txtInitialCost.Tag = "Initial Cost";
            // 
            // label6
            // 
            this.label6.Location = new System.Drawing.Point(32, 70);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(114, 20);
            this.label6.TabIndex = 22;
            this.label6.Text = "Life of Asset in Years:";
            this.label6.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // label7
            // 
            this.label7.Location = new System.Drawing.Point(32, 43);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(114, 20);
            this.label7.TabIndex = 21;
            this.label7.Text = "Final Value of Asset:";
            this.label7.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // label8
            // 
            this.label8.Location = new System.Drawing.Point(32, 15);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(114, 20);
            this.label8.TabIndex = 19;
            this.label8.Text = "Initial Cost of Asset:";
            this.label8.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // btnClose
            // 
            this.btnClose.cuteColor1 = System.Drawing.Color.LightGreen;
            this.btnClose.cuteColor2 = System.Drawing.Color.DarkBlue;
            this.btnClose.cuteTransparent1 = 64;
            this.btnClose.cuteTransparent2 = 64;
            this.btnClose.Location = new System.Drawing.Point(155, 291);
            this.btnClose.Name = "btnClose";
            this.btnClose.Size = new System.Drawing.Size(75, 23);
            this.btnClose.TabIndex = 29;
            this.btnClose.Text = "Close";
            this.btnClose.UseVisualStyleBackColor = true;
            this.btnClose.Click += new System.EventHandler(this.btnClose_Click);
            // 
            // cuteButton2
            // 
            this.cuteButton2.cuteColor1 = System.Drawing.Color.LightGreen;
            this.cuteButton2.cuteColor2 = System.Drawing.Color.DarkBlue;
            this.cuteButton2.cuteTransparent1 = 64;
            this.cuteButton2.cuteTransparent2 = 64;
            this.cuteButton2.Location = new System.Drawing.Point(74, 291);
            this.cuteButton2.Name = "cuteButton2";
            this.cuteButton2.Size = new System.Drawing.Size(75, 23);
            this.cuteButton2.TabIndex = 28;
            this.cuteButton2.Text = "Calculate";
            this.cuteButton2.UseVisualStyleBackColor = true;
            this.cuteButton2.Click += new System.EventHandler(this.cuteButton2_Click);
            // 
            // frmTab
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(319, 338);
            this.Controls.Add(this.btnClose);
            this.Controls.Add(this.cuteButton2);
            this.Controls.Add(this.tabCalculations);
            this.Name = "frmTab";
            this.Text = "Financial Calculations";
            this.Load += new System.EventHandler(this.frmTab_Load);
            this.tabCalculations.ResumeLayout(false);
            this.tabPage1.ResumeLayout(false);
            this.tabPage1.PerformLayout();
            this.tabPage2.ResumeLayout(false);
            this.tabPage2.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TabControl tabCalculations;
        private System.Windows.Forms.TabPage tabPage1;
        private System.Windows.Forms.TabPage tabPage2;
        private System.Windows.Forms.TextBox txtFutureValue;
        private System.Windows.Forms.TextBox txtYears;
        private System.Windows.Forms.TextBox txtInterestRate;
        private System.Windows.Forms.TextBox txtMonthlyInvestment;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.ListBox lstDepreciation;
        private System.Windows.Forms.ComboBox cboLife;
        private System.Windows.Forms.TextBox txtFinalValue;
        private System.Windows.Forms.TextBox txtInitialCost;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label8;
        private ctlCuteButton.cuteButton btnClose;
        private ctlCuteButton.cuteButton cuteButton2;
    }
}