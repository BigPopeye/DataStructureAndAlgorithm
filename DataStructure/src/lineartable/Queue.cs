public class Queue{
  private Object[] _array;
  private int _size; //actual size of Queue
  private int _head;
  private int _tail;
  private const int _defaultCapacity = 8;

  public Queue(){
      _array = new Object[_defaultCapacity];
      _size = 0;
      _head = 0;
      _tail = 0;
  }
  public int Count{get{return _size;}}

  public void Enqueue(Object obj){
      if(_size == _array.Length){
          int newCapacity = _array.Length * 2; // double Queue's size
          SetCapacity(newCapacity);
      }
      _array[_tail] = obj;
      _tail = (_tail + 1) % _array.Length;
      _size++;
  }

  public Object Dequeue(){
      if(Count == 0){
          Console.WriteLine("Queue is empty!");
      }
      Object obj = _array[_head];
      _array[_head] = null;
      _head = (_head + 1) % _array.Length;
      _size--;
      if(_size < 0.25 * _array.Length){ // cut down 1/2 Queue's size if the actual size < 1/4 array.Length
          SetCapacity(0.5 * _array.Length);
      }
      return obj;
  }
  
  public Object Peek() {
            if (Count == 0)
                Consolo.WriteLine("EmptyQueue");
            return _array[_head];
  }

  private void SetCapacity(int capacity){
        Object[] newArray = new Object[capacity];
        if(_size > 0){
            if(_head < _tail){
                Array.Copy(_array, _head, newArray, 0, _size);
            }else{
                Array.Copy(_array, _head, newArray, 0, _array.Length - _head);
                Array.Copy(_array, 0, newArray, _array.Length - _head, _tail);
            }
        }
        _array = newArray;
        _head = 0;
        _tail = (_size == capacity)? 0: _size;
  }
}
