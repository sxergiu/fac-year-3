using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment9FCPL
{
    public class Game
    {
        public string Name { get; set; }
        public string Developer { get; set; }
        public DateTime ReleaseDate { get; set; }
        public float Price { get; set; }
        public List<string> Tags { get; set; }

        public Game(string name, string developer, DateTime releaseDate, float price, List<string> tags)
        {
            Name = name;
            Developer = developer;
            ReleaseDate = releaseDate;
            Price = price;
            Tags = tags;
        }

        public override string ToString()
        {
            string tags = Tags.Count > 0 ? string.Join(", ", Tags) : "No tags";
            return $"Game Name: {Name}\nDeveloper: {Developer}\nRelease Date: {ReleaseDate.ToShortDateString()}\nPrice: ${Price:F2}\nTags: {tags}";
        }
    }
}
