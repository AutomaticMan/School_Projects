using System;

delegate void DiscountDelegate(ref double saleAmount);

class DiscountDelegateDemo
{
    public static void StandardDiscount(ref double saleAmount)
    {
        const double DISCOUNT_RATE = 0.05;
        const double CUTOFF = 1000.00;
        double discount;
        if (saleAmount >= CUTOFF)
            discount = saleAmount * DISCOUNT_RATE;
        else
            discount = 0;
        saleAmount -= discount;
    }
    public static void PreferredDiscount(ref double saleAmount)
    {
        const double SPECIAL_DISCOUNT = 0.10;
        double discount = saleAmount * SPECIAL_DISCOUNT;
        saleAmount -= discount;
    }
    static void Main()
    {
        double saleAmount;
        char code;
        DiscountDelegate firstDel, secondDel;
        firstDel = new DiscountDelegate(StandardDiscount);
        secondDel = new DiscountDelegate(PreferredDiscount);
        Console.Write("Enter amount of sale ");
        saleAmount = Convert.ToDouble(Console.ReadLine());
        Console.Write("Enter S for standard discount, or P for preferred discount ");
        code = Convert.ToChar(Console.ReadLine());
        if (code == 'S')
            firstDel(ref saleAmount);
        else
            secondDel(ref saleAmount);
        Console.WriteLine("New sale amount is {0}", saleAmount.ToString("C2"));
    }
}