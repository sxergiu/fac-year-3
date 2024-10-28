using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment4
{
    internal interface IRentable
    {
        bool IsRented { get; set; }
        decimal MonthlyRent { get; set; }

    }
}
