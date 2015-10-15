/*This program compares the number of contestants between this
years and the prior years Idol competition.  In addition, it
calculates revenue, and accepts the name and talent type, for
this years competition.*/

using System;

namespace GreenvilleRevenue
{
    class GreenvilleRevenue
    {
        const string QUIT = "Q";
        const int MIN = 0, MAX = 30;
        const int MULTIPLIER = 2;
        const double ENTRANCE_FEE = 25.00;
        private static string[] talent = { "Singing", "Dancing", "Musical Instrument", "Other" };
        private static void GenerateArray(string[,] input)
        {
            bool talentCompare;
            for (int x = 0; x < input.GetLength(0); ++x)
            {
                Console.Write("Who is going to be number " + (x + 1) + "? ");
                input[x, 0] = Console.ReadLine();
                do
                {
                    talentCompare = false;
                    Console.Write("What is their special skill? ");
                    input[x, 1] = Console.ReadLine();
                    for (int y = 0; y < talent.Length; ++y)
                    {
                        if (input[x, 1] == Convert.ToString(talent[y].ToCharArray()[0]))
                        {
                            talentCompare = true;
                        }
                    }
                    if (talentCompare == false)
                    {
                        Console.WriteLine(GenerateValidationMsg());
                    }
                } while (talentCompare == false);

            }
        }
        private static void GenerateComparison(int thisYears, int lastYears)
        {
            string output;
            output = "\nThis year's competition has " + thisYears + " contestants, while last year's competition had " + lastYears + " contestants, so ";
            if (thisYears == lastYears)
                output += "this years competition has the same number of participants as last.  ";
            else if (thisYears > lastYears * MULTIPLIER)
                output += "this years competition has more than " + MULTIPLIER + " times the number of participants!  ";
            else if (thisYears > lastYears)
                output += "this years competition is bigger then ever!  ";
            else
                output += "it's a tighter race this year.  Come out and cast your vote!  ";
            Console.WriteLine(output);
        }
        private static string GenerateValidationMsg()
        {
            string output = "Please enter a valid talent code.  ";
            for (int x = 0; x < talent.Length; ++x)
            {
                output += talent[x].ToCharArray()[0] + " for " + talent[x];
                if (x < talent.Length - 1)
                {
                    output += ", ";
                }
                else
                {
                    output += ".  ";
                }

            }
            return output;
        }
        private static void SearchArray(string[,] contestants)
        {
            string inputString;
            int count;
            do
            {
                count = 0;
                Console.Write("Enter a talent code to see the members in that group or type {0} to quit: ", QUIT);
                inputString = Console.ReadLine();
                for (int x = 0; x < talent.Length; ++x)
                {
                    if (inputString == Convert.ToString(talent[x].ToCharArray()[0]))
                    {
                        count = 1;
                        for (int y = 0; y < contestants.GetLength(0); ++y)
                        {
                            if (contestants[y, 1] == inputString)
                            {
                                Console.WriteLine("{0,4}{1}", count + ": ", contestants[y, 0]);
                                ++count;
                            }
                        }
                    }
                }
                if (count == 1)
                {
                    Console.WriteLine("No Results found for talent code: {0}.", inputString);
                }
                else if (count == 0 && inputString != QUIT)
                {
                    Console.WriteLine(GenerateValidationMsg());
                }
            } while (inputString != QUIT);
        }
        private static int ValidateContestants(string inputString)
        {
            bool inputCompare;
            int input = -1;
            string tempInput;
            do
            {
                inputCompare = true; //Setting initial values for each iteration of the loop.
                Console.Write("\nEnter the number of contestants in {0} year's event: ", inputString);
                tempInput = Console.ReadLine();
                for (int x = 0; x < tempInput.Length; ++x)
                {
                    if (!char.IsNumber(tempInput.ToCharArray()[x]))
                    {
                        inputCompare = false;
                        break;
                    }
                }
                if (inputCompare)
                {
                    input = Convert.ToInt32(tempInput);
                }
                if (input < MIN || input > MAX)
                {
                    Console.WriteLine("\nError, number of contestants for this event must be between {0} and {1}.", MIN, MAX);
                    input = -1;
                }
            } while (input == -1);
            return input;
        }
        static void Main(string[] args)
        {
            string thisString = "this", lastString = "last";
            int thisYears, lastYears;
            double revenue;
            thisYears = ValidateContestants(thisString);
            lastYears = ValidateContestants(lastString);
            GenerateComparison(thisYears, lastYears);
            revenue = thisYears * ENTRANCE_FEE;
            Console.WriteLine("\n\nIf a " + ENTRANCE_FEE.ToString("C") + " entrance fee is charged, then this year's event should generate " + revenue.ToString("C") + " in revenue for the Greenville County Fair.");
            Console.WriteLine("\n-----------------------------------------------");
            if (thisYears != 0)
            {
                Console.WriteLine("\nNow, lets collect the names and talents of the contestants from this years competition: ");
                string[,] contestants = new string[thisYears, 2];
                GenerateArray(contestants);
                SearchArray(contestants);
            }
        }
    }
}