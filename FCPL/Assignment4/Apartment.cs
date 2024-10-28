using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment4
{
    internal class Apartment : Property
    {
        private int Floor { get; set; }
        private bool HasElevator { get; set; }

        public Apartment(string address, int indoorArea, decimal propertyValue, int floor, bool hasElevator) 
                : base(address, indoorArea, propertyValue) 
        {
            Floor = floor;
            HasElevator = hasElevator;
        }

        public override string ToString()
        {
            string s = base.ToString();
            return s + "\nFloor: " + Floor + "\nHasElevator: " + HasElevator; ;
        }

    }
}
