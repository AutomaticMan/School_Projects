//CS4  Overloading Operators - John Gardiner 
/*
Overload operators to work with Rational class.
*/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CS4
{
    public class Rational
    {
        //The code provided in this project may need to be alter to match your class variable names.

        //declare class variables
        private int intNumerator;
        private int intDenominator;

        //default constructor - sets numerator to 0, denominator to 1
        public Rational()
        {
            intNumerator = 0;
            intDenominator = 1;
        }

        //Overloaded constructor - assign arguments to property names
        public Rational(int intNumerator, int intDenominator)
        {
            this.intNumerator = intNumerator;
            this.intDenominator = intDenominator;
        }

        //Properties: Numerator (provided), Denominator, Fraction
        public int Numerator
        {
            get
            {
                return intNumerator;
            }
            set
            {
                intNumerator = value;
            }
        }

        public int Denominator
        {
            get
            {
                return intDenominator;
            }
            set
            {
                intDenominator = value;
            }
        }

        public string Fraction
        {
            get
            {
                return intNumerator.ToString() + "/" + intDenominator.ToString();
            }
        }

        //overloaded arithmetic operators declared as public static (+ provided)
        public static Rational operator +(Rational left, Rational right)
        {
            int intNumerator = left.Numerator * right.Denominator + left.Denominator * right.Numerator;
            int intDenominator = left.Denominator * right.Denominator;
            
            return new Rational(intNumerator, intDenominator);
        }

        public static Rational operator -(Rational left, Rational right)
        {
            int intNumerator = left.Numerator * right.Denominator - left.Denominator * right.Numerator;
            int intDenominator = left.Denominator * right.Denominator;
            
            return new Rational(intNumerator, intDenominator);
        }

        public static Rational operator *(Rational left, Rational right)
        {
            int intNumerator = left.Numerator * right.Numerator;
            int intDenominator = left.Denominator * right.Denominator;
            
            return new Rational(intNumerator, intDenominator);
        }

        public static Rational operator /(Rational left, Rational right)
        {
            int intNumerator = left.Numerator * right.Denominator;
            int intDenominator = left.Denominator * right.Numerator;
            
            return new Rational(intNumerator, intDenominator);
        }

        public static bool operator <(Rational left,  Rational right)
        {
            return left.Numerator * right.Denominator < right.Numerator * left.Denominator;
        }

        public static bool operator >(Rational left, Rational right)
        {
            return left.Numerator * right.Denominator > right.Numerator * left.Denominator;
        }

        public static bool operator ==(Rational left, Rational right)
        {
            return left.Numerator * right.Denominator == right.Numerator * left.Denominator;
        }

        public static bool operator !=(Rational left, Rational right)
        {
            return left.Numerator * right.Denominator != right.Numerator * left.Denominator;
        }

        //override Equals and GetHashCode (provided)
        public override bool Equals(Object obj)
        {
            Rational right = (Rational)obj;  // cast the obj to Rational
            
            return this.Numerator * right.Denominator == right.Numerator * this.Denominator;
        }

        public override int GetHashCode()
        {
            string hashString = this.Numerator.ToString() + "/" + this.Denominator.ToString();
            
            return hashString.GetHashCode();
        }

    }//end of Rational
 
    class CS4
    {
        static void Main(string[] args)
        {

            Console.WriteLine("CS4 John Gardiner \n");

            Rational x = new Rational();         //calls default ructor 
            x.Numerator = 2;    //use properties to set values
            x.Denominator = 3;
            Console.WriteLine("Rational x;           //calls default constructor");
            Console.WriteLine("  x = " + x.Fraction + " \n");

            Rational y = new Rational(3,5);   //calls overloaded ructor
            Console.WriteLine("Rational y(3,5);      //calls overloaded constructor "); 
            Console.WriteLine("  y = " + y.Fraction + "\n");

            Rational result = new Rational();
            Console.WriteLine("Testing arithmetic operator overloading:");

            result = y + x;
            Console.WriteLine("  " + y.Fraction + " + " + x.Fraction + " = " + result.Fraction);

            result = y * x;
            Console.WriteLine("  " + y.Fraction + " * " + x.Fraction + " = " + result.Fraction);

            result = y - x;
            Console.WriteLine("  " + y.Fraction + " - " + x.Fraction + " = " + result.Fraction);

            result = y / x;
            Console.WriteLine("  " + y.Fraction + " / " + x.Fraction + " = " + result.Fraction);


            Console.WriteLine("\nTesting relational operator overloading (9/15 < 10/15) ");

            Console.WriteLine("  " + y.Fraction + " == " + x.Fraction + " = " + (y == x));
            Console.WriteLine("  " + y.Fraction + " != " + x.Fraction + " = " + (y != x));

            Console.WriteLine("  " + y.Fraction + " <  " + x.Fraction + " = " + (y < x));
            Console.WriteLine("  " + x.Fraction + " <  " + y.Fraction + " = " + (x < y));

            Console.WriteLine("  " + y.Fraction + " >  " + x.Fraction + " = " + (y > x));
            Console.WriteLine("  " + x.Fraction + " >  " + y.Fraction + " = " + (x > y));
            Console.WriteLine(" ");

            Console.ReadLine();
            return;

        }//end Main
    }//end class
}//end namespace