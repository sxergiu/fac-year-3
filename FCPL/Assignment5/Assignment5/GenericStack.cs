using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Assignment5
{
    internal class GenericStack<T>
    {
        private List<T> _stack = new List<T>();

        public void Push(T item)
        {
            _stack.Add(item);
        }

        public T Pop()
        {
            if( IsEmpty() )
                throw new InvalidOperationException("Empty Stack!");
            
            T item = _stack[_stack.Count - 1];
            _stack.RemoveAt(_stack.Count - 1 );
            return item;
        }

        public bool TryPop(out T item)
        {

            if (IsEmpty())
            {
                item = default(T);  
                return false;
            }

            item = Pop(); 
            return true;
        }

        public T Peek()
        {
            if( IsEmpty()) { throw new InvalidOperationException("Empty Stack!");  }
            return _stack[_stack.Count - 1];
        }


        private bool IsEmpty()
        {
            return _stack.Count == 0;
        }

        public override string ToString()
        {
            string s = "Stack:\n";
            foreach( T item in _stack )
            {
                s += item + " ";
            }
            return s;
        }
    }
}
