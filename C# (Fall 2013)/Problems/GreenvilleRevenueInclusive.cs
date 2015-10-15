// This program calculates revenue and compares
// the number of contestants for the Greenville
// Idol competition.

using System;

class GreenvilleRevenue
{
    static void Main()
    {
            const double ENTRANCE_FEE = 25, MULTIPLIER = 2;
            const double MIN = 0, MAX = 30;
            Boolean inclusiveCompare;
            double thisYears, lastYears;
            double revenue;
            string output;
            do {
                Console.Write("Enter the number of contestants in this year's event: ");
                thisYears = Convert.ToDouble(Console.ReadLine());
                Console.Write("Enter the number of contestants from last year's event: ");
                lastYears = Convert.ToDouble(Console.ReadLine());
                inclusiveCompare = thisYears < MIN || thisYears > MAX || lastYears < MIN || lastYears > MAX;
                if (inclusiveCompare)
                    Console.WriteLine("\nError, number of contestants for both events must be between {0} and {1}.", MIN, MAX);
            } while (inclusiveCompare);

            output = "\nThis year's competition has " + thisYears + " contestants, while last year's competition had " + lastYears + " contestants, so ";
            if (thisYears == lastYears)
                output += "this years competition has the same number of participants as last.  ";
            else if (thisYears > lastYears * MULTIPLIER)
                output += "this years competition has more than " + MULTIPLIER + " times the number of participants!  ";
            else if (thisYears > lastYears)
                output += "this years competition is bigger then ever!  ";
            else
                output += "it's a tighter race this year.  Come out and cast your vote!  ";
            revenue = thisYears * ENTRANCE_FEE;
            output += "\n\nIf a " + ENTRANCE_FEE.ToString("C") + " entrance fee is charged, then this year's event should generate " + revenue.ToString("C") + " in revenue for the Greenville County Fair.";
            Console.WriteLine(output);
            Console.ReadLine();

    }
}