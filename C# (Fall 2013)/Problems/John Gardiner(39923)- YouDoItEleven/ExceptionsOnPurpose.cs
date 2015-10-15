using System;
class ExceptionsOnPurpose
{
	static void Main()
	{
		int answer;
		int result;
		int zero = 0;
		Console.Write("Enter an integer >> ");
		answer = Convert.ToInt32(Console.ReadLine());
		result = answer/zero;
		Console.WriteLine("The answer is " + answer);
	}
}