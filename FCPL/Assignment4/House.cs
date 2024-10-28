using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Transactions;

namespace Assignment4
{
    internal class House : Property
    {
        private int OutdoorArea {  get; set; }
        private int TotalArea { get => base.IndoorArea + OutdoorArea; }

        public House(string address, int indoorArea, decimal properyValue,int outdoorArea)
            : base(address, indoorArea, properyValue)
        {
            OutdoorArea = outdoorArea;
        }

        public override string ToString()
        {
            string s = base.ToString();
            return s + "\nOutdoorArea: " + OutdoorArea + "m^2";
        }
    }
}
