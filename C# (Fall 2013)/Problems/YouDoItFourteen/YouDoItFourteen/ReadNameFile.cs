using System;
using System.IO;

namespace ReadNameFile
{

    class ReadNameFile
    {

        static void Main()
        {

            FileStream file = new FileStream("Names.txt", FileMode.Open, FileAccess.Read);

            StreamReader reader = new StreamReader(file);

            int count = 1;
            string name;

            Console.WriteLine("Display all names");
            
            name = reader.ReadLine();
            
            while (name != null)
            {

                Console.WriteLine(count.ToString() + " " + name);
                name = reader.ReadLine();
                ++count;
            }

            reader.Close();

            file.Close();
        }
    }
}