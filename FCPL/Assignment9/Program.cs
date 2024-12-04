
using Assignment9FCPL;

var tags1 = new List<string>{"Platformer", "2D"};

Game g1 = new Game("LostKnight", "Charlie", new DateTime(2021, 12, 7), 2.99f, tags1);

Game g2 = new Game("Rayman", "Ubisoft", new DateTime(2017, 10, 14), 9.99f, tags1);

var tags2 = new List<string> { "Horror", "3D" };

Game g3 = new Game("Layers of Fear", "Ubisoft", new DateTime(2019, 9, 9), 14.99f, tags2);

Game g4 = new Game("Outlast", "Red Barrel", new DateTime(2013, 2, 20), 7.99f, tags2);

var tags3 = new List<string> { "Horror", "2D" };

Game g5 = new Game("Little Nightmares", "FromSoftware", new DateTime(2016, 5, 15), 19.99f, tags3);

Store store = new Store();
store.AddGame(g1);
store.AddGame(g2);
store.AddGame(g3);
store.AddGame(g4);
store.AddGame(g5);

Console.WriteLine("Games before 2019: ");
var games = store.GamesBefore(new DateTime(2019, 1, 1));
games.ForEach( game => Console.WriteLine(game+"\n"));

Console.WriteLine("Games between 2019 2022: ");
Console.WriteLine(store.GamesBetween(2019,2022));

Console.WriteLine("Games ordered by developer and name: ");
games = store.OrderByDeveloperAndByName();
games.ForEach(game => Console.WriteLine(game + "\n"));

Console.WriteLine("Games by Ubisoft ordered by price price descending: ");
games = store.GamesByDeveloperOrderedByPrice("Ubisoft",true);
games.ForEach(game => Console.WriteLine(game + "\n"));

Console.WriteLine("Games by Ubisoft ordered by price price ascending: ");
games = store.GamesByDeveloperOrderedByPrice("Ubisoft");
games.ForEach(game => Console.WriteLine(game + "\n"));

Console.WriteLine("First game by Ubisoft: ");
Console.WriteLine(store.FirstGameByDeveloper("Ubisoft"));

Console.WriteLine("Are there game more expensive than $15?: " + store.GameMoreExpensiveThan(15f));
Console.WriteLine("Are there game more expensive than $30?: " + store.GameMoreExpensiveThan(30f));

Console.WriteLine("Sum of prices of horror games: " + store.SumOfPriceForGamesWithTag("Horror"));
Console.WriteLine("Sum of prices of 2D games: " + store.SumOfPriceForGamesWithTag("2D"));
Console.WriteLine("Sum of prices of 3D games: " + store.SumOfPriceForGamesWithTag("3D"));

Console.WriteLine("Games which are either Platformer or 3D: ");
var tags = new List<string>{ "Platformer", "3D" };
games = store.GamesWhichContainAtLeastOneTag(tags);
games.ForEach(game => Console.WriteLine(game + "\n"));





