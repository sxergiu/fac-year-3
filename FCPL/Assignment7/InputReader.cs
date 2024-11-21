using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment_Events
{
    public class KeyboardInputEventArgs : EventArgs
    {
        public string Input { get; }

        public KeyboardInputEventArgs(string input)
        {
            Input = input;
        }
    }

    public class InputReader
    {
        public event EventHandler<KeyboardInputEventArgs> OnKeyPressed;

        public void ReadKeys()
        {
            string input;
            Console.WriteLine("Start typing (press Enter to stop):");

            while (!string.IsNullOrEmpty(input = Console.ReadLine()))
            {
                OnKeyPressed?.Invoke(this, new KeyboardInputEventArgs(input));
            }

            Console.WriteLine("Input reading stopped.");
        }
    }
}
