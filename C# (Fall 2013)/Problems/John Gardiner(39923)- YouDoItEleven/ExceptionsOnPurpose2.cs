
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
		catch(Exception e)
		{
			Console.WriteLine(e.Message);
		}
	}
}