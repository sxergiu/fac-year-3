namespace Assignment_Events
{
    using System;

    public class CharListener
    {
        private char keyChar { get; }
        private InputReader inputReader { get; }

        public CharListener(char keyChar, InputReader inputReader)
        {
            this.keyChar = keyChar;
            this.inputReader = inputReader;

            this.inputReader.OnKeyPressed += HandleKeyPressed;
        }

        private void HandleKeyPressed(object sender, KeyboardInputEventArgs e)
        {
            if (e.Input.Contains(keyChar) && e.Input != "print all" && e.Input != "print last")
            {
                Console.WriteLine($"The input \"{e.Input}\" contains the character '{keyChar}'.");
            }
        }
    }

}
