using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment4
{
    internal class RealEstateAgency
    {
        private List<Property> properties;
        
        public RealEstateAgency()
        {
            properties = new List<Property>();
        }

        public void AddProperty(Property p)
        {
            properties.Add(p);
        }

        public void RentProperty(string address)
        {
            foreach (Property property in properties)
            {
                if (property.Address == address)
                {
                    if (property is IRentable rentableProperty)
                    {
                        if (rentableProperty.IsRented)
                            Console.WriteLine("The property is already rented!\nAddress: " + address);
                        else
                        {
                            rentableProperty.IsRented = true;
                            Console.WriteLine("Property at " + address + " is now rented.");
                        }
                    }
                    else
                    {
                        Console.WriteLine("The property is not rentable!\nAddress: " + address);
                    }
                }
            }
        }
    }
}
