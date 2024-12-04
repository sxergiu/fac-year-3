using Assignment9FCPL;
using System;
using System.Collections.Generic;
using System.Linq;

public class Store
{
    public List<Game> Games { get; set; }

    public Store()
    {
        Games = new List<Game>();
    }

    public void AddGame(Game game)
    {
        Games.Add(game);
    }

    public List<Game> GamesBefore(DateTime date)
    {
        return Games.Where(game => game.ReleaseDate < date).ToList();
    }

    public int GamesBetween(int year1, int year2)
    {
        return Games.Count(game => game.ReleaseDate.Year >= year1 && game.ReleaseDate.Year <= year2);
    }

    public List<Game> OrderByDeveloperAndByName()
    {
        return Games.OrderBy(game => game.Developer)
                    .ThenBy(game => game.Name)
                    .ToList();
    }

    public List<Game> GamesByDeveloperOrderedByPrice(string developer, bool descending = false)
    {
        if (descending)
        {
            return Games.Where(game => game.Developer == developer)
                        .OrderByDescending(game => game.Price)
                        .ToList();
        }
        else
        {
            return Games.Where(game => game.Developer == developer)
                        .OrderBy(game => game.Price)
                        .ToList();
        }
    }

    public Game? FirstGameByDeveloper(string developer)
    {
        return Games.Where(game => game.Developer == developer)
                    .OrderBy(game => game.ReleaseDate)
                    .FirstOrDefault();
    }

    public bool GameMoreExpensiveThan(float price)
    {
        return Games.Any(game => game.Price > price);
    }

    public float SumOfPriceForGamesWithTag(string tag)
    {
        return Games.Where(game => game.Tags.Contains(tag))
                    .Sum(game => game.Price);
    }

    public List<Game> GamesWhichContainAtLeastOneTag(List<string> tags)
    {
        return Games.Where(game => game.Tags.Intersect(tags).Any())
                    .ToList();
    }
}