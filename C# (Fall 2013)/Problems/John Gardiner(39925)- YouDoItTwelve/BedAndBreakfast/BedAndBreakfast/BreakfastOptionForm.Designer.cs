namespace BedAndBreakfast
{
    partial class BreakfastOptionForm
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
            this.contButton = new System.Windows.Forms.RadioButton();
            this.fullButton = new System.Windows.Forms.RadioButton();
            this.deluxeButton = new System.Windows.Forms.RadioButton();
            this.priceLabel = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // contButton
            // 
            this.contButton.AutoSize = true;
            this.contButton.Font = new System.Drawing.Font("Papyrus", 7.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.contButton.Location = new System.Drawing.Point(16, 63);
            this.contButton.Name = "contButton";
            this.contButton.Size = new System.Drawing.Size(106, 26);
            this.contButton.TabIndex = 0;
            this.contButton.TabStop = true;
            this.contButton.Text = "Continental";
            this.contButton.UseVisualStyleBackColor = true;
            this.contButton.CheckedChanged += new System.EventHandler(this.contButton_CheckedChanged);
            // 
            // fullButton
            // 
            this.fullButton.AutoSize = true;
            this.fullButton.Font = new System.Drawing.Font("Papyrus", 7.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.fullButton.Location = new System.Drawing.Point(16, 90);
            this.fullButton.Name = "fullButton";
            this.fullButton.Size = new System.Drawing.Size(55, 26);
            this.fullButton.TabIndex = 1;
            this.fullButton.TabStop = true;
            this.fullButton.Text = "Full";
            this.fullButton.TextAlign = System.Drawing.ContentAlignment.TopRight;
            this.fullButton.UseVisualStyleBackColor = true;
            this.fullButton.CheckedChanged += new System.EventHandler(this.fullButton_CheckedChanged);
            // 
            // deluxeButton
            // 
            this.deluxeButton.AutoSize = true;
            this.deluxeButton.Font = new System.Drawing.Font("Papyrus", 7.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.deluxeButton.Location = new System.Drawing.Point(16, 117);
            this.deluxeButton.Name = "deluxeButton";
            this.deluxeButton.Size = new System.Drawing.Size(77, 26);
            this.deluxeButton.TabIndex = 2;
            this.deluxeButton.TabStop = true;
            this.deluxeButton.Text = "Deluxe";
            this.deluxeButton.UseVisualStyleBackColor = true;
            this.deluxeButton.CheckedChanged += new System.EventHandler(this.deluxeButton_CheckedChanged);
            // 
            // priceLabel
            // 
            this.priceLabel.AutoSize = true;
            this.priceLabel.Font = new System.Drawing.Font("Papyrus", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.priceLabel.Location = new System.Drawing.Point(110, 178);
            this.priceLabel.Name = "priceLabel";
            this.priceLabel.Size = new System.Drawing.Size(57, 31);
            this.priceLabel.TabIndex = 3;
            this.priceLabel.Text = "Price";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Papyrus", 7.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(11, 16);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(161, 22);
            this.label1.TabIndex = 4;
            this.label1.Text = "Select breakfast option";
            // 
            // BreakfastOptionForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Yellow;
            this.ClientSize = new System.Drawing.Size(282, 253);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.priceLabel);
            this.Controls.Add(this.deluxeButton);
            this.Controls.Add(this.fullButton);
            this.Controls.Add(this.contButton);
            this.Name = "BreakfastOptionForm";
            this.Text = "BreakfastOptionForm";
            this.Load += new System.EventHandler(this.BreakfastOptionForm_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.RadioButton contButton;
        private System.Windows.Forms.RadioButton fullButton;
        private System.Windows.Forms.RadioButton deluxeButton;
        private System.Windows.Forms.Label priceLabel;
        private System.Windows.Forms.Label label1;
    }
}