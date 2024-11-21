
using Assignment_Events;

InputReader inputReader = new InputReader();

CharListener charListenerA = new CharListener('a', inputReader);
CharListener charListenerB = new CharListener('b', inputReader);

ComplexListener complexListener = new ComplexListener(5, inputReader);

inputReader.ReadKeys();
