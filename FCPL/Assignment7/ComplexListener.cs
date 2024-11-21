using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment_Events
{
    internal class ComplexListener
    {
        private int strNo { get; }
        private InputReader InputReader { get; }

        private readonly List<string> _stringMemory = new List<string>();

        public ComplexListener(int strno, InputReader inputReader)
        {
            strNo = strno;
            InputReader = inputReader;

            InputReader.OnKeyPressed += OnKeyPressed;
        }

        private void OnKeyPressed(object sender, KeyboardInputEventArgs e)
        {
            // Console.WriteLine("handling strings.." + strNo);

            if (e.Input == "print last" || e.Input == "print all")
            {
                if (_stringMemory.Count == 0)
                {
                    Console.WriteLine("Empty String Memory.");
                    return;
                }

                if (e.Input == "print last")
                {
                    Console.WriteLine("Last string: " + _stringMemory[_stringMemory.Count - 1]);
                    Console.WriteLine();
                    return;
                }

                if (e.Input == "print all")
                {
                    int i = 1;
                    foreach (string s in _stringMemory)
                    {
                        Console.WriteLine($"string {i}: " + s);
                        i++;
                    }
                    Console.WriteLine();
                    return;
                }
            }   
            else
            {
                _stringMemory.Add(e.Input);
                if( _stringMemory.Count > strNo) {
                    _stringMemory.RemoveAt(0);
                }
            }
        }
    }
}
