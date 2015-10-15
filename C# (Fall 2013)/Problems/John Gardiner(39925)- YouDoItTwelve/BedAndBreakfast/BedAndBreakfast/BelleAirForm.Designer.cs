namespace BedAndBreakfast
{
    partial class BelleAirForm
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
            this.belleAirDescriptionLabel = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // belleAirDescriptionLabel
            // 
            this.belleAirDescriptionLabel.Font = new System.Drawing.Font("Papyrus", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.belleAirDescriptionLabel.Location = new System.Drawing.Point(64, 40);
            this.belleAirDescriptionLabel.Name = "belleAirDescriptionLabel";
            this.belleAirDescriptionLabel.Size = new System.Drawing.Size(313, 50);
            this.belleAirDescriptionLabel.TabIndex = 0;
            this.belleAirDescriptionLabel.Text = "The BelleAire suite has two bedrooms, two baths, and a private balcony.";
            this.belleAirDescriptionLabel.Click += new System.EventHandler(this.belleAirDescriptionLabel_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Papyrus", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(72, 105);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(146, 24);
            this.label1.TabIndex = 1;
            this.label1.Text = "$199.95 per night.";
            // 
            // BelleAirForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Yellow;
            this.ClientSize = new System.Drawing.Size(456, 260);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.belleAirDescriptionLabel);
            this.Name = "BelleAirForm";
            this.SizeGripStyle = System.Windows.Forms.SizeGripStyle.Show;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "Belle Aire Room";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label belleAirDescriptionLabel;
        private System.Windows.Forms.Label label1;
    }
}