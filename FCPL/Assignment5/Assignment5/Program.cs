using Assignment5;
using System.Collections.Generic;

static void RemoveAt(int[] array, ref int length, int n)
{

    for (int i = n; i < length-1 ; i++)
        mySwap(ref array[i], ref array[i + 1]);

    length--;
}

static void printArray(int[] arr,int n)
{
    Console.WriteLine("Printing Array: ");
    for( int i = 0; i < n; i++ )
        Console.Write(arr[i] + " ");
    Console.WriteLine();
}

static void mySwap(ref int a, ref int b)
{
    int aux = a;
    a = b; 
    b = aux;
}


int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
int len = array.Length;

printArray(array,len);
RemoveAt(array, ref len , 0);
printArray(array, len);
RemoveAt(array, ref len , 7);
RemoveAt(array, ref len , 3);
printArray(array,len);


static List<int> Intersection(List<int> l1, List<int> l2)
{
    HashSet<int> set = new HashSet<int>();

    foreach(int i in l1)
        foreach(int j in l2)
            if( i == j )
                set.Add(i);

    List<int> resList = new List<int>(set);

    return resList;
}

static List<int> FastIntersection(List<int> l1, List<int> l2)
{
    return l1
        .Intersect(l2)
        .Distinct()
        .ToList();
}

static void printList(List<int> list)
{
    Console.WriteLine("Printing List: ");
    foreach (var item in list)
    {
        Console.Write(item + " ");
    }
    Console.WriteLine();
}


List<int> list1 = new List<int> { 1, 2, 3, 4, 5, 8, 77 };
List<int> list2 = new List<int> { 3, 4, 5, 6, 7, 100, 77 };
printList(Intersection(list1, list2));
printList(FastIntersection(list1, list2));

GenericStack<int> stack = new GenericStack<int>();

stack.Push(1);
stack.Push(2);
stack.Push(3);

Console.WriteLine(stack.ToString());
stack.Pop();
Console.WriteLine(stack.ToString());
int a; 
stack.TryPop(out a);

Console.WriteLine(stack.Peek());
stack.TryPop(out a);
Console.WriteLine(stack.TryPop(out a));
try
{
    stack.Pop();
}catch(InvalidOperationException e)
{ Console.WriteLine(e.Message); }

