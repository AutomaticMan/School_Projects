using System;

namespace ArrayDemo2
{
    class ArrayDemo2
    {
        static void Main(string[] args)
        {
            int[] scores = new int[8];
            int x;
            for(x = 0; x < scores.Length; ++x)
            {
                Console.Write("Enter your score on test {0} ", x + 1);
                scores[x] = Convert.ToInt32(Console.ReadLine());
            }
            Console.WriteLine("\n--------------------------------");
            Console.WriteLine("Scores in original order:");
            for (x = 0; x < scores.Length; ++x)
            {
                Console.Write("{0,6}", scores[x]);
            }
            Console.WriteLine("\n--------------------------------");
            Console.WriteLine("Scores in sorted order:");
            Array.Sort(scores);
            for (x = 0; x < scores.Length; ++x)
            {
                Console.Write("{0,6}", scores[x]);
            }
            Console.WriteLine("\n--------------------------------");
            Console.WriteLine("Scores in reverse order:");
            Array.Reverse(scores);
            for (x = 0; x < scores.Length; ++x)
            {
                Console.Write("{0,6}", scores[x]);
            }

        }
    }
}