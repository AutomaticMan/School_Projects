// This program calculates revenue and compares
// the number of contestants for the Greenville
// Idol competition.

using System;

class GreenvilleRevenue
{
    static void Main()
    {
        const double ENTRANCE_FEE = 25;
        Boolean contestCompare;
        string thisYearsAsString, lastYearsAsString;
        double thisYears, lastYears;
        double revenue, contestDif;
        Console.WriteLine("Welcome user, please enter the number of contestants in this year's Idol competition:");
        thisYearsAsString = Console.ReadLine();
        Console.WriteLine("Now, enter the number of contestants in last year's competition:");
        lastYearsAsString = Console.ReadLine();
        thisYears = Convert.ToDouble(thisYearsAsString);
        lastYears = Convert.ToDouble(lastYearsAsString);
        Console.Write("This year's competition has {0} contestants, while last year's competition had {1} contestants, so ", thisYears, lastYears);
        contestCompare = thisYears > lastYears;        //I used a boolean here to demostrate its use.
        if (thisYears == lastYears)
        {
            Console.Write("both competitions have the same number of participants.");
        }
        else
        {
            if (contestCompare)
            {
                contestDif = thisYears - lastYears;
                Console.Write("there will be {0} more contestant(s) than in last year's competition.  ", contestDif);
            }
            else
            {
                contestDif = lastYears - thisYears;
                Console.Write("there will be {0} fewer contestant(s) this year.  ", contestDif);
            }
        }
        revenue = thisYears * ENTRANCE_FEE;
        Console.WriteLine("This year's event should generate {0} in revenue for the Greenville County Fair, if a $25.00 entrance fee is charged.", revenue.ToString("C"));
        Console.ReadLine();
    }
}