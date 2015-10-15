using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

//CS3  BankAccount Inheritance - John Gardiner 
/*
Use the base abstract class BankAccount to create a CheckingAccount
and SavingsAccount class with different withdrawal rules.

*/

namespace CS3
{
    
    //BankAccount - Base Abstract class with abstract withdraw method
    abstract class BankAccount
    {
        protected decimal decBalance;

        public decimal Balance
        {
            get
            {
                return decBalance;
            }

            set
            {
                decBalance = value;
            }
        }

        public BankAccount()
        { 
        }

        public BankAccount(decimal decOpeningDeposit)
        {
            Balance = decOpeningDeposit;
        }

        public void deposit(decimal decDeposit)
        {
            Balance += decDeposit;
        }

        public abstract int withdraw(decimal decAmt);
    }
    
    //SavingsAccount - Derived Class
    class SavingsAccount : BankAccount
    { 
        private const decimal cdecWITHDAWAL_FEE = .10m;

        public SavingsAccount(decimal decOpeningBalance) : base(decOpeningBalance)
        {
        }

        public override int withdraw(decimal decAmt)
        {
            decAmt += decAmt * cdecWITHDAWAL_FEE;
            if (decBalance - decAmt >= 0)
            {
                decBalance -= decAmt;

                return 0;
            }
            else
            {
                return 1;
            }
        }
    }
    
    //CheckingAccount - Derived Class
    class CheckingAccount : BankAccount
    { 
        
        private const decimal cdecWITHDAWAL_FEE = 1.5m;
        //determines how many transactions are allowed before fee is charged.
        private const int cintFREE_WITHDRAWALS = 2;
        private int intWithdrawalCount = 0; 

        public CheckingAccount(decimal decOpeningBalance) : base(decOpeningBalance)
        {
        }

        public override int withdraw(decimal decAmt)
        {
            if (intWithdrawalCount > cintFREE_WITHDRAWALS - 1)
            {
                decAmt += cdecWITHDAWAL_FEE;
            }

            if (decBalance - decAmt >= 0)
            {
                intWithdrawalCount++;

                decBalance -= decAmt;

                return 0;
            }
            else
            {
                return 1;
            }
        }
    }

    class CS3
    {
        //method used to perform transactions
        static void transfer(BankAccount fromAccount, BankAccount toAccount, decimal decAmt)
        {
            int insufficientFunds;

            insufficientFunds = fromAccount.withdraw(decAmt);
            if (insufficientFunds == 1)
                Console.WriteLine("*** Transfer failed - insufficient funds *** ");
            else
                toAccount.deposit(decAmt);

            return;
        }

        static void Main(string[] args)
        {
            Console.WriteLine("CS3 John Gardiner \n\n");

            //declare objects using overloaded constructors
            CheckingAccount checking = new CheckingAccount(100.00m);
            SavingsAccount savings = new SavingsAccount(200.00m);

            Console.WriteLine("Initial Balances");
            Console.WriteLine("  Checking: " + checking.Balance.ToString("c"));
            Console.WriteLine("  Savings: " + savings.Balance.ToString("c") + " \n\n");

            //**
            Console.WriteLine("Transfer from Checking to Savings, Amount: 101.00 ");

            transfer(checking, savings, 101.00m);

            Console.WriteLine("Current Balances");
            Console.WriteLine("  Checking: " + checking.Balance.ToString("c"));
            Console.WriteLine("  Savings: " + savings.Balance.ToString("c") + " \n\n");

            //**
            Console.WriteLine("Transfer from Checking to Savings, Amount: 25.00 (3 transactions) \n"
                 + "First 2 withdrawals from Checking are free; others 1.50 fee");

            transfer(checking, savings, 25.00m);
            transfer(checking, savings, 25.00m);
            transfer(checking, savings, 25.00m);

            Console.WriteLine("Current Balances");
            Console.WriteLine("  Checking: " + checking.Balance.ToString("c"));
            Console.WriteLine("  Savings: " + savings.Balance.ToString("c") + " \n\n");

            //**
            Console.WriteLine("Transfer from Savings to Checking, Amount: 100.00 \n"
                 + "10% fee is $10.00, total deduction 110.00 ");

            transfer(savings, checking, 100.00m);

            Console.WriteLine("Current Balances");
            Console.WriteLine("  Checking: " + checking.Balance.ToString("c"));
            Console.WriteLine("  Savings: " + savings.Balance.ToString("c") + " \n\n");

            //**
            Console.WriteLine("Transfer from Savings to Checking, Amount: 166.00 ");

            transfer(savings, checking, 166.00m);

            Console.WriteLine("Current Balances");
            Console.WriteLine("  Checking: " + checking.Balance.ToString("c"));
            Console.WriteLine("  Savings: " + savings.Balance.ToString("c") + " \n\n");

            //**
            Console.WriteLine("Transfer from Checking to Savings, Amount: 123.00 + 1.50 fee.");

            transfer(checking, savings, 123.00m);

            Console.WriteLine("Current Balances");
            Console.WriteLine("  Checking: " + checking.Balance.ToString("c"));
            Console.WriteLine("  Savings: " + savings.Balance.ToString("c") + " \n\n");

            Console.ReadLine();

            return;

        }//end Main
    }//end class
}//end namespace