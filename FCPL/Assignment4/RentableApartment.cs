using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment4
{
    internal class RentableApartment : Apartment, IRentable
    {
        public bool IsRented { get; set; }
        public decimal MonthlyRent {  get; set; }

        public RentableApartment( string address, int indoorArea, decimal propertyValue,
            int floor, bool hasElevator, decimal monthlyRent) 
            : base(address,indoorArea,propertyValue,floor,hasElevator)
        {
            IsRented = false;
            MonthlyRent = monthlyRent;
        }

        public override string ToString()
        {
            string s = base.ToString();
            return s + "\nIsRented: " + IsRented + "\nMonthlyRent: " + MonthlyRent;
        }
    }
}
