/* This program calculates revenue and accepts input data
* about contestants from the user.  All data inputs are verified
* through the use of the TryParse method.  Additionally, this
* version uses a class called Constant to handle all operations 
* related to each individual contestant.*/

using System;
namespace Greenville
{
    class Contestant
    {
        const string INVALID = "Invalid";  //If no acceptable code is inputed talent is set to this constant.
        private char talentCode;
        public static string[] talents = { "Singing", "Dancing", "Musical Instrument", "Other" }; //Public array holds talent codes, and descriptions, thanks to the use of the ToCharArray method throughout the program.
        public string Name { get; set; } //Auto-implemented property as requested in directions.
        public string TalentDescription //Directions asked for a read-only property that displays talent description.
        {
            get
            {
                for (int x = 0; x < talents.Length; ++x)
                {
                    if (talentCode == talents[x].ToCharArray()[0])
                    {
                        return talents[x];
                    }
                }
                return INVALID;
            }
        }
        public char Talent
        {
            get
            {
                return talentCode;
            }
            set
            {
                talentCode = value;
                if (!ValidateCode(talentCode))  //Invalid talents set to proper code.
                {
                    talentCode = INVALID.ToCharArray()[0];
                }
            }
        }
        public static bool ValidateCode(char input)
        {
            for (int x = 0; x < talents.Length; ++x)  //Compares input to each talent code in the talents array.
            {
                if (input == talents[x].ToCharArray()[0])
                {
                    return true;
                }
            }
            return false;
        }
        public static string GetValidationMsg()  //Generates validation message for easy use throughout the program. 
        {
            string output = "\nValid talent codes are as follows.  Please use ";
            for (int x = 0; x < talents.Length; ++x)
            {
                output += talents[x].ToCharArray()[0] + " for " + talents[x];
                if (x < talents.Length - 1)
                {
                    output += ", ";
                }
                else
                {
                    output += ", or contestant's talent will be set to " + INVALID + ".  ";
                }

            }
            return output;
        }
        class GreenvilleRevenue
        {
            const char QUIT = 'Q', REENTER = 'R';  //For loop control later in the program.
            const int MIN = 0, MAX = 30, MULTIPLIER = 2;
            const double ENTRANCE_FEE = 25.00;
            private static bool ValidateGroup(int input)  //Verifies the number of contestants in each competition is with-in parameters.
            {
                if (input >= MIN && input <= MAX)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            public static double GetRevenue(int quantity)  //Generates revenue.
            {
                double revenue;
                revenue = quantity * ENTRANCE_FEE;
                return revenue;
            }
            public static string GetComparison(int x, int y)  //Compares the number of contestants between two years, and generates the appropriate output.
            {
                string output;
                output = "\nThis year's competition has " + x + " contestants, while last year's competition had " + y + " contestants, so ";
                if (x == y)
                    output += "this years competition has the same number of participants as last.  ";
                else if (x > y * MULTIPLIER)
                    output += "this years competition has more than " + MULTIPLIER + " times the number of participants!  ";
                else if (x > y)
                    output += "this years competition is bigger then ever!  ";
                else
                    output += "it's a tighter race this year.  Come out and cast your vote!  ";
                return output;
            }
            private static void SearchContestants(char inputChar, Contestant[] contestant)  //Search feature.  Could have avoided difficultly by adding "Invalid" to the talents array, but where is the fun in that.
            {
                int count = 0;
                char invalid = INVALID.ToCharArray()[0];
                for (int x = 0; x < talents.Length; ++x)
                {
                    if (inputChar == talents[x].ToCharArray()[0] || inputChar == invalid)
                    {
                        count = 1;
                        for (int y = 0; y < contestant.Length; ++y)
                        {
                            if (inputChar == contestant[y].Talent)
                            {
                                Console.WriteLine("{0,4}{1,-32}{2}", count + ": ", contestant[y].Name, contestant[y].TalentDescription);
                                ++count;
                            }
                        }
                        break; //Prevents the loop from cycling once a result is found.
                    }
                }
                if (count == 1)
                {
                    Console.WriteLine("No Results found for talent code: {0}.", inputChar);
                }
            }

            static void Main(string[] args)
            {
                int thisYears, lastYears;
                string inputString;
                char outputTalent, controlChar;
                bool quitCompare, reenterCompare;
                Console.Write("Enter the number of contestants in this years competition >> ");  //Next section of code gets number of contestants.
                inputString = Console.ReadLine();
                while (!int.TryParse(inputString, out thisYears) || !ValidateGroup(thisYears))  //Validation made easy thanks to TryParse.
                {
                    Console.Write("Please enter a valid integer between {0} and {1} >> ", MIN, MAX);
                    inputString = Console.ReadLine();
                }
                Console.Write("Enter the number of contestants in last years competition >> ");
                inputString = Console.ReadLine();
                while (!int.TryParse(inputString, out lastYears) || !ValidateGroup(lastYears))
                {
                    Console.Write("Please enter a valid integer between {0} and {1} >> ", MIN, MAX);
                    inputString = Console.ReadLine();
                }

                Console.WriteLine(GetComparison(thisYears, lastYears));  //Generates comparision message.  GetComparision() does all the work.

                Console.WriteLine("\nIf a {0} entrance fee is charged, then the competition should generate {1} in revenue.  ", ENTRANCE_FEE.ToString("C"), GetRevenue(thisYears).ToString("C")); //Revenue statement.

                Contestant[] contestant = new Contestant[thisYears]; //This section of code gets the names and talents, and delivers them to Contestant class.
                for (int x = 0; x < thisYears; ++x)
                {
                    Console.Write("\nEnter the name of contestant number {0} >> ", x + 1);
                    contestant[x] = new Contestant();  //A new object for each new contestant.
                    contestant[x].Name = Console.ReadLine();
                    do
                    {
                        controlChar = '\0'; //Resetting controlChar for each run of the loop.
                        Console.Write("Enter {0}'s talent code >> ", contestant[x].Name);
                        while (!char.TryParse(Console.ReadLine(), out outputTalent))
                        {
                            Console.Write("Please enter a single character >> ");
                        }
                        if (!Contestant.ValidateCode(outputTalent))  //If the talent code is invalid, lets let the user know before proceeding.
                        {
                            Console.WriteLine(Contestant.GetValidationMsg());
                            Console.Write("\nType {0} to re-enter or press enter to continue >> ", REENTER);
                            char.TryParse(Console.ReadLine(), out controlChar);
                        }
                        reenterCompare = controlChar == REENTER || controlChar == Char.ToLower(REENTER);
                        if (!reenterCompare)
                        {
                            contestant[x].Talent = outputTalent;
                        }
                    } while (reenterCompare); //Loop allows for corrections to the talent code.
                }

                do  //Search contestants by way of SearchContestants().
                {
                    Console.Write("\nEnter a talent code to see users from that category or press {0} to quit >> ", QUIT);
                    while (!char.TryParse(Console.ReadLine(), out controlChar))
                    {
                        Console.Write("\nPlease enter a single character >> ");
                    }
                    quitCompare = controlChar == QUIT || controlChar == Char.ToLower(QUIT);
                    if (!Contestant.ValidateCode(controlChar) && controlChar != INVALID.ToCharArray()[0] && !quitCompare) //All these conditions must be met for the error msg to show.
                    {
                        Console.WriteLine("\n" + Contestant.GetValidationMsg());
                        continue;
                    }
                    else
                    {
                        SearchContestants(controlChar, contestant);
                    }
                } while (!quitCompare);
            }
        }
    }
}