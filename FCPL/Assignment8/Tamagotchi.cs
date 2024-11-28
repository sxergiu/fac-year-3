using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment8
{
    public class Tamagotchi
    {
        public string Name { get; }
        public int Food { get; private set; }
        public int HungerRate { get; }
        public bool Alive { get; private set; } = true;
        public char Key { get; }

        private readonly InputReader _inputReader;

        public Tamagotchi(string name, int startingFood, int hungerRate, char key, InputReader inputReader)
        {
            Name = name;
            Food = startingFood;
            HungerRate = hungerRate*1000; //s to ms
            Key = key;
            _inputReader = inputReader;

            _inputReader.OnKeyPressed += HandleKeyPressed;
        }

        private void HandleKeyPressed(object sender, string input)
        {
            if (input.Length == 1 && input[0] == Key)
            {
                Feed();
            }
        }

        private void Feed()
        {
            if( Food < 20 )
            {
                Food += 5;
                Console.WriteLine($"{Name} has been fed. Current food: {Food}");
            }
            else
            {
                Alive = false;
                Console.WriteLine($"{Name} ovarate and died!");
            }
        }

        public async Task Run()
        {
            while (Alive)
            {
                await Task.Delay(HungerRate);

                Food -= 3;
                if (Food <= 0)
                {
                    Alive = false;
                    Console.WriteLine($"{Name} has starved to death.");
                }
                else Console.WriteLine(ToString());
            }
        }

        public override string ToString()
        {
            return $"{Name} is alive and well. Remaining food: {Food}";
        }
    }
}
