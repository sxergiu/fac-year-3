
using Assignment8;


    var inputReader = new InputReader();

    var tamagotchi = new Tamagotchi("charlie", 10, 3, 'f', inputReader);

    Task.Run(() => inputReader.ReadKeys());

    await tamagotchi.Run();
