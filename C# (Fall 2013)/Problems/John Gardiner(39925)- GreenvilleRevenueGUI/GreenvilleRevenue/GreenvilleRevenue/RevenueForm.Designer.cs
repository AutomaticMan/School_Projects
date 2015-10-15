namespace GreenvilleRevenue
{
    partial class RevenueForm
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
            this.thisYearsLabel = new System.Windows.Forms.Label();
            this.lastYearsLabel = new System.Windows.Forms.Label();
            this.lastYearsTextBox = new System.Windows.Forms.TextBox();
            this.thisYearsTextBox = new System.Windows.Forms.TextBox();
            this.calculateButton = new System.Windows.Forms.Button();
            this.titleLabel = new System.Windows.Forms.Label();
            this.outputRichTextBox = new System.Windows.Forms.RichTextBox();
            this.SuspendLayout();
            // 
            // thisYearsLabel
            // 
            this.thisYearsLabel.AutoSize = true;
            this.thisYearsLabel.Location = new System.Drawing.Point(49, 78);
            this.thisYearsLabel.Name = "thisYearsLabel";
            this.thisYearsLabel.Size = new System.Drawing.Size(273, 17);
            this.thisYearsLabel.TabIndex = 0;
            this.thisYearsLabel.Text = "Enter the number of contestants this year:";
            // 
            // lastYearsLabel
            // 
            this.lastYearsLabel.AutoSize = true;
            this.lastYearsLabel.Location = new System.Drawing.Point(48, 131);
            this.lastYearsLabel.Name = "lastYearsLabel";
            this.lastYearsLabel.Size = new System.Drawing.Size(289, 17);
            this.lastYearsLabel.TabIndex = 1;
            this.lastYearsLabel.Text = "Enter the number contestants from last year:";
            // 
            // lastYearsTextBox
            // 
            this.lastYearsTextBox.Location = new System.Drawing.Point(360, 131);
            this.lastYearsTextBox.Name = "lastYearsTextBox";
            this.lastYearsTextBox.Size = new System.Drawing.Size(100, 22);
            this.lastYearsTextBox.TabIndex = 2;
            // 
            // thisYearsTextBox
            // 
            this.thisYearsTextBox.Location = new System.Drawing.Point(359, 78);
            this.thisYearsTextBox.Name = "thisYearsTextBox";
            this.thisYearsTextBox.Size = new System.Drawing.Size(100, 22);
            this.thisYearsTextBox.TabIndex = 1;
            // 
            // calculateButton
            // 
            this.calculateButton.Location = new System.Drawing.Point(385, 177);
            this.calculateButton.Name = "calculateButton";
            this.calculateButton.Size = new System.Drawing.Size(75, 23);
            this.calculateButton.TabIndex = 3;
            this.calculateButton.Text = "Calculate";
            this.calculateButton.UseVisualStyleBackColor = true;
            this.calculateButton.Click += new System.EventHandler(this.calculateButton_Click);
            // 
            // titleLabel
            // 
            this.titleLabel.AutoSize = true;
            this.titleLabel.Location = new System.Drawing.Point(18, 21);
            this.titleLabel.Name = "titleLabel";
            this.titleLabel.Size = new System.Drawing.Size(479, 17);
            this.titleLabel.TabIndex = 5;
            this.titleLabel.Text = "Welcome to the Greenville County Fair\'s Idol competition revenue progarm.";
            // 
            // outputRichTextBox
            // 
            this.outputRichTextBox.Location = new System.Drawing.Point(51, 225);
            this.outputRichTextBox.Name = "outputRichTextBox";
            this.outputRichTextBox.ReadOnly = true;
            this.outputRichTextBox.Size = new System.Drawing.Size(409, 96);
            this.outputRichTextBox.TabIndex = 5;
            this.outputRichTextBox.TabStop = false;
            this.outputRichTextBox.Text = "";
            // 
            // RevenueForm
            // 
            this.AcceptButton = this.calculateButton;
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(526, 354);
            this.Controls.Add(this.outputRichTextBox);
            this.Controls.Add(this.titleLabel);
            this.Controls.Add(this.calculateButton);
            this.Controls.Add(this.thisYearsTextBox);
            this.Controls.Add(this.lastYearsTextBox);
            this.Controls.Add(this.lastYearsLabel);
            this.Controls.Add(this.thisYearsLabel);
            this.Name = "RevenueForm";
            this.SizeGripStyle = System.Windows.Forms.SizeGripStyle.Show;
            this.Text = "Revenue Generator";
            this.Load += new System.EventHandler(this.RevenueForm_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label thisYearsLabel;
        private System.Windows.Forms.Label lastYearsLabel;
        private System.Windows.Forms.TextBox lastYearsTextBox;
        private System.Windows.Forms.TextBox thisYearsTextBox;
        private System.Windows.Forms.Button calculateButton;
        private System.Windows.Forms.Label titleLabel;
        private System.Windows.Forms.RichTextBox outputRichTextBox;
    }
}

