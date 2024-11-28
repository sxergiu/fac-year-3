using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment8
{
    public class InputReader
    {
        public event EventHandler<string> OnKeyPressed;

        public void ReadKeys()
        {
            string input;
            while (!string.IsNullOrEmpty(input = Console.ReadLine()))
            {
                OnKeyPressed?.Invoke(this, input);
            }
        }
    }
}
