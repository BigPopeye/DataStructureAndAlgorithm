public class Stack{
    private Object[] _array;
    private int _size;
    private const int _defaultCapacity = 8;
    public int Size{get{
        return _size;
    }}

    public Stack(){
        _array = new Object[_defaultCapacity];
        _size= 0;
    }
    public void Push(Object obj){
        if(_size == _array.Length){
            Object[] newArray = new Object[2*_array.Length];
            Array.Copy(_array, 0, newArray, _size);
            _array = newArray;
        }
        _array[_size++] = obj;
    }
    
    public Object Pop(){
        if(_size == 0){
            Console.WriteLine("Stack is empty!");
            return null;
        }
        object obj = _array[--_size];
        _array[_size] = null;
        return obj;
    }

    public Object Peek(){
        if(_size == 0){
            Console.WriteLine("Stack is empty!");
            return null;
        }
        return _array[_size-1];
    }
}