
static List<int> Filter(MyDelegate condition, List<int> list)
{
   
    List<int> result = new List<int>();

    foreach (int item in list)
    {
        if (condition(item))
        {
            result.Add(item);
        }
    }

    return result;
}

static bool IsOdd(int number)
{
    return number % 2 == 1;
}

List<int> numbers = new List<int> { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

List<int> oddNumbers = Filter(IsOdd, numbers);
foreach (int number in oddNumbers)
    Console.Write(number + " ");
Console.WriteLine();

static float FGX(FloatDelegate del1, FloatDelegate del2, float x)
{
    return del2(del1(x));
}

static float Cube(float x) { return x * x * x; }
static float AddTenth(float x) { return x + (float)0.1; }

static float f(float x)
{
    return x * 3;
}
static float g(float x)
{
    return x - 2;
}

float x = 2.0f;
Console.WriteLine(FGX(Cube, AddTenth, x));
Console.WriteLine(FGX(f,g,x));

public delegate bool MyDelegate(int number);
public delegate float FloatDelegate(float x);


