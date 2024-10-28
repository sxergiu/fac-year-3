using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment4
{
    internal abstract class Property
    {
        public string Address {  get; private set; }

        protected int IndoorArea {  get; set; }

        protected decimal PropertyValue { get; set; }

        public Property(string address, int indoorArea, decimal propertyValue) {
            Address = address;
            IndoorArea = indoorArea;
            PropertyValue = propertyValue;
        }

        public override string ToString()
        {
            return "Property:\nAddress: " + Address + "\nIndoorArea: " + IndoorArea + "m^2\nPropertyValue: " + PropertyValue +"$"; 
        }
    }
}
