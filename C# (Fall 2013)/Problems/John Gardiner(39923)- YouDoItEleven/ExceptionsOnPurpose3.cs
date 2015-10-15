using System;
class ExceptionsOnPurpose
{
	static void Main()
	{
		int answer = 0;
		int result;
		int zero = 0;
		try
		{
			Console.Write("Enter an integer >> ");
			answer = Convert.ToInt32(Console.ReadLine());
			result = answer/zero;
			Console.WriteLine("The answer is " + answer);
		}
		catch(FormatException e)
		{
			Console.WriteLine("You did not enter an integer");
		}
		catch(DivideByZeroException e)
		{
			Console.WriteLine("This is not your fault.");
			Console.WriteLine("You entered the integer correctly.");
			Console.WriteLine("The program divides by zero.");
		}
	}
}